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
public class PrintCounterDaysController {

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

    @FXML private Label lbData;
    String[] variantNameDay = {"Вечер","Утро"};
    String[] variantNamePrinter = {"Все принтеры","Один принтер"};
    private Integer saveidPrint =0;
    String data ;

    @FXML private ComboBox<Printer> SortPrinterBox;
    @FXML private ComboBox SortSelectBox;

    @FXML
    private void initialize() throws Exception {
        data = "curdate()";

        PrintCountDB.LastOrder();
        ComboBoxData();
        TablePrintUpdate();
        TablePrintUpdata();
        OnActionTextField();

    }


        private void ComboBoxData() {
        ObservableList<Printer> list = null;
        try {
            list = PrinterDB.selectCheckCount();
        } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }

        PrinterBox.setItems(list);
        PrinterBox.getSelectionModel().selectFirst();
        SortPrinterBox.setItems(list);
        SortPrinterBox.getSelectionModel().selectFirst();

        ObservableList<String> variant =
                FXCollections.observableArrayList(
                        variantNameDay
                );
        DayBox.setItems(variant);
        DayBox.getSelectionModel().selectFirst();

        ObservableList<String> Select =
                FXCollections.observableArrayList(
                        variantNamePrinter
                );
        SortSelectBox.setItems(Select);
        SortSelectBox.getSelectionModel().selectFirst();


    }


    public void TablePrintUpdate() throws Exception {


        tablePrintCountViewController.TablePrintCount.setRowFactory( tv -> { TableRow<PrintCount> row = new TableRow<>(); row.setOnMouseClicked(event -> { if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

            saveidPrint = tablePrintCountViewController.getIdPrinterCounter();
            System.out.println(saveidPrint);
            TextData();


        } }); return row; });

    }

    public void TextData() {
        rowPrinter(tablePrintCountViewController.getIdPrinter());
        if (getDayBox()==variantNameDay[0]){
            tfCount.setText(String.valueOf(tablePrintCountViewController.getCountEnd()));

        }else {
            tfCount.setText(String.valueOf(tablePrintCountViewController.getCountStart()));
        }

        lbData.setText(tablePrintCountViewController.getDataCount());
    }

    public  void TablePrintUpdata() {
        if(getSortSelectBox()==variantNamePrinter[0]){
            SortPrinterBox.setVisible(false);
        }else{
            SortPrinterBox.setVisible(true);
        }

        ObservableList<PrintCount> data = null;

        if (getSortSelectBox()==variantNamePrinter[0]){
            try { data = PrintCountDB.selectDay(); } catch (Exception e) { e.printStackTrace(); }

        }else {
            try { data = PrintCountDB.selectDaysPrint(getSortPrinterBox()); } catch (Exception e) { e.printStackTrace(); }
        }

        tablePrintCountViewController.TablePrintCount.setItems(data);
        System.out.println(saveidPrint);

        if(saveidPrint==0){
            tablePrintCountViewController.TablePrintCount.getSelectionModel().select(0);
            TextData();
        }else {
            tablePrintCountViewController.rowPrinterTable(saveidPrint);
            TextData();
        }
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

            if (getDayBox()==variantNameDay[0]){
                PrintCountDB.updateDayCountEnd(tablePrintCountViewController.getIdPrinterCounter(),getCount());

            }else {
                PrintCountDB.updateDayCountStart(tablePrintCountViewController.getIdPrinterCounter(),getCount());
            }
            TablePrintUpdata();


    }

    String getLbData(){
        return lbData.getText().toString();
    }


    Integer getIdPrinter(){
        return PrinterBox.getSelectionModel().getSelectedItem().getIdPrinter();
    }
    Integer getSortPrinterBox(){
        return SortPrinterBox.getSelectionModel().getSelectedItem().getIdPrinter();
    }



    String getDayBox(){
        return DayBox.getSelectionModel().getSelectedItem().toString();
    }

    String getSortSelectBox(){
        return SortSelectBox.getSelectionModel().getSelectedItem().toString();
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

