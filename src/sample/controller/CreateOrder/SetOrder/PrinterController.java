package sample.controller.CreateOrder.SetOrder;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.model.print.paper.PaperDuplex;
import sample.model.print.paper.PaperDuplexDB;
import sample.model.print.paper.PaperPrice;
import sample.model.print.paper.PaperPriceDB;
import sample.model.print.*;
import sample.model.print.Printer;

import java.sql.SQLException;

public class PrinterController {

    @FXML    public  TableView<Printer> PrinterTable;
    @FXML    public TableColumn<Printer, String> PrinterColumnName;
    @FXML    public TableView<PrinterFormat> FormatTable;
    @FXML    public TableColumn<PrinterFormat, String> FormatColumnName;
    @FXML    public TableView<PrinterPrice> PrinterPriceTable;
    @FXML    public TableColumn<PrinterPrice, String> PrinterPriceColumnName;
    @FXML    public TableColumn<PrinterPrice, Float> PrinterPriceColumnCost;
    @FXML    public TableView<PaperPrice> PaperNameTable;
    @FXML    public TableColumn<PaperPrice, String> PaperNameColumnName;
    @FXML    public TableView<PaperPrice> PaperDensityTable;
    @FXML    public TableColumn<PaperPrice, Integer> PaperDensityColumnName;
    @FXML    public TableView<PaperPrice> PaperPriceTable;
    @FXML    public TableColumn<PaperPrice, Float> PaperCostColumnName;
    @FXML    public TableView<PaperDuplex> PaperDuplexTable;
    @FXML    public TableColumn<PaperDuplex, String> PaperDuplexColumnName;
    @FXML    public TextField ColumEdit;
    @FXML    public TextField PriceEditText;
    @FXML    private TextArea TextDesc;
    @FXML    private Label LabelPaper;
    @FXML    private Label LabelPrinter;
    @FXML    private Label LabelPriceOne;
    @FXML    private Label LabelPriceAll;

    public Integer saveIdFormat = 0;
    public Integer saveidPrice= 0;
    public Integer saveidPaper= 0;
    public Integer saveidDuplex= 0;
    public Integer saveDensity = 0;

    @FXML
    private void initialize () throws Exception {


        Printer();
        PrinterUpdata();

        PrinterFormat();
        PrinterPrice();

        ColumEdit();
        PriceEditText();
        PaperName();
        PaperDensity();
        PaperPrice();
        PaperDuplex();



    }


    //*************************Printer ***********************************************//

