package sample.model.create_order.print;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 26.01.2017.
 */
public class PrinterFormatDB {



    public static ObservableList<PrinterFormat> selectPrinterFormat(Integer PrintID) throws Exception {

        String selectStmt = "SELECT pf.id_printer, pp.name_printer, ff.id_format, ff.name_format, pf.visible FROM printer_format pf\n" +
                " inner join printer pp on pp.id_printer=pf.id_printer\n" +
                " inner join format ff on ff.id_format=pf.id_format "+
                " where pf.id_printer="+PrintID+";";
      //  System.out.println(selectStmt);

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<PrinterFormat> printerList = getPrinterFormatResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }
    private static ObservableList<PrinterFormat> getPrinterFormatResultSet(ResultSet result) throws SQLException    {

        ObservableList<PrinterFormat> printerFormatList =  FXCollections.observableArrayList();
        PrinterFormat printerFormat = null;
        while (result.next()) {
            printerFormat = new PrinterFormat();
            printerFormat.setPrinterId(result.getInt("id_printer"));
            printerFormat.setFormatId(result.getInt("id_format"));
            printerFormat.setPrinterName(result.getString("name_printer"));
            printerFormat.setFormatName(result.getString("name_format"));
            printerFormat.setVisible(result.getBoolean("visible"));
            printerFormatList.add(printerFormat);
        }
        return printerFormatList;
    }


}
