package sample.model.statistic.deal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 28.03.2017.
 */
public class DealDB {

    public static ObservableList<Deal> select() throws Exception {

        String selectStmt = "SELECT * FROM deal";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<Deal> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<Deal> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<Deal> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            Deal data = new Deal();
            data.setIdDeal(result.getInt("id_deal"));
            data.setNameDeal(result.getString("name_deal"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}
