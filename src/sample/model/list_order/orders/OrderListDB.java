package sample.model.list_order.orders;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderListDB {
    public static String selectStmt1 = "select *, \n" +
            "\tcase  when order_sum <= 0 then 'Брак' \n" +
            "\telse case  when pay_sum = 0 then 'Не оплачен' \n" +
            "\telse case when order_sum= pay_sum then 'Оплачено' \n" +
            "\telse case when  order_sum>pay_sum then 'Задолженность' \n" +
            "\telse  case when  order_sum<pay_sum then 'Переплата' end  end end end end as status_pay,\n" +
            " round(order_sum-pay_sum, 2) as dolg\n" +
            "from (select id_orders,\n" +
            "\tord.data_create, ord.time_create, ord.data_end, ord.time_end, \n" +
            "    ord.name_status_order, ord.id_order_status, ord.text_description,\n" +
            "\tplotter+printer+service+binding+product as order_sum, pay_sum,  \n" +
            "    product, plotter,printer,service,binding,id_manager,id_printing,id_cutter, name_manager,name_printing,name_cutter,name_client, data_pay, id_client \n" +
            "from (select ords.id_orders, \n" +
            "\tords.data_create, ords.time_create, ords.data_end, ords.time_end,\n" +
            "\tIFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0) as plotter,\n" +
            "\tIFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer,\n" +
            "\tIFNULL((select sum(order_service.sum_all) from order_service  where order_service.id_orders=ords.id_orders),0) as service,\n" +
            "\tIFNULL((select sum(order_product.sum_all) from order_product  where order_product.id_orders=ords.id_orders),0) as product,\n" +
            "\tIFNULL((select sum(order_binding.sum_all) from order_binding  where order_binding.id_orders=ords.id_orders),0) as binding,\n" +
            "\tIFNULL((select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=ords.id_orders ),0) as pay_sum,\n" +
            "   orst.name_status_order, ords.id_order_status, ords.text_description, ords.id_manager,ords.id_printing,ords.id_cutter, ifnull(pay.data_pay,' ') as data_pay ,\n" +
            "   pm.name_people as name_manager,\n" +
            "\tpp.name_people as name_printing,\n" +
            "    pc.name_people as name_cutter,\n" +
            "\tcc.name_сompany as name_client, ords.id_client \n" +
            "from orders ords  \n" +
            "\tinner join status_order orst on orst.id_status_order=ords.id_order_status\n" +
            "    inner join people pm on pm.id_people=ords.id_manager\n" +
            "    inner join people pp on pp.id_people=ords.id_printing\n" +
            "    inner join people pc on pc.id_people=ords.id_cutter\n" +
            "    inner join clients cc on cc.id_clients=ords.id_client\n" +
            "\tleft join order_pay pay on pay.id_orders=ords.id_orders \n ";


        public static ObservableList<OrderList> selectOrderAll() throws Exception {
             String selectStmt = selectStmt1+
            "group by id_orders order by id_orders desc) as ord  ) as ord1 ;";
            // System.out.println(selectStmt);
            try {
                ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

                ObservableList<OrderList> printerList = getOrdersResultSet(result);

                return printerList;
            } catch (SQLException e) {
                System.out.println("error occurred: " + e);
                throw e;
            }

        }

    public static ObservableList<OrderList> selectOrderAll(Integer idOrders) throws Exception {
        String stOrders ="";
        if (idOrders!=null){
            stOrders =" where ords.id_orders like '%"+idOrders+"%' ";
        }

        String selectStmt = selectStmt1+ stOrders+
                "group by id_orders order by id_orders desc) as ord  ) as ord1 ;";
        //  System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderList> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<OrderList> selectOrderToDay(Integer idOrders) throws Exception {
            String stOrders ="";
         if (idOrders!=null){
             stOrders =" and ords.id_orders like '%"+idOrders+"%' ";
         }

        String selectStmt = selectStmt1+
                "where data_create=curdate()  " + stOrders+
                " group by id_orders order by id_orders desc) as ord  ) as ord1;";
         // System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderList> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    private static ObservableList<OrderList> getOrdersResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderList> orderList =  FXCollections.observableArrayList();

        while (result.next()) {
            OrderList orders = new OrderList();

            orders.setIdOrders(result.getInt("id_orders"));
            orders.setIdClient(result.getInt("id_client"));
            orders.setDataCreate(result.getString("data_create"));
            orders.setTimeCreate(result.getString("time_create"));
            orders.setDataEnd(result.getString("data_end"));
            orders.setTimeEnd(result.getString("time_end"));
            orders.setStatusPay(result.getString("status_pay"));
            orders.setOrderSum(result.getDouble("order_sum"));
            orders.setPaySum(result.getDouble("pay_sum"));
            orders.setDolg(result.getDouble("dolg"));
            orders.setIdOrderStatus(result.getInt("id_order_status"));
            orders.setTextDescription(result.getString("text_description"));
            orders.setNameStatus(result.getString("name_status_order"));
            orders.setIdManager(result.getInt("id_manager"));
            orders.setIdPrinting(result.getInt("id_printing"));
            orders.setIdCutter(result.getInt("id_cutter"));
            orders.setNameManager(result.getString("name_manager"));
            orders.setNamePrinting(result.getString("name_printing"));
            orders.setNameCutter(result.getString("name_cutter"));
            orders.setNameClient(result.getString("name_client"));

            orders.setPlotter(result.getDouble("plotter"));
            orders.setPrinter(result.getDouble("printer"));
            orders.setService(result.getDouble("service"));
            orders.setBing(result.getDouble("binding"));
            orders.setProduct(result.getDouble("product"));
            orders.setDataPay(result.getString("data_pay"));


            orderList.add(orders);


        }
        return orderList;
    }


    public static int LastOrder()  {
        OrderList orders = new OrderList();
        String updateStmt = "INSERT INTO orders (id_order_status, data_create, time_create, data_end, time_end, id_client,id_manager,id_printing,id_cutter) " +
                "" +
                "select 1, NOW(), CURTIME(), NOW(), CURTIME(), 1,1,1,1";
        //System.out.println(updateStmt);

          String selectStmt = "SELECT LAST_INSERT_ID() as LastIdOrders;";
        try {
            try {
                ExecuteQuery.dbExecuteUpdate(updateStmt);
                ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
                ObservableList<OrderList> orderList =  FXCollections.observableArrayList();
                while (result.next()) {
                    orders.setIdOrders(result.getInt("LastIdOrders"));

                    orderList.add(orders);
                }
                ObservableList<OrderList> printerList = orderList;

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //  return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
        }
        return  orders.getIdOrders();
    }



    public static OrderList getOrders(Integer IdOrder) throws Exception {
        OrderList orders = new OrderList();
        String selectStmt = selectStmt1+
                "    where ords.id_orders="+IdOrder+" group by id_orders ) as ord) as ord1 ;\n";
      //  System.out.println(selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<OrderList> orderList =  FXCollections.observableArrayList();
            while (result.next()) {

                orders.setIdOrders(result.getInt("id_orders"));
                orders.setIdClient(result.getInt("id_client"));

                orders.setDataCreate(result.getString("data_create"));
                orders.setTimeCreate(result.getString("time_create"));
                orders.setDataEnd(result.getString("data_end"));
                orders.setTimeEnd(result.getString("time_end"));
                orders.setStatusPay(result.getString("status_pay"));
                orders.setOrderSum(result.getDouble("order_sum"));
                orders.setPaySum(result.getDouble("pay_sum"));
                orders.setDolg(result.getDouble("dolg"));
                orders.setIdOrderStatus(result.getInt("id_order_status"));
                orders.setTextDescription(result.getString("text_description"));
                orders.setNameStatus(result.getString("name_status_order"));
                orders.setIdManager(result.getInt("id_manager"));
                orders.setIdPrinting(result.getInt("id_printing"));
                orders.setIdCutter(result.getInt("id_cutter"));
                orders.setNameManager(result.getString("name_manager"));
                orders.setNamePrinting(result.getString("name_printing"));
                orders.setNameCutter(result.getString("name_cutter"));
                orders.setNameClient(result.getString("name_client"));
                orders.setPlotter(result.getDouble("plotter"));
                orders.setPrinter(result.getDouble("printer"));
                orders.setService(result.getDouble("service"));
                orders.setBing(result.getDouble("binding"));
                orders.setProduct(result.getDouble("product"));
                orders.setDataPay(result.getString("data_pay"));
                orderList.add(orders);
            }
            ObservableList<OrderList> printerList = orderList;

            //  return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
        return  orders;
    }
    public static void deleteOrders (Integer id_order) {
        String updateStmt = "DELETE FROM `orders` WHERE `id_orders`='"+id_order+"'; ";
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void updateOrders (Integer id_order,Integer id_client,Integer id_order_status,String text_description,Integer id_manager,Integer id_printing,Integer id_cutter,
                                     String data_create, String time_create, String data_end, String time_end) {
        String updateStmt = "UPDATE orders SET `id_client`='" + id_client + "', `id_order_status`='" + id_order_status + "', `text_description`='" + text_description +
                "', `id_manager`='" + id_manager + "', `id_printing`='" + id_printing + "', `id_cutter`='" + id_cutter +
                "', `data_create`='"+data_create+"', `time_create`='"+time_create+"', `data_end`='"+data_end+"', `time_end`='"+time_end+"'  WHERE `id_orders`='" + id_order +"'";
        //.out.println(updateStmt);

        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ObservableList<OrderList> selectOrderDebt() throws Exception {

        String selectStmt = "select * from (\n" +
                "select *, \n" +
                "\tcase  when order_sum <= 0 then 'Брак' \n" +
                "\telse case  when pay_sum = 0 then 'Не оплачен' \n" +
                "\telse case when order_sum= pay_sum then 'Оплачено' \n" +
                "\telse case when  order_sum>pay_sum then 'Задолженность' \n" +
                "\telse  case when  order_sum<pay_sum then 'Переплата' end  end end end end as status_pay,\n" +
                "\torder_sum-pay_sum as dolg\n" +
                "from (select id_orders,\n" +
                "\tord.data_create, ord.time_create, ord.data_end, ord.time_end, \n" +
                "    ord.name_status_order, ord.id_order_status, ord.text_description,\n" +
                "\tplotter+printer+service+binding+product as order_sum, pay_sum,\n" +
                "    product, plotter,printer,service,binding,id_manager,id_printing,id_cutter, name_manager,name_printing,name_cutter,name_client,data_pay, id_client \n" +
                "from (select ords.id_orders, \n" +
                "\tords.data_create, ords.time_create, ords.data_end, ords.time_end,\n" +
                "\tIFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0) as plotter,\n" +
                "\tIFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer,\n" +
                "\tIFNULL((select sum(order_service.sum_all) from order_service  where order_service.id_orders=ords.id_orders),0) as service,\n" +
                "\tIFNULL((select sum(order_product.sum_all) from order_product  where order_product.id_orders=ords.id_orders),0) as product,\n" +
                "\tIFNULL((select sum(order_binding.sum_all) from order_binding  where order_binding.id_orders=ords.id_orders),0) as binding,\n" +
                "\tIFNULL((select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=ords.id_orders ),0) as pay_sum,\n" +
                "   orst.name_status_order, ords.id_order_status, ords.text_description, ords.id_manager,ords.id_printing,ords.id_cutter,\n" +
                "   pm.name_people as name_manager,\n" +
                "\tpp.name_people as name_printing,\n" +
                "    pc.name_people as name_cutter,\n" +
                "\tcc.name_сompany as name_client, ifnull(pay.data_pay,'') as data_pay, ords.id_client  \n" +
                "from orders ords  \n" +
                "\tinner join status_order orst on orst.id_status_order=ords.id_order_status\n" +
                "    inner join people pm on pm.id_people=ords.id_manager\n" +
                "    inner join people pp on pp.id_people=ords.id_printing\n" +
                "    inner join people pc on pc.id_people=ords.id_cutter\n" +
                "    inner join clients cc on cc.id_clients=ords.id_client\n" +
                "    left join order_pay pay on pay.id_orders=ords.id_orders\n" +
                "group by id_orders order by id_orders desc) as ord  \n" +
                ") as ord1 ) as p \n" +
                "where status_pay='Задолженность' or  status_pay='Не оплачен' and  data_create<>curdate()";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderList> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<OrderList> selectOrderDebtPay() throws Exception {

        String selectStmt = "select * from (\n" +
                "select *, \n" +
                "\tcase  when order_sum <= 0 then 'Брак' \n" +
                "\telse case  when pay_sum = 0 then 'Не оплачен' \n" +
                "\telse case when order_sum= pay_sum then 'Оплачено' \n" +
                "\telse case when  order_sum>pay_sum then 'Задолженность' \n" +
                "\telse  case when  order_sum<pay_sum then 'Переплата' end  end end end end as status_pay,\n" +
                "\torder_sum-pay_sum as dolg\n" +
                "from (select id_orders,\n" +
                "\tord.data_create, ord.time_create, ord.data_end, ord.time_end, \n" +
                "    ord.name_status_order, ord.id_order_status, ord.text_description,\n" +
                "\tplotter+printer+service+binding+product as order_sum, pay_sum,\n" +
                "    product, plotter,printer,service,binding,id_manager,id_printing,id_cutter, name_manager,name_printing,name_cutter,name_client,data_pay , id_client \n" +
                "from (select ords.id_orders, \n" +
                "\tords.data_create, ords.time_create, ords.data_end, ords.time_end,\n" +
                "\tIFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0) as plotter,\n" +
                "\tIFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer,\n" +
                "\tIFNULL((select sum(order_service.sum_all) from order_service  where order_service.id_orders=ords.id_orders),0) as service,\n" +
                "\tIFNULL((select sum(order_product.sum_all) from order_product  where order_product.id_orders=ords.id_orders),0) as product,\n" +
                "\tIFNULL((select sum(order_binding.sum_all) from order_binding  where order_binding.id_orders=ords.id_orders),0) as binding,\n" +
                "\tIFNULL((select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=ords.id_orders ),0) as pay_sum,\n" +
                "   orst.name_status_order, ords.id_order_status, ords.text_description, ords.id_manager,ords.id_printing,ords.id_cutter,\n" +
                "   pm.name_people as name_manager,\n" +
                "\tpp.name_people as name_printing,\n" +
                "    pc.name_people as name_cutter,\n" +
                "\tcc.name_сompany as name_client, ifnull(pay.data_pay,'') as data_pay , ords.id_client\n" +
                "from orders ords  \n" +
                "\tinner join status_order orst on orst.id_status_order=ords.id_order_status\n" +
                "    inner join people pm on pm.id_people=ords.id_manager\n" +
                "    inner join people pp on pp.id_people=ords.id_printing\n" +
                "    inner join people pc on pc.id_people=ords.id_cutter\n" +
                "    inner join clients cc on cc.id_clients=ords.id_client\n" +
                "    left join order_pay pay on pay.id_orders=ords.id_orders\n" +
                "group by id_orders order by id_orders desc) as ord  \n" +
                ") as ord1 ) as p \n" +
                "where status_pay='Оплачено' and data_pay=curdate() and  data_create<>data_pay";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderList> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
}

