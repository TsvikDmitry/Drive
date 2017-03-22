package sample.controller.Statisic.CounterPrinter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.controller.convection.TextFieldFormatter;
import sample.model.create_order.print.Printer;
import sample.model.create_order.print.PrinterDB;
import sample.model.statistic.PrintCount;
import sample.model.statistic.PrintCountDB;

/**
 * Created by Dima on 23.03.2017.
 */
public class PrintCounterTodayController {


    @FXML    public TableView<PrintCount> TablePrintCount;
    @FXML    public TableColumn<PrintCount, Integer> IdPrintColumn;
    @FXML    public TableColumn<PrintCount, String> NamePrintColumn;
    @FXML    public TableColumn<PrintCount, Integer> CountStartColumn;
    @FXML    public TableColumn<PrintCount, Integer> CountEndColumn;
    @FXML    public TableColumn<PrintCount, Integer> DifferenceColumn;
    @FXML    public TableColumn<PrintCount, String> DateCountColumn;

    @FXML    private TablePrintCounterController tablePrintCountViewController;
    @FXML private ComboBox<Printer> PrinterBox;
    @FXML private ComboBox DayBox;
    @FXML private TextField tfCount;
    String data ;

    @FXML
    private void initialize() throws Exception {
        data = "curdate()";
        PrintCountDB.LastOrder();
        TablePrintClick();
        OnActionTextField();
        UpdateData();

    }


    public void UpdateData() throws Exception {



        TablePrintUpdata();
        ComboBoxData();

    }



    private void ComboBoxData() {
        ObservableList<Printer> list = null;
        try {
            list = PrinterDB.selectCheckCount();
        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }

        PrinterBox.setItems(list);
        PrinterBox.getSelectionModel().selectFirst();


        ObservableList<String> variant =
                FXCollections.observableArrayList(
                        "Вечер","Утро"
                );
        DayBox.setItems(variant);
        DayBox.getSelectionModel().selectFirst();
    }


    public void TablePrintClick() throws Exception {

        tablePrintCountViewController.TablePrintCount.setRowFactory( tv -> { TableRow<PrintCount> row = new TableRow<>(); row.setOnMouseClicked(event -> { if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                    rowPrinter(tablePrintCountViewController.getIdPrinter());
            if (getDayBox()=="Вечер"){
                tfCount.setText(String.valueOf(tablePrintCountViewController.getCountEnd()));

            }else {
                tfCount.setText(String.valueOf(tablePrintCountViewController.getCountStart()));
            }

        } }); return row; });

    }



    public  void TablePrintUpdata() {
        //Get all Employees information
        ObservableList<PrintCount> data = null;

        try {
            data = PrintCountDB.selectToDay();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tablePrintCountViewController.TablePrintCount.setItems(data);

    }

    public void rowPrinter(Integer id) {

        Integer count = PrinterBox.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PrinterBox.getSelectionModel().select(i);
                if (PrinterBox.getSelectionModel().getSelectedItem().getIdPrinter()== id) {
                    break;
                }
                if (count == i) {
                    PrinterBox.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }



    public void AddData(ActionEvent actionEvent) {
        if (getDayBox()=="Вечер"){
            PrintCountDB.updateCountEnd(getIdPrinter(),getCount());
        }else {
            PrintCountDB.updateCountStart(getIdPrinter(),getCount());
        }
        TablePrintUpdata();


    }
    Integer getIdPrinter(){
        return PrinterBox.getSelectionModel().getSelectedItem().getIdPrinter();
    }

    String getDayBox(){
        return DayBox.getSelectionModel().getSelectedItem().toString();
    }

    public Integer getCount() {
        return Integer.valueOf(tfCount.getText().toString());
    }


    void OnActionTextField(){
        tfCount.setTextFormatter(TextFieldFormatter.getItneger());
        tfCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {

                }}});
        tfCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {

                }}});
    }
}
