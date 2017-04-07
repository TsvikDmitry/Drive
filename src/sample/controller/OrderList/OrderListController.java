package sample.controller.OrderList;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import sample.Main;
import sample.controller.CreateOrder.TableOrder.*;
<<<<<<< HEAD
import sample.controller.convection.Print;
import sample.controller.convection.TextFieldFormatter;
import sample.model.list_order.orders.OrderList;
import sample.model.list_order.orders.OrderListDB;

import java.util.Optional;
=======
import sample.model.orders.OrderList;
import sample.model.orders.OrderListDB;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca

public class OrderListController {
    public Label lbNamberOrder;
    public Label lbSumOrder;
    public Label lbManager;
    public Label lbSumPay;
    public Label lbCutter;
    public Label lbDataCreat;
    public Label lbClient;
    public Label lbStatusPay;
    public Label lbDataEnd;
    public Label lbPrinting;
    public TabPane TabOrder;
    public TextField tfOrderAllDay;
    public TextField tfOrderToDay;
    public TabPane TabOrderDebt;

    private Main mainApp = new Main();
    @FXML    private TableOrderPrinter tablePrinterViewController;
    @FXML    private TableOrderPlotter tablePlotterViewController;
    @FXML    private TableOrderBinding tableBindingViewController;
    @FXML    private TableOrderService tableServiceViewController;
    @FXML    private TableOrderProduct tableProductViewController;

    @FXML    private TableOrderListController tableListTodayViewController;
    @FXML    private TableOrderListController tableListAllDayViewController;
    @FXML    private TableOrderListController tableListDebtController;
    @FXML    private TableOrderListController tableListDebtPayController;




<<<<<<< HEAD
    @FXML    private TableOrderAll tableAllViewController;

    private Integer saveIdOrders = 0;
    private Integer idOrders = 0;

    public Integer getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }
=======
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
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca

    private void ColumnDebt() {
        TableOrderListController listView = tableListDebtController;
        listView.DataEndOrdersColumn.setVisible(false);
        listView.TimeEndOrdersColumn.setVisible(false);
        listView.PlotterOrdersColumn.setVisible(false);
        listView.PrinterOrdersColumn.setVisible(false);
        listView.ProductOrdersColumn.setVisible(false);
        listView.ServicOrdersColumn.setVisible(false);
        listView.BindOrdersColumn.setVisible(false);
    }

    private void ColumnDebtPay() {
        TableOrderListController listView = tableListDebtPayController;
        listView.DataEndOrdersColumn.setVisible(false);
        listView.TimeEndOrdersColumn.setVisible(false);
        listView.PlotterOrdersColumn.setVisible(false);
        listView.PrinterOrdersColumn.setVisible(false);
        listView.ProductOrdersColumn.setVisible(false);
        listView.ServicOrdersColumn.setVisible(false);
        listView.BindOrdersColumn.setVisible(false);
    }

<<<<<<< HEAD
    public  void ColumnToDay() {
        TableOrderListController listView = tableListTodayViewController;
        listView.DataPayColumn.setVisible(false);
        listView.DataEndOrdersColumn.setVisible(false);
        listView.PlotterOrdersColumn.setVisible(false);
        listView.PrinterOrdersColumn.setVisible(false);
        listView.ProductOrdersColumn.setVisible(false);
        listView.ServicOrdersColumn.setVisible(false);
        listView.BindOrdersColumn.setVisible(false);
    }

    public  void ColumnAllDay() {
        TableOrderListController listView = tableListAllDayViewController;
        listView.DataPayColumn.setVisible(false);
        listView.DataEndOrdersColumn.setVisible(false);
        listView.PlotterOrdersColumn.setVisible(false);
        listView.PrinterOrdersColumn.setVisible(false);
        listView.ProductOrdersColumn.setVisible(false);
        listView.ServicOrdersColumn.setVisible(false);
        listView.BindOrdersColumn.setVisible(false);
=======
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
    }
    @FXML
    private void initialize () throws Exception {
        OnActionTextField();
        ColumnToDay();
        ColumnDebt();
        ColumnDebtPay();
        ColumnAllDay();

        UpdateTableData();

        clickTable(tableListTodayViewController);
        clickTable(tableListAllDayViewController);
        clickTable(tableListDebtController);
        clickTable(tableListDebtPayController);

<<<<<<< HEAD
    }

    public  void UpdateTableData() {
        TableToDay();
        TableDebt();
        TableDebtPay();
        TableAllDay();
    }
