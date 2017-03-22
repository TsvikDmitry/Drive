package sample.model.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDB {

    private static String selectStmt1 = "SELECT * FROM clients;";

    public static ObservableList<Client> select() throws Exception {
        String selectStmt = selectStmt1;

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<Client> printerList = getResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }



    private static ObservableList<Client> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<Client> payMente =  FXCollections.observableArrayList();


        while (result.next()) {
            Client orders = new Client();
            orders.setIdClient(result.getInt("id_clients"));
            orders.setNameClient(result.getString("name_сompany"));
            orders.setFioClient(result.getString("fio"));
            orders.setPhoneClient(result.getString("phone"));
            orders.setPrice(result.getInt("id_price"));

            payMente.add(orders);
        }
        return payMente;
    }



    public static ObservableList<Client> selectList() throws Exception {
        String selectStmt = selectStmt1;
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        ObservableList<Client> printerList ;
        try {
            printerList =  FXCollections.observableArrayList();

            while (result.next()) {
                Client orders = new Client();
                orders.setIdClient(result.getInt("id_clients"));
                orders.setNameClient(result.getString("name_сompany"));
                orders.setFioClient(result.getString("fio"));
                orders.setPhoneClient(result.getString("phone"));
                orders.setPrice(result.getInt("id_price"));
                printerList.add(orders);
            }


            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }



}