    public void Printer() throws Exception {

        PrinterColumnName.setCellValueFactory(cellData -> cellData.getValue().printerNameProperty());
        PrinterTable.setRowFactory( tv -> {
            TableRow<Printer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                    try {
                        PrinterFormatUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

    }

    public  void PrinterUpdata()throws SQLException {
        //Get all Employees information
        ObservableList<Printer> lazData = null;
        try {

            lazData = PrinterDB.selectPrint();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrinterTable.setItems(lazData);


    }

    public void rowPrinter(Integer id) {

        Integer count = PrinterTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PrinterTable.getSelectionModel().select(i);
                if (PrinterTable.getSelectionModel().getSelectedItem().getPrinterId()== id) {
                    break;
                }
                if (count == i) {
                    PrinterTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    //*************************Printer Format***********************************************//

    public void PrinterFormat() {
        FormatColumnName.setCellValueFactory(cellData1 -> cellData1.getValue().formatNameProperty());

        FormatTable.setRowFactory( tv -> {
            TableRow<PrinterFormat> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveIdFormat = FormatTable.getSelectionModel().getSelectedItem().getFormatId();



                    try {
                        PaperNameUpdate();
                        PrinterPriceUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            return row ;
        });
    }


    public  void PrinterFormatUpdate()  throws Exception {

        ObservableList<PrinterFormat> printFormat = null;
        try {

            printFormat = PrinterFormatDB.selectPrinterFormat(getIdPrinter());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FormatTable.setItems(printFormat);
        if (saveIdFormat==0){
            FormatTable.getSelectionModel().select(0);
            PrinterPriceUpdate();
            PaperNameUpdate();
        }else{
            rowFormat(saveIdFormat);
            PrinterPriceUpdate();
            PaperNameUpdate();
        }
    }

    public void rowFormat(Integer id) {

        //print("rowFormat ", id);

        Integer count = FormatTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                FormatTable.getSelectionModel().select(i);
                if (FormatTable.getSelectionModel().getSelectedItem().getFormatId() == id) {
                    break;
                }
                if (count == i) {
                    FormatTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }


    //***************************PrinterPrice********************************//

    public void PrinterPrice() {

        PrinterPriceColumnName.setCellValueFactory(cellData -> cellData.getValue().namePriceProperty());
        PrinterPriceColumnCost.setCellValueFactory(cellData -> cellData.getValue().costPrintProperty().asObject());

        PrinterPriceTable.setRowFactory( tv -> {
            TableRow<PrinterPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveidPrice =  PrinterPriceTable.getSelectionModel().getSelectedItem().getIdPrice();
                }
                OrderText();
            });
            return row ;
        });
    }


    private void PrinterPriceUpdate() throws Exception {
        Integer idPrinter = FormatTable.getSelectionModel().getSelectedItem().getPrinterId();
        Integer idFormat = FormatTable.getSelectionModel().getSelectedItem().getFormatId();
        Integer count = 1;

        try {
            ObservableList<PrinterPrice> printFormat = null;

                printFormat = PrinterPriceDB.selectPrinterPrice(idPrinter,idFormat, getCount());

            PrinterPriceTable.setItems(printFormat);
        } catch (SQLException e){
            throw e;
        }

        if(saveidPrice==0){
            PrinterPriceTable.getSelectionModel().select(0);
        }else {
            rowIdPrice(saveidPrice);
        }

        OrderText();
    }

    public void rowIdPrice(Integer id) {

        Integer count = PrinterPriceTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PrinterPriceTable.getSelectionModel().select(i);
                if (PrinterPriceTable.getSelectionModel().getSelectedItem().getIdPrice() == id) {
                    break;
                }
                if (count == i) {
                    PrinterPriceTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }


    //***************************ColumEdit********************************//

    public void PriceEditText() {
        PriceEditText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {

                OrderText();


            }

        });
        PriceEditText.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {

                OrderText();
            }

        });
        PriceEditText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    if (!newValue.matches("\\d*")) {

                    PriceEditText.setText(newValue.replaceAll("[^\\d]", "."));
                }
            }
        });
    }

