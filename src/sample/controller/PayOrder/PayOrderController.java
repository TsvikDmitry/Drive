package sample.controller.PayOrder;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import sample.controller.convection.Calendar;
import sample.controller.convection.ComboBoxDate;
import sample.controller.convection.List;
import sample.controller.convection.ToDate;
import sample.model.list_order.orders.OrderList;
import sample.model.list_order.orders.OrderListDB;
import sample.model.pay.PayMent;
import sample.model.pay.PayOrder;
import sample.model.pay.PayOrderDB;

import java.time.LocalDate;
import java.util.regex.Pattern;


public class PayOrderController {

    @FXML  public TableView<PayOrder> PayTable;
    @FXML  public TableColumn<PayOrder, Integer> PayColumnIdOrder;
 //   @FXML  public TableColumn<PayOrder, Integer> PayColumnNamePayMent;

    @FXML  public TableColumn<PayOrder, String> PayColumnDataPay;
    @FXML  public TableColumn<PayOrder, String> PayColumnDataGet;
    @FXML  public TableColumn<PayOrder, Float> PayColumnSumPay;

    @FXML  public TableColumn<PayOrder, String> PayColumnNamePayMent;
    @FXML  public TableColumn<PayOrder, String> PayColumnNamberCard;
    @FXML  public TableColumn<PayOrder, String> PayColumnTextPay;


    @FXML  public Button addPayCard;
    @FXML  public Button addPayMoney;

    private Integer idOrder;
    private OrderList list ;

    @FXML  private Label IdOrderLabel;
    @FXML  private Label SumOrderLabel;
    @FXML  private Label SumPayLabel;
    @FXML  private Label StatusPayLabel;
    @FXML  private Label DolgLabel;
    @FXML  private Label DolgLabelMoney;
    @FXML  private Label DolgLabelCard;

    @FXML private GridPane PayMentGrid;
    @FXML private ComboBox<PayMent>  PayMentBox;
    @FXML private ComboBox VariantPayBox;


    //Data
    @FXML private GridPane DataGrid;
    @FXML private Label DataPayLabel;

    //Money
    @FXML private GridPane MoneyGrid;
    @FXML private Label DolgLableMoney;
    @FXML private TextField SumPayFieldMoney;
    @FXML private Label LableMoney1;
    @FXML private Label LableMoney2;
    @FXML private Label ErrorLableMoney;
    @FXML private Label ErrorLableCard;

    //Card
    @FXML private GridPane CardGrid;
    @FXML private DatePicker DataGetCard;
    @FXML private ComboBox CardHourBox;
    @FXML private ComboBox CardMinuteBox;
    @FXML private TextArea FioFieald;
    @FXML private TextField SumPayFieldCard;
    @FXML private Label DolgLableCard;
    @FXML private Label NamberCardPayLabel;
    @FXML private Label FioCardPayLabel;
    @FXML private Label LableCard1;
    @FXML private Label LableCard2;
    Stage stagePay;

    @FXML
    private void initialize() throws Exception {

        ComboBoxData();
        TablePay();
        DataGrid.setVisible(false);
        new Calendar(DataGetCard);
        EditMoney();
        EditCard();
        OnClickTablePrinter();



    }


