package sample.model.pay;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.convection.ToDate;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Dima on 01.03.2017.
 */
public class PayOrderDB {

    public static ObservableList<PayOrder> selectOrderPrinter() throws Exception {
        String selectStmt = "SELECT orp.id_orders, orp.id_order_pay, orp.data_get, orp.time_get, orp.data_pay,orp.time_pay, orp.id_order_paymant, orp.sum_pay FROM order_pay orp;";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PayOrder> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }


    public static ObservableList<PayOrder> selectOrderPrinter(Integer idOrder) throws Exception {
        String selectStmt = "SELECT orp.id_orders, orp.id_order_pay, orp.data_get, orp.time_get, orp.data_pay,orp.time_pay, orp.id_order_paymant, orp.sum_pay,\n" +
                "met.name_payment, met.namber_card, orp.text_pay, met.name_people\n" +
                "FROM order_pay orp\n" +
                "inner join order_payment met on met.id_payment=orp.id_order_paymant" +
                " where id_orders="+idOrder+";";
    //System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PayOrder> printerList = getOrdersResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }
    }

    private static ObservableList<PayOrder> getOrdersResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PayOrder> payOrder =  FXCollections.observableArrayList();


        while (result.next()) {
            PayOrder orders = new PayOrder();
            orders.setIdOrder(result.getInt("id_orders"));
            orders.setIdPay(result.getInt("id_order_pay"));
            orders.setIdPaymant(result.getInt("id_order_paymant"));
            orders.setDataGet(result.getString("data_get")+" "+result.getString("time_get"));
            orders.setTimeGet(result.getString("time_get"));
            orders.setDataPay(result.getString("data_pay")+" "+result.getString("time_pay"));
            orders.setTimePay(result.getString("time_pay"));
            orders.setSumPay(result.getFloat("sum_pay"));
            orders.setTextPay(result.getString("text_pay"));
            orders.setNamePayment(result.getString("name_payment"));
            orders.setNamberCard(result.getString("namber_card"));
            orders.setNamePeople(result.getString("name_people"));


            payOrder.add(orders);
        }
        return payOrder;
    }


    public static void insertOrderPrinter(Integer idOrders, Integer IdPaymant, LocalDate data_get, String time_get, Float sum_pay, String text_pay) throws SQLException, ClassNotFoundException {


        String updateStmt1 ="INSERT INTO `order_pay` (`id_orders`, `id_order_paymant`,`data_pay`, `time_pay`, `sum_pay`) VALUES ( " +
                "'"+idOrders+"', " +
                "'"+IdPaymant+"', " +
                "'"+new ToDate().getToDay()+"', " +
                "'"+new ToDate().getTime()+"', " +
                "'"+sum_pay+"');\n";

        String updateStmt2 ="INSERT INTO `order_pay` (`id_orders`, `id_order_paymant`,`data_pay`, `time_pay`, `data_get`, `time_get`, `sum_pay`,  `text_pay`) VALUES ( " +
                "'"+idOrders+"', " +
                "'"+IdPaymant+"', " +
                "'"+new ToDate().getToDay()+"', " +
                "'"+new ToDate().getTime()+"', " +
                "'"+data_get+"', " +
                "'"+time_get+"', " +
                "'"+sum_pay+"'," +
                "'"+text_pay+"');";

        try {
            if (IdPaymant==1){
                ExecuteQuery.dbExecuteUpdate(updateStmt1);
              //  System.out.println(updateStmt1);

            }else{
                ExecuteQuery.dbExecuteUpdate(updateStmt2);
              //  System.out.println(updateStmt2);

            }
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    public static void delete (Integer idOrders) throws SQLException, ClassNotFoundException {
        String updateStmt ="     DELETE FROM `order_pay` WHERE `id_order_pay`='"+idOrders+"'";

        System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }



}
