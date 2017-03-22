package sample.controller.CreateOrder.SetOrder;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.controller.convection.TextFieldFormatter;
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
    @FXML public TextArea tfTextDesc;
    public Integer saveIdService = 0;
    public Integer saveIdServiceItems= 0;

    @FXML private void initialize () throws Exception {

        Service();
        ServiceUpdata();

        ServiceItems();
        OnActionTextField();

    }




    /**********************************Format************************************************/
    public void Service() {
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

    public void ServiceUpdata() {
        ObservableList<Service> lazData = null;
        try {

            lazData = ServiceDB.select();
            System.out.println(getIdService() +" "+getIdServiceItems());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServiceTable.setItems(lazData);
        ServiceTable.getSelectionModel().select(0);

      /*  if (saveIdService==0){
            ServiceTable.getSelectionModel().select(0);

            TablText();
        }else{
            rowServiceItems(saveIdService);
            TablText();
        }*/
    }


    public void rowService(Integer id) {

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

    public void ServiceItems() {
        ServiceItemColumnName.setCellValueFactory(cellData -> cellData.getValue().nameItemsProperty());
        ServiceItemColumnCost.setCellValueFactory(cellData -> cellData.getValue().costItemsProperty().asObject());
        ServiceItemTable.setRowFactory( tv -> {
            TableRow<ServiceItems> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    TablText();
                    saveIdServiceItems = getIdServiceItems();

                }
            });
            return row ;
        });
    }

    public void ServiceItemsUpdata() {
        ObservableList<ServiceItems> lazData = null;
        try {

            lazData = ServiceItemsDB.select(getIdService());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServiceItemTable.setItems(lazData);
        if (saveIdServiceItems==0){
            ServiceItemTable.getSelectionModel().select(0);
            TablText();
        }else{
            rowServiceItems(saveIdServiceItems);
            TablText();
        }
    }

    public void rowServiceItems(Integer id) {

        Integer count = ServiceItemTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                ServiceItemTable.getSelectionModel().select(i);
                if (ServiceItemTable.getSelectionModel().getSelectedItem().getIdServiceItems()== id) {
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
    void TablText(){

        lbServiceItemName.setText(""+ getNameItems());
        lbSumOne.setText(""+getSumOne());
        ActiveText();
    }
    void ActiveText(){

        lbSumAll.setText(""+getSumAll());

    }

    /**********************************Get************************************************/

    public String getNameOrder() {
        String nameOrder = getNameService()+": "+getNameItems();
        return nameOrder;
    }

    public Integer getCount() {
        return Integer.valueOf(tfCount.getText().toString());
    }

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
    public Double getPrimeCostSumAll() {
        Double txIdPlotter = getPrimeCostSumOne()*getCount();

        return txIdPlotter;
    }
    public Double getPrimeCostSumOne() {
        Double txIdPlotter = 0.0;
        if(ServiceItemTable.getItems().size()!=0){
            txIdPlotter = ServiceItemTable.getSelectionModel().getSelectedItem().getPrimeCostItems();
        }
        return txIdPlotter;
    }
    public String getNameService() {
        String txIdPlotter = "";
        if(ServiceItemTable.getItems().size()!=0){
            txIdPlotter = ServiceItemTable.getSelectionModel().getSelectedItem().getNameService();
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

    public Double getSumAll() {
        Double txIdPlotter = 0.0;
        if(tfCount.getText().length()!=0){
            txIdPlotter = getCostItems()*getCount();
        }
        return txIdPlotter;
    }
    public Double getSumOne() {
        Double txIdPlotter = 0.0;
        if(tfCount.getText().length()!=0){
             txIdPlotter = getCostItems();
        }
        return txIdPlotter;
    }
    public void setCount(String tfCount) {
        this.tfCount.setText(tfCount);
    }


    void OnActionTextField(){
        tfCount.setTextFormatter(TextFieldFormatter.getItneger(1));
        tfCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    ActiveText();
                }}});
        tfCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    ActiveText();
                }}});
    }


    public String getTextDesc() {
        return tfTextDesc.getText().toString();
    }

}
