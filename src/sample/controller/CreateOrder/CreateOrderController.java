package sample.controller.CreateOrder;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import sample.controller.CreateOrder.DataOrder.DataOrderController;
import sample.controller.CreateOrder.SetOrder.BindingController;
import sample.controller.CreateOrder.SetOrder.PlotterController;
import sample.controller.CreateOrder.SetOrder.PrinterController;
import sample.controller.CreateOrder.SetOrder.ServiceController;
import sample.controller.CreateOrder.TableOrder.*;
import sample.controller.OrderList.OrderListController;
import sample.model.OrderTableAll;
import sample.model.binding.order.OrderBinding;
import sample.model.binding.order.OrderBindingDB;
import sample.model.plotter.order.OrderPlotter;
import sample.model.plotter.order.OrderPlotterDB;
import sample.model.print.order.OrderPrinter;
import sample.model.print.order.OrderPrinterDB;
import sample.model.service.order.OrderService;
import sample.model.service.order.OrderServiceDB;

import java.sql.SQLException;

public class CreateOrderController {
    @FXML    private PrinterController orderCreatePrinterController;
    @FXML    private PlotterController orderCreatePlotterController;
    @FXML    private BindingController orderCreateBindingController;
    @FXML    private ServiceController orderCreateServiceController;
    @FXML    private DataOrderController dataOrderViewController;
    @FXML    private OrderListController orderListViewController;

    @FXML    private TableOrderPrinter tablePrinterViewController;
    @FXML    private TableOrderPlotter tablePlotterViewController;
    @FXML    private TableOrderBinding tableBindingViewController;
    @FXML    private TableOrderService tableServiceViewController;
    @FXML    private TableOrderAll tableAllViewController;

    private Integer idOrder;
    @FXML
    TabPane TabOrder;
    @FXML
    TabPane TabTableOrder;

    @FXML
    CheckBox cbExpertMode;
    Integer index;



    @FXML
    private void initialize() throws Exception {

        OnClickTablePrinter();
        OnClickTablePlotter();
        OnClickTableBinding();
        OnClickTableService();
        OnClickAllService();
        //TabOrder.getSelectionModel().select(3);

    }

    public void TabTableOrder() {
        if (TabTableOrder.getSelectionModel().getSelectedIndex() != 0) {
            TabOrder.getSelectionModel().select(TabTableOrder.getSelectionModel().getSelectedIndex() - 1);
        }
    }


    public void TabOrder() {
        if (TabTableOrder.getSelectionModel().getSelectedIndex() != 0) {
            TabTableOrder.getSelectionModel().select(TabOrder.getSelectionModel().getSelectedIndex() + 1);
        }
    }


