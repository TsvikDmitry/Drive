package sample.model.create_order.binding;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingWorkDB {

    private static String selectStmt1 = "SELECT * FROM binding_work bw\n" +
            "inner join binding_format bf on bf.id_binding_format=bw.id_binding_format \n";

    public static ObservableList<BindingWork> select() throws Exception {

        String selectStmt = selectStmt1 ;


        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<BindingWork> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<BindingWork> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<BindingWork> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            BindingWork data = new BindingWork();
            data.setIdBindingWork(result.getInt("id_binding_work"));
            data.setIdBindingFormat(result.getInt("id_binding_format"));
            data.setSheetWork(result.getInt("sheet_work"));
            data.setNameFormat(result.getString("name_format"));
            data.setNameWork(result.getString("name_work"));
            data.setNameWorkEng(result.getString("name_work_eng"));
            data.setCostWork(result.getDouble("cost_work"));
            data.setPrimeCostWork(result.getDouble("prime_cost_work"));
            data.setVisible(result.getBoolean("visible"));


            listSet.add(data);
        }
        return listSet;
    }



    public static BindingWork getCostWork(Integer formaId, Integer sheet) throws Exception {
        BindingWork workData = new BindingWork();
        String selectStmt = selectStmt1+
                "where bw.id_binding_format="+formaId+" and bw.sheet_work>="+sheet+" order by sheet_work limit 1;";
      //  System.out.println(selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<BindingWork> dataList =  FXCollections.observableArrayList();
            while (result.next()) {
                workData.setIdBindingWork(result.getInt("id_binding_work"));
                workData.setIdBindingFormat(result.getInt("id_binding_format"));
                workData.setSheetWork(result.getInt("sheet_work"));
                workData.setNameFormat(result.getString("name_format"));
                workData.setNameWork(result.getString("name_work"));
                workData.setNameWorkEng(result.getString("name_work_eng"));
                workData.setCostWork(result.getDouble("cost_work"));
                workData.setPrimeCostWork(result.getDouble("prime_cost_work"));
                workData.setVisible(result.getBoolean("visible"));

                dataList.add(workData);
            }
            ObservableList<BindingWork> printerList = dataList;

            //  return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
        return  workData;
    }
}
