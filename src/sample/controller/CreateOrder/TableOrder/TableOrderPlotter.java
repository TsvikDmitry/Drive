package sample.controller.CreateOrder.TableOrder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controller.CreateOrder.TabOrder.PrinterController;
import sample.model.create_order.plotter.order.OrderPlotter;
import sample.model.create_order.plotter.order.OrderPlotterDB;

/**
 * Created by Dima on 19.02.2017.
 */
public class TableOrderPlotter {
    @FXML    public TableView<OrderPlotter> OrderPlotterTable;
    @FXML    public TableColumn<OrderPlotter, Integer> PlotterOrderColumnId;
    @FXML    public TableColumn<OrderPlotter, String> PlotterOrderColumnText;

    @FXML    public TableColumn<OrderPlotter, String> PlotterOrderColumnNamePaper;
    @FXML    public TableColumn<OrderPlotter, Integer> PlotterOrderColumnCount;
    @FXML    public TableColumn<OrderPlotter, Integer> PlotterOrderColumnDensity;
    @FXML    public TableColumn<OrderPlotter, Float> PlotterOrderColumnPrimeCostSumOne;
    @FXML    public TableColumn<OrderPlotter, Float> PlotterOrderColumnPrimeCostSumAll;
    @FXML    public TableColumn<OrderPlotter, Float> PlotterOrderColumnProfit;
    @FXML   public TableColumn <OrderPlotter, String> PlotterOrderColumnNamePlotter;
    @FXML   public TableColumn<OrderPlotter, Integer>  PlotterOrderColumnFill;
    @FXML   public TableColumn <OrderPlotter, Integer> PlotterOrderColumnWidth;
    @FXML   public TableColumn<OrderPlotter, Integer>  PlotterOrderColumnLength;
    @FXML   public TableColumn <OrderPlotter, Float> PlotterOrderColumnArea;
    @FXML   public TableColumn <OrderPlotter, Float> PlotterOrderColumnCostMeter;
    @FXML    public TableColumn<OrderPlotter, Float> PlotterOrderColumnSumOne;
    @FXML    public TableColumn<OrderPlotter, Float> PlotterOrderColumnSumAll;


    @FXML    private PrinterController orderCreatePrinterController;
    private Integer idOrder ;





    @FXML
    private void initialize() throws Exception {

        OrderPlotter();
       // UpdateTableData(idOrder);
        ColumnVisible(false);
    }

    public void ColumnVisible(boolean status){
        PlotterOrderColumnPrimeCostSumOne.setVisible(status);
        PlotterOrderColumnPrimeCostSumAll.setVisible(status);
        PlotterOrderColumnProfit.setVisible(status);

    }

/*
            orderPlotter.setArea(result.getFloat("area"));
            orderPlotter.setCostMeter(result.getFloat("cost_meter"));
            */

    public void OrderPlotter() throws Exception {

        PlotterOrderColumnId.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());

        PlotterOrderColumnNamePlotter.setCellValueFactory(cellData -> cellData.getValue().namePlotterProperty());
        PlotterOrderColumnNamePaper.setCellValueFactory(cellData -> cellData.getValue().namePaperProperty());
        PlotterOrderColumnDensity.setCellValueFactory(cellData -> cellData.getValue().densityProperty().asObject());
        PlotterOrderColumnWidth.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
        PlotterOrderColumnLength.setCellValueFactory(cellData -> cellData.getValue().lengthProperty().asObject());
        PlotterOrderColumnFill.setCellValueFactory(cellData -> cellData.getValue().fillProperty().asObject());

        PlotterOrderColumnArea.setCellValueFactory(cellData -> cellData.getValue().areaProperty().asObject());
        PlotterOrderColumnCostMeter.setCellValueFactory(cellData -> cellData.getValue().costMeterProperty().asObject());

        PlotterOrderColumnCount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());

        PlotterOrderColumnSumAll.setCellValueFactory(cellData -> cellData.getValue().sumAllProperty().asObject());
        PlotterOrderColumnSumOne.setCellValueFactory(cellData -> cellData.getValue().sumOneProperty().asObject());

        PlotterOrderColumnPrimeCostSumOne.setCellValueFactory(cellData -> cellData.getValue().primeCostSumOneProperty().asObject());
        PlotterOrderColumnPrimeCostSumAll.setCellValueFactory(cellData -> cellData.getValue().primeCostSumAllProperty().asObject());

        PlotterOrderColumnProfit.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());
        PlotterOrderColumnText.setCellValueFactory(cellData -> cellData.getValue().textDescProperty());

    }


    public  void UpdateTableData(Integer idOrder) {
        //Get all Employees information
        ObservableList<OrderPlotter> orderPrintTableList = null;
        try {

            orderPrintTableList = OrderPlotterDB.selectOrderPlotter(idOrder);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OrderPlotterTable.setItems(orderPrintTableList);
    }


    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }


    public void addPay() {


    }


    public String textDesc(){
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getTextDesc();
    }

    public Integer getIdPlotter() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getIdPlotter();
    }


    public Integer getIdPaper() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getIdPaper();

    }


    public Integer getDensity() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getDensity();

    }

    public Integer getFill() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getFill();

    }

    public Integer getWidth() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getWidth();
    }



    public Integer getLength() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getLength();

    }

    public Integer getCount() {
        return OrderPlotterTable.getSelectionModel().getSelectedItem().getCount();

    }

    public Float getCostMeter() {
            return OrderPlotterTable.getSelectionModel().getSelectedItem().getCostMeter();
    }


}