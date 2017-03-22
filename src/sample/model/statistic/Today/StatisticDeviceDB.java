package sample.model.statistic.Today;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.convection.Print;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticDeviceDB {
    public static ObservableList<StatisticDevice> select2() throws Exception {
        String selectStmt = "select id_people, name_people,\n" +
                "m_1,m_p2,\n" +
                "(m_print+m_plotter+m_binding+m_service) as sum_manager, \n" +
                "(m_print+m_plotter+m_binding+m_service)*ord.percent_manager/100 as manager, \n" +
                "\n" +
                "(p_print+p_plotter) as sum_printing,\n" +
                "\n" +
                "(p_print+p_plotter)*ord.percent_printing/100 as printing,\n" +
                "(s_binding+s_service) as sum_cutter,\n" +
                "\n" +
                "(s_binding+s_service)*ord.percent_service/100 as cutter,\n" +
                "\n" +
                "(s_binding+m_service_one)*ord.percent_service_one/100 as cutter_one\n" +
                "\n" +
                "from (select ryls.id_people,ryls.name_people,\n" +
                " IFNULL((select sum(ordp.sum_all) from order_plotter  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_manager=ryls.id_people  and ord.data_create=curdate()) ,0) as m_p2, \n" +
                "    \n" +
                "\t IFNULL((select  sum(ordp.sum_all) from order_printer  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders  \n" +
                "    where ord.id_manager=ryls.id_people and ord.data_create=curdate()),0) as m_1,\n" +
                "    \n" +
                "    IFNULL((select  sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_printer  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders  \n" +
                "    where ord.id_manager=ryls.id_people and ord.data_create=curdate()),0) as m_print,\n" +
                "        \n" +
                "    IFNULL((select sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_plotter  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_manager=ryls.id_people  and ord.data_create=curdate()) ,0) as m_plotter, \n" +
                "    \n" +
                "      IFNULL((select  sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_binding  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_manager=ryls.id_people and ord.data_create=curdate()),0) as m_binding,\n" +
                "        \n" +
                "    IFNULL((select sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_service  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_manager=ryls.id_people  and ord.data_create=curdate() and ordp.id_service=1) ,0) as m_service, \n" +
                "    \n" +
                "    IFNULL((select sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_service  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_manager=ryls.id_people  and ord.data_create=curdate() and ordp.id_service=2) ,0) as m_service_one, \n" +
                "    \n" +
                "    IFNULL((select  sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_printer  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_cutter=ryls.id_people and ord.data_create=curdate()),0) as p_print,\n" +
                "        \n" +
                "    IFNULL((select sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_plotter  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where  ord.id_printing=ryls.id_people and ord.data_create=curdate()) ,0) as p_plotter,\n" +
                "    \n" +
                "    \n" +
                "    IFNULL((select  sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_binding  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where ord.id_cutter=ryls.id_people and ord.data_create=curdate()),0) as s_binding,\n" +
                "        \n" +
                "    IFNULL((select sum(ordp.sum_all)-sum(prime_cost_sum_all) from order_service  ordp\n" +
                "    inner join orders ord on ord.id_orders=ordp.id_orders \n" +
                "    where  ord.id_cutter=ryls.id_people and ord.data_create=curdate()) ,0) as s_service,\n" +
                "\n" +
                "\tryls.percent_printing, ryls.percent_manager, ryls.percent_service, ryls.percent_service_one,ryls.percent_binding\n" +
                "\n" +
                "from people ryls \n" +
                "\n" +
                ") as ord ;";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<StatisticDevice> printerList = getOrdersResultSet2(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }

    private static ObservableList<StatisticDevice> getOrdersResultSet2(ResultSet result) throws SQLException
    {
        ObservableList<StatisticDevice> payMente =  FXCollections.observableArrayList();
        while (result.next()) {
            StatisticDevice orders = new StatisticDevice();
          new Print("",""+result.getInt("id_people")+" "+result.getDouble("sum_printing"));


            payMente.add(orders);
        }
        return payMente;
    }

    public static ObservableList<StatisticDevice> selectGroupDevice(String data) throws Exception {
        String selectStmt = "SELECT ordp.id_сategory, сс.name_сategory, ordp.id_printer as id_items, pp.name_printer as name_items, sum(count_print_a4) \n" +
                "as count, sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_printer ordp\n" +
                "inner join orders ord on ord.id_orders=ordp.id_orders\n" +
                "inner join printer pp on pp.id_printer=ordp.id_printer\n" +
                "inner join сategory сс on сс.id_сategory=ordp.id_сategory\n" +
                "where ord.data_create="+data+"\n" +
                "group by id_items\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, ordpl.id_plotter as id_items, pl.name_plotter, sum(count) as count,  \n" +
                "sum(sum_all)  as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_plotter ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join plotter pl on pl.id_plotter=ordpl.id_plotter\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_plotter)\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, ordpl.id_service as id_items, sr.name_items, sum(count) as count, \n" +
                " sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_service ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join service_items sr on sr.id_service_items=ordpl.id_service_items\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_service_items)\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, ordpl.id_product as id_items, sr.name_items, sum(count) as count,  \n" +
                "sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_product ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join product_items sr on sr.id_product_items=ordpl.id_product_items\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_product_items)\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, 1,'Брошюровка' as id_items, sum(count) as count, \n" +
                " sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_binding ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_сategory)";

        //new Print("",selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<StatisticDevice> printerList = getOrdersResultSet(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList<StatisticDevice> selectGroupCategory(String data) throws Exception {
        String selectStmt = "SELECT ordp.id_сategory, сс.name_сategory, ordp.id_printer as id_items, pp.name_printer as name_items, sum(count_print_a4) \n" +
                "as count, sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_printer ordp\n" +
                "inner join orders ord on ord.id_orders=ordp.id_orders\n" +
                "inner join printer pp on pp.id_printer=ordp.id_printer\n" +
                "inner join сategory сс on сс.id_сategory=ordp.id_сategory\n" +
                "where ord.data_create="+data+"\n" +
                "group by id_сategory\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, ordpl.id_plotter as id_items, pl.name_plotter, sum(count) as count,  \n" +
                "sum(sum_all)  as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_plotter ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join plotter pl on pl.id_plotter=ordpl.id_plotter\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_сategory)\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, ordpl.id_service as id_items, sr.name_items, sum(count) as count, \n" +
                " sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_service ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join service_items sr on sr.id_service_items=ordpl.id_service_items\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_сategory)\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, ordpl.id_product as id_items, sr.name_items, sum(count) as count,  \n" +
                "sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_product ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join product_items sr on sr.id_product_items=ordpl.id_product_items\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_сategory)\n" +
                "union\n" +
                "(SELECT ordpl.id_сategory, сс.name_сategory, 1,'Брошюровка' as id_items, sum(count) as count, \n" +
                " sum(sum_all) as sum, sum(prime_cost_sum_all) as prime_cost_sum_all, sum(sum_all-prime_cost_sum_all) as profit\n" +
                "FROM order_binding ordpl\n" +
                "inner join orders ordl on ordl.id_orders=ordpl.id_orders\n" +
                "inner join сategory сс on сс.id_сategory=ordpl.id_сategory\n" +
                "where ordl.data_create="+data+"\n" +
                "group by ordpl.id_сategory)";

        //new Print("",selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<StatisticDevice> printerList = getOrdersResultSet(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }

    private static ObservableList<StatisticDevice> getOrdersResultSet(ResultSet result) throws SQLException
    {
        ObservableList<StatisticDevice> payMente =  FXCollections.observableArrayList();
        while (result.next()) {
            StatisticDevice orders = new StatisticDevice();
            orders.setIdCategory(result.getInt("id_сategory"));
            orders.setIdItems(result.getInt("id_items"));
            orders.setNameCategory(result.getString("name_сategory"));
            orders.setNameItems(result.getString("name_items"));
            orders.setCount(result.getInt("count"));
            orders.setSum(result.getDouble("sum"));
            orders.setPrimeCostSum(result.getDouble("prime_cost_sum_all"));
            orders.setProfit(result.getDouble("profit"));



            payMente.add(orders);
        }
        return payMente;
    }
}
