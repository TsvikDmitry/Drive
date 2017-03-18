package sample.controller.CreateOrder.SetOrder;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.convection.TextFieldFormatter;
import sample.model.binding.BindingCover;
import sample.model.binding.BindingCoverDB;
import sample.model.binding.BindingFormat;
import sample.model.binding.BindingFormatDB;
import sample.model.service.Service;
import sample.model.service.ServiceDB;
import sample.model.service.ServiceItems;
import sample.model.service.ServiceItemsDB;

/**
 * Created by Dima on 13.03.2017.
 */
public class ServiceController {

    @FXML public TableView<Service> ServiceTable;
    @FXML public TableColumn<Service, String> ServiceColumnName;

    @FXML public TableView<ServiceItems> ServiceItemTable;
    @FXML public TableColumn<ServiceItems, String> ServiceItemColumnName;
    @FXML public TableColumn<ServiceItems, Double> ServiceItemColumnCost;


    @FXML public Label lbServiceItemName;
    @FXML public Label lbSumOne;
    @FXML public Label lbSumAll;
    @FXML public TextField tfCount;


    @FXML private void initialize () throws Exception {

        Service();
        ServiceUpdata();
        ServiceItems();
        ServiceItemsUpdata();
        OnActionTextField();
    }




    /**********************************Format************************************************/
    private void Service() {
        ServiceColumnName.setCellValueFactory(cellData -> cellData.getValue().nameServiceProperty());
        ServiceTable.setRowFactory( tv -> {
            TableRow<Service> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                    ServiceItemsUpdata();

                }
            });
            return row ;
        });
    }

    private void ServiceUpdata() {
        ObservableList<Service> lazData = null;
        try {

            lazData = ServiceDB.select();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServiceTable.setItems(lazData);
        ServiceTable.getSelectionModel().select(0);

    }


    public void rowPrinter(Integer id) {

        Integer count = ServiceTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                ServiceTable.getSelectionModel().select(i);
                if (ServiceTable.getSelectionModel().getSelectedItem().getIdService()== id) {
                    break;
                }
                if (count == i) {
                    ServiceTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    /**********************************Cover************************************************/

    private void ServiceItems() {
        ServiceItemColumnName.setCellValueFactory(cellData -> cellData.getValue().nameItemsProperty());
        ServiceItemColumnCost.setCellValueFactory(cellData -> cellData.getValue().costItemsProperty().asObject());
        ServiceItemTable.setRowFactory( tv -> {
            TableRow<ServiceItems> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    OrderText();

                }
            });
            return row ;
        });
    }

    private void ServiceItemsUpdata() {
        ObservableList<ServiceItems> lazData = null;
        try {

            lazData = ServiceItemsDB.select(getIdService());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServiceItemTable.setItems(lazData);
        ServiceItemTable.getSelectionModel().select(0);
        OrderText();
    }

    public void rowServiceItems(Integer id) {

        Integer count = ServiceItemTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                ServiceItemTable.getSelectionModel().select(i);
                if (ServiceItemTable.getSelectionModel().getSelectedItem().getIdService()== id) {
                    break;
                }
                if (count == i) {
                    ServiceItemTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    /**********************************TextField************************************************/
    void OrderText(){

        lbServiceItemName.setText(""+ getNameItems());
        lbSumOne.setText(""+getCostItems());
        SumAll();
    }

    void SumAll(){
        lbSumAll.setText(String.format("%.2f", getSumOne()));
    }
    /**********************************Get************************************************/


    public Integer getIdService() {
        Integer txIdPlotter = 0;
        if(ServiceTable.getItems().size()!=0){
            txIdPlotter = ServiceTable.getSelectionModel().getSelectedItem().getIdService();
        }
        return txIdPlotter;
    }

    public Integer getIdServiceItems() {
        Integer txIdPlotter = 0;
        if(ServiceItemTable.getItems().size()!=0){
            txIdPlotter = ServiceItemTable.getSelectionModel().getSelectedItem().getIdServiceItems();
        }
        return txIdPlotter;
    }

    public Double getCostItems() {
        Double txIdPlotter = 0.0;
        if(ServiceItemTable.getItems().size()!=0){
            txIdPlotter = ServiceItemTable.getSelectionModel().getSelectedItem().getCostItems();
        }
        return txIdPlotter;
    }

    public Double getPrimeCostItems() {
        Double txIdPlotter = 0.0;
        if(ServiceItemTable.getItems().size()!=0){
            txIdPlotter = ServiceItemTable.getSelectionModel().getSelectedItem().getPrimeCostItems();
        }
        return txIdPlotter;
    }
    public String getNameItems() {
        String txIdPlotter = "";
        if(ServiceItemTable.getItems().size()!=0){
            txIdPlotter = ServiceItemTable.getSelectionModel().getSelectedItem().getNameItems();
        }
        return txIdPlotter;
    }


    public Double getSumOne() {
        Double txIdPlotter = 0.0;
        if(tfCount.getText().length()!=0){
             txIdPlotter = getCostItems()*Double.valueOf(tfCount.getText().toString());
        }
        return txIdPlotter;
    }


    void OnActionTextField(){
        tfCount.setTextFormatter(TextFieldFormatter.getItneger(1));
        tfCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    SumAll();
                }}});
        tfCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    SumAll();
                }}});
    }
}
