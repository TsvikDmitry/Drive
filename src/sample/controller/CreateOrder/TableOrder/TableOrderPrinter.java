package sample.controller.CreateOrder.TableOrder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controller.CreateOrder.SetOrder.PrinterController;
import sample.model.print.order.OrderPrinter;
import sample.model.print.order.OrderPrinterDB;

/**
 * Created by Dima on 19.02.2017.
 */
public class TableOrderPrinter {
    @FXML    public TableView<OrderPrinter> OrderPrintTable;
    @FXML    public TableColumn<OrderPrinter, Integer> PrintOrderColumnId;
    @FXML    public TableColumn<OrderPrinter, String> PrintOrderColumnText;
    @FXML    public TableColumn<OrderPrinter, Float> PrintOrderColumnCostOne;
    @FXML    public TableColumn<OrderPrinter, Float> PrintOrderColumnCostAll;
    @FXML    public TableColumn<OrderPrinter, Integer> PrintOrderColumnCountPrint;
    @FXML    public TableColumn<OrderPrinter, String> PrintOrderColumnNameFormat;
    @FXML    public TableColumn<OrderPrinter, String> PrintOrderColumnNamePrice;
    @FXML    public TableColumn<OrderPrinter, String> PrintOrderColumnNamePrinter;
    @FXML    public TableColumn<OrderPrinter, String> PrintOrderColumnNameDuplex;
    @FXML    public TableColumn<OrderPrinter, String> PrintOrderColumnNamePaper;
    @FXML    public TableColumn<OrderPrinter, Integer> PrintOrderColumnCount;
    @FXML    public TableColumn<OrderPrinter, Integer> PrintOrderColumnDensity;
    @FXML    public TableColumn<OrderPrinter, Float> PrintOrderColumnPrimeCostOne;
    @FXML    public TableColumn<OrderPrinter, Float> PrintOrderColumnPrimeCostAll;
    @FXML    public TableColumn<OrderPrinter, Float> PrintOrderColumnProfit;

    @FXML    private PrinterController orderCreatePrinterController;
    private Integer idOrder ;





    @FXML
    private void initialize() throws Exception {

        OrderPrinter();

        ColumnVisible(false);


    }
    public void ColumnVisible(boolean status){
        PrintOrderColumnProfit.setVisible(status);
        PrintOrderColumnPrimeCostOne.setVisible(status);
        PrintOrderColumnPrimeCostAll.setVisible(status);
    }
    public void OrderPrinter() throws Exception {

        PrintOrderColumnId.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());
        PrintOrderColumnCount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        PrintOrderColumnNamePrice.setCellValueFactory(cellData -> cellData.getValue().namePriceProperty());
        PrintOrderColumnCostOne.setCellValueFactory(cellData -> cellData.getValue().costSumOneProperty().asObject());
        PrintOrderColumnCostAll.setCellValueFactory(cellData -> cellData.getValue().costSumAllProperty().asObject());
        PrintOrderColumnCountPrint.setCellValueFactory(cellData -> cellData.getValue().countPrinterA4Property().asObject());
        PrintOrderColumnNameFormat.setCellValueFactory(cellData -> cellData.getValue().nameFormatProperty());
        PrintOrderColumnNamePrinter.setCellValueFactory(cellData -> cellData.getValue().namePrinterProperty());
        PrintOrderColumnNameDuplex.setCellValueFactory(cellData -> cellData.getValue().nameDuplexProperty());
        PrintOrderColumnNamePaper.setCellValueFactory(cellData -> cellData.getValue().namePaperProperty());
        PrintOrderColumnDensity.setCellValueFactory(cellData -> cellData.getValue().densityProperty().asObject());
        PrintOrderColumnPrimeCostOne.setCellValueFactory(cellData -> cellData.getValue().primeCostSumOneProperty().asObject());
        PrintOrderColumnPrimeCostAll.setCellValueFactory(cellData -> cellData.getValue().primeCostSumAllProperty().asObject());
        PrintOrderColumnProfit.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());
        PrintOrderColumnText.setCellValueFactory(cellData -> cellData.getValue().textProperty());


    }


    public  void UpdateTableData(Integer idOrder) {
        //Get all Employees information
        ObservableList<OrderPrinter> orderPrintTableList = null;
        try {

            orderPrintTableList = OrderPrinterDB.selectOrderPrinter(idOrder);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OrderPrintTable.setItems(orderPrintTableList);
    }


    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }


    public void addPay() {


    }

    public Integer orderIdFormat(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getIdFormat();
    }
    public Integer orderIdPrice(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getIdPrice();
    }
    public Float orderCostPrint(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getCostPrint();
    }
    public Integer orderIdPaper(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getIdPaper();
    }
    public Integer orderDensity(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getDensity();
    }
    public Integer orderIdDuplex(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getIdDuplex();
    }
    public Integer orderCount(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getCount();
    }

    public String textDesc(){
        return OrderPrintTable.getSelectionModel().getSelectedItem().getText();
    }
}