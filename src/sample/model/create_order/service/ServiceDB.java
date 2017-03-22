package sample.model.create_order.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 14.03.2017.
 */
public class ServiceDB {

    public static ObservableList<Service> select() throws Exception {

        String selectStmt = "SELECT * FROM service;";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<Service> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<Service> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<Service> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            Service data = new Service();
            data.setIdService(result.getInt("id_service"));
            data.setNameService(result.getString("name_service"));
            data.setNameServiceEng(result.getString("name_service_eng"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}