=======
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
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca

    private void TableDebt() {
        TableOrderListController listView = tableListDebtController;
        ObservableList<OrderList> orderListTableList = null;
        try {
            orderListTableList = OrderListDB.selectOrderDebt();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listView.OrdersTable.setItems(orderListTableList);
        rowTable(listView);
    }


    private void TableDebtPay() {

        TableOrderListController listView = tableListDebtPayController;

        ObservableList<OrderList> orderListTableList = null;
        try {
            orderListTableList = OrderListDB.selectOrderDebtPay();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        listView.OrdersTable.setItems(orderListTableList);
        rowTable(listView);
    }

=======
*/
    public void newOrder(ActionEvent actionEvent) throws IOException {
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca

    public  void TableAllDay() {
        TableOrderListController listView = tableListAllDayViewController;
        ObservableList<OrderList> orderListTableList = null;
        try {
            orderListTableList = OrderListDB.selectOrderAll(getFieldAllDay());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listView.OrdersTable.setItems(orderListTableList);
        rowTable(listView);
    }



    public  void TableToDay() {
        TableOrderListController listView = tableListTodayViewController;

        ObservableList<OrderList> orderListTableList = null;
        try {

            orderListTableList = OrderListDB.selectOrderToDay(getFieldToDay());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        listView.OrdersTable.setItems(orderListTableList);
        rowTable(listView);

    }


<<<<<<< HEAD
    public  void rowTable(TableOrderListController listView ) {
/*
        if(saveIdOrders==0){
            listView.OrdersTable.getSelectionModel().select(0);
            if(listView.OrdersTable.getItems().size()!=0) try {


            } catch (Exception e) { e.printStackTrace(); }

        }else {
            listView.rowIdOrders(saveIdOrders);
            if(listView.OrdersTable.getItems().size()!=0) try {


            } catch (
               Exception e) { e.printStackTrace(); }
        }*/
        listView.rowIdOrders(saveIdOrders);
        UpdateOrdersData(listView);

=======
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
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
    }



    public void UpdateOrdersData(TableOrderListController listView )   {

        Integer idOrders = listView.getIdOrders();
        tablePrinterViewController.setIdOrder(idOrders);
        tablePrinterViewController.UpdateTableData(idOrders);

        tablePlotterViewController.setIdOrder(idOrders);
        tablePlotterViewController.UpdateTableData(idOrders);

        tableBindingViewController.setIdOrder(idOrders);
        tableBindingViewController.UpdateTableData(idOrders);

        tableServiceViewController.setIdOrder(idOrders);
        tableServiceViewController.UpdateTableData(idOrders);

        tableProductViewController.setIdOrder(idOrders);
        tableProductViewController.UpdateTableData(idOrders);

        tableAllViewController.setIdOrder(idOrders);
        tableAllViewController.UpdateTableData(idOrders);

        lbNamberOrder.setText(String.valueOf(listView.getIdOrders()));
        lbPrinting.setText(listView.getNamePrinting());
        lbCutter.setText(listView.getNameCutter());
        lbManager.setText(listView.getNameManager());
        lbClient.setText(listView.getNameClient());
        lbStatusPay.setText(listView.getStatusPay());
        lbDataEnd.setText(listView.getDataEnd()+" "+listView.getTimeEnd());
        lbDataCreat.setText(listView.getDataCreate()+" "+listView.getTimeCreate());
        lbSumOrder.setText(String.valueOf(listView.getOrderSum()));
        lbSumPay.setText(String.valueOf(listView.getPaySum()));
    }



    public void clickTable(TableOrderListController listView) {

        listView.OrdersTable.setRowFactory(
                new Callback<TableView<OrderList>, TableRow<OrderList>>() {
                    @Override
                    public TableRow<OrderList> call(TableView<OrderList> tableView) {
                        final TableRow<OrderList> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem payItem = new MenuItem("Оплатить");
                        MenuItem editItem = new MenuItem("Редактировать");
                        MenuItem removeItem = new MenuItem("Удалить");
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

<<<<<<< HEAD
                                saveIdOrders = listView.getIdOrders();
                                UpdateOrdersData(listView);

                            }
                            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {

                                mainApp.showCreadOrders(listView.getIdOrders());
                                UpdateTableData();
=======
                                saveIdOrders = getIdOrders();
                                try { UpdateOrdersData(getIdOrders()); } catch (Exception e) { e.printStackTrace(); }


                            }
                            if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                                mainApp.showAddItemsOrder(OrdersTable.getSelectionModel().getSelectedItem().getIdOrders());
                                OrderListAllUpdata();
                                try { } catch (Exception e) { e.printStackTrace(); }
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
                            }
                        });
                        removeItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

<<<<<<< HEAD
                                DeleteOredrs(listView);
                            }
                        });

                        editItem.setOnAction(new EventHandler<ActionEvent>() {
=======
                        removeItem.setOnAction(new EventHandler<ActionEvent>() {
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    OnEditOrder(listView);
                                } catch (Exception e) { e.printStackTrace(); }
                            }
                        });

<<<<<<< HEAD
                        payItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    OnPay(listView);
                                } catch (Exception e) { e.printStackTrace(); }
=======
                                try { DeleteOredrs(); } catch (Exception e) { e.printStackTrace(); }
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
                            }
                        });
                        rowMenu.getItems().addAll( payItem);
                        rowMenu.getItems().addAll( editItem);
                        rowMenu.getItems().addAll( removeItem);
