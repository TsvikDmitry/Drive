package sample.model.create_order.plotter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 09.03.2017.
 */
public class PlotterDB {

    public static ObservableList<Plotter> select() throws Exception {

        String selectStmt = "SELECT * FROM plotter  where visible=0";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<Plotter> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<Plotter> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<Plotter> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            Plotter plotter = new Plotter();
            plotter.setPlotterId(result.getInt("id_plotter"));
            plotter.setPlotterName(result.getString("name_plotter"));
            plotter.setPlotterNameEng(result.getString("name_plotter_eng"));
            plotter.setVisible(result.getBoolean("visible"));

            listSet.add(plotter);
        }
        return listSet;
    }


}
