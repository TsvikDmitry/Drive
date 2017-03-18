package sample.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dima on 03.02.2017.
 */
public class ConnectionDB {

    private static final String connStr = "jdbc:mysql://localhost:3306/copydrive.v2?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "1";

    private static final String connStr1 = "jdbc:mysql://178.151.241.202:3306/copydrive?autoReconnect=true&useSSL=false";
    private static final String user1 = "root";
    private static final String password1 = "1";

    private static final String connStr2 = "jdbc:mysql://copydrive.cyyu9udcfkqt.us-west-2.rds.amazonaws.com:3306/copydrive";
    private static final String user2 = "tsvikdima";
    private static final String password2 = "Tsvik9056";

    private static ConnectionDB dbIsntance;
    private static java.sql.Connection con ;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";



    private ConnectionDB() {
        // private constructor //
    }

    public static ConnectionDB getInstance(){
        if(dbIsntance==null){
            dbIsntance= new ConnectionDB();
        }
        return dbIsntance;
    }


    public java.sql.Connection getConnection() throws ClassNotFoundException {

        if(con==null){
            try {
                try {
                    Class.forName(JDBC_DRIVER);
                } catch (ClassNotFoundException e) {
                    System.out.println("Where is your  JDBC Driver?");
                    e.printStackTrace();
                    throw e;
                }
                   con = DriverManager.getConnection(connStr, user, password);
                //con = DriverManager.getConnection(connStr1, user1, password1);
                //con = DriverManager.getConnection(connStr2, user2, password2);
                System.out.println(" Подключение к серверу");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return con;
    }



}
