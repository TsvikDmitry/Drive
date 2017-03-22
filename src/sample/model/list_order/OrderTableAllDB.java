package sample.model.list_order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 20.03.2017.
 */
public class OrderTableAllDB {


    public static ObservableList<OrderTableAll> select(Integer id_orders) throws Exception {

        String selectStmt = "(SELECT id_order_printer as id_order_all, id_сategory, id_orders, name_order, count, sum_one, sum_all, prime_cost_sum_one, prime_cost_sum_all, sum_all-prime_cost_sum_all as profit, text_desc FROM order_printer where id_orders="+id_orders+") \n" +
                "union\n" +
                "(SELECT id_order_plotter as id_order_all, id_сategory, id_orders, name_order, count, sum_one, sum_all, prime_cost_sum_one, prime_cost_sum_all, sum_all-prime_cost_sum_all as profit, text_desc FROM order_plotter where id_orders="+id_orders+")\n" +
                "union\n" +
                "(SELECT id_order_binding as id_order_all, id_сategory, id_orders, name_order, count, sum_one, sum_all, prime_cost_sum_one, prime_cost_sum_all, sum_all-prime_cost_sum_all as profit, text_desc FROM order_binding where id_orders="+id_orders+")\n" +
                "union\n" +
                "(SELECT id_order_service as id_order_all, id_сategory, id_orders, name_order, count, sum_one, sum_all, prime_cost_sum_one, prime_cost_sum_all, sum_all-prime_cost_sum_all as profit, text_desc FROM order_service where id_orders="+id_orders+")"+
                "union\n" +
                "(SELECT id_order_product as id_order_all, id_сategory, id_orders, name_order, count, sum_one, sum_all, prime_cost_sum_one, prime_cost_sum_all, sum_all-prime_cost_sum_all as profit, text_desc FROM order_product where id_orders="+id_orders+")";
             //     System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderTableAll> printerList = getPrinterResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<OrderTableAll> getPrinterResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderTableAll> printerList =  FXCollections.observableArrayList();

        while (result.next()) {
            OrderTableAll printer = new OrderTableAll();
            printer.setIdOrderAll(result.getInt("id_order_all"));
            printer.setIdCategory(result.getInt("id_сategory"));
            printer.setIdOrders(result.getInt("id_orders"));
            printer.setCount(result.getInt("count"));
            printer.setNameOrder(result.getString("name_order"));
            printer.setCostSumOne(result.getDouble("sum_one"));
            printer.setCostSumAll(result.getDouble("sum_all"));
            printer.setPrimeCostSumOne(result.getDouble("prime_cost_sum_one"));
            printer.setPrimeCostSumAll(result.getDouble("prime_cost_sum_all"));
            printer.setProfit(result.getDouble("profit"));
            printer.setTextDesc(result.getString("text_desc"));


            printerList.add(printer);
        }
        return printerList;
    }



}


