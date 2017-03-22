package sample.model.create_order.plotter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.convection.Print;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 09.03.2017.
 */
public class PlotterPriceDB {

    private static String Stmt = "SELECT plp.id_plotter_price, plp.visible as visible_plotter_price, plc.cost_print+plpc.cost_paper as cost,  plpc.prime_cost_paper+plc.prime_cost_print as prime_cost, \n" +
            " pl.name_plotter,pl.name_plotter_eng, pl.visible as visible_plotter, \n" +
            " plc.id_plotter, plc.fill, plc.prime_cost_print, plc.visible as visible_plotter_cost,  plc.cost_print,\n" +
            " plpp.name_paper, plpp.name_paper_eng, plpp.visible as visible_paper, \n" +
            " plpc.id_plotter_paper, plpc.width, plpc.density, plpc.cost_paper, plpc.prime_cost_paper, plpc.visible as visible_paper_cost\n" +
            " FROM plotter_price plp\n" +
            " inner join plotter_cost plc on plc.id_plotter_cost=plp.id_plotter_cost\n" +
            " inner join plotter pl on pl.id_plotter=plc.id_plotter\n" +
            " inner join plotter_paper_cost plpc on plpc.id_plotter_paper_cost=plp.id_plotter_paper_cost\n" +
            " inner join plotter_paper plpp on plpp.id_plotter_paper=plpc.id_plotter_paper\n" +
            " where plp.visible=1  ";




    private static ObservableList<PlotterPrice> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PlotterPrice> listSet =  FXCollections.observableArrayList();

        while (result.next()) {


            PlotterPrice plotter = new PlotterPrice();
            plotter.setPlotterPriceId(result.getInt("id_plotter_price"));
            plotter.setPrimeCost(result.getFloat("prime_cost"));

            plotter.setPlotterName(result.getString("name_plotter"));
            plotter.setPlotterNameEng(result.getString("name_plotter_eng"));

            plotter.setPlotterId(result.getInt("id_plotter"));
            plotter.setFill(result.getInt("fill"));
            plotter.setPrimeCostPrint(result.getFloat("prime_cost_print"));
            plotter.setCostPrint(result.getFloat("cost_print"));

            plotter.setPaperName(result.getString("name_paper"));
            plotter.setPaperNameEng(result.getString("name_paper_eng"));

            plotter.setPaperId(result.getInt("id_plotter_paper"));
            plotter.setWidth(result.getInt("width"));
            plotter.setDensity(result.getInt("density"));
            plotter.setPrimeCostPaper(result.getFloat("prime_cost_paper"));
            plotter.setCostPaper(result.getFloat("cost_paper"));


            listSet.add(plotter);
        }
        return listSet;
    }

    public static ObservableList<PlotterPrice> selectPlotterPaper(Integer PlotterId) throws Exception {

        String selectStmt = Stmt +" and plc.id_plotter="+PlotterId+" group by plc.id_plotter";

       // new Print("selectPlotterPaper", selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PlotterPrice> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<PlotterPrice> selectFill(Integer PlotterId,Integer PaperId) throws Exception {

        String selectStmt = Stmt +" and plc.id_plotter="+PlotterId+"  and plpc.id_plotter_paper="+PaperId+" group by fill order by fill desc";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PlotterPrice> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<PlotterPrice> selectDensity(Integer PlotterId,Integer PaperId) throws Exception {

        String selectStmt = Stmt +" and plc.id_plotter="+PlotterId+"  and plpc.id_plotter_paper="+PaperId+" group by density order by density desc";
        System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PlotterPrice> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<PlotterPrice> selectWidth(Integer PlotterId,Integer PaperId, Integer Density, Integer Fill ) throws Exception {

        String selectStmt = Stmt +" and plc.id_plotter="+PlotterId+"  and plpc.id_plotter_paper="+PaperId+" and Density="+Density+" and Fill="+Fill+" ";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PlotterPrice> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

}
