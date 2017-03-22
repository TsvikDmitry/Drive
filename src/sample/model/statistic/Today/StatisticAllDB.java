package sample.model.statistic.Today;

import sample.database.ExecuteQuery;

import java.sql.ResultSet;
public class StatisticAllDB {

    public static Integer PayMany = 1;
    public static Integer PayCard = 2;
    public static Integer PayManyLastDay = 3;
    public  static Integer PayCardLastDay = 4;

    public  static Integer RePayMony = 3;
    public static Integer RePayCard = 4;


    public static Double selectDeal (String date, Integer deal ) throws Exception {

        String selectStmt2 = "";
        if (deal==PayMany){
            selectStmt2 =  " and dg.id_deal=2 and id_payment=1;";
        }
        if (deal==PayCard){
            selectStmt2 =  " and dg.id_deal=2 and id_payment<>1;";
        }
        if (deal==RePayMony){
            selectStmt2 =  " and dg.id_deal=1 and id_payment=1;";
        }
        if (deal==RePayCard){
            selectStmt2 =  " and dg.id_deal=1 and id_payment<>1;";
        }

        String selectStmt = "SELECT sum(sum) as sum_all FROM deal_order do\n" +
                " inner join deal_group dg on dg.id_deal_group=do.id_deal_group\n"+
                "where data_create="+date+"  " + selectStmt2;

       // new Print("selectDeal", selectStmt);
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");
        }
        return sumAll;
    }


    public static Double selectPay (String date, Integer index ) throws Exception {

        String selectStmt2 = "";
        if (index==PayMany){
            selectStmt2 =  " and ors.data_create="+date+" and id_order_paymant=1";
        }
        if (index==PayCard){
            selectStmt2 =  " and ors.data_create="+date+" and id_order_paymant<>1";
        }
        if (index==PayManyLastDay){
            selectStmt2 =  " and ors.data_create<>"+date+" and id_order_paymant=1";
        }
        if (index==PayCardLastDay){
            selectStmt2 =  " and ors.data_create<>"+date+" and id_order_paymant<>1";
        }

        String selectStmt = "SELECT sum(orp.sum_pay) as sum_all\n" +
                "FROM order_pay orp\n" +
                "inner join orders ors on ors.id_orders=orp.id_orders\n" +
                "where orp.data_pay="+date+" "+ selectStmt2;

        //new Print("selectDeal", selectStmt);
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");
        }
        return sumAll;
    }

/*

    public static Double selectPayMonyLastDay (String date) throws Exception {

        String selectStmt = "SELECT sum(orp.sum_pay) as sum_all\nFROM order_pay orp\n" +
                "inner join orders ors on ors.id_orders=orp.id_orders\n" +
                "where orp.data_pay="+date+" and ors.data_create<>"+date+" and id_order_paymant=1";
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");
        }
        return sumAll;
    }


    public static Double selectPayCardLastDay (String date) throws Exception {

        String selectStmt = "SELECT sum(orp.sum_pay) as sum_all\nFROM order_pay orp\n" +
                "inner join orders ors on ors.id_orders=orp.id_orders\n" +
                "where orp.data_pay="+date+" and ors.data_create<>"+date+" and id_order_paymant<>1";

        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");
        }
        return sumAll;
    }



    public static Double selectPayCard (String date) throws Exception {

        String selectStmt = "SELECT sum(orp.sum_pay) as sum_all\nFROM order_pay orp\n" +
                "inner join orders ors on ors.id_orders=orp.id_orders\n" +
                "where orp.data_pay="+date+" and ors.data_create="+date+" and id_order_paymant<>1";
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");
        }
        return sumAll;
    }



    public static Double selectPayMony (String date) throws Exception {

        String selectStmt = "SELECT sum(orp.sum_pay) as sum_all\nFROM order_pay orp\ninner join orders ors on ors.id_orders=orp.id_orders\n" +
                "where orp.data_pay="+date+" and ors.data_create="+date+" and id_order_paymant=1";
        new Print("selectPayMony", selectStmt);
        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");
        }
        return sumAll;
    }
*/


        public static Double selectCashDayMony(String date) throws Exception {


        String selectStmt = "select plotter+printer+service+binding+product as sum_all\n" +
                "from (select *\n" +
                "from (select id_orders, \n" +
                "\tords.data_create, ords.time_create, ords.data_end, ords.time_end,\n" +
                "\tsum(IFNULL((select sum(order_plotter.sum_all) from order_plotter  where order_plotter.id_orders=ords.id_orders ),0)) as plotter,\n" +
                "\tsum(IFNULL((select sum(order_printer.sum_all) from order_printer  where order_printer.id_orders=ords.id_orders),0)) as printer,\n" +
                "\tsum(IFNULL((select sum(order_service.sum_all) from order_service  where order_service.id_orders=ords.id_orders),0)) as service,\n" +
                "\tsum(IFNULL((select sum(order_product.sum_all) from order_product  where order_product.id_orders=ords.id_orders),0)) as product,\n" +
                "\tsum(IFNULL((select sum(order_binding.sum_all) from order_binding  where order_binding.id_orders=ords.id_orders),0) )as binding\n" +
                "from orders ords  \n" +
                "where data_create="+date+"\n" +
                "group by data_create ) as ord  ) as ord1;\n";



        ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);
        Double sumAll =  0.0;
        while (result.next()) {
            sumAll = result.getDouble("sum_all");

        }
        return sumAll;
    }









}
