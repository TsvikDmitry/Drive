package sample.model.print.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderPrinterDB {


    public static ObservableList<OrderPrinter> selectOrderPrinter(Integer IdOrder) throws Exception {

        String selectStmt = "SELECT ordp.*, pp.name_printer, p.name_price, ff.name_format, dup.name_duplex, pap.name_paper, ordp.sum_one-ordp.prime_cost_sum_all as profit\n" +
                " FROM order_printer ordp\n" +
                "inner join price p on p.id_price=ordp.id_price\n" +
                "inner join format ff on ff.id_format=ordp.id_format\n" +
                "inner join duplex dup on dup.id_duplex=ordp.id_duplex\n" +
                "inner join paper pap on pap.id_paper=ordp.id_paper\n" +
                "inner join printer pp on pp.id_printer=ordp.id_printer\n " +
                "where id_orders="+IdOrder+";";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderPrinter> printerList = getOrderPrinterResultSet(result);

            return printerList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<OrderPrinter> getOrderPrinterResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderPrinter> printerList =  FXCollections.observableArrayList();


        while (result.next()) {
            OrderPrinter orderPrinter = new OrderPrinter();
            orderPrinter.setIdOrderPrinter(result.getInt("id_order_printer"));
            orderPrinter.setIdOrders(result.getInt("id_orders"));


            orderPrinter.setNamePrinter(result.getString("name_printer"));
            orderPrinter.setNamePaper(result.getString("name_paper"));

            orderPrinter.setNameOrder(result.getString("name_order"));
            orderPrinter.setNamePrice(result.getString("name_price"));
            orderPrinter.setNameFormat(result.getString("name_format"));
            orderPrinter.setNameDuplex(result.getString("name_duplex"));


            orderPrinter.setIdPrinter(result.getInt("id_printer"));
            orderPrinter.setIdFormat(result.getInt("id_format"));
            orderPrinter.setIdPrice(result.getInt("id_price"));
            orderPrinter.setIdDuplex(result.getInt("id_duplex"));
            orderPrinter.setIdPaper(result.getInt("id_paper"));


            orderPrinter.setDensity(result.getInt("density"));
            orderPrinter.setCount(result.getInt("count"));
            orderPrinter.setCostPrint(result.getFloat("cost_print"));
            orderPrinter.setCostPaper(result.getFloat("cost_paper"));
            orderPrinter.setCostSumOne(result.getFloat("sum_one"));
            orderPrinter.setCostSumAll(result.getFloat("sum_all"));
            orderPrinter.setCountPrinterA4(result.getInt("count_print_a4"));
            orderPrinter.setText(result.getString("text_desc"));

            orderPrinter.setPrimeCostPrint(result.getFloat("prime_cost_price"));
            orderPrinter.setPrimeCostPaper(result.getFloat("prime_cost_paper"));
            orderPrinter.setPrimeCostSumOne(result.getFloat("prime_cost_sum_one"));
            orderPrinter.setPrimeCostSumAll(result.getFloat("prime_cost_sum_all"));
            orderPrinter.setProfit(result.getFloat("profit"));

            printerList.add(orderPrinter);
        }
        return printerList;
    }

    public static void insertOrderPrinter(Integer id_orders, String orderName, Integer idPrinter, Integer id_format, Integer idDuplex, Integer idPaper, Integer idPrice, Float price_print, Float price_paper, Integer density, Integer count, Float sum_one, Float sum_all, Integer count_print_a4,String text_desc,Float cost_price,Float cost_paper,Float cost_sum_one,Float cost_sum_all ) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO `order_printer`" +
                        " (`id_orders`, `name_order`, `id_printer`, `id_format`, `id_duplex`, `id_paper`, `id_price`, `cost_print`, `cost_paper`, `density`, `count`, `sum_one`, `sum_all`, `count_print_a4`, `text_desc`,`prime_cost_price`,`prime_cost_paper`,`prime_cost_sum_one`,`prime_cost_sum_all`) VALUES " +
                        "('"+id_orders+"', '"+orderName+"', '"+idPrinter+"', '"+id_format+"','"+idDuplex+"', '"+idPaper+"', '"+idPrice+"', '"+price_print+"', '"+price_paper+"', '"+density+"', '"+count+"', '"+sum_one+"', '"+sum_all+"','"+count_print_a4+"','"+text_desc+"','"+cost_price+"','"+cost_paper+"','"+cost_sum_one+"','"+cost_sum_all+"');";
        //System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }


    public static void deleteOrderPrinter (Integer id_order_printer) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM `order_printer` WHERE `id_order_printer`='"+id_order_printer+"'; ";

        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

}
