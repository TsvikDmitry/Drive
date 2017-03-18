package sample.model.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 14.03.2017.
 */
public class ServiceItemsDB {

    private static String selectStmt1 = "SELECT * FROM service_items si\n" +
            "inner join service ss on ss.id_service=si.id_service  \n";



    public static ObservableList<ServiceItems> select(Integer idService) throws Exception {

        String selectStmt = selectStmt1 +" where ss.id_service="+idService+"";
        System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<ServiceItems> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<ServiceItems> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<ServiceItems> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            ServiceItems data = new ServiceItems();
            data.setIdService(result.getInt("id_service"));
            data.setIdServiceItems(result.getInt("id_service"));
            data.setNameItems(result.getString("name_items"));
            data.setNameItemsEng(result.getString("name_items_eng"));
            data.setNameService(result.getString("name_service"));
            data.setNameServiceEng(result.getString("name_service_eng"));
            data.setCostItems(result.getDouble("cost_items"));
            data.setPrimeCostItems(result.getDouble("prime_cost_items"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}
