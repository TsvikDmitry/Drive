package sample.model.create_order.product.order;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProductDB {
    public static ObservableList<OrderProduct> selectProductPlotter(Integer IdOrder) throws Exception {

        String selectStmt = "SELECT *, ords.sum_all-ords.prime_cost_sum_all as profit FROM order_product ords\n" +
                "inner join product ss on ss.id_product=ords.id_product\n" +
                "inner join product_items si on si.id_product_items=ords.id_product_items\n" +
                "where ords.id_orders="+IdOrder+";";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderProduct> list = getOrderProductResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<OrderProduct> getOrderProductResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderProduct> List =  FXCollections.observableArrayList();


        while (result.next()) {
            OrderProduct order = new OrderProduct();
           order.setIdOrderProduct(result.getInt("id_order_product"));
            order.setIdOrders(result.getInt("id_orders"));
            order.setIdCategory(result.getInt("id_сategory"));
            order.setCount(result.getInt("count"));

            order.setNameOrder(result.getString("name_order"));
            order.setIdProduct(result.getInt("id_product"));
            order.setIdProductItems(result.getInt("id_product_items"));
            order.setNameItems(result.getString("name_items"));
            order.setNameProduct(result.getString("name_product"));

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

    public static void insertOrderProduct(Integer id_orders, String orderName,
                                          Integer id_product,Integer id_product_items,
                                          Integer count, Double sum_one, Double prime_cost_sum_one, Double sum_all,
                                          Double prime_cost_sum_all, String text_desc) throws SQLException, ClassNotFoundException {

        String updateStmt = "    INSERT INTO order_product" +
                "(`id_orders`, `name_order`, " +
                "`id_product`, `id_product_items`, " +
                "`count`, `sum_one`, `prime_cost_sum_one`, `sum_all`, `prime_cost_sum_all`, `text_desc`) VALUES " +
                "('"+id_orders+"', '"+orderName+"', '"+
                id_product+"', '"+id_product_items+"','"+
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
    public static void delete(Integer id_order_product) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM `order_product` WHERE `id_order_product`='"+id_order_product+"'; ";

        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}
