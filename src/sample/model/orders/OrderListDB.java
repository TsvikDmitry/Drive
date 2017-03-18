package sample.model.orders;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class OrderListDB {
    public static String selectStmt1 = "select id_orders,\n" +
            "\tord.data_create, ord.time_create, ord.data_end, ord.time_end,\n" +
            "\tcase  when brak <= 0 then 'Брак' \n" +
            "\telse case  when pay_sum = 0 then 'Не оплачен' \n" +
            "\telse case when order_sum= pay_sum then 'Оплачено' \n" +
            "\telse case when  order_sum>pay_sum then 'Задолженность' \n" +
            "\telse  case when  order_sum<pay_sum then 'Переплата' end  end end end end as status_pay,\n" +
            "    plotter,printer, order_sum,pay_sum,\n" +
            "\torder_sum-pay_sum as dolg, \n" +
            "    ord.name_status_order, ord.id_order_status, ord.text_description\n" +
            "from (select id_orders, \n" +
            "\tords.data_create, ords.time_create, ords.data_end, ords.time_end,\n" +
            "\tIFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0) as plotter,\n" +
            "\tIFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as printer,\n" +
            "    \tIFNULL((select sum(order_dop.sum_all) from order_dop  where order_dop.id_orders=ords.id_orders),0) as dop,\n" +
            "\tIFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0)+\n" +
            "    IFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0) as order_sum,\n" +
            "\tIFNULL((select sum(order_pay.sum_pay) from order_pay  where order_pay.id_orders=ords.id_orders ),0) as pay_sum,\n" +
            "\tIFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0)+\n" +
            "    IFNULL((select sum(order_plotter.sum_all) from order_plotter  where  order_plotter.id_orders=ords.id_orders),0) as brak,\n" +
            "    orst.name_status_order, ords.id_order_status, ords.text_description\n" +
            "from orders ords \n" +
            "\tinner join order_status orst on orst.id_status_order=ords.id_order_status \n" ;

        public static ObservableList<OrderList> selectOrderPrinter() throws Exception {
             String selectStmt = selectStmt1+
                    "group by id_orders order by id_orders desc) as ord ;\n";

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
       // String pattern = "yyyy-MM-dd HH:mm:ss";
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
      //  LocalDateTime date = LocalDateTime.parse("ord.data_create", formatter);

        while (result.next()) {
            OrderList orders = new OrderList();

            orders.setIdOrders(result.getInt("id_orders"));
            orders.setIdClient(result.getInt("id_orders"));
            orders.setIdOperator(result.getInt("id_orders"));
            orders.setDataCreate(result.getString("data_create"));
            orders.setTimeCreate(result.getString("time_create"));
            orders.setDataEnd(result.getString("data_end"));
            orders.setTimeEnd(result.getString("time_end"));
            orders.setStatusPay(result.getString("status_pay"));
            orders.setPlotter(result.getFloat("plotter"));
            orders.setPrinter(result.getFloat("printer"));
            orders.setOrderSum(result.getFloat("order_sum"));
            orders.setPaySum(result.getFloat("pay_sum"));
            orders.setDolg(result.getFloat("dolg"));
            orders.setIdOrderStatus(result.getInt("id_order_status"));
            orders.setNameSstatus(result.getString("name_status_order"));
            orders.setTextDescription(result.getString("text_description"));
            orderList.add(orders);
           // System.out.println(result.getString("time_create"));
           // System.out.println(orders.getTimeCreate());

        }
        return orderList;
    }


    public static int LastOrder()  {
        OrderList orders = new OrderList();

        Date toDay = new Date();
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        String updateStmt = "INSERT INTO `orders` (`id_order_status`,`data_create`,`time_create`,`data_end`) VALUES " +
                "('1', '"+date.format(toDay)+"','"+time.format(toDay)+"','"+date.format(toDay)+"');\n" ;

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
                "    where id_orders="+IdOrder+" group by id_orders ) as ord ;\n";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<OrderList> orderList =  FXCollections.observableArrayList();
            while (result.next()) {
                orders.setIdOrders(result.getInt("id_orders"));
                orders.setIdClient(result.getInt("id_orders"));
                orders.setIdOperator(result.getInt("id_orders"));
                orders.setDataCreate(result.getString("data_create"));
                orders.setTimeCreate(result.getString("time_create"));
                orders.setDataEnd(result.getString("data_end"));
                orders.setTimeEnd(result.getString("time_end"));
                orders.setStatusPay(result.getString("status_pay"));
                orders.setPlotter(result.getFloat("plotter"));
                orders.setPrinter(result.getFloat("printer"));
                orders.setOrderSum(result.getFloat("order_sum"));
                orders.setPaySum(result.getFloat("pay_sum"));
                orders.setDolg(result.getFloat("dolg"));
                orders.setIdOrderStatus(result.getInt("id_order_status"));
                orders.setNameSstatus(result.getString("name_status_order"));
                orders.setTextDescription(result.getString("text_description"));

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
    public static void deleteOrders (Integer id_order) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM `orders` WHERE `id_orders`='"+id_order+"'; ";
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }



/*
        public static void deleteOrderPrinter (Integer id_order_printer) throws SQLException, ClassNotFoundException {
            String updateStmt = "DELETE FROM `order_printer` WHERE `id_order_printer`='"+id_order_printer+"'; ";

            try {
                ExecuteQuery.dbExecuteUpdate(updateStmt);
            } catch (SQLException e) {
                System.out.print("Error occurred while UPDATE Operation: " + e);
                throw e;
            }
        }*/


}