    public void EditMoney() {

        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");

        TextFormatter<Double> textFormatter = new TextFormatter<Double>(new DoubleStringConverter(), null,
                change -> {
                    String newText = change.getControlNewText() ;
                    if (validDoubleText.matcher(newText).matches()) {
                 return change ; } else return null; });

        SumPayFieldMoney.setTextFormatter(textFormatter);
        SumPayFieldMoney.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(SumPayFieldMoney.getText().length()!=0){
                    OnKeyMoney();
                } } });

        SumPayFieldMoney.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(SumPayFieldMoney.getText().length()!=0){
                    OnKeyMoney();
                } } });

    }


    void OnKeyMoney(){
        Double ff;
        if (getVariantPayBox()=="Полная"){
            ff = Double.valueOf(SumPayFieldMoney.getText())-list.getDolg();
            ErrorLableMoney.setVisible(false);
            addPayMoney.setVisible(true);
        }else {
            ff = list.getDolg()-Float.valueOf(SumPayFieldMoney.getText());
            if (Float.valueOf(SumPayFieldMoney.getText())>list.getDolg()){
                ErrorLableMoney.setVisible(true);
                ErrorLableMoney.setText("Ошибка, сумма предоплаты больше задолженности");
                addPayMoney.setVisible(false);
            }else{
                ErrorLableMoney.setVisible(false);
                addPayMoney.setVisible(true);
            }
        }
        DolgLableMoney.setText(String.format("%.2f", Double.valueOf(ff)));
    }

    public void EditCard() {

        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");

        TextFormatter<Double> textFormatter = new TextFormatter<Double>(new DoubleStringConverter(), null,
                change -> {
                    String newText = change.getControlNewText();
                    if (validDoubleText.matcher(newText).matches()) {
                        return change;
                    } else return null;
                });

        SumPayFieldCard.setTextFormatter(textFormatter);

        SumPayFieldCard.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (SumPayFieldCard.getText().length() != 0) {
                    OnKeyCard();
                }
            }
        });
        SumPayFieldCard.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (SumPayFieldCard.getText().length() != 0) {
                    OnKeyCard();
                }
            }
        });
    }


    public void OnKeyCard(){
        //System.out.println(ff);
        Double ff ;
        if (getVariantPayBox()=="Полная"){
            ff = Double.valueOf(SumPayFieldCard.getText())-list.getDolg();

            ErrorLableCard.setVisible(false);
            addPayCard.setVisible(true);
        }else {
             ff = list.getDolg()-Float.valueOf(SumPayFieldCard.getText());

            if (Double.valueOf(SumPayFieldCard.getText())>list.getDolg()){
                ErrorLableCard.setVisible(true);
                ErrorLableCard.setText("Ошибка, сумма предоплаты больше задолженности");
                addPayCard.setVisible(false);
            }else{
                ErrorLableCard.setVisible(false);
                addPayCard.setVisible(true);
            }
        }
        DolgLableCard.setText(String.format("%.2f", Double.valueOf(ff)));

    }



    public void onCreate(Integer idOrder) throws Exception {
        setIdOrder(idOrder);
        TableUpdata(idOrder);
        DataUpdate();
    }

    public void DataUpdate() throws Exception {
        list=  OrderListDB.getOrders(idOrder);
        IdOrderLabel.setText(String.valueOf(idOrder));
        SumOrderLabel.setText(String.valueOf(list.getOrderSum()));
        SumPayLabel.setText(String.valueOf(list.getPaySum()));
        StatusPayLabel.setText(list.getStatusPay());
        DolgLabel.setText(String.valueOf(list.getDolg()));

        if (list.getOrderSum()-list.getPaySum()==0) {
            PayMentGrid.setVisible(false);
            MoneyGrid.setVisible(false);
            CardGrid.setVisible(false);
        }else {
            PayMentGrid.setVisible(true);
            VariantPayBox.getSelectionModel().selectFirst();
            PayMentBox.getSelectionModel().selectFirst();


            PayMentGrid();

        }



    }
@FXML
    void PayMentGrid(){

        if (getPayMentId()==1){
            DolgLabelMoney.setText(String.valueOf(list.getDolg()));

            CardGrid.setVisible(false);
            MoneyGrid.setVisible(true);
            SumPayFieldMoney.setText("");
            if (getVariantPayBox()=="Полная"){
                list.getDolg();
                LableMoney1.setText("Принял");
                LableMoney2.setText("Сдача");


            }else {
                LableMoney1.setText("Сумма предоплаты:");
                LableMoney2.setText("Задолженность:");

            }
        }

        if (getPayMentId()!=1){
            DolgLabelCard.setText(String.valueOf(list.getDolg()));
            NamberCardPayLabel.setText(getPayMentCard());
            FioCardPayLabel.setText(getPayMentFio());
            CardGrid.setVisible(true);
            MoneyGrid.setVisible(false);
            SumPayFieldCard.setText("");

            DataGetCard.setValue(LocalDate.parse(new ToDate().getToDay()));
            CardMinuteBox.setItems(new ComboBoxDate().getMinute());
            CardHourBox.setItems(new ComboBoxDate().getHour());
            CardMinuteBox.setValue(new ToDate().getMinets());
            CardHourBox.setValue(new ToDate().getHous());


            if (getVariantPayBox()=="Полная"){
                SumPayFieldCard.setVisible(false);
                DolgLableCard.setVisible(false);
                LableCard1.setVisible(false);
                LableCard2.setVisible(false);
            }else {
                SumPayFieldCard.setVisible(true);
                DolgLableCard.setVisible(true);
                LableCard1.setVisible(true);
                LableCard2.setVisible(true);

            }
        }


    }




    public  void ComboBoxData(){


        ObservableList<String> variant =
                FXCollections.observableArrayList(
                        "Полная","Частичная"
                );
        VariantPayBox.setItems(variant);
        VariantPayBox.getSelectionModel().selectFirst();

        PayMentBox.setItems( List.PayMent());
        PayMentBox.getSelectionModel().selectFirst();

    }

    String getVariantPayBox(){
        return VariantPayBox.getSelectionModel().getSelectedItem().toString();
    }

    Integer getPayMentId(){
        return PayMentBox.getSelectionModel().getSelectedItem().getIdPayment();
    }

    String getPayMentCard(){
        return PayMentBox.getSelectionModel().getSelectedItem().getNamber_card();
    }
    String getPayMentName(){
        return PayMentBox.getSelectionModel().getSelectedItem().getName_payment();
    }
    String getPayMentFio(){
        return PayMentBox.getSelectionModel().getSelectedItem().getFioPeople();
    }

    public void TablePay() throws Exception {
        PayColumnIdOrder.setCellValueFactory(cellData -> cellData.getValue().idOrderProperty().asObject());
        PayColumnDataPay.setCellValueFactory(cellData -> cellData.getValue().dataPayProperty());
        PayColumnDataGet.setCellValueFactory(cellData -> cellData.getValue().dataGetProperty());
        PayColumnSumPay.setCellValueFactory(cellData -> cellData.getValue().sumPayProperty().asObject());
        PayColumnNamePayMent.setCellValueFactory(cellData -> cellData.getValue().namePaymentProperty());
        PayColumnNamberCard.setCellValueFactory(cellData -> cellData.getValue().namberCardProperty());
        PayColumnTextPay.setCellValueFactory(cellData -> cellData.getValue().textPayProperty());
    }


    public void OnClickTablePrinter() {

        PayTable.setRowFactory(
                new Callback<TableView<PayOrder>, TableRow<PayOrder>>() {
                    @Override
                    public TableRow<PayOrder> call(TableView<PayOrder> tableView) {
                        final TableRow<PayOrder> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem removeItem = new MenuItem("Delete");

                        removeItem.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                try {
                                    DeletePay();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        row.setOnMouseClicked(event -> {
                            if (event.getClickCount() == 2 && (!row.isEmpty())) {
                                //
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


    public  void TableUpdata(Integer idOrder) {
        //Get all Employees information
        ObservableList<PayOrder> payOrderList = null;
        try {
            payOrderList = PayOrderDB.selectOrderPrinter(idOrder);
        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        PayTable.setItems(payOrderList);
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }


    public void CloseForm(ActionEvent actionEvent) {
        stagePay.close();
    }

    public void addPayCard(ActionEvent actionEvent) throws Exception {

        Double sum_pay;
        if (getVariantPayBox()=="Полная"){
            sum_pay = Double.valueOf(list.getDolg());
        }else {
            sum_pay = Double.valueOf(SumPayFieldCard.getText());
        }
        PayOrderDB.insertOrderPrinter(
                idOrder,
                getPayMentId(),
                DataGetCard.getValue(),
                CardHourBox.getValue()+":"+CardMinuteBox.getValue(),
                sum_pay,
                FioFieald.getText());
        TableUpdata(idOrder);
        DataUpdate();
    }

    public void addPayMoney(ActionEvent actionEvent) throws Exception {
        Double sum_pay;
        if (getVariantPayBox()=="Полная"){
            sum_pay = Double.valueOf(list.getDolg());


        }else {
            sum_pay = Double.valueOf(SumPayFieldMoney.getText());
        }


        PayOrderDB.insertOrderPrinter(
                idOrder,
                getPayMentId(),
               null,
                null, sum_pay, null);
        TableUpdata(idOrder);
        DataUpdate();
    }

    public void DeletePay() throws Exception {
        Integer idPay = PayTable.getSelectionModel().getSelectedItem().getIdPay();

        PayOrderDB.delete(idPay);
        TableUpdata(idOrder);
        DataUpdate();
    }
    public void setClose(Stage stage) {
        this.stagePay = stage;
    }
}
