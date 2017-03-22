package sample.controller.Statisic.Deal;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.controller.convection.Calendar;
import sample.controller.convection.List;
import sample.controller.convection.TextFieldFormatter;
import sample.controller.convection.ToDate;
import sample.model.pay.PayMent;
import sample.model.pay.PayMentDB;
import sample.model.statistic.deal.*;

import java.time.LocalDate;

/**
 * Created by Admin on 28.03.2017.
 */
public class DealDataController {



    @FXML   public DatePicker DataGetCard;
    @FXML   public ComboBox<PayMent> PayMentBox;
    @FXML   public ComboBox<Deal> DealBox;
    @FXML   public ComboBox<DealGroup> DealGroupBox;
    @FXML   public TextField tfSum;
    @FXML   public TextArea arNameOrder;
    @FXML   public Label lbNameGroup;
    @FXML   public Label lbNameDeal;
    @FXML   public Button AddData;

    @FXML
    private void initialize() throws Exception {
        new Calendar(DataGetCard);
        DataGetCard.setValue(LocalDate.parse(new ToDate().getToDay()));
        OnActionTextField();
        ComboBoxPayMent();
        ComboBoxDeal();
        ComboBoxDealGroup();

        DealBox.setOnAction((event) -> {
            ComboBoxDealGroup();
        });


    }

    public  void ComboBoxPayMent(){
        PayMentBox.setItems( List.PayMent());
        PayMentBox.getSelectionModel().selectFirst();
    }

    public  void ComboBoxDeal(){
        ObservableList<Deal> dealList = null;
        try {    dealList = DealDB.select(); } catch (Exception e) { e.printStackTrace(); }
        DealBox.setItems(dealList);
        DealBox.getSelectionModel().selectFirst();
    }

    public  void ComboBoxDealGroup(){
        ObservableList<DealGroup> dealGroupList = null;
        try {    dealGroupList = DealGroupDB.select(getIdDeal()); } catch (Exception e) { e.printStackTrace(); }
        DealGroupBox.setItems(dealGroupList);
        DealGroupBox.getSelectionModel().selectFirst();

    }
    Integer getIdDeal(){
        return DealBox.getSelectionModel().getSelectedItem().getIdDeal();
    }

    String getNameDeal(){
        return DealBox.getSelectionModel().getSelectedItem().getNameDeal();
    }
    String getNameGroup(){
        return DealGroupBox.getSelectionModel().getSelectedItem().getNameGroup();
    }

    Integer getIdDealGroup(){
        return DealGroupBox.getSelectionModel().getSelectedItem().getIdDealGroup();
    }

    Integer getPayMentId(){
        return PayMentBox.getSelectionModel().getSelectedItem().getIdPayment();
    }

    String getPayMentCard(){
        return PayMentBox.getSelectionModel().getSelectedItem().getNamber_card();
    }

    public void InsertData( ) {
        Double Sum = 0.0;
        if(getIdDeal()==1){
             Sum = Double.valueOf(tfSum.getText())*-1;
        }else{
            Sum = Double.valueOf(tfSum.getText());

        }

        DealOrderDB.InsertData(
                getIdPeople(),
                getIdDealGroup(),
                arNameOrder.getText(),
                getIdPayMent(),Sum ,
                DataGetCard.getValue() );
    }

    /*



    public void UpdateTableDataGroup()  {
        ObservableList<DealGroup> lazData = null;
        try {    lazData = DealGroupDB.select(getIdDeal()); } catch (Exception e) { e.printStackTrace(); }
        TableDealGroup.setItems(lazData);
        TableDealGroup.getSelectionModel().select(0);
        UpdateData();
    }

*/
/*
    public void UpdateData() {
        lbNameGroup.setText(getNameGroup());
        lbNameDeal.setText(getNameDeal());
    }





/*
    public Integer getIdDeal() {
        Integer data = 0;
        if(TableDeal.getItems().size()!=0){
            data = TableDeal.getSelectionModel().getSelectedItem().getIdDeal();
        }
        return data;
    }
    public Integer getIdDealGroup() {
        Integer data = 0;
        if(TableDealGroup.getItems().size()!=0){
            data = TableDealGroup.getSelectionModel().getSelectedItem().getIdDealGroup();
        }
        return data;
    }


    public String getNameDeal() {
        String data = "";
        if(TableDeal.getItems().size()!=0){
            data = TableDeal.getSelectionModel().getSelectedItem().getNameDeal();
        }
        return data;
    }


    public String getNameGroup() {
        String data = "";
        if(TableDealGroup.getItems().size()!=0){
            data = TableDealGroup.getSelectionModel().getSelectedItem().getNameGroup();
        }
        return data;
    }
*/
    void OnActionTextField(){
        tfSum.setTextFormatter(TextFieldFormatter.getDouble());
        tfSum.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfSum.getText().length() != 0) {
                    ActiveText();
                }}});
        tfSum.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfSum.getText().length() != 0) {
                    ActiveText();
                }}});
    }

    Integer getIdPayMent(){
        return PayMentBox.getSelectionModel().getSelectedItem().getIdPayment();
    }

    private void ActiveText() {

    }

    private Integer getIdPeople(){

        return 1;
    }


}

