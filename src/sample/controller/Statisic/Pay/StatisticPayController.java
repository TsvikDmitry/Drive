package sample.controller.Statisic.Pay;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.pay.PayOrder;
import sample.model.pay.PayOrderDB;

/**
 * Created by Dima on 31.03.2017.
 */
public class StatisticPayController {
    public ComboBox GroupsBox;
    String[] groups = {"Cпособу оплаты","№ заказам", "без групировки"};


    @FXML  public TableView<PayOrder> PayTable;
    @FXML  public TableColumn<PayOrder, Integer> PayColumnIdOrder;
    //   @FXML  public TableColumn<PayOrder, Integer> PayColumnNamePayMent;

    @FXML  public TableColumn<PayOrder, String> PayColumnDataPay;
    @FXML  public TableColumn<PayOrder, String> PayColumnDataGet;
    @FXML  public TableColumn<PayOrder, Float> PayColumnSumPay;

    @FXML  public TableColumn<PayOrder, String> PayColumnNamePayMent;
    @FXML  public TableColumn<PayOrder, String> PayColumnNamberCard;
    @FXML  public TableColumn<PayOrder, String> PayColumnTextPay;



    String  data ;

    @FXML
    private void initialize() throws Exception {
        PayColumnIdOrder.setCellValueFactory(cellData -> cellData.getValue().idOrderProperty().asObject());
        PayColumnDataPay.setCellValueFactory(cellData -> cellData.getValue().dataPayProperty());
        PayColumnDataGet.setCellValueFactory(cellData -> cellData.getValue().dataGetProperty());
        PayColumnSumPay.setCellValueFactory(cellData -> cellData.getValue().sumPayProperty().asObject());
        PayColumnNamePayMent.setCellValueFactory(cellData -> cellData.getValue().namePaymentProperty());
        PayColumnNamberCard.setCellValueFactory(cellData -> cellData.getValue().namberCardProperty());
        PayColumnTextPay.setCellValueFactory(cellData -> cellData.getValue().textPayProperty());

        data = "curdate()";
        ObservableList<String> variant = FXCollections.observableArrayList(groups);
        GroupsBox.setItems(variant);
        GroupsBox.getSelectionModel().selectFirst();
        UpdateData();




    }


    public void UpdateData() {
        //Get all Employees information
        ObservableList<PayOrder> payOrderList = null;
        try {

            if (getGroupsBox()==groups[0]){
                payOrderList = PayOrderDB.selectOrderPay(data, PayOrderDB.PayMent);
            }
            if (getGroupsBox()==groups[1]){
                payOrderList = PayOrderDB.selectOrderPay(data, PayOrderDB.PayOrder);
            }
            if (getGroupsBox()==groups[2]){
                payOrderList = PayOrderDB.selectOrderPay(data,PayOrderDB.NotGroup );
            }

        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        PayTable.setItems(payOrderList);

    }

    String getGroupsBox(){
        return GroupsBox.getSelectionModel().getSelectedItem().toString();
    }


}
