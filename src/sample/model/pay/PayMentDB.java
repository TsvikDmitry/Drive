package sample.model.pay;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 22.02.2017.
 */
public class PayMentDB {

    public static ObservableList<PayMent> selectOrderPrinter() throws Exception {
        String selectStmt = "SELECT * FROM payment;";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PayMent> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }



    private static ObservableList<PayMent> getOrdersResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PayMent> payMente =  FXCollections.observableArrayList();


        while (result.next()) {
            PayMent orders = new PayMent();
            orders.setIdPayment(result.getInt("id_payment"));
            orders.setName_payment(result.getString("name_payment"));
            orders.setNamber_card(result.getString("namber_card"));
            orders.setFioPeople(result.getString("name_people"));
            orders.setVisible(result.getBoolean("visible"));
            payMente.add(orders);
        }
        return payMente;
    }


    public static ObservableList<PayMent> selectOrderPrinter2() throws Exception {
        String selectStmt = "SELECT * FROM payment;";
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        ObservableList<PayMent> printerList ;
        try {
            printerList =  FXCollections.observableArrayList();

            while (result.next()) {
                PayMent orders = new PayMent();
                orders.setNamber_card(result.getString("name_payment"));
                printerList.add(orders);
            }


            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
}
