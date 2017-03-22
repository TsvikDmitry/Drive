package sample.model.binding.order;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.ExecuteQuery;
import sample.model.binding.BindingCover;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dima on 16.03.2017.
 */
public class OrderBindingDB {

    public static ObservableList<OrderBinding> select(Integer order) throws Exception {

        String selectStmt = "SELECT orb.*, sum_all-prime_cost_sum_all as profit,\n" +
                "bc.name_cover, bs.name_color,bs.name_spring,bss.name_size\n" +
                "FROM order_binding orb\n" +
                "inner join binding_format bf on bf.id_binding_format=orb.id_format\n" +
                "inner join binding_cover bc on bc.id_binding_cover=orb.id_cover\n" +
                "inner join binding_spring bs on bs.id_binding_spring=orb.id_spring\n" +
                "inner join binding_spring_size bss on bss.id_binding_spring_size=orb.id_spring_size\n" +
                "where id_orders="+order+";";


        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<OrderBinding> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<OrderBinding> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<OrderBinding> listSet =  FXCollections.observableArrayList();


        while (result.next()) {
            OrderBinding data = new OrderBinding();

            data.setIdOrderBinging(result.getInt("id_order_binding"));

            data.setIdBindingCover(result.getInt("id_cover"));
            data.setIdOrder(result.getInt("id_orders"));
            data.setIdCategory(result.getInt("id_сategory"));
            data.setNameOrder(result.getString("name_order"));

            data.setIdBindingFormat(result.getInt("id_format"));
            data.setCostWork(result.getDouble("work_cost"));
            data.setCountWork(result.getDouble("count_work"));

            data.setIdBindingCover(result.getInt("id_cover"));
            data.setCostCover(result.getDouble("cover_cost"));
            data.setPrimeCostCover(result.getDouble("cover_prime_cost"));
            data.setCostCoverOne(result.getDouble("cover_cost_one"));
            data.setPrimeCostCoverOne(result.getDouble("cover_prime_cost_one"));


            data.setIdBindingSpring(result.getInt("id_spring"));
            data.setCountSpring(result.getDouble("count_spring"));
            data.setIdBindingSpringSize(result.getInt("id_spring_size"));
            data.setCostSpringSize(result.getDouble("spring_size_cost"));
            data.setPrimeCostSpringSize(result.getDouble("spring_size_prime_cost"));

            data.setSheet(result.getInt("sheet"));

            data.setCountCover(result.getDouble("count_cover"));
            data.setCount(result.getInt("count"));

            data.setCostSumOne(result.getDouble("sum_one"));
            data.setCostSumAll(result.getDouble("sum_all"));
            data.setPrimeCostSumOne(result.getDouble("prime_cost_sum_one"));
            data.setPrimeCostSumAll(result.getDouble("prime_cost_sum_all"));

            data.setNameCover(result.getString("name_cover"));
            //data.setNameFormat(result.getString("name_format"));

            data.setNameSpring(result.getString("name_spring")+" "+result.getString("name_size") +", "+result.getInt("sheet")+"л.");

            data.setNameSpringSize(result.getString("name_size"));
            data.setTextDesc(result.getString("text_desc"));
            data.setProfit(result.getDouble("profit"));


            data.setCostWorkOne(result.getDouble("work_cost_one"));
            data.setCostSpringSizeOne(result.getDouble("spring_size_cost_one"));
            data.setPrimeCostSpringSizeOne(result.getDouble("spring_size_prime_cost_one"));



            listSet.add(data);
        }
        return listSet;
    }

    public static void insertOrderBinding(Integer id_orders, String name_order, Integer id_cover,Double cover_cost,
                                          Double cover_prime_cost, Integer id_format, Double work_cost, Integer id_spring,Integer sheet,
                                          Integer id_spring_size, Double spring_size_cost,Double spring_size_prime_cost,Double count_cover,
                                          Double count_spring, Double count_work, Integer count, Double sum_one,
                                          Double sum_all,Double prime_cost_sum_one,Double prime_cost_sum_all,String text_desc,
                                          Double cover_cost_one,Double cover_prime_cost_one,Double spring_size_cost_one,
                                          Double spring_size_prime_cost_one,Double work_cost_one ) throws SQLException, ClassNotFoundException {

        String updateStmt = "INSERT INTO order_binding\n" +
                "  (`id_orders`, `name_order`, `id_cover`, \n" +
                "  `cover_cost`, `cover_prime_cost`, `id_format`, \n" +
                "  `work_cost`, `id_spring`, `sheet`, \n" +
                "  `id_spring_size`, `spring_size_cost`, `spring_size_prime_cost`, \n" +
                "  `count_cover`, `count_spring`, `count_work`, \n" +
                "  `count`, `sum_one`, `sum_all`, \n" +
                "  `prime_cost_sum_one`, `prime_cost_sum_all`, `text_desc`, `cover_cost_one`, `cover_prime_cost_one`, `spring_size_cost_one`, `spring_size_prime_cost_one`, `work_cost_one`) VALUES " +
                "('"+id_orders+"', '"+name_order+"', '"+id_cover+"', '"+cover_cost+"', '"+cover_prime_cost+"', '"+id_format+"', '"+work_cost+"', '"+id_spring+"', '"+sheet+"', " +
                "'"+id_spring_size+"', '"+spring_size_cost+"', '"+spring_size_prime_cost+"', '"+count_cover+"', '"+count_spring+"', '"+count_work+"', '"+count+"', '"+sum_one+"', '"+sum_all+"', " +
                "'"+prime_cost_sum_one+"', '"+prime_cost_sum_all+"', '"+text_desc
                +"', '"+cover_cost_one
                +"', '"+cover_prime_cost_one
                +"', '"+spring_size_cost_one
                +"', '"+spring_size_prime_cost_one
                +"', '"+work_cost_one+"')";

        //System.out.println(updateStmt);
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static void delete(int id_order_binding) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM `order_binding` WHERE `id_order_binding`='"+id_order_binding+"'; ";

        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}
