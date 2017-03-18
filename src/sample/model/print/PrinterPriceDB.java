package sample.model.print;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 25.01.2017.
 */
public class PrinterPriceDB {

    public static ObservableList<PrinterPrice> selectPrinterPrice(Integer idPrinter, Integer idFormat, Integer count ) throws Exception {

        String selectStmt = "SELECT \n" +
                "pf.id_printer_price, pf.id_printer, pf.id_format,pf.id_price,\n" +
                "pp.name_printer,  ff.name_format, pr.name_price,\n" +
                " pf.count_print, pf.cost_print,   pf.prime_cost_print, pf.visible\n" +
                " FROM printer_price pf\n" +
                " inner join printer pp on pp.id_printer=pf.id_printer\n" +
                " inner join format ff on ff.id_format=pf.id_format\n" +
                " inner join price pr on pr.id_price=pf.id_price\n" +
                " where pf.id_printer="+idPrinter+" and pf.id_format="+idFormat+"  and pf.count_print>"+count+" " +
                " group by pf.id_price;";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PrinterPrice> printerPriceList = getPrinterPriceResultSet(result);

            return printerPriceList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
    private static ObservableList<PrinterPrice> getPrinterPriceResultSet(ResultSet result) throws SQLException    {

        ObservableList<PrinterPrice> printerPriceList =  FXCollections.observableArrayList();

        while (result.next()) {
            PrinterPrice printerPrice = new PrinterPrice();
            printerPrice.setIdPrinterPrice(result.getInt("id_printer_price"));

            printerPrice.setIdPrinter(result.getInt("id_printer"));
            printerPrice.setIdFormat(result.getInt("id_format"));
            printerPrice.setIdPrice(result.getInt("id_price"));

            printerPrice.setNamePrice(result.getString("name_price"));
            printerPrice.setNameFormat(result.getString("name_format"));
            printerPrice.setNamePrinter(result.getString("name_printer"));

            printerPrice.setCountPrint(result.getInt("count_print"));

            printerPrice.setCostPrint(result.getFloat("cost_print"));
            printerPrice.setPrintPrimeCost(result.getFloat("prime_cost_print"));
            printerPrice.setVisible(result.getBoolean("visible"));

            printerPriceList.add(printerPrice);
        }
        return printerPriceList;
    }



}
