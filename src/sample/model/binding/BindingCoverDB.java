package sample.model.binding;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BindingCoverDB {

    public static ObservableList<BindingCover> select(Integer formaId) throws Exception {

        String selectStmt = "SELECT * FROM binding_cover bc\n" +
                "inner join binding_format bf on bf.id_binding_format=bc.id_binding_format\n" +
                "where bc.id_binding_format="+formaId+";";


        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<BindingCover> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<BindingCover> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<BindingCover> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            BindingCover data = new BindingCover();
            data.setIdBindingCover(result.getInt("id_binding_cover"));
            data.setIdBindingFormat(result.getInt("id_binding_format"));
            data.setNameFormat(result.getString("name_format"));
            data.setNameCover(result.getString("name_cover"));
            data.setNameCoverEng(result.getString("name_cover_eng"));
            data.setCostCover(result.getDouble("cost_cover"));
            data.setPrimeCostCover(result.getDouble("prime_cost_cover"));
            data.setVisible(result.getBoolean("visible"));


            listSet.add(data);
        }
        return listSet;
    }
}
