package sample.database;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dima on 03.02.2017.
 */
public class ExecuteQuery {

    public static ResultSet getExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        java.sql.Connection con = ConnectionDB.getInstance().getConnection();
        Statement stmt= null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            //dbConnect();
           // System.out.println("Select statement: " + queryStmt + "\n");
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            //    dbDisconnect(connect);
        }
        //Return CachedRowSet
        return crs;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        java.sql.Connection con = ConnectionDB.getInstance().getConnection();
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            //dbConnect();
            //Create Statement
            stmt = con.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            // dbDisconnect();
        }
    }



}
