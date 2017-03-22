package sample.model.plotter.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;
import sample.model.print.order.OrderPrinter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 * Created by Dima on 11.03.2017.
 */
public class OrderPlotterDB {

    public static ObservableList<OrderPlotter> selectOrderPlotter(Integer IdOrder) throws Exception {

        String selectStmt = "SELECT orpl.*,pl.name_plotter, plp.name_paper, orpl.sum_all-orpl.prime_cost_sum_all as profit FROM order_plotter orpl\n" +
                "inner join plotter pl on pl.id_plotter=orpl.id_plotter\n" +
                "inner join plotter_paper plp on plp.id_plotter_paper=orpl.id_plotter_paper"
                +" where id_orders="+IdOrder+";";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderPlotter> PlotterList = getOrderPlotterResultSet(result);

            return PlotterList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<OrderPlotter> getOrderPlotterResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderPlotter> PlotterList =  FXCollections.observableArrayList();


        while (result.next()) {
            OrderPlotter orderPlotter = new OrderPlotter();
            orderPlotter.setIdOrderPlotter(result.getInt("id_order_plotter"));
            orderPlotter.setIdOrders(result.getInt("id_orders"));
            orderPlotter.setIdCategory(result.getInt("id_сategory"));
            orderPlotter.setWidth(result.getInt("width"));
            orderPlotter.setLength(result.getInt("length"));
            orderPlotter.setFill(result.getInt("fill"));


            orderPlotter.setNamePlotter(result.getString("name_plotter"));
            orderPlotter.setNamePaper(result.getString("name_paper"));
            orderPlotter.setNameOrder(result.getString("name_order"));
            orderPlotter.setIdPlotter(result.getInt("id_plotter"));
            orderPlotter.setIdPaper(result.getInt("id_plotter_paper"));

            orderPlotter.setTextDesc(result.getString("text_desc"));
            orderPlotter.setDensity(result.getInt("density"));
            orderPlotter.setCount(result.getInt("count"));


            orderPlotter.setArea(result.getFloat("area"));
            orderPlotter.setCostMeter(result.getFloat("cost_meter"));
            orderPlotter.setPrimeCostPaper(result.getFloat("prime_cost_paper"));
            orderPlotter.setPrimeCostPrint(result.getFloat("prime_cost_print"));
            orderPlotter.setSumOne(result.getFloat("sum_one"));
            orderPlotter.setSumAll(result.getFloat("sum_all"));
            orderPlotter.setPrimeCostSumOne(result.getFloat("prime_cost_sum_one"));
            orderPlotter.setPrimeCostSumAll(result.getFloat("prime_cost_sum_all"));


            orderPlotter.setProfit(result.getFloat("profit"));

            PlotterList.add(orderPlotter);
        }
        return PlotterList;
    }


    public static void insertOrderPlotter(Integer id_orders, String orderName, Integer id_plotter,Integer id_plotter_paper,
                                          Integer length, Integer width, Integer count, Integer density,Integer fill,
                                          String text_desc, Float area,Float cost_meter,Float prime_cost_print,
                                           Float prime_cost_paper, Float sum_one, Float prime_cost_sum_one, Float sum_all,
                                          Float prime_cost_sum_all) throws SQLException, ClassNotFoundException {

        String updateStmt = "    INSERT INTO order_plotter" +
                "(`id_orders`, `name_order`, `id_plotter`, `id_plotter_paper`, `length`, `width`, `count`, " +
                "`density`, `fill`, `text_desc`, `area`, `cost_meter`, `prime_cost_print`,  " +
                "`prime_cost_paper`, `sum_one`, `prime_cost_sum_one`, `sum_all`, `prime_cost_sum_all`) VALUES " +
                "('"+id_orders+"', '"+orderName+"', '"+id_plotter+"', '"+id_plotter_paper+"','"+length+"', '"+width+"', " +
                "'"+count+"', '"+density+"', '"+fill+"', '"+text_desc+"', '"+area+"', '"+cost_meter+"', " +
                "'"+prime_cost_print+"', '"+prime_cost_paper+"', '"+sum_one+"', '"+prime_cost_sum_one+"', " +
                "'"+sum_all+"', '"+prime_cost_sum_all+"');";


            /*    "INSERT INTO `order_printer`" +
                        " (`id_orders`, `name_order`, `id_printer`, `id_format`, `id_duplex`, `id_paper`, `id_price`, `cost_print`, `cost_paper`, `density`, `count`, `sum_one`, `sum_all`, `count_print_a4`, `text_desc`,`prime_cost_price`,`prime_cost_paper`,`prime_cost_sum_one`,`prime_cost_sum_all`) VALUES " +
                        "('"+id_orders+"', '"+orderName+"', '"+idPrinter+"', '"+id_format+"','"+idDuplex+"', '"+idPaper+"', '"+idPrice+"', '"+price_print+"', '"+price_paper+"', '"+density+"', '"+count+"', '"+sum_one+"', '"+sum_all+"','"+count_print_a4+"','"+text_desc+"','"+cost_price+"','"+cost_paper+"','"+cost_sum_one+"','"+cost_sum_all+"');";
       */
       //System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }


    public static void delete(Integer id_order_plotter) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM `order_plotter` WHERE `id_order_plotter`='"+id_order_plotter+"'; ";

        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    /*
    public static String Format(Float number) {
        String numberAsString = String.format("%.2f", number);
        return numberAsString;
    }

    /*
    public static String Format(Float number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String numberAsString = decimalFormat.format(number);
        return numberAsString;
    }*/
}
