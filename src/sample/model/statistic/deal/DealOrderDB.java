package sample.model.statistic.deal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import sample.controller.CreateOrder.TableOrder.TableOrderPrinter;
import sample.controller.convection.Print;
import sample.database.ExecuteQuery;

import java.awt.geom.Arc2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DealOrderDB {


    public static ObservableList<DealOrder> selectAllDay() throws Exception {

        String selectStmt = "SELECT dg.id_deal, do.id_deal_group,do.id_deal_order,do.id_payment,do.id_people,\n" +
                "\tp.name_people,\n" +
                "    data_create, \n" +
                "     do.name_order, \n" +
                "\tname_deal,\n" +
                "    name_group,\n" +
                "    name_payment,\n" +
                "    sum\n" +
                " FROM deal_order do\n" +
                "inner join people p on p.id_people=do.id_people\n" +
                "inner join deal_group dg on dg.id_deal_group=do.id_deal_group\n" +
                "inner join deal d on d.id_deal=dg.id_deal\n" +
                "inner join payment pay on pay.id_payment=do.id_payment";

        // new Print("DealOrderDB",selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<DealOrder> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }

    public static ObservableList<DealOrder> select(String date) throws Exception {

        String selectStmt = "SELECT dg.id_deal, do.id_deal_group,do.id_deal_order,do.id_payment,do.id_people,\n" +
                "\tp.name_people,\n" +
                "    data_create, \n" +
                "     do.name_order, \n" +
                "\tname_deal,\n" +
                "    name_group,\n" +
                "    name_payment,\n" +
                "    sum\n" +
                " FROM deal_order do\n" +
                "inner join people p on p.id_people=do.id_people\n" +
                "inner join deal_group dg on dg.id_deal_group=do.id_deal_group\n" +
                "inner join deal d on d.id_deal=dg.id_deal\n" +
                "inner join payment pay on pay.id_payment=do.id_payment\n"+
                "where data_create="+date;
       // new Print("DealOrderDB",selectStmt);
        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<DealOrder> list = getResultSet(result);

            return list;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<DealOrder> getResultSet(ResultSet result) throws SQLException
    {
        ObservableList<DealOrder> listSet =  FXCollections.observableArrayList();

        while (result.next()) {
            DealOrder data = new DealOrder();
            data.setIdDealOrder (result.getInt("id_deal_order"));
            data.setNamePeople (result.getString("name_people"));
            data.setDataCreate(result.getString("data_create"));
            data.setNameDeal(result.getString("name_deal"));
            data.setNameGroup(result.getString("name_group"));
            data.setNameOrder(result.getString("name_order"));
            data.setNamePayment(result.getString("name_payment"));
            data.setSum(result.getDouble("sum"));

            listSet.add(data);
        }
        return listSet;
    }

    public static void InsertData(Integer id_people, Integer id_deal_group, String name_order, Integer id_payment, Double sum, LocalDate data_create) {


        String updateStmt = "INSERT INTO deal_order(id_people, id_deal_group, name_order, id_payment, sum, data_create) VALUES\n" +
              "("+id_people+", " +
                ""+id_deal_group+", " +
                "'"+name_order+"', " +
                ""+id_payment+", " +
                ""+sum+", " +
                "'"+data_create+"');";
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }

    }


    public static void delete(int id_deal_order) {
        String updateStmt = "DELETE FROM deal_order WHERE id_deal_order="+id_deal_order;
        try {
            ExecuteQuery.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }


    }
}