    public void onCreate(Integer idOrder) throws Exception {
        setIdOrder(idOrder);
        dataOrderViewController.setIdOrder(idOrder);

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

    public void ButtonOrderPrintAdd() throws SQLException, ClassNotFoundException {
        // TabOrder.getSelectionModel().select(1);
        // TabOrder.getSelectionModel().getSelectedItem().setId("TabPrinter");
        Integer Tab = TabOrder.getSelectionModel().getSelectedIndex();


        if (Tab == 0) {
            OrderPrinterDB.insertOrderPrinter(idOrder, orderCreatePrinterController.getNameOrder(), orderCreatePrinterController.getIdPrinter(),
                    orderCreatePrinterController.getIdFormat(), orderCreatePrinterController.getIdDuplex(), orderCreatePrinterController.getIdPaper(), orderCreatePrinterController.getIdPrice(),
                    orderCreatePrinterController.getPricePrint(), orderCreatePrinterController.getPricePaper(), orderCreatePrinterController.getDensity(),
                    orderCreatePrinterController.getCount(), orderCreatePrinterController.getSumOne(), orderCreatePrinterController.getSumAll(),
                    orderCreatePrinterController.getCountPrintA4(), orderCreatePrinterController.getTextDesc(),
                    orderCreatePrinterController.getPrintPrimeCost(), orderCreatePrinterController.getPaperPrimeCost(),
                    orderCreatePrinterController.getPrimeCostSumOne(), orderCreatePrinterController.getPrimeCostSumAll());
            tablePrinterViewController.UpdateTableData(idOrder);
        }
        if (Tab == 1) {
            OrderPlotterDB.insertOrderPlotter(idOrder, orderCreatePlotterController.getNameOrder(), orderCreatePlotterController.getIdPlotter(), orderCreatePlotterController.getIdPaper(),
                    orderCreatePlotterController.getLength(), orderCreatePlotterController.getWidth(), orderCreatePlotterController.getCount()
                    , orderCreatePlotterController.getDensity(), orderCreatePlotterController.getFill(), orderCreatePlotterController.getTextDesc()
                    , orderCreatePlotterController.getArea(), orderCreatePlotterController.getCostMeter(), orderCreatePlotterController.getPrimeCostPrint()
                    , orderCreatePlotterController.getPrimeCostPaper(), orderCreatePlotterController.getSumOne()
                    , orderCreatePlotterController.getPrimeSumOne(), orderCreatePlotterController.getSumAll(), orderCreatePlotterController.getPrimeSumAll());
            tablePlotterViewController.UpdateTableData(idOrder);
        }
        if (Tab == 2) {
            OrderBindingDB.insertOrderBinding(idOrder, orderCreateBindingController.getNameOrder(), orderCreateBindingController.getIdCaver(), orderCreateBindingController.getCoverCost(),
                    orderCreateBindingController.getCoverPrimeCostOne(), orderCreateBindingController.getIdFormat(), orderCreateBindingController.getWorkCostOne(),
                    orderCreateBindingController.getIdSpring(), orderCreateBindingController.getSheet(), orderCreateBindingController.getIdSpringSize(),
                    orderCreateBindingController.getSpringCost(), orderCreateBindingController.getSpringPrimeCostOne(),
                    Double.valueOf(orderCreateBindingController.tfCoverCount.getText().toString()),
                    Double.valueOf(orderCreateBindingController.tfSpringCount.getText().toString()),
                    Double.valueOf(orderCreateBindingController.tfWorkCount.getText().toString()),
                    Integer.valueOf(orderCreateBindingController.tfCount.getText().toString()),
                    orderCreateBindingController.getSumOne(), orderCreateBindingController.getSumAll(),
                    orderCreateBindingController.getPrimeSumOne(),
                    orderCreateBindingController.getPrimeSumAll(),
                    orderCreateBindingController.getTextDesc(),
                    orderCreateBindingController.getCoverCost(), orderCreateBindingController.getCoverPrimeCost(),
                    orderCreateBindingController.getSpringCost(), orderCreateBindingController.getSpringPrimeCost(),
                    orderCreateBindingController.getWorkCost());

            tableBindingViewController.UpdateTableData(idOrder);
        }
        if (Tab == 3) {

            OrderServiceDB.insertOrderService(idOrder, orderCreateServiceController.getNameOrder(),
                    orderCreateServiceController.getIdService(), orderCreateServiceController.getIdServiceItems(),
                    orderCreateServiceController.getCount(), orderCreateServiceController.getSumOne(),
                    orderCreateServiceController.getSumAll(), orderCreateServiceController.getPrimeCostSumOne(),
                    orderCreateServiceController.getPrimeCostSumAll(), orderCreateServiceController.getTextDesc());
            tableServiceViewController.UpdateTableData(idOrder);

        }


        try {
            tableAllViewController.UpdateTableData(idOrder);
            dataOrderViewController.DateUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void DeleteTableItemService() throws Exception {
        OrderServiceDB.delete(tableServiceViewController.OrderServiceTable.getSelectionModel().getSelectedItem().getIdOrderService());
        setIdOrder(idOrder);
        tableServiceViewController.UpdateTableData(idOrder);
        tableAllViewController.UpdateTableData(idOrder);
        dataOrderViewController.DateUpdate();
    }

    public void DeleteTableItemPrinter() throws Exception {
        OrderPrinterDB.delete(tablePrinterViewController.OrderPrintTable.getSelectionModel().getSelectedItem().getIdOrderPrinter());
        tablePrinterViewController.UpdateTableData(idOrder);
        tableAllViewController.UpdateTableData(idOrder);

        dataOrderViewController.DateUpdate();
    }

    public void DeleteTableItemPlotter() throws Exception {
        OrderPlotterDB.delete(tablePlotterViewController.OrderPlotterTable.getSelectionModel().getSelectedItem().getIdOrderPlotter());
        tablePlotterViewController.UpdateTableData(idOrder);
        tableAllViewController.UpdateTableData(idOrder);
        dataOrderViewController.DateUpdate();
    }

    public void DeleteTableItemBinding() throws Exception {
        OrderBindingDB.delete(tableBindingViewController.OrderBindingTable.getSelectionModel().getSelectedItem().getIdOrderBinging());
        tableBindingViewController.UpdateTableData(idOrder);
        tableAllViewController.UpdateTableData(idOrder);
        dataOrderViewController.DateUpdate();
    }

    public void setIdOrder(Integer idOrder) throws Exception {
        this.idOrder = idOrder;
    }


    public void OnClickTablePrinter() {

        tablePrinterViewController.OrderPrintTable.setRowFactory(
                new Callback<TableView<OrderPrinter>, TableRow<OrderPrinter>>() {
                    @Override
                    public TableRow<OrderPrinter> call(TableView<OrderPrinter> tableView) {
                        final TableRow<OrderPrinter> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                try {
                                    DeleteTableItemPrinter();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                                ActionPrinter();
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

    public void OnClickTablePlotter() {

        tablePlotterViewController.OrderPlotterTable.setRowFactory(
                new Callback<TableView<OrderPlotter>, TableRow<OrderPlotter>>() {
                    @Override
                    public TableRow<OrderPlotter> call(TableView<OrderPlotter> tableView) {
                        final TableRow<OrderPlotter> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                try {
                                    DeleteTableItemPlotter();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                                ActionPlotter();
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

    public void OnClickTableBinding() {

        tableBindingViewController.OrderBindingTable.setRowFactory(
                new Callback<TableView<OrderBinding>, TableRow<OrderBinding>>() {
                    @Override
                    public TableRow<OrderBinding> call(TableView<OrderBinding> tableView) {
                        final TableRow<OrderBinding> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                try {
                                    DeleteTableItemBinding();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                                ActionBinding();
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

    public void OnClickTableService() {

        tableServiceViewController.OrderServiceTable.setRowFactory(
                new Callback<TableView<OrderService>, TableRow<OrderService>>() {
                    @Override
                    public TableRow<OrderService> call(TableView<OrderService> tableView) {
                        final TableRow<OrderService> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    DeleteTableItemService();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                                ActionService();
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
    public void OnClickAllService() {

        tableAllViewController.TableOrderAll.setRowFactory(
                new Callback<TableView<OrderTableAll>, TableRow<OrderTableAll>>() {
                    @Override
                    public TableRow<OrderTableAll> call(TableView<OrderTableAll> tableView) {
                        final TableRow<OrderTableAll> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");
                        removeItem.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                try {
                                    DeleteTableItemAll();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                                try {
                                    ActionAll();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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

    void DeleteTableItemAll() throws Exception {

        int month = tableAllViewController.getIdCategory();
        String monthString;
        switch (month) {
            case 1:
                OrderPrinterDB.delete(tableAllViewController.getIdOrderAll());
                tablePrinterViewController.UpdateTableData(idOrder);
                tableAllViewController.UpdateTableData(idOrder);
                dataOrderViewController.DateUpdate();
                break;
            case 2:
                OrderPlotterDB.delete(tableAllViewController.getIdOrderAll());
                tablePlotterViewController.UpdateTableData(idOrder);
                tableAllViewController.UpdateTableData(idOrder);
                dataOrderViewController.DateUpdate();
                break;
            case 3:
                OrderBindingDB.delete(tableAllViewController.getIdOrderAll());
                tableBindingViewController.UpdateTableData(idOrder);
                tableAllViewController.UpdateTableData(idOrder);
                dataOrderViewController.DateUpdate();
                break;
            case 4:
                OrderServiceDB.delete(tableAllViewController.getIdOrderAll());
                tableServiceViewController.UpdateTableData(idOrder);
                tableAllViewController.UpdateTableData(idOrder);
                dataOrderViewController.DateUpdate();
                break;
            default:
                break;
        }


    }

    void ActionAll(){

        int index = tableAllViewController.getIdCategory();
        switch (index) {
            case 1:
                TabTableOrder.getSelectionModel().select(index);
                break;
            case 2:
                TabTableOrder.getSelectionModel().select(index);
                break;
            case 3:
                TabTableOrder.getSelectionModel().select(index);
                break;
            case 4:
                TabTableOrder.getSelectionModel().select(index);
                break;
            default:
                break;
        }


    }

    void ActionService() {
        orderCreateServiceController.setCount(String.valueOf(tableServiceViewController.OrderServiceTable.getSelectionModel().getSelectedItem().getCount()));
        orderCreateServiceController.saveIdServiceItems = tableServiceViewController.getIdServiceItems();
        orderCreateServiceController.rowService(tableServiceViewController.OrderServiceTable.getSelectionModel().getSelectedItem().getIdService());
        orderCreateServiceController.ServiceItemsUpdata();
    }

    void ActionPrinter() {
        try {
            orderCreatePrinterController.rowPrinter(tablePrinterViewController.OrderPrintTable.getSelectionModel().getSelectedItem().getIdPrinter());
            orderCreatePrinterController.ColumEdit.setText(String.valueOf(tablePrinterViewController.orderCount()));
            orderCreatePrinterController.rowFormat(tablePrinterViewController.orderIdFormat());
            orderCreatePrinterController.saveIdFormat = tablePrinterViewController.orderIdFormat();
            orderCreatePrinterController.PrinterFormatUpdate();
            orderCreatePrinterController.PaperPriceUpdate();
            orderCreatePrinterController.rowIdPrice(tablePrinterViewController.orderIdPrice());
            if (tablePrinterViewController.orderIdPrice() == 4) {
                orderCreatePrinterController.PriceEditText.setText(String.format("%.2f", tablePrinterViewController.orderCostPrint()));
            }
            orderCreatePrinterController.saveidPrice = tablePrinterViewController.orderIdPrice();
            orderCreatePrinterController.rowPaper(tablePrinterViewController.orderIdPaper());
            orderCreatePrinterController.saveidPaper = tablePrinterViewController.orderIdPaper();
            orderCreatePrinterController.PaperNameUpdate();
            orderCreatePrinterController.rowPaperDensity(tablePrinterViewController.orderDensity());
            orderCreatePrinterController.saveDensity = tablePrinterViewController.orderDensity();
            orderCreatePrinterController.PaperDensity();
            orderCreatePrinterController.rowDuplex(tablePrinterViewController.orderIdDuplex());
            orderCreatePrinterController.saveidDuplex = tablePrinterViewController.orderIdDuplex();
            orderCreatePrinterController.PaperDuplexUpdate();
            orderCreatePrinterController.setTextDesc(tablePrinterViewController.textDesc());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ActionPlotter() {
        try {
            orderCreatePlotterController.rowPlotter(tablePlotterViewController.getIdPlotter());
            orderCreatePlotterController.rowPaper(tablePlotterViewController.getIdPaper());
            orderCreatePlotterController.savePaperId = tablePlotterViewController.getIdPaper();
            orderCreatePlotterController.PaperUpdata();
            orderCreatePlotterController.rowDensity(tablePlotterViewController.getDensity());
            orderCreatePlotterController.saveDensity = tablePlotterViewController.getDensity();
            orderCreatePlotterController.DensityUpdata();
            orderCreatePlotterController.rowFill(tablePlotterViewController.getFill());
            orderCreatePlotterController.saveFill = tablePlotterViewController.getFill();
            orderCreatePlotterController.FillUpdata();
            orderCreatePlotterController.rowWidth(tablePlotterViewController.getWidth());
            orderCreatePlotterController.saveWidth = tablePlotterViewController.getWidth();
            orderCreatePlotterController.WidthUpdata();
            orderCreatePlotterController.setLength(String.valueOf(tablePlotterViewController.getLength()));
            orderCreatePlotterController.setCostMeter(tablePlotterViewController.getCostMeter());
            orderCreatePlotterController.TextFilds();
            orderCreatePlotterController.setTextDesc(tablePlotterViewController.textDesc());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ActionBinding() {
        try {
            orderCreateBindingController.rowIdBindingFormat(tableBindingViewController.getIdBindingFormat());
            System.out.println(tableBindingViewController.getIdBindingFormat());
            orderCreateBindingController.rowCover(tableBindingViewController.getIdBindingCover());
            orderCreateBindingController.saveCover2 = tableBindingViewController.getIdBindingCover();
            orderCreateBindingController.CoverUpdata();
            orderCreateBindingController.rowSpring(tableBindingViewController.getIdBindingSpring());
            orderCreateBindingController.saveSpring = tableBindingViewController.getIdBindingSpring();
            orderCreateBindingController.SpringUpdata();
            orderCreateBindingController.rowSheet(tableBindingViewController.getSheet());
            orderCreateBindingController.SpringSize();
            orderCreateBindingController.setTfCoverCount(String.valueOf(tableBindingViewController.getCountCover()));
            orderCreateBindingController.setTfSpringCount(String.valueOf(tableBindingViewController.getCountSpring()));
            orderCreateBindingController.setTfWorkCount(String.valueOf(tableBindingViewController.getCountWork()));
            orderCreateBindingController.setTfCount(String.valueOf(tableBindingViewController.getCount()));
            orderCreateBindingController.setTfCoverCostOne(String.valueOf(tableBindingViewController.getCostCoverOne()));
            orderCreateBindingController.setTfSpringCostOne(String.valueOf(tableBindingViewController.getCostSpringSizeOne()));
            orderCreateBindingController.setTfWorkCostOne(String.valueOf(tableBindingViewController.getCostWorkOne()));
            orderCreateBindingController.TextData();
            orderCreateBindingController.setTextDesc(tableBindingViewController.getTextDesc());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionExpertMode(ActionEvent actionEvent) {
        if (cbExpertMode.isSelected()) {
            tableBindingViewController.ColumnVisible(cbExpertMode.isSelected());
            tablePlotterViewController.ColumnVisible(cbExpertMode.isSelected());
            tablePrinterViewController.ColumnVisible(cbExpertMode.isSelected());
            tableServiceViewController.ColumnVisible(cbExpertMode.isSelected());
            tableAllViewController.ColumnVisible(cbExpertMode.isSelected());

        } else {
            tableBindingViewController.ColumnVisible(cbExpertMode.isSelected());
            tablePlotterViewController.ColumnVisible(cbExpertMode.isSelected());
            tablePrinterViewController.ColumnVisible(cbExpertMode.isSelected());
            tableServiceViewController.ColumnVisible(cbExpertMode.isSelected());
            tableAllViewController.ColumnVisible(cbExpertMode.isSelected());
        }
    }

}
