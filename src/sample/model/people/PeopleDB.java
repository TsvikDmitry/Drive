package sample.model.people;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 22.03.2017.
 */
public class PeopleDB {
    private static String selectStmt1 = "SELECT * FROM people;";

    public static ObservableList<People> select() throws Exception {
        String selectStmt = selectStmt1;

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<People> printerList = getResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }



    private static ObservableList<People> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<People> payMente =  FXCollections.observableArrayList();


        while (result.next()) {
            People orders = new People();
            orders.setIdPeople(result.getInt("id_people"));
            orders.setNamePeople(result.getString("name_people"));
            orders.setPassword(result.getString("password"));
            orders.setWage(result.getDouble("wage"));
          //  orders.setVisible(result.getBoolean("visible"));
            payMente.add(orders);
        }
        return payMente;
    }


    public static ObservableList<People> selectList() throws Exception {
        String selectStmt = selectStmt1;
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        ObservableList<People> printerList ;
        try {
            printerList =  FXCollections.observableArrayList();

            while (result.next()) {
                People orders = new People();
                orders.setIdPeople(result.getInt("id_people"));
                orders.setNamePeople(result.getString("name_people"));
                printerList.add(orders);
            }


            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
}
