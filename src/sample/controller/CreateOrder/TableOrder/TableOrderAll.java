package sample.controller.CreateOrder.TableOrder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.list_order.OrderTableAll;
import sample.model.list_order.OrderTableAllDB;

/**
 * Created by Dima on 19.02.2017.
 */
public class TableOrderAll {
    @FXML    public TableView<OrderTableAll> TableOrderAll;
    @FXML    public TableColumn<OrderTableAll, Integer> TableAllColumnIdOrders;
    @FXML    public TableColumn<OrderTableAll, String> TableAllColumnNameOrder;
    @FXML    public TableColumn<OrderTableAll, Integer> TableAllColumnCount;
    @FXML    public TableColumn<OrderTableAll, Double> TableAllColumnSumOne;
    @FXML    public TableColumn<OrderTableAll, Double> TableAllColumnSumAll;
    @FXML    public TableColumn<OrderTableAll, Double> TableAllColumnPrimeSumOne;
    @FXML    public TableColumn<OrderTableAll, Double> TableAllColumnPrimeSumAll;
    @FXML    public TableColumn<OrderTableAll, Double> TableAllColumnProfit;
    @FXML    public TableColumn<OrderTableAll, String> TableAllColumnTextDesc;
    private Integer idOrder;


    @FXML
    private void initialize() throws Exception {

        TableColumn();
      //  UpdateTableData(idOrder);
        ColumnVisible(false);

    }

    public void ColumnVisible(boolean status){

        TableAllColumnPrimeSumOne.setVisible(status);
        TableAllColumnPrimeSumAll.setVisible(status);
        TableAllColumnProfit.setVisible(status);
    }

    public void TableColumn() throws Exception {

        TableAllColumnIdOrders.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());
        TableAllColumnNameOrder.setCellValueFactory(cellData -> cellData.getValue().nameOrderProperty());
        TableAllColumnCount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        TableAllColumnSumOne.setCellValueFactory(cellData -> cellData.getValue().costSumOneProperty().asObject());
        TableAllColumnSumAll.setCellValueFactory(cellData -> cellData.getValue().costSumAllProperty().asObject());
        TableAllColumnPrimeSumOne.setCellValueFactory(cellData -> cellData.getValue().primeCostSumOneProperty().asObject());
        TableAllColumnPrimeSumAll.setCellValueFactory(cellData -> cellData.getValue().primeCostSumAllProperty().asObject());
        TableAllColumnProfit.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());
        TableAllColumnTextDesc.setCellValueFactory(cellData -> cellData.getValue().textDescProperty());


    }

    public Integer getIdCategory(){
        return TableOrderAll.getSelectionModel().getSelectedItem().getIdCategory();

    }

    public Integer getIdOrderAll(){
        return TableOrderAll.getSelectionModel().getSelectedItem().getIdOrderAll();

    }

    public  void UpdateTableData(Integer idOrder) {
        //Get all Employees information
        ObservableList<OrderTableAll> dataList = null;
        try {

            dataList  = OrderTableAllDB.select(idOrder);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TableOrderAll.setItems(dataList);
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }



}