package sample.controller.CreateOrder.DataOrder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.convection.Calendar;
import sample.convection.ComboBoxDate;
import sample.convection.TimeConv;
import sample.convection.ToDate;
import sample.model.orders.*;

import java.time.LocalDate;


/**
 * Created by Dima on 19.02.2017.
 */
public class DataOrderController {
    private Main mainApp = new Main();

    //@FXML   private DatePicker dataEndOrder;
    // @FXML    private DatePicker dataCreateOrder;
  //  @FXML    public TextField EditSumOrder;
    //@FXML    public Label LabelMoneyOdd;
    //@FXML    public ComboBox<PayMent> payMentBox;

    @FXML public Label LabelNumberOrder;

    @FXML public Label LabelSumOrder;
    @FXML public Label LabelDolg;
    @FXML public Label LabelStatusPay;
    @FXML public ComboBox CreateHourBox;
    @FXML public ComboBox CreateMinuteBox;
    @FXML public ComboBox EndHourBox;
    @FXML public ComboBox EndMinuteBox;

    @FXML private DatePicker DataCreatePicker;
    @FXML private DatePicker DataEndPicker;
    @FXML private  TextArea TextInfo;
    @FXML public ComboBox StatusOrderBox;
    Calendar DataCreate ;
    Calendar DataEnd;
    private Integer idOrder ;



    @FXML    private void initialize () throws Exception {
        DataCreate = new Calendar(DataCreatePicker);
        DataEnd = new Calendar(DataEndPicker);

        //  System.out.println( payMentBox.getSelectionModel().getSelectedItem().toString());
        //     System.out.println( payMentBox.getSelectionModel().getSelectedItem().getIdPayment());
        //Get all Employees information



    }

    public void onCreate(Integer idOrder) throws Exception {
        setIdOrder(idOrder);
        DateUpdate();
    }

    public void setIdOrder(Integer idOrder) throws Exception {
        this.idOrder = idOrder;
        DateUpdate();
    }


    public void DateUpdate() throws Exception {
        OrderList list = OrderListDB.getOrders(idOrder);
        setLabelNumberOrder();
        DataCreatePicker.setValue(LocalDate.parse(list.getDataCreate()));
        //Sytem.out.println(list.getDataEnd());
        DataEndPicker.setValue(LocalDate.parse(list.getDataEnd()));
        LabelSumOrder.setText(""+list.getOrderSum());
        LabelDolg.setText(""+list.getDolg());
        LabelStatusPay.setText(list.getStatusPay());
        TextInfo.setText(list.getTextDescription());
        ComboBoxData();
        if(list.getTimeCreate()!=null){
            CreateMinuteBox.setValue(new TimeConv(list.getTimeCreate()).getMinets());
            CreateHourBox.setValue(new TimeConv(list.getTimeCreate()).getHous());}

        if(list.getTimeEnd()!=null){
             EndMinuteBox.setValue(new TimeConv(list.getTimeEnd()).getMinets());
             EndHourBox.setValue(new TimeConv(list.getTimeEnd()).getHous());
        }
    }


    public  void ComboBoxData(){


        CreateMinuteBox.setItems(new ComboBoxDate().getMinute());
        EndMinuteBox.setItems(new ComboBoxDate().getMinute());

        CreateHourBox.setItems(new ComboBoxDate().getHour());
        EndHourBox.setItems(new ComboBoxDate().getHour());



    }


    public void SaveOrder(ActionEvent actionEvent) {
    }

    public void CancelOrder(ActionEvent actionEvent) {
    }

    public void PayOrder(ActionEvent actionEvent) throws Exception {
        mainApp.showPayOrder(idOrder);
        DateUpdate();

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



}