    public void ColumEdit() {

        ColumEdit.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                try {
                    PrinterPriceUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
        ColumEdit.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                try {
                   PrinterPriceUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ColumEdit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    ColumEdit.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }



    //***************************PrinterPrice********************************//

    public void PaperName() throws SQLException {

        PaperNameColumnName.setCellValueFactory(cellData -> cellData.getValue().paperNameProperty());

        PaperNameTable.setRowFactory( tv -> {
            TableRow<PaperPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveidPaper = PaperNameTable.getSelectionModel().getSelectedItem().getIdPaper();
                    try {
                        PaperDensityUpdate();
                        PaperDuplexUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });


    }

    public void PaperNameUpdate() throws SQLException {

        Integer idPrinter = FormatTable.getSelectionModel().getSelectedItem().getPrinterId();
        Integer idFormat = FormatTable.getSelectionModel().getSelectedItem().getFormatId();

        ObservableList<PaperPrice> printFormat = null;
        try {
            printFormat = PaperPriceDB.selectPaperName(idPrinter,idFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PaperNameTable.setItems(printFormat);

        if(saveidPaper==0){
            PaperNameTable.getSelectionModel().select(0);
            PaperDensityUpdate();
            PaperDuplexUpdate();
        }else{
            rowPaper(saveidPaper);
            PaperDensityUpdate();
            PaperDuplexUpdate();
        }


    }

    public void rowPaper(Integer id) {
      // print("rowPaper ", saveidPaper);

        //Integer save = Integer.parseInt(ColumEdit.getText().toString());
        Integer count = PaperNameTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PaperNameTable.getSelectionModel().select(i);
                if (PaperNameTable.getSelectionModel().getSelectedItem().getIdPaper() == id) {
                    break;
                }
                if (count == i) {
                    PaperNameTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }


    //***************************PaperDensity********************************//

    public void PaperDensity() {

        PaperDensityColumnName.setCellValueFactory(cellData -> cellData.getValue().densityPaperPriceProperty().asObject());

        PaperDensityTable.setRowFactory( tv -> {
            TableRow<PaperPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    try {
                        saveDensity = PaperDensityTable.getSelectionModel().getSelectedItem().getDensityPaperPrice();
                        PaperPriceUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });
    }

    private void PaperDensityUpdate() throws SQLException {

        Integer idPrinter = PaperNameTable.getSelectionModel().getSelectedItem().getIdPrinter();
        Integer idFormat = PaperNameTable.getSelectionModel().getSelectedItem().getIdFormat();
        Integer idPaper = PaperNameTable.getSelectionModel().getSelectedItem().getIdPaper();
        try {
            //Get all Employees information
            ObservableList<PaperPrice> printFormat = null;
            try {
                printFormat = PaperPriceDB.selectDensity(idPrinter,idFormat, idPaper);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PaperDensityTable.setItems(printFormat);

        } catch (SQLException e){

            throw e;
        }
        if(saveDensity==0){
            PaperDensityTable.getSelectionModel().select(0);
            PaperPriceUpdate();
        }else {
            rowPaperDensity(saveDensity);
            PaperPriceUpdate();
        }


    }

    public void rowPaperDensity(Integer id) {
        //System.out.println("rowPaperDensity " + saveDensity);

        //Integer save = Integer.parseInt(ColumEdit.getText().toString());
        Integer count = PaperDensityTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PaperDensityTable.getSelectionModel().select(i);
                if (PaperDensityTable.getSelectionModel().getSelectedItem().getDensityPaperPrice() == id) {
                    break;
                }
                if (count == i) {
                    PaperDensityTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    //***************************PaperPrice********************************//
    public void PaperPrice() {
        PaperCostColumnName.setCellValueFactory(cellData -> cellData.getValue().paperCostProperty().asObject());
        PaperPriceTable.setRowFactory(tv -> {
            TableRow<PaperPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    OrderText();
                }
            });
            return row ;
        });
    }

    public void PaperPriceUpdate() throws SQLException {

        Integer idPrinter = PaperDensityTable.getSelectionModel().getSelectedItem().getIdPrinter();
        Integer idFormat = PaperDensityTable.getSelectionModel().getSelectedItem().getIdFormat();
        Integer idPaper = PaperDensityTable.getSelectionModel().getSelectedItem().getIdPaper();
        Integer density = PaperDensityTable.getSelectionModel().getSelectedItem().getDensityPaperPrice();
        try {
            //Get all Employees information
            ObservableList<PaperPrice> printFormat = null;
            try {
                printFormat = PaperPriceDB.selectPaperPrice(idPrinter,idFormat, idPaper, density);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PaperPriceTable.setItems(printFormat);

        } catch (SQLException e){

            throw e;
        }

        PaperPriceTable.getSelectionModel().select(0);
        OrderText();
    }
    //***************************PaperDuplex********************************//
    public void PaperDuplex() {
        PaperDuplexColumnName.setCellValueFactory(cellData -> cellData.getValue().nameDuplexProperty());

        PaperDuplexTable.setRowFactory( tv -> {
            TableRow<PaperDuplex> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveidDuplex = PaperDuplexTable.getSelectionModel().getSelectedItem().getIdDuplex();
                    OrderText();
                }
            });
            return row ;
        });

    }

    public void PaperDuplexUpdate() throws SQLException {

        Integer idPaper = PaperNameTable.getSelectionModel().getSelectedItem().getIdPaper();
        try {
            //Get all Employees information
            ObservableList<PaperDuplex> printFormat = null;
            try {
                printFormat = PaperDuplexDB.selectDuplexName(idPaper);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PaperDuplexTable.setItems(printFormat);

        } catch (SQLException e){

            throw e;
        }

        if(saveidDuplex==0){
            PaperDuplexTable.getSelectionModel().select(0);
            PaperPriceUpdate();
        }else {
            rowDuplex(saveidDuplex);
            PaperPriceUpdate();
        }


        OrderText();
    }


    public void rowDuplex(Integer id) {
        //System.out.println("rowPaperDensity " + saveDensity);

        //Integer save = Integer.parseInt(ColumEdit.getText().toString());
        Integer count = PaperDuplexTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PaperDuplexTable.getSelectionModel().select(i);
                if (PaperDuplexTable.getSelectionModel().getSelectedItem().getIdDuplex() == id) {
                    break;
                }
                if (count == i) {
                    PaperDuplexTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }
    /******************************************************************************************/
    void OrderText(){

       LabelPrinter.setText(""+ getPrinterName()+" ("+ getFormatName()+", "+ getDuplexName()+" )" );
       LabelPaper.setText(""+ getPaperName()+", "+ getDensity());
       LabelPriceOne.setText(String.format("%.2f", getSumOne()));
       LabelPriceAll.setText(String.format("%.2f", getSumAll()));
    }




    public Float getSumOne() {
        Float txConstOne = null;
        if (getIdDuplex()==1){
            txConstOne = getPricePrint()+ getPricePaper();
        }
        if (getIdDuplex()==2){
            txConstOne = getPricePrint()*2+ getPricePaper();
        }
        return txConstOne;
    }

    public Float getSumAll() {
        Float txConstAll = getCount()* getSumOne();
        return txConstAll;
    }


    public  String getNameOrder() {
        String name = ""+getPrinterName()+" ("+ getFormatName()+", "+ getDuplexName()+", "+ getPaperName()+", "+ getDensity()+")";

        return name;
    }

    public Integer getIdPrinter() {
        Integer txIdPrinter ;
        if(PrinterTable.getItems().size()==0){
            txIdPrinter = 0;
        }else{
            txIdPrinter = PrinterTable.getSelectionModel().getSelectedItem().getPrinterId();
        }
        return txIdPrinter;
    }

    String ggg(){
        return "234234";
    }

     String getPrinterName() {
        String txPrinterName;
        if(PrinterTable.getItems().size()==0){
            txPrinterName = "";
        }else{
             txPrinterName = PrinterTable.getSelectionModel().getSelectedItem().getPrinterName();
        }
        return txPrinterName;
    }

    public Integer getIdFormat() {
        Integer txIdFormat ;
        if(FormatTable.getItems().size()==0){
            txIdFormat = 0;
        }else{
            txIdFormat = FormatTable.getSelectionModel().getSelectedItem().getFormatId();
        }

        return txIdFormat;
    }

    public String getFormatName() {
        String  txFormatName = FormatTable.getSelectionModel().getSelectedItem().getFormatName();

        return txFormatName;
    }

    public Integer getCount() {
        Integer txCount = 1;
        if (ColumEdit.getText().length()!=0) {
            txCount = Integer.parseInt(ColumEdit.getText().toString());
        }
        return txCount;
    }

    public Integer getIdPrice() {
        Integer  txIdPrice =  PrinterPriceTable.getSelectionModel().getSelectedItem().getIdPrice();
        return txIdPrice;
    }

    public String getIdPricName() {
        String idPricName = PrinterPriceTable.getSelectionModel().getSelectedItem().getNamePrinter();
        return idPricName;
    }

    public Float getPricePrint() {
        if (getIdPrice()==4){
            PriceEditText.setVisible(true);
        }else {
            PriceEditText.setVisible(false);
        }
        Float txPrintCost = 0f;
        if (getIdPrice()==4){
            if(PriceEditText.getText().length()==0){
                 txPrintCost = 0f;
            }else{
                txPrintCost = Float.parseFloat(PriceEditText.getText().toString());
            }

        }else{
            txPrintCost = PrinterPriceTable.getSelectionModel().getSelectedItem().getCostPrint();
        }

        return txPrintCost;
    }

    public Integer getIdPaper() {
        Integer txIdPaper = PaperNameTable.getSelectionModel().getSelectedItem().getIdPaper();
        return txIdPaper;
    }

    public String getPaperName() {

        String  txPaperName ;
        if(PaperNameTable.getItems().size()==0){
            txPaperName = "";
        }else{
            txPaperName = PaperNameTable.getSelectionModel().getSelectedItem().getPaperName();
        }

        return txPaperName;
    }

    public Integer getDensity() {
        Integer txDensity ;
        if(PaperDensityTable.getItems().size()==0){
            txDensity = 0;
        }else{
            txDensity= PaperDensityTable.getSelectionModel().getSelectedItem().getDensityPaperPrice();
        }


        return txDensity;
    }


    public Float getPricePaper() {
        Float txPaperCost;
        if(PaperPriceTable.getItems().size()==0){
            txPaperCost = Float.valueOf(0);
        }else{
            txPaperCost= PaperPriceTable.getSelectionModel().getSelectedItem().getPaperCost();
        }
        return txPaperCost;
    }

    public Integer getIdDuplex() {
        Integer txIdDuplex ;
        if(PaperDuplexTable.getItems().size()==0){
            txIdDuplex = 1;
        }else{
            txIdDuplex = PaperDuplexTable.getSelectionModel().getSelectedItem().getIdDuplex();
        }
        return txIdDuplex;
    }

    public String getDuplexName() {
        String  txDuplexName;
        if(PaperDuplexTable.getItems().size()==0){
            txDuplexName = "";
        }else{
            txDuplexName = PaperDuplexTable.getSelectionModel().getSelectedItem().getNameDuplex();

        }
        return txDuplexName;
    }
    public Integer getCountPrintA4(){
        Integer count = null;
        if (getIdDuplex()==1){
            if (getIdFormat()==2){
                count = getCount()*2;
            }else{
                count = getCount();
            }
        }
        if (getIdDuplex()==2){
            if (getIdFormat()==2){
                count = getCount()*4;
            }else{
                count = getCount()*2;
            }
        }
        return count;
    }




    public Float getPrimeCostSumAll() {
        Float txConstAll = getCount()* getPrimeCostSumOne();
        return txConstAll;
    }

    public Float getPrimeCostSumOne() {
        Float SumOne = null;
        if (getIdDuplex()==1){
            SumOne = getPrintPrimeCost()+ getPaperPrimeCost();
        }
        if (getIdDuplex()==2){
            SumOne = getPrintPrimeCost()*2+ getPaperPrimeCost();
        }
        return SumOne;
    }

    public Float getPaperPrimeCost() {
        Float txPaperCost;
        if(PaperPriceTable.getItems().size()==0){
            txPaperCost = Float.valueOf(0);
        }else{
            txPaperCost= PaperPriceTable.getSelectionModel().getSelectedItem().getPaperPrimeCost();
        }
        return txPaperCost;
    }

    public Float getPrintPrimeCost() {
        Float txPrintCost = 0f;
        txPrintCost = PrinterPriceTable.getSelectionModel().getSelectedItem().getPrintPrimeCost();
        return txPrintCost;
    }
    //***************************ColumEdit********************************//


    public String getTextDesc() {
        return TextDesc.getText();
    }

    public void setTextDesc(String textDesc) {
        TextDesc.setText(textDesc);
    }


    public void print(String text, String data ){
        System.out.println(text+": "+data);
    }
    public void print(String text, Integer data ){
        System.out.println(text+": "+data);
    }


}
