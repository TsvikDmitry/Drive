package sample.model.create_order.binding;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingFormatDB {

    public static ObservableList<BindingFormat> select() throws Exception {

        String selectStmt = "SELECT * FROM binding_format";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<BindingFormat> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<BindingFormat> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<BindingFormat> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            BindingFormat data = new BindingFormat();
            data.setIdBindingFormat(result.getInt("id_binding_format"));
            data.setNameFormat(result.getString("name_format"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}
