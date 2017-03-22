package sample.controller.Statisic.Deal;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sample.model.statistic.PrintCountDB;
import sample.model.statistic.deal.DealOrder;
import sample.model.statistic.deal.DealOrderDB;


/**
 * Created by Dima on 29.03.2017.
 */
public class DealTodayController {
    @FXML    public DealDataController dealDataViewController;
    @FXML    public DealTableController dealTableViewController;
    String data ;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }




    @FXML
    private void initialize() throws Exception {
        OnClickTableProduct();
        setData("curdate()");

        dealDataViewController.AddData.setOnAction((event) -> {
            dealDataViewController.InsertData();
            UpdateTable();
        });
        dealDataViewController.DataGetCard.setVisible(false);

    }

    public void UpdateData() throws Exception {


        UpdateTable();


    }


    public void UpdateTable()  {
        ObservableList<DealOrder> lazData = null;
        try {    lazData = DealOrderDB.select(getData()); } catch (Exception e) { e.printStackTrace(); }
        dealTableViewController.TableDealOrder.setItems(lazData);

    }


    public void OnClickTableProduct() {

        dealTableViewController.TableDealOrder.setRowFactory(
                new Callback<TableView<DealOrder>, TableRow<DealOrder>>() {
                    @Override
                    public TableRow<DealOrder> call(TableView<DealOrder> tableView) {
                        final TableRow<DealOrder> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    DeleteTableItemProduct();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                               //ActionProduct();
                            }
                        });
                        rowMenu.getItems().addAll(removeItem);
                        row.contextMenuProperty().bind(
                                Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                        .then(rowMenu)
                                        .otherwise((ContextMenu) null));
                        return row;
                    }
                });
    }
    public void DeleteTableItemProduct() throws Exception {
        DealOrderDB.delete(dealTableViewController.getIdDealOrder());
        UpdateTable();
    }



}