<<<<<<< HEAD

=======
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
                        row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(rowMenu).otherwise((ContextMenu) null));
                        return row;
                    }


                });
<<<<<<< HEAD
    }



    public void OnEditOrder()  {

=======
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
    }
    public void OnPay()  {

<<<<<<< HEAD
=======
    public Integer getIdOrders() {
        Integer data = 0;
        if(OrdersTable.getItems().size()!=0){
            data =  OrdersTable.getSelectionModel().getSelectedItem().getIdOrders();
        }
        return data;
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
    }

    public void DeleteOredrs(TableOrderListController listView)  {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаления заказа");
        alert.setHeaderText("Удалить заказ: "+listView.getIdOrders()+"?");
        //alert.setContentText("Удалить заказ: "+getIdOrders()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            OrderListDB.deleteOrders(listView.getIdOrders());
            UpdateTableData();


        }else {
            UpdateTableData();


        }

    }
    public void NewOrders()  {
        Integer id = OrderListDB.LastOrder();
        mainApp.showCreadOrders(id);
        UpdateTableData();


    }

    public void OnEditOrder(TableOrderListController listView) {
        mainApp.showCreadOrders(listView.getIdOrders());
        UpdateTableData();

    }

    public void OnPay(TableOrderListController listView) {
        mainApp.showPayOrder(listView.getIdOrders());
        UpdateTableData();

    }

    void OnActionTextField(){
        tfOrderAllDay.setTextFormatter(TextFieldFormatter.getItneger());
        tfOrderAllDay.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                UpdateTableData();
                }});
        tfOrderAllDay.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                UpdateTableData();

                }});


        tfOrderToDay.setTextFormatter(TextFieldFormatter.getItneger());
        tfOrderToDay.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {

                UpdateTableData();
                    new Print(getFieldToDay());
                }});
        tfOrderToDay.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                UpdateTableData();
                }});

    }


    Integer getFieldToDay(){
        Integer index = null;
        if(tfOrderToDay.getText().length()!=0){
            index = Integer.valueOf(tfOrderToDay.getText());
        }
        return index;
    }

    Integer getFieldAllDay(){
        Integer index = null;
        if(tfOrderAllDay.getText().length()!=0){
            index = Integer.valueOf(tfOrderAllDay.getText());
        }
        return index;
    }



}

