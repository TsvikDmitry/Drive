package sample.model.statistic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.convection.Print;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 23.03.2017.
 */
public class PrintCountDB {

    public static ObservableList<PrintCount> selectDaysPrint(Integer id_printer) throws Exception {
        String selectStmt = "select *, count_start+count_printing-count_end as difference from (\n" +
                "SELECT (SELECT sum(count_print_a4)  FROM order_printer op\n" +
                "left join orders ord on ord.id_orders=op.id_orders\n" +
                "where data_create=pc.dataCount and op.id_printer=pc.id_printer\n" +
                "group by data_create, op.id_printer)  as count_printing, \n" +
                "pc.id_printer,pp.name_printer, id_printer_counter, pc.dataCount, count_start, count_end \n" +
                " FROM printer_counter pc\n" +
                "inner join order_printer op on pc.id_printer=op.id_printer\n" +
                "inner join printer pp on pp.id_printer=pc.id_printer\n" +
                "where pc.id_printer="+id_printer+
                "\n group by dataCount, pc.id_printer) as p";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<PrintCount> printerList = getOrdersResultSet(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }


    public static ObservableList<PrintCount> selectDay() throws Exception {
        String selectStmt = "select *, count_start+count_printing-count_end as difference from (\n" +
                "SELECT (SELECT sum(count_print_a4)  FROM order_printer op\n" +
                "left join orders ord on ord.id_orders=op.id_orders\n" +
                "where data_create=pc.dataCount and op.id_printer=pc.id_printer\n" +
                "group by data_create, op.id_printer)  as count_printing, \n" +
                "pc.id_printer,pp.name_printer, id_printer_counter, pc.dataCount, count_start, count_end \n" +
                " FROM printer_counter pc\n" +
                "inner join order_printer op on pc.id_printer=op.id_printer\n" +
                "inner join printer pp on pp.id_printer=pc.id_printer\n" +
                "group by dataCount, pc.id_printer) as p";
        new Print("selectToDay", selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<PrintCount> printerList = getOrdersResultSet(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }
    public static ObservableList<PrintCount> selectToDay() throws Exception {
        String selectStmt = "select *, count_start+count_printing-count_end as difference from (\n" +
                "SELECT (SELECT sum(count_print_a4)  FROM order_printer op\n" +
                "left join orders ord on ord.id_orders=op.id_orders\n" +
                "where data_create=pc.dataCount and op.id_printer=pc.id_printer\n" +
                "group by data_create, op.id_printer)  as count_printing, \n" +
                "pc.id_printer,pp.name_printer, id_printer_counter, pc.dataCount, count_start, count_end \n" +
                " FROM printer_counter pc\n" +
                "inner join order_printer op on pc.id_printer=op.id_printer\n" +
                "inner join printer pp on pp.id_printer=pc.id_printer\n" +
                "where dataCount=curdate()\n" +
                "group by dataCount, pc.id_printer) as p";

    new Print("selectToDay", selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<PrintCount> printerList = getOrdersResultSet(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }

    private static ObservableList<PrintCount> getOrdersResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PrintCount> payMente =  FXCollections.observableArrayList();
        while (result.next()) {
            PrintCount orders = new PrintCount();
            orders.setIdPrinterCounter(result.getInt("id_printer_counter"));
            orders.setIdPrinter(result.getInt("id_printer"));
            orders.setNamePrinter(result.getString("name_printer"));
            orders.setDataCount(result.getString("dataCount"));
            orders.setCountEnd(result.getInt("count_end"));
            orders.setCountStart(result.getInt("count_start"));
            orders.setDifference(result.getInt("difference"));
            orders.setCounterPrinting(result.getInt("count_printing"));



            payMente.add(orders);
        }
        return payMente;
    }

    public static void LastOrder() throws SQLException, ClassNotFoundException {

        for (int id = 1; id <=3; id++){

                String selectStmt = "SELECT EXISTS(SELECT id_printer_counter end FROM printer_counter where id_printer="+id+" and dataCount=CURDATE()) as rou;";

                ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            Integer index =  0;
            while (result.next()) {
                index = result.getInt("rou");
                //System.out.println(index);
            }

        if (index == 0 ){
            String updateStmt = "INSERT INTO  \n" +
                    "printer_counter\n" +
                    "(id_printer, count_start, count_end, dataCount ) \n" +
                    "select "+id+", \n" +
                    "(SELECT count_end FROM printer_counter where dataCount<=date(CURDATE()-1) and id_printer="+id+" group by dataCount desc limit 1),\n" +
                    "0, CURDATE() ";
            ExecuteQuery.dbExecuteUpdate(updateStmt);

        }
        }

    }

    public static void updateCountStart(Integer idPrinter, Integer count_start)  {

        String selectStmt = "SELECT id_printer_counter FROM  printer_counter where id_printer="+idPrinter+" and dataCount=curdate();";
        String updateStmt = "UPDATE  printer_counter set id_printer="+idPrinter+", count_start="+count_start+" where id_printer_counter=";
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            while (result.next()) {
                ExecuteQuery.dbExecuteUpdate(updateStmt+ result.getInt("id_printer_counter"));
                System.out.println(updateStmt+ result.getInt("id_printer_counter"));

            }
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }


    }
    public static void updateCountEnd(Integer idPrinter, Integer count_end)  {

        String selectStmt = "SELECT id_printer_counter FROM  printer_counter where id_printer="+idPrinter+" and dataCount=curdate();";
        String updateStmt = "UPDATE  printer_counter set id_printer="+idPrinter+", count_end="+count_end+" where id_printer_counter=";
        System.out.println(selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            while (result.next()) {
                ExecuteQuery.dbExecuteUpdate(updateStmt+ result.getInt("id_printer_counter"));
                System.out.println(updateStmt+ result.getInt("id_printer_counter"));

            }
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }

    }

    public static void updateDayCountEnd(Integer idPrinterCount, Integer count_end)  {

        String updateStmt = "UPDATE  printer_counter set count_end="+count_end+" where id_printer_counter="+idPrinterCount+"";
        System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }

    }

    public static void updateDayCountStart(Integer idPrinterCount, Integer count_start)  {

        String updateStmt = "UPDATE  printer_counter set count_start="+count_start+" where id_printer_counter="+idPrinterCount+"";
        System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }

    }
/*
    public static int LastOrder()  {
        OrderList orders = new OrderList();

        String selectStmt = "SELECT LAST_INSERT_ID() as LastIdOrders;";
        try {
            try {
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
*/
}
