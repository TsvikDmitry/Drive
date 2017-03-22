package sample.controller.Statisic.CounterPrinter;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.statistic.PrintCount;

/**
 * Created by Admin on 24.03.2017.
 */
public class TablePrintCounterController {
    @FXML
    public TableView<PrintCount> TablePrintCount;
    @FXML    public TableColumn<PrintCount, Integer> IdPrintColumn;
    @FXML    public TableColumn<PrintCount, String> NamePrintColumn;
    @FXML    public TableColumn<PrintCount, Integer> CountStartColumn;
    @FXML    public TableColumn<PrintCount, Integer> CountEndColumn;
    @FXML    public TableColumn<PrintCount, Integer> DifferenceColumn;
    @FXML    public TableColumn<PrintCount, String> DateCountColumn;
    @FXML    public TableColumn<PrintCount, Integer> CountPrintingColumn;


    @FXML
    private void initialize() throws Exception {

        IdPrintColumn.setCellValueFactory(cellData -> cellData.getValue().idPrinterProperty().asObject());
        NamePrintColumn.setCellValueFactory(cellData -> cellData.getValue().namePrinterProperty());
        CountStartColumn.setCellValueFactory(cellData -> cellData.getValue().countStartProperty().asObject());
        CountEndColumn.setCellValueFactory(cellData -> cellData.getValue().countEndProperty().asObject());
        DifferenceColumn.setCellValueFactory(cellData -> cellData.getValue().differenceProperty().asObject());
        DateCountColumn.setCellValueFactory(cellData -> cellData.getValue().dataCountProperty());
        CountPrintingColumn.setCellValueFactory(cellData -> cellData.getValue().counterPrintingProperty().asObject());


    }

    public void rowPrinterTable(Integer id) {

        Integer count = TablePrintCount.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                TablePrintCount.getSelectionModel().select(i);
                if (TablePrintCount.getSelectionModel().getSelectedItem().getIdPrinterCounter()== id) {
                    break;
                }
                if (count == i) {
                    TablePrintCount.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    public Integer getIdPrinterCounter() {
        Integer  txDuplexName = 0;
        if(TablePrintCount.getItems().size()!=0){
            txDuplexName = TablePrintCount.getSelectionModel().getSelectedItem().getIdPrinterCounter();
        }
        return txDuplexName;
    }

    public Integer getIdPrinter() {
        Integer  txDuplexName = 0;
        if(TablePrintCount.getItems().size()!=0){
            txDuplexName = TablePrintCount.getSelectionModel().getSelectedItem().getIdPrinter();
        }
        return txDuplexName;
    }

    public Integer getCountEnd() {
        Integer  txDuplexName = 0;
        if(TablePrintCount.getItems().size()!=0){
            txDuplexName = TablePrintCount.getSelectionModel().getSelectedItem().getCountEnd();
        }
        return txDuplexName;
    }

    public Integer getCountStart() {
        Integer  txDuplexName = 0;
        if(TablePrintCount.getItems().size()!=0){
            txDuplexName = TablePrintCount.getSelectionModel().getSelectedItem().getCountStart();
        }
        return txDuplexName;
    }
    public String getDataCount() {
        String  txDuplexName = "";
        if(TablePrintCount.getItems().size()!=0){
            txDuplexName = TablePrintCount.getSelectionModel().getSelectedItem().getDataCount();
        }
        return txDuplexName;
    }
}
