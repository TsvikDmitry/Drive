package sample.controller.CreateOrder.TableOrder;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controller.CreateOrder.SetOrder.BindingController;
import sample.model.binding.order.OrderBinding;
import sample.model.binding.order.OrderBindingDB;

/**
 * Created by Dima on 19.02.2017.
 */
public class TableOrderBinding {
    @FXML    public TableView<OrderBinding> OrderBindingTable;
    @FXML    public TableColumn<OrderBinding, Integer> BindingOrderColumnId;
    @FXML    public TableColumn<OrderBinding, String> BindingOrderColumnNameCover;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnCountCover;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnCostCover;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnPrimeCostCover;


    @FXML    public TableColumn<OrderBinding, String> BindingOrderColumnNameSpring;
    @FXML    public TableColumn<OrderBinding, Integer> BindingOrderColumnSheet;
    @FXML    public TableColumn<OrderBinding, String> BindingOrderColumnNameSpringSize;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnCountSpringSize;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnCostSpringSize;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnPrimeCostSpringSize;


    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnCountWork;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnCostWork;

    @FXML    public TableColumn<OrderBinding, Integer> BindingOrderColumnCount;

    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnSumOne;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnSumAll;

    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnPrimeCostSumOne;
    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnPrimeCostSumAll;

    @FXML    public TableColumn<OrderBinding, Double> BindingOrderColumnProfit;
    @FXML    public TableColumn<OrderBinding, String> BindingOrderColumnText;

    @FXML    private BindingController orderCreateBingingController;

    private Integer idOrder ;


    @FXML
    private void initialize() throws Exception {

        OrderBinding();
        OrderBindingUpdata(idOrder);

    }



    public void OrderBinding() throws Exception {

        BindingOrderColumnId.setCellValueFactory(cellData -> cellData.getValue().idOrderProperty().asObject());

        BindingOrderColumnNameCover.setCellValueFactory(cellData -> cellData.getValue().nameCoverProperty());
        BindingOrderColumnCountCover.setCellValueFactory(cellData -> cellData.getValue().countCoverProperty().asObject());
        BindingOrderColumnCostCover.setCellValueFactory(cellData -> cellData.getValue().costCoverProperty().asObject());
        BindingOrderColumnPrimeCostCover.setCellValueFactory(cellData -> cellData.getValue().primeCostCoverProperty().asObject());

        BindingOrderColumnNameSpring.setCellValueFactory(cellData -> cellData.getValue().nameSpringProperty());
      //  BindingOrderColumnSheet.setCellValueFactory(cellData -> cellData.getValue().sheetProperty().asObject());
   //     BindingOrderColumnNameSpringSize.setCellValueFactory(cellData -> cellData.getValue().nameSpringSizeProperty());

        BindingOrderColumnCountSpringSize.setCellValueFactory(cellData -> cellData.getValue().countSpringProperty().asObject());
        BindingOrderColumnCostSpringSize.setCellValueFactory(cellData -> cellData.getValue().costSpringSizeProperty().asObject());
        BindingOrderColumnPrimeCostSpringSize.setCellValueFactory(cellData -> cellData.getValue().primeCostSpringSizeProperty().asObject());

        BindingOrderColumnCountWork.setCellValueFactory(cellData -> cellData.getValue().countWorkProperty().asObject());
        BindingOrderColumnCostWork.setCellValueFactory(cellData -> cellData.getValue().costWorkProperty().asObject());

        BindingOrderColumnCount.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());

        BindingOrderColumnSumOne.setCellValueFactory(cellData -> cellData.getValue().costSumOneProperty().asObject());
        BindingOrderColumnSumAll.setCellValueFactory(cellData -> cellData.getValue().costSumAllProperty().asObject());

        BindingOrderColumnPrimeCostSumOne.setCellValueFactory(cellData -> cellData.getValue().primeCostSumOneProperty().asObject());
        BindingOrderColumnPrimeCostSumAll.setCellValueFactory(cellData -> cellData.getValue().primeCostSumAllProperty().asObject());

        BindingOrderColumnProfit.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());
        BindingOrderColumnText.setCellValueFactory(cellData -> cellData.getValue().textDescProperty());


    }


    public  void OrderBindingUpdata(Integer idOrder) {
        //Get all Employees information
        ObservableList<OrderBinding> tableList = null;
        try {

            tableList = OrderBindingDB.select(idOrder);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OrderBindingTable.setItems(tableList);
    }


    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdBindingFormat() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getIdBindingFormat();
    }
    public Integer getIdBindingCover() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getIdBindingCover();
    }

    public Integer getIdBindingSpring() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getIdBindingSpring();
    }
    public Integer getIdBindingSpringSize() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getIdBindingSpringSize();
    }
    public Integer getSheet() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getSheet();
    }

    public Double getCountCover() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCountCover();
    }
    public Double getCountSpring() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCountSpring();
    }
    public Double getCountWork() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCountWork();
    }
    public Integer getCount() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCount();
    }
    public Double getCostCoverOne() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCostCoverOne();
    }
    public Double getCostSpringSizeOne() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCostSpringSizeOne();
    }
    public Double getCostWorkOne() {
        return OrderBindingTable.getSelectionModel().getSelectedItem().getCostWorkOne();
    }

    public String getTextDesc() {
            return OrderBindingTable.getSelectionModel().getSelectedItem().getTextDesc();
    }


}