package sample.model.create_order.product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductItemsDB {


    private static String selectStmt1 = "SELECT * FROM product_items si\n" +
            "inner join product ss on ss.id_product=si.id_product  \n";



    public static ObservableList<ProductItems> select(Integer idProduct) throws Exception {

        String selectStmt = selectStmt1 +" where ss.id_product="+idProduct+"";
        // System.out.println(selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<ProductItems> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<ProductItems> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<ProductItems> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            ProductItems data = new ProductItems();
            data.setIdProduct(result.getInt("id_product"));
            data.setIdProductItems(result.getInt("id_product_items"));
            data.setNameItems(result.getString("name_items"));
            data.setNameItemsEng(result.getString("name_items_eng"));
            data.setNameProduct(result.getString("name_product"));
            data.setNameProductEng(result.getString("name_product_eng"));
            data.setCostItems(result.getDouble("cost_items"));
            data.setPrimeCostItems(result.getDouble("prime_cost_items"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}