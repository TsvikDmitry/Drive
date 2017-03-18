package sample.model.binding;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingSpringSizeDB {

    private static String selectStmt1 = "SELECT * FROM binding_spring_size bsz\n" +
            "inner join binding_spring bs on bs.id_binding_spring=bsz.id_binding_spring  \n";


    public static ObservableList<BindingSpringSize> selectSpringSize(Integer bindingId) throws Exception {

        String selectStmt = selectStmt1 +" where bsz.id_binding_spring="+bindingId+"";
       // System.out.println(selectStmt);


        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<BindingSpringSize> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<BindingSpringSize> selectSpring() throws Exception {

        String selectStmt = selectStmt1 +" group by bs.id_binding_spring";

          //  System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<BindingSpringSize> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<BindingSpringSize> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<BindingSpringSize> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            BindingSpringSize data = new BindingSpringSize();
            data.setIdBindingSpringSize(result.getInt("id_binding_spring_size"));
            data.setIdBindingSpring(result.getInt("id_binding_spring"));
            data.setSheet(result.getInt("sheet"));
            data.setNameSpring(result.getString("name_spring"));
            data.setNameSpringEng(result.getString("name_spring_eng"));
            data.setNameColor(result.getString("name_color"));
            data.setNameSize(result.getString("name_size"));
            data.setCostSize(result.getDouble("cost_size"));
            data.setPrimeCostSize(result.getDouble("prime_cost_size"));
            data.setVisible(result.getBoolean("visible"));
            listSet.add(data);
        }
        return listSet;
    }

}
