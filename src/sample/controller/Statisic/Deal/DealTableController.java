package sample.controller.Statisic.Deal;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import sample.model.create_order.product.order.OrderProduct;
import sample.model.create_order.product.order.OrderProductDB;
import sample.model.statistic.deal.DealOrder;
import sample.model.statistic.deal.DealOrderDB;

/**
 * Created by Admin on 28.03.2017.
 */
public class DealTableController {

    @FXML   public TableView<DealOrder> TableDealOrder;
    @FXML   public TableColumn<DealOrder, String> NamePeopleColumn;
    @FXML   public TableColumn<DealOrder, String> NameDealColumn;
    @FXML   public TableColumn<DealOrder, String> NameDealGroupColumn;
    @FXML   public TableColumn<DealOrder, String> NameOrderDealColumn;
    @FXML   public TableColumn<DealOrder, String> DataColumn;
    @FXML   public TableColumn<DealOrder, String> NamePayColumn;
    @FXML   public TableColumn<DealOrder, Double> SumPayColumn;

    @FXML
    private void initialize() throws Exception {

        NamePeopleColumn.setCellValueFactory(cellData -> cellData.getValue().namePeopleProperty());
        NameDealColumn.setCellValueFactory(cellData -> cellData.getValue().nameDealProperty());
        NameDealGroupColumn.setCellValueFactory(cellData -> cellData.getValue().nameGroupProperty());
        NameOrderDealColumn.setCellValueFactory(cellData -> cellData.getValue().nameOrderProperty());
        DataColumn.setCellValueFactory(cellData -> cellData.getValue().dataCreateProperty());
        NamePayColumn.setCellValueFactory(cellData -> cellData.getValue().namePaymentProperty());
        SumPayColumn.setCellValueFactory(cellData -> cellData.getValue().sumProperty().asObject());

        ClikColumn();
    }


    public void ClikColumn() {
        TableDealOrder.setRowFactory( tv -> {
            TableRow<DealOrder> row = new TableRow<>(); row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                } }); return row; });
    }




    public Integer getIdDealOrder() {
        Integer data = 0;
        if(TableDealOrder.getItems().size()!=0){
            data = TableDealOrder.getSelectionModel().getSelectedItem().getIdDealOrder();
        }
        return data;
    }

}

