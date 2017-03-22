package sample.controller.OrderList;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.list_order.orders.OrderList;

/**
 * Created by Admin on 01.04.2017.
 */
public class TableOrderListController {
    @FXML    public TableView<OrderList> OrdersTable;
    @FXML    public TableColumn<OrderList, Integer> IdOrderColumn;
    @FXML    public TableColumn<OrderList, String>  DataCreateOrdersColumn;
    @FXML    public TableColumn<OrderList, String>  TimeEndOrdersColumn;
    @FXML    public TableColumn<OrderList, String>  DataEndOrdersColumn;
    @FXML    public TableColumn<OrderList, String>  TimeCreateOrdersColumn;
    @FXML    public TableColumn<OrderList, String>  StatusOrdersColumn;
    @FXML    public TableColumn<OrderList, Double>   SumOrdersColumn;

    @FXML    public TableColumn<OrderList, Double>   DolgOrdersColumn;
    @FXML    public TableColumn<OrderList, String>  StatusPayColumn;

    @FXML    public TableColumn<OrderList, String>  DataPayColumn;

    @FXML    public TableColumn<OrderList, Double>   PrinterOrdersColumn;
    @FXML    public TableColumn<OrderList, Double>  PlotterOrdersColumn;
    @FXML    public TableColumn<OrderList, Double> ProductOrdersColumn;
    @FXML    public TableColumn<OrderList, Double>  ServicOrdersColumn;
    @FXML    public TableColumn<OrderList, Double>  BindOrdersColumn;



    @FXML
    private void initialize () throws Exception {

        IdOrderColumn.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());
        DataCreateOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().dataCreateProperty());
        DataEndOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().dataEndProperty());
        TimeCreateOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().timeCreateProperty());
        TimeEndOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().timeEndProperty());
        SumOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().orderSumProperty().asObject());
        StatusOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().nameStatusProperty());
        StatusPayColumn.setCellValueFactory(cellData -> cellData.getValue().statusPayProperty());
        DolgOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().dolgProperty().asObject());

        PrinterOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().printerProperty().asObject());
        PlotterOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().plotterProperty().asObject());
        ProductOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().productProperty().asObject());
        BindOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().bingProperty().asObject());
        ServicOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().serviceProperty().asObject());

        DataPayColumn.setCellValueFactory(cellData -> cellData.getValue().dataPayProperty());

    }


    public void rowIdOrders(Integer id) {

        Integer count = OrdersTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                OrdersTable.getSelectionModel().select(i);
                if (OrdersTable.getSelectionModel().getSelectedItem().getIdOrders() == id) {
                    break;
                }
                if (count == i) {
                    OrdersTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    public Double getPaySum() {
        Double data = 0.0;
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getPaySum();
        }
        return data;
    }

    public Double getOrderSum() {
        Double data = 0.0;
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getOrderSum();
        }
        return data;
    }


    public String getTimeEnd() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getTimeEnd();
        }
        return data;
    }



    public String getDataEnd() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getDataEnd();
        }
        return data;
    }

    public String getTimeCreate() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getTimeCreate();
        }
        return data;
    }



    public String getDataCreate() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getDataCreate();
        }
        return data;
    }



    public String getStatusPay() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getStatusPay();
        }
        return data;
    }

    public String getNameClient() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getNameClient();
        }
        return data;
    }
    public String getNameCutter() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getNameCutter();
        }
        return data;
    }

    public String getNamePrinting() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getNamePrinting();
        }
        return data;
    }
    public String getNameManager() {
        String data ="";
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getNameManager();
        }
        return data;
    }
    public Integer getIdOrders() {
        Integer data = 0;
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getIdOrders();
        }
        return data;
    }



}
