package sample.model.statistic.save_banknot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 07.04.2017.
 */
public class SaveBanknotDB {

    public static ObservableList<SaveBanknot> selectToDay() throws Exception {
        String selectStmt = "SELECT * FROM save_banknot;";

       // new Print("", selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
            ObservableList<SaveBanknot> printerList = getOrdersResultSet(result);
            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }

    private IntegerProperty idSaveBanknot;
    private StringProperty dataSave;
    private IntegerProperty bank_500;
    private IntegerProperty bank_200;
    private IntegerProperty bank_100;
    private IntegerProperty bank_50;
    private IntegerProperty bank_20;
    private IntegerProperty bank_10;
    private IntegerProperty bank_5;
    private IntegerProperty bank_2;
    private IntegerProperty bank_1;
    private IntegerProperty bank_01;
    private IntegerProperty bank_050;
    private IntegerProperty bank_025;
    private IntegerProperty bank_010;
    private IntegerProperty bank_005;
    private DoubleProperty all_money;

    private static ObservableList<SaveBanknot> getOrdersResultSet(ResultSet result) throws SQLException
    {
        ObservableList<SaveBanknot> payMente =  FXCollections.observableArrayList();
        while (result.next()) {
            SaveBanknot orders = new SaveBanknot();
            orders.setIdSaveBanknot(result.getInt("id_printer_counter"));
            orders.setDataSave(result.getString("date_save"));
            orders.setBank_500(result.getInt("bank_500"));
            orders.setBank_200(result.getInt("bank_200"));
            orders.setBank_100(result.getInt("bank_100"));
            orders.setBank_50(result.getInt("bank_50"));
            orders.setBank_20(result.getInt("bank_20"));
            orders.setBank_10(result.getInt("bank_10"));
            orders.setBank_5(result.getInt("bank_5"));
            orders.setBank_2(result.getInt("bank_2"));
            orders.setBank_1(result.getInt("bank_1"));
            orders.setBank_01(result.getInt("bank_01"));
            orders.setBank_050(result.getInt("bank_050"));
            orders.setBank_025(result.getInt("bank_025"));
            orders.setBank_010(result.getInt("bank_010"));
            orders.setBank_005(result.getInt("bank_005"));
            orders.setAll_money(result.getDouble("all_money"));

            payMente.add(orders);
        }
        return payMente;
    }



 public static void InsertSaveBaknot(Integer bank_500, Integer bank_200, Integer bank_100, Integer bank_50, Integer bank_20, Integer bank_10, Integer bank_5, Integer bank_2, Integer bank_1, Integer bank_01, Integer bank_050, Integer bank_025, Integer bank_010, Integer bank_005, Double all_money){

        String updateStmt = "INSERT INTO save_banknot\n" +
                "(date_save,bank_500,bank_200,bank_100,bank_50,bank_20,bank_10,bank_5,bank_2,bank_1,bank_01,bank_050,bank_025,bank_010,bank_005,all_money) VALUES" +
                "( curdate(), "+bank_500+", "+bank_200+", "+bank_100+", "+bank_50+", "+bank_20+", "+bank_10+", "+bank_5+", "+bank_2+", "+bank_1+", "+bank_01+", "+bank_050+", "+bank_025+", "+bank_010+", "+bank_005+", "+all_money+")";
     System.out.println(" "+updateStmt);

     try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

  public static void InsertSaveBaknot(String date_save, Integer bank_500, Integer bank_200, Integer bank_100, Integer bank_50, Integer bank_20, Integer bank_10, Integer bank_5, Integer bank_2, Integer bank_1, Integer bank_01, Integer bank_050, Integer bank_025, Integer bank_010, Integer bank_005, Double all_money){

        String updateStmt = "INSERT INTO save_banknot\n" +
                "(date_save,bank_500,bank_200,bank_100,bank_50,bank_20,bank_10,bank_5,bank_2,bank_1,bank_01,bank_050,bank_025,bank_010,bank_005,all_money) VALUES" +
                " curdate(),"+date_save+", "+bank_500+", "+bank_200+", "+bank_100+", "+bank_50+", "+bank_20+", "+bank_10+", "+bank_5+", "+bank_2+", "+bank_1+", "+bank_01+", "+bank_050+", "+bank_025+", "+bank_010+", "+bank_005+", "+all_money+";\n";
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
