package sample.controller.CreateOrder.TableOrder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controller.CreateOrder.TabOrder.ProductController;
import sample.model.create_order.product.order.OrderProduct;
import sample.model.create_order.product.order.OrderProductDB;


public class TableOrderProduct {
    @FXML    public TableView<OrderProduct> OrderProductTable;
    @FXML    public TableColumn<OrderProduct, Integer> ProductOrderColumnId;

    @FXML    public TableColumn<OrderProduct, String> ProductOrderColumnNameProduct;
    @FXML    public TableColumn<OrderProduct, String> ProductOrderColumnNameProductItems;

    @FXML    public TableColumn<OrderProduct, Integer> ProductOrderColumnCount;

    @FXML    public TableColumn<OrderProduct, Double> ProductOrderColumnPrimeCostOne;
    @FXML    public TableColumn<OrderProduct, Double> ProductOrderColumnPrimeCostAll;
    @FXML    public TableColumn<OrderProduct, Double> ProductOrderColumnCostOne;
    @FXML    public TableColumn<OrderProduct, Double> ProductOrderColumnCostAll;
    @FXML    public TableColumn<OrderProduct, Double> ProductOrderColumnProfit;

    @FXML    public TableColumn<OrderProduct, String> ProductOrderColumnTextDesc;


    @FXML    private ProductController orderCreateProductController;
    private Integer idOrder ;

    @FXML
    private void initialize() throws Exception {
        OrderProduct();
        ColumnVisible(false);
    }

    public void ColumnVisible(boolean status){
        ProductOrderColumnProfit.setVisible(status);
        ProductOrderColumnPrimeCostOne.setVisible(status);
        ProductOrderColumnPrimeCostAll.setVisible(status);
    }
    public void OrderProduct() throws Exception {

        ProductOrderColumnId.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());
        ProductOrderColumnCount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        ProductOrderColumnNameProduct.setCellValueFactory(cellData -> cellData.getValue().nameProductProperty());
        ProductOrderColumnNameProductItems.setCellValueFactory(cellData -> cellData.getValue().nameItemsProperty());

        ProductOrderColumnCostOne.setCellValueFactory(cellData -> cellData.getValue().sumOneProperty().asObject());
        ProductOrderColumnCostAll.setCellValueFactory(cellData -> cellData.getValue().sumAllProperty().asObject());

        ProductOrderColumnPrimeCostOne.setCellValueFactory(cellData -> cellData.getValue().primeCostSumOneProperty().asObject());
        ProductOrderColumnPrimeCostAll.setCellValueFactory(cellData -> cellData.getValue().primeCostSumAllProperty().asObject());
        ProductOrderColumnProfit.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());
        ProductOrderColumnTextDesc.setCellValueFactory(cellData -> cellData.getValue().textDescProperty());

    }

    public  void UpdateTableData(Integer idOrder) {
        //Get all Employees information
        ObservableList<OrderProduct> orderProductTableList = null;
        try {
            orderProductTableList = OrderProductDB.selectProductPlotter(idOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OrderProductTable.setItems(orderProductTableList);
    }


    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdProductItems() {
        Integer data = 0;
        if(OrderProductTable.getItems().size()!=0){
            data = OrderProductTable.getSelectionModel().getSelectedItem().getIdProductItems();
        }
        return data;
    }

}