package sample.model.print;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PrinterDB {


    public static ObservableList<Printer> selectPrint() throws Exception {

        String selectStmt = "SELECT * FROM printer  where visible=0";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<Printer> printerList = getPrinterResultSet(result);

            return printerList;
        } catch (SQLException e) {
             System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<Printer> getPrinterResultSet(ResultSet result) throws SQLException
    {
        ObservableList<Printer> printerList =  FXCollections.observableArrayList();

        while (result.next()) {
            Printer printer = new Printer();
            printer.setPrinterId(result.getInt("id_printer"));
            printer.setPrinterName(result.getString("name_printer"));
            printer.setPrinterNameEng(result.getString("name_printer_eng"));
            printer.setVisible(result.getBoolean("visible"));


            printerList.add(printer);
        }
        return printerList;
    }


    public static void updatePrinterName (Integer idPrinter, String PrinterName, String PrinterNameEnd, Boolean visible ) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt = "";
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static void deletePrinter (String id_order_printer) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
               "DELETE FROM `order_printer` WHERE `id_order_printer`='"+id_order_printer+"';";

        //Execute UPDATE operation
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

}
