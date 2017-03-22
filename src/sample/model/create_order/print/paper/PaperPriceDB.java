package sample.model.create_order.print.paper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 29.01.2017.
 */
public class PaperPriceDB {

    private static String selectStmt1 ="SELECT prt.id_printer, prt.name_printer, f.id_format, \n" +
            " f.name_format, pap.id_paper, pap.name_paper, pp.density_paper,  pp.cost_paper, pp.prime_cost_paper \n" +
            "FROM printer_to_paper ppp\n" +
            "inner join printer prt on prt.id_printer=ppp.id_printer\n" +
            "inner join paper_price pp on pp.id_paper_price=ppp.id_paper_price\n" +
            "inner join format f on f.id_format=pp.id_format\n" +
            "inner join paper pap on pap.id_paper=pp.id_paper " ;

    private static ObservableList<PaperPrice> getPaperNameResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PaperPrice> paperNameList =  FXCollections.observableArrayList();

        while (result.next()) {
            PaperPrice paperPrice = new PaperPrice();

            paperPrice.setIdPrinter(result.getInt("id_printer"));
            paperPrice.setIdFormat(result.getInt("id_format"));
            paperPrice.setIdPaper(result.getInt("id_paper"));
            paperPrice.setPrinterName(result.getString("name_printer"));
            paperPrice.setFormatName(result.getString("name_format"));
            paperPrice.setPaperName(result.getString("name_paper"));
            paperPrice.setDensityPaperPrice(result.getInt("density_paper"));
            paperPrice.setPaperCost(result.getFloat("cost_paper"));
            paperPrice.setPaperPrimeCost(result.getFloat("prime_cost_paper"));
            paperNameList.add(paperPrice);
        }
        return paperNameList;
    }


    public static ObservableList<PaperPrice> selectPaperName(Integer idPrinter, Integer idFormat) throws Exception {
        String selectStmt = selectStmt1+
                " where f.id_format="+idFormat+" and prt.id_printer="+idPrinter+"  group by pap.id_paper;";
      //  System.out.println("selectPaperName  "+selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PaperPrice> paperPriceList = getPaperNameResultSet(result);

            return paperPriceList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    public static ObservableList<PaperPrice> selectDensity(Integer idPrinter, Integer idFormat, Integer idPaper)throws SQLException, ClassNotFoundException {

        String selectStmt = selectStmt1+
                " where f.id_format="+idFormat+" and prt.id_printer="+idPrinter+" and pp.id_paper= " +idPaper+" "+
                "group by  pp.density_paper;";
       // System.out.println("selectDensity  "+selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PaperPrice> paperPriceList = getPaperNameResultSet(result);

            return paperPriceList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    public static ObservableList<PaperPrice> selectPaperPrice(Integer idPrinter, Integer idFormat, Integer idPaper, Integer density)throws SQLException, ClassNotFoundException {

        //Get ResultSet from dbExecuteQuery method
        String selectStmt = selectStmt1+

                " where f.id_format="+idFormat+" and prt.id_printer="+idPrinter+"   and pp.id_paper= " +idPaper+" "+
                " and pp.density_paper="+density+";";
      // System.out.println("selectDensity  "+selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PaperPrice> paperPriceList = getPaperNameResultSet(result);

            return paperPriceList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
}
