package sample.model.list_order.orders;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 22.03.2017.
 */
public class OrderStatusDB {
    private static String selectStmt1 = "SELECT * FROM status_order;";

    public static ObservableList<OrderStatus> select() throws Exception {
        String selectStmt = selectStmt1;

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderStatus> printerList = getResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }



    private static ObservableList<OrderStatus> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderStatus> payMente =  FXCollections.observableArrayList();


        while (result.next()) {
            OrderStatus orders = new OrderStatus();
            orders.setIdOrderStatus(result.getInt("id_status_order"));
            orders.setNameStatus(result.getString("name_status_order"));
            orders.setVisible(result.getBoolean("visible"));
            payMente.add(orders);
        }
        return payMente;
    }


    public static ObservableList<OrderStatus> selectList() throws Exception {
        String selectStmt = selectStmt1;
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        ObservableList<OrderStatus> printerList ;
        try {
            printerList =  FXCollections.observableArrayList();

            while (result.next()) {
                OrderStatus orders = new OrderStatus();
                orders.setIdOrderStatus(result.getInt("id_status_order"));
                orders.setNameStatus(result.getString("name_status_order"));
                printerList.add(orders);
            }


            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
}