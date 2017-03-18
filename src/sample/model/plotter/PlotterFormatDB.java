package sample.model.plotter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;
import sample.model.binding.BindingFormat;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 09.03.2017.
 */
public class PlotterFormatDB {


    public static ObservableList<PlotterFormat> select(Integer width) throws Exception {

        String selectStmt = "SELECT * FROM plotter_paper_format\n" +
                "where width="+width+" \n" +
                "order by name_format desc";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PlotterFormat> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<PlotterFormat> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PlotterFormat> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            PlotterFormat plotter = new PlotterFormat();
           plotter.setNameFormat(result.getString("name_format"));
            plotter.setWidth(result.getInt("width"));
            plotter.setLength(result.getInt("length"));

            listSet.add(plotter);
        }
        return listSet;
    }


}
