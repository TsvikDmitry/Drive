package sample.controller.CreateOrder.TableOrder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controller.CreateOrder.TabOrder.ServiceController;
import sample.model.create_order.service.order.OrderService;
import sample.model.create_order.service.order.OrderServiceDB;

/**
 * Created by Dima on 19.02.2017.
 */
public class TableOrderService {
    @FXML    public TableView<OrderService> OrderServiceTable;
    @FXML    public TableColumn<OrderService, Integer> ServiceOrderColumnId;

    @FXML    public TableColumn<OrderService, String> ServiceOrderColumnNameService;
    @FXML    public TableColumn<OrderService, String> ServiceOrderColumnNameServiceItems;

    @FXML    public TableColumn<OrderService, Integer> ServiceOrderColumnCount;

    @FXML    public TableColumn<OrderService, Double> ServiceOrderColumnPrimeCostOne;
    @FXML    public TableColumn<OrderService, Double> ServiceOrderColumnPrimeCostAll;
    @FXML    public TableColumn<OrderService, Double> ServiceOrderColumnCostOne;
    @FXML    public TableColumn<OrderService, Double> ServiceOrderColumnCostAll;
    @FXML    public TableColumn<OrderService, Double> ServiceOrderColumnProfit;

    @FXML    public TableColumn<OrderService, String> ServiceOrderColumnTextDesc;


    @FXML    private ServiceController orderCreateServiceController;
    private Integer idOrder ;

    @FXML
    private void initialize() throws Exception {
        OrderService();
        ColumnVisible(false);
    }

    public void ColumnVisible(boolean status){
        ServiceOrderColumnProfit.setVisible(status);
        ServiceOrderColumnPrimeCostOne.setVisible(status);
        ServiceOrderColumnPrimeCostAll.setVisible(status);
    }
    public void OrderService() throws Exception {

        ServiceOrderColumnId.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());
        ServiceOrderColumnCount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        ServiceOrderColumnNameService.setCellValueFactory(cellData -> cellData.getValue().nameServiceProperty());
        ServiceOrderColumnNameServiceItems.setCellValueFactory(cellData -> cellData.getValue().nameItemsProperty());

        ServiceOrderColumnCostOne.setCellValueFactory(cellData -> cellData.getValue().sumOneProperty().asObject());
        ServiceOrderColumnCostAll.setCellValueFactory(cellData -> cellData.getValue().sumAllProperty().asObject());

        ServiceOrderColumnPrimeCostOne.setCellValueFactory(cellData -> cellData.getValue().primeCostSumOneProperty().asObject());
        ServiceOrderColumnPrimeCostAll.setCellValueFactory(cellData -> cellData.getValue().primeCostSumAllProperty().asObject());
        ServiceOrderColumnProfit.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());
        ServiceOrderColumnTextDesc.setCellValueFactory(cellData -> cellData.getValue().textDescProperty());

    }

    public  void UpdateTableData(Integer idOrder) {
        //Get all Employees information
        ObservableList<OrderService> orderServiceTableList = null;
        try {
            orderServiceTableList = OrderServiceDB.selectServicePlotter(idOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OrderServiceTable.setItems(orderServiceTableList);
    }


    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdServiceItems() {
        Integer data = 0;
        if(OrderServiceTable.getItems().size()!=0){
            data = OrderServiceTable.getSelectionModel().getSelectedItem().getIdServiceItems();
        }
        return data;
    }


}