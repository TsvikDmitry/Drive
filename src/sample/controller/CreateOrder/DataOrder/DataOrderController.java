package sample.controller.CreateOrder.DataOrder;

<<<<<<< HEAD
import javafx.collections.ObservableList;
=======
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.Main;
<<<<<<< HEAD
import sample.controller.CreateOrder.TabOrder.PrinterController;
import sample.controller.convection.Calendar;
import sample.controller.convection.ComboBoxDate;
import sample.controller.convection.Print;
import sample.controller.convection.TimeConv;
import sample.model.client.Client;
import sample.model.client.ClientDB;
import sample.model.list_order.orders.*;
import sample.model.people.People;
import sample.model.people.PeopleDB;
=======
import sample.controller.convection.Calendar;
import sample.controller.convection.ComboBoxDate;
import sample.controller.convection.TimeConv;
import sample.model.orders.*;
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca

import java.time.LocalDate;


/**
 * Created by Dima on 19.02.2017.
 */
public class DataOrderController {

    //@FXML   private DatePicker dataEndOrder;
    // @FXML    private DatePicker dataCreateOrder;
  //  @FXML    public TextField EditSumOrder;
    //@FXML    public Label LabelMoneyOdd;
    //@FXML    public ComboBox<PayMent> payMentBox;

    @FXML public Label LabelNumberOrder;

    @FXML public Label LabelSumOrder;
    @FXML public Label LabelDolg;
    @FXML public Label LabelStatusPay;
    @FXML public ComboBox<String> CreateHourBox;
    @FXML public ComboBox<String> CreateMinuteBox;
    @FXML public ComboBox<String> EndHourBox;
    @FXML public ComboBox<String> EndMinuteBox;
   // @FXML public ComboBox<Client>  ClientBox;

    @FXML public ComboBox<People> PeopleManagerBox;
    @FXML public ComboBox<People>  PeoplePrintingBox;
    @FXML public ComboBox<People>  PeopleCutterBox;
    @FXML public ComboBox<OrderStatus>  StatusOrderBox;

    public DatePicker getDataCreatePicker() {
        return DataCreatePicker;
    }

    @FXML public DatePicker DataCreatePicker;
  //  @FXML private DatePicker DataEndPicker;
    @FXML public  TextArea TextInfo;
    private Integer idOrder ;


    @FXML    private void initialize () throws Exception {
         new Calendar(DataCreatePicker);
       // new Calendar(DataEndPicker);

    }


    public Integer getIdStatusOrder(){
        return StatusOrderBox.getSelectionModel().getSelectedItem().getIdOrderStatus();
    }

   /*public Integer getIdClient(){
        return ClientBox.getSelectionModel().getSelectedItem().getIdClient();
    }

    public Integer getPrice(){
        return ClientBox.getSelectionModel().getSelectedItem().getPrice();
    }
*/

    public Integer getIdManager(){
        return PeopleManagerBox.getSelectionModel().getSelectedItem().getIdPeople();
    }
    public Integer getIdPrinting(){
        return PeoplePrintingBox.getSelectionModel().getSelectedItem().getIdPeople();
    }
    public Integer getIdCutter(){
        return PeopleCutterBox.getSelectionModel().getSelectedItem().getIdPeople();
    }

    public void onCreate(Integer idOrder) throws Exception {
        setIdOrder(idOrder);
    }

    private void setIdOrder(Integer idOrder) throws Exception {
        this.idOrder = idOrder;
    }


    public void DateUpdate(Integer idOrder) throws Exception {
        //new Print("DateUpdate"+idOrder);
        setIdOrder(idOrder);
        OrderList list = OrderListDB.getOrders(idOrder);
        setLabelNumberOrder();
        DataCreatePicker.setValue(LocalDate.parse(list.getDataCreate()));
//        DataEndPicker.setValue(LocalDate.parse(list.getDataEnd()));

        LabelSumOrder.setText(""+list.getOrderSum());
        LabelDolg.setText(""+list.getDolg());
        LabelStatusPay.setText(""+list.getStatusPay());
         if( list.getTextDescription()!=null){
            TextInfo.setText(""+list.getTextDescription());
        }
        ComboBoxData();

        if(list.getTimeCreate()!=null){
            CreateMinuteBox.setValue(new TimeConv(list.getTimeCreate()).getMinets());
            CreateHourBox.setValue(new TimeConv(list.getTimeCreate()).getHous());
        }
      //  new Print("DateUpdate ",list.getTimeEnd());

        if(list.getTimeEnd()!=null){
            EndHourBox.setValue(new TimeConv(list.getTimeEnd()).getHous());
            EndMinuteBox.setValue(new TimeConv(list.getTimeEnd()).getMinets());
        }

       // new Print("list.getIdClient() "+list.getIdClient());
        rowPeopleManager(list.getIdManager());
        rowPeoplePrinting(list.getIdPrinting());
        rowPeopleCutter(list.getIdCutter());
        //rowClient(list.getIdClient());

        rowStatusOrder(list.getIdOrderStatus());

      //  new Print("getPrice()2 "+getPrice());
    }
    /************************************************************/
    public  void ComboBoxData(){


        CreateMinuteBox.setItems(new ComboBoxDate().getMinute());
        EndMinuteBox.setItems(new ComboBoxDate().getMinute());

        CreateHourBox.setItems(new ComboBoxDate().getHour());
        EndHourBox.setItems(new ComboBoxDate().getHour());

        ObservableList<People> listPeople = null;
        try {
            listPeople = PeopleDB.select();
        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }

        PeopleManagerBox.setItems(listPeople);
        PeoplePrintingBox.setItems(listPeople);
        PeopleCutterBox.setItems(listPeople);
/*
       ObservableList<Client> listClient = null;
        try {
            listClient = ClientDB.select();
        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        ClientBox.setItems(listClient);
*/
        ObservableList<OrderStatus> listOrderStatus = null;
        try {
            listOrderStatus = OrderStatusDB.select();
        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        StatusOrderBox.setItems(listOrderStatus);
    }

    /************************************************************/

    public void rowStatusOrder(Integer id) {

        Integer count = StatusOrderBox.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                StatusOrderBox.getSelectionModel().select(i);
                if (StatusOrderBox.getSelectionModel().getSelectedItem().getIdOrderStatus()== id) {
                    break;
                }
                if (count == i) {
                    StatusOrderBox.getSelectionModel().selectFirst();
                    break;
                }
            }
        }
    }
    /************************************************************/

    public void rowPeopleCutter(Integer id) {

        Integer count = PeopleCutterBox.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PeopleCutterBox.getSelectionModel().select(i);
                if (PeopleCutterBox.getSelectionModel().getSelectedItem().getIdPeople()== id) {
                    break;
                }
                if (count == i) {
                    PeopleCutterBox.getSelectionModel().selectFirst();
                    break;
                }
            }
        }
    }
    /************************************************************/

    public void rowPeoplePrinting(Integer id) {

        Integer count = PeoplePrintingBox.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PeoplePrintingBox.getSelectionModel().select(i);
                if (PeoplePrintingBox.getSelectionModel().getSelectedItem().getIdPeople()== id) {
                    break;
                }
                if (count == i) {
                    PeoplePrintingBox.getSelectionModel().selectFirst();
                    break;
                }
            }
        }
    }

    /************************************************************/

    public void rowPeopleManager(Integer id) {

        Integer count = PeopleManagerBox.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PeopleManagerBox.getSelectionModel().select(i);
                if (PeopleManagerBox.getSelectionModel().getSelectedItem().getIdPeople()== id) {
                    break;
                }
                if (count == i) {
                    PeopleManagerBox.getSelectionModel().selectFirst();
                    break;
                }
            }
        }
    }

    /************************************************************/
/*

    public void rowClient (Integer id) {

        Integer count = ClientBox.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                ClientBox.getSelectionModel().select(i);
                if (ClientBox.getSelectionModel().getSelectedItem().getIdClient()== id) {
                    break;
                }
                if (count == i) {
                    ClientBox.getSelectionModel().selectFirst();
                    break;
                }
            }
        }
    }*/

    /************************************************************/

    public String  getTextInfo() {
        String text = "";
        if (TextInfo.getText().length() != 0) {
            text = TextInfo.getText();
        }
        return text;
    }

    public void SaveOrder(ActionEvent actionEvent) {
    }





    public Label getLabelNumberOrder() {
        return LabelNumberOrder;
    }


    public void setLabelNumberOrder() {
        LabelNumberOrder.setText(""+getIdOrder());
    }



    public Integer getIdOrder() {
        return idOrder;
    }





    public void AddClient(ActionEvent actionEvent) {
    }
}
