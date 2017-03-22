package sample.model.statistic.deal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.convection.Print;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 28.03.2017.
 */
public class DealGroupDB {
    public static ObservableList<DealGroup> select(Integer id_deal) throws Exception {

        String selectStmt = "SELECT * FROM deal_group dg\n" +
                "inner join deal d on d.id_deal=dg.id_deal\n" +
                "where dg.id_deal="+id_deal;
            //new Print(getClass(),id_deal);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<DealGroup> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<DealGroup> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<DealGroup> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            DealGroup data = new DealGroup();
            data.setIdDealGroup (result.getInt("id_deal_group"));
            data.setIdDeal(result.getInt("id_deal"));
            data.setNameDeal(result.getString("name_deal"));
            data.setNameGroup(result.getString("name_group"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}
