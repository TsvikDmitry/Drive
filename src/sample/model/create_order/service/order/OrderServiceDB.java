package sample.model.create_order.service.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 18.03.2017.
 */
public class OrderServiceDB {
    public static ObservableList<OrderService> selectServicePlotter(Integer IdOrder) throws Exception {

        String selectStmt = "SELECT *, ords.sum_all-ords.prime_cost_sum_all as profit FROM order_service ords\n" +
                "inner join service ss on ss.id_service=ords.id_service\n" +
                "inner join service_items si on si.id_service_items=ords.id_service_items\n" +
                "where ords.id_orders="+IdOrder+";";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderService> list = getOrderServiceResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<OrderService> getOrderServiceResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderService> List =  FXCollections.observableArrayList();


        while (result.next()) {
            OrderService order = new OrderService();
            order.setIdOrderService(result.getInt("id_order_service"));
            order.setIdOrders(result.getInt("id_orders"));
            order.setIdCategory(result.getInt("id_сategory"));
            order.setCount(result.getInt("count"));

            order.setNameOrder(result.getString("name_order"));
            order.setIdService(result.getInt("id_service"));
            order.setIdServiceItems(result.getInt("id_service_items"));
            order.setNameItems(result.getString("name_items"));
            order.setNameService(result.getString("name_service"));

            order.setSumOne(result.getDouble("sum_one"));
            order.setSumAll(result.getDouble("sum_all"));
            order.setPrimeCostSumOne(result.getDouble("prime_cost_sum_one"));
            order.setPrimeCostSumAll(result.getDouble("prime_cost_sum_all"));
            order.setProfit(result.getDouble("profit"));
            order.setTextDesc(result.getString("text_desc"));

            List.add(order);
        }
        return List;
    }

    public static void insertOrderService(Integer id_orders, String orderName,
                                          Integer id_service,Integer id_service_items,
                                           Integer count, Double sum_one, Double prime_cost_sum_one, Double sum_all,
                                          Double prime_cost_sum_all, String text_desc) throws SQLException, ClassNotFoundException {

        String updateStmt = "    INSERT INTO order_service" +
                "(`id_orders`, `name_order`, " +
                "`id_service`, `id_service_items`, " +
                "`count`, `sum_one`, `prime_cost_sum_one`, `sum_all`, `prime_cost_sum_all`, `text_desc`) VALUES " +
                "('"+id_orders+"', '"+orderName+"', '"+
                id_service+"', '"+id_service_items+"','"+
                count+"', '"+sum_one+"', '"+sum_all+"', " +
                "'"+prime_cost_sum_one+"', '"+prime_cost_sum_all+"', '"+text_desc+"');";

       // System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    public static void delete(Integer id_order_service) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM `order_service` WHERE `id_order_service`='"+id_order_service+"'; ";

        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}
