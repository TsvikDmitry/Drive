package sample.model.create_order.product;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDB {

    public static ObservableList<Product> select() throws Exception {

        String selectStmt = "SELECT * FROM product;";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<Product> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<Product> getResultSet(ResultSet result) throws SQLException {
        ObservableList<Product> listSet = FXCollections.observableArrayList();

        while (result.next()) {
            Product data = new Product();
            data.setIdProduct(result.getInt("id_product"));
            data.setNameProduct(result.getString("name_product"));
            data.setNameProductEng(result.getString("name_product_eng"));
            data.setVisible(result.getBoolean("visible"));

            listSet.add(data);
        }
        return listSet;
    }
}
