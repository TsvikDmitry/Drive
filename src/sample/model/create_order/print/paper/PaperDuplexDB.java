package sample.model.create_order.print.paper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import sample.database.ExecuteQuery;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 29.01.2017.
 */
public class PaperDuplexDB {
    public static ObservableList<PaperDuplex> selectDuplexName(Integer idPaper)throws SQLException, ClassNotFoundException {


        String selectStmt ="SELECT pd.id_paper, pd.id_duplex, d.name_duplex FROM paper_duplex pd\n" +
                "inner join paper p on p.id_paper=pd.id_paper\n" +
                "inner join duplex d on d.id_duplex=pd.id_duplex\n" +
                "where p.id_paper="+idPaper+";";

        try {
            ResultSet result = ExecuteQuery.getExecuteQuery(selectStmt);

            ObservableList<PaperDuplex> paperPriceList = getDuplexNameResultSet(result);

            return paperPriceList;
        } catch (SQLException e) {
            System.out.println("error occurred: " + e);
            throw e;
        }

    }


    private static ObservableList<PaperDuplex> getDuplexNameResultSet(ResultSet result) throws SQLException
    {
        ObservableList<PaperDuplex> paperDuplexList =  FXCollections.observableArrayList();
        PaperDuplex paperDuplex = null;


        while (result.next()) {
            paperDuplex = new PaperDuplex();
            paperDuplex.setIdPaper(result.getInt("id_paper"));
            paperDuplex.setIdDuplex(result.getInt("id_duplex"));
            paperDuplex.setNameDuplex(result.getString("name_duplex"));
            paperDuplexList.add(paperDuplex);
        }
        return paperDuplexList;


    }


}
