package sample.controller.OrderList;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import sample.Main;
import sample.controller.CreateOrder.TableOrder.*;
import sample.model.orders.OrderList;
import sample.model.orders.OrderListDB;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

public class OrderListController {
    private Main mainApp = new Main();

    @FXML    public TableView<OrderList> OrdersTable;
    @FXML    public TableColumn<OrderList, Integer> IdOrderColumn;

    @FXML    public TableColumn<OrderList, String> DataCreateOrdersColumn;
    @FXML    public TableColumn<OrderList, String> TimeEndOrdersColumn;
    @FXML    public TableColumn<OrderList, String>  DataEndOrdersColumn;
    @FXML    public TableColumn<OrderList, String> TimeCreateOrdersColumn;

    @FXML    public TableColumn<OrderList, String>  StatusOrdersColumn;

    @FXML    public TableColumn<OrderList, Float>  PrinterOrdersColumn;
    @FXML    public TableColumn<OrderList, Float> SumOrdersColumn;
    @FXML    public TableColumn<OrderList, Float>  DolgOrdersColumn;

    @FXML    public TableColumn<OrderList, String>  StatusPayColumn;
/**/
    @FXML    private TableOrderPrinter tablePrinterViewController;
    @FXML    private TableOrderPlotter tablePlotterViewController;
    @FXML    private TableOrderBinding tableBindingViewController;
    @FXML    private TableOrderService tableServiceViewController;
    @FXML    private TableOrderAll tableAllViewController;

    private Integer saveIdOrders = 0;
    @FXML
    private void initialize () throws Exception {


        //Long start = TimeStart();
        OrderListAll();
        OrderListAllUpdata();
        OrdersTableClick();
        // TimeFinish(start);

    }


    public void UpdateOrdersData(Integer idOrder) throws Exception {

        tablePrinterViewController.setIdOrder(idOrder);
        tablePrinterViewController.UpdateTableData(idOrder);

        tablePlotterViewController.setIdOrder(idOrder);
        tablePlotterViewController.UpdateTableData(idOrder);

        tableBindingViewController.setIdOrder(idOrder);
        tableBindingViewController.UpdateTableData(idOrder);

        tableServiceViewController.setIdOrder(idOrder);
        tableServiceViewController.UpdateTableData(idOrder);

        tableAllViewController.setIdOrder(idOrder);
        tableAllViewController.UpdateTableData(idOrder);

    }


/*
    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        System.out.println("formKeyPressed(evt) - formKeyPressed");

             switch (evt.getKeyCode()) {

                case KeyEvent.VK_BACK_SPACE:
                    System.out.println("formKeyPressed(evt) VK_BACK_SPACE");

                    break;
                case KeyEvent.VK_ENTER: //Нажата клавиша Enter
                    OnEditOrder();
                    System.out.println("formKeyPressed(evt) VK_ENTER");

                    break;
                case KeyEvent.VK_ESCAPE: //Нажата клавиша Enter
                    NewOrders();
                    System.out.println("formKeyPressed(evt) VK_ESCAPE");

                    break;
                default:
            }
        }
*/
    public void newOrder(ActionEvent actionEvent) throws IOException {

    }

    public void OrderListAll() throws Exception {

        IdOrderColumn.setCellValueFactory(cellData -> cellData.getValue().idOrdersProperty().asObject());
        DataCreateOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().dataCreateProperty());
        DataEndOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().dataEndProperty());
        TimeCreateOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().timeCreateProperty());
        TimeEndOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().timeEndProperty());
        SumOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().orderSumProperty().asObject());
        StatusOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().nameSstatusProperty());
        StatusPayColumn.setCellValueFactory(cellData -> cellData.getValue().statusPayProperty());
        PrinterOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().printerProperty().asObject());
        DolgOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().dolgProperty().asObject());


    }
    public  void OrderListAllUpdata() {
        //Get all Employees information
        ObservableList<OrderList> orderListTableList = null;
        try {

            orderListTableList = OrderListDB.selectOrderPrinter();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        OrdersTable.setItems(orderListTableList);

        if(saveIdOrders==0){
            OrdersTable.getSelectionModel().select(0);
            if(OrdersTable.getItems().size()!=0) try { UpdateOrdersData(getIdOrders()); } catch (Exception e) { e.printStackTrace(); }

        }else {
            rowIdOrders(saveIdOrders);
            if(OrdersTable.getItems().size()!=0) try { UpdateOrdersData(getIdOrders()); } catch (Exception e) { e.printStackTrace(); }
        }
    }

    public void rowIdOrders(Integer id) {
        //System.out.println("rowPaperDensity " + saveDensity);

        //Integer save = Integer.parseInt(ColumEdit.getText().toString());
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

    public void OrdersTableClick() {

        OrdersTable.setRowFactory(
                new Callback<TableView<OrderList>, TableRow<OrderList>>() {
                    @Override
                    public TableRow<OrderList> call(TableView<OrderList> tableView) {
                        final TableRow<OrderList> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                                saveIdOrders = getIdOrders();
                                try { UpdateOrdersData(getIdOrders()); } catch (Exception e) { e.printStackTrace(); }


                            }
                            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                                mainApp.showAddItemsOrder(OrdersTable.getSelectionModel().getSelectedItem().getIdOrders());
                                OrderListAllUpdata();
                                try { } catch (Exception e) { e.printStackTrace(); }
                            }
                        });

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                try { DeleteOredrs(); } catch (Exception e) { e.printStackTrace(); }
                            }
                        });
                        rowMenu.getItems().addAll( removeItem);
                        row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(rowMenu).otherwise((ContextMenu) null));
                        return row;
                    }
                });
    }

    public Integer getIdOrders() {
        Integer data = 0;
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getIdOrders();
        }
        return data;
    }


    public void DeleteOredrs() throws SQLException, ClassNotFoundException {
        OrderListDB.deleteOrders(getIdOrders());
        OrderListAllUpdata();

    }
    public void NewOrders()  {
        Integer id = OrderListDB.LastOrder();
        OrderListAllUpdata();
        mainApp.showAddItemsOrder(id);
        OrderListAllUpdata();

    }

    public void OnEditOrder() {
        mainApp.showAddItemsOrder(OrdersTable.getSelectionModel().getSelectedItem().getIdOrders());
        OrderListAllUpdata();
    }

    public void OnPay() {
        mainApp.showPayOrder(OrdersTable.getSelectionModel().getSelectedItem().getIdOrders());
        OrderListAllUpdata();
    }
}
