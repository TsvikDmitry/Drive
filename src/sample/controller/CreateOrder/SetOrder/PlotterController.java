package sample.controller.CreateOrder.SetOrder;

import javafx.collections.ObservableList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.controller.convection.TextFieldFormatter;
import sample.controller.convection.Timer;
import sample.model.plotter.*;
import java.sql.SQLException;


public class PlotterController {


        @FXML public TableView<Plotter> PlotterTable;
        @FXML public TableColumn<Plotter, String> PlotterColumnName;

        @FXML public TableView<PlotterPrice> PaperTable;
        @FXML public TableColumn<PlotterPrice, String> PaperColumnName;

        @FXML public TableView<PlotterPrice> PaperDensityTable;
        @FXML public TableColumn<PlotterPrice, Integer> PaperDensityColumnName;

        @FXML public TableView<PlotterPrice> FillTable;
        @FXML public TableColumn<PlotterPrice, Integer> FillColumnName;

        @FXML public TableView<PlotterPrice> WidthTable;
        @FXML public TableColumn<PlotterPrice, Integer> WidthColumnNamber;

        @FXML public TableView<PlotterFormat> FormatTable;
        @FXML public TableColumn<PlotterFormat, String> FormatColumnName;

        public Integer savePaperId = 0;
        public Integer saveDensity = 0;
        public Integer saveFill = 0;
        public Integer saveWidth = 0;
        public Integer saveLength = 0;
        public Integer saveFormat = 0;


        @FXML public TextField WidthField;
        @FXML public TextField LengthField;
        @FXML public TextField CountField;
        @FXML public TextField CostMeterField;

        @FXML private TextArea TextDesc;
        @FXML private Label AreaLabel;
        @FXML private Label LabelNamePaper;
        @FXML private Label LabelPlotter;
        @FXML public Label LabelSumOne;
        @FXML public Label LabelSumOne2;
        @FXML public Label LabelSumAll;
        @FXML public Label CostAreaLabel;

    @FXML private void initialize () throws Exception {
        //Long start = Timer.TimeStart();

        Plotter();
        PlotterUpdata();

            LengthField();
            CountField();
            CostMeterField();

            Paper();
            Density();
            Fill();
            Width();
            Format();


         //Timer.TimeFinish(getClass().getName(),start);


    }


        //*************************Printer ***********************************************//

        public void Plotter() {

            PlotterColumnName.setCellValueFactory(cellData -> cellData.getValue().plotterNameProperty());
            PlotterTable.setRowFactory( tv -> {
                TableRow<Plotter> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                        try {
                            PaperUpdata();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return row ;
            });

        }

        public  void PlotterUpdata() throws SQLException {
            //Get all Employees information
            ObservableList<Plotter> lazData = null;
            try {

                lazData = PlotterDB.select();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            PlotterTable.setItems(lazData);



        }

        public void rowPlotter(Integer id) {

            Integer count = PlotterTable.getItems().size();
            if (count!=0) {
                for (int i = 0; i <= count; i++) {
                    PlotterTable.getSelectionModel().select(i);
                    if (PlotterTable.getSelectionModel().getSelectedItem().getPlotterId()== id) {
                        break;
                    }
                    if (count == i) {
                        PlotterTable.getSelectionModel().select(0);
                        break;
                    }
                }
            }
        }

        /*******************************************************************************************/

        public void Paper() throws Exception {

            PaperColumnName.setCellValueFactory(cellData -> cellData.getValue().paperNameProperty());
            PaperTable.setRowFactory( tv -> {
                TableRow<PlotterPrice> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                        savePaperId = getIdPaper();

                        try {
                            DensityUpdata();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return row ;
            });

        }

    public  void PaperUpdata() throws SQLException {
        //Get all Employees information
        ObservableList<PlotterPrice> data = null;
        try {

            data = PlotterPriceDB.selectPlotterPaper(getIdPlotter());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PaperTable.setItems(data);
        if (savePaperId==0){
            PaperTable.getSelectionModel().select(0);
            DensityUpdata();
        }else{
            rowPaper(savePaperId);
            DensityUpdata();
        }

    }

    public void rowPaper(Integer id) {

        Integer count = PaperTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PaperTable.getSelectionModel().select(i);
                if (PaperTable.getSelectionModel().getSelectedItem().getPaperId()== id) {
                    break;
                }
                if (count == i) {
                    PaperTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }
    /*******************************************************************************************/

    public void Density() throws Exception {

        PaperDensityColumnName.setCellValueFactory(cellData -> cellData.getValue().densityProperty().asObject());
        PaperDensityTable.setRowFactory( tv -> {
            TableRow<PlotterPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveDensity= getDensity();
                    try {
                        FillUpdata();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

    }

    public  void DensityUpdata() throws SQLException {
        //Get all Employees information
        ObservableList<PlotterPrice> data = null;
        try {

            data = PlotterPriceDB.selectDensity(getIdPlotter(),getIdPaper());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PaperDensityTable.setItems(data);
        if (saveDensity==0){
            PaperDensityTable.getSelectionModel().select(0);
            FillUpdata();
        }else{
            rowDensity(saveDensity);
            FillUpdata();
        }
    }

    public void rowDensity(Integer id) {

        Integer count = PaperDensityTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                PaperDensityTable.getSelectionModel().select(i);
                if (PaperDensityTable.getSelectionModel().getSelectedItem().getDensity()== id) {
                    break;
                }
                if (count == i) {
                    PaperDensityTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }
    /*******************************************************************************************/

    public void Fill() throws Exception {

        FillColumnName.setCellValueFactory(cellData -> cellData.getValue().fillProperty().asObject());
        FillTable.setRowFactory( tv -> {
            TableRow<PlotterPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveFill= getFill();

                    try {
                        WidthUpdata();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

    }

    public  void FillUpdata() throws SQLException {
        //Get all Employees information
        ObservableList<PlotterPrice> data = null;
        try {

            data = PlotterPriceDB.selectFill(getIdPlotter(),getIdPaper());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FillTable.setItems(data);
        if (saveFill==0){
            FillTable.getSelectionModel().select(0);
            WidthUpdata();
        }else{
            rowFill(saveFill);
            WidthUpdata();
        }
    }

    public void rowFill(Integer id) {

        Integer count = FillTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                FillTable.getSelectionModel().select(i);
                if (FillTable.getSelectionModel().getSelectedItem().getFill()== id) {
                    break;
                }
                if (count == i) {
                    FillTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }
    /*******************************************************************************************/

    public void Width() throws Exception {

        WidthColumnNamber.setCellValueFactory(cellData -> cellData.getValue().widthProperty().asObject());
        WidthTable.setRowFactory( tv -> {
            TableRow<PlotterPrice> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveWidth= getWidth();
                    try {
                        WidthClick();
                    } catch (SQLException e) {   e.printStackTrace();}
                }
            });
            return row ;
        });

    }

    public  void WidthUpdata() throws SQLException {
        //Get all Employees information
        ObservableList<PlotterPrice> data = null;
        try {

            data = PlotterPriceDB.selectWidth(getIdPlotter(),getIdPaper(),getDensity(),getFill());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        WidthTable.setItems(data);
        if (saveWidth==0){
            WidthTable.getSelectionModel().select(0);
            WidthClick();
        }else{
            rowWidth(saveWidth);
            WidthClick();
        }

    }

    public void WidthClick() throws SQLException {
        FormatUpdata();
        setCostMeter((getCostPaper()+getCostPrint()));
        System.out.println((getCostPaper()+getCostPrint()));
        TextFilds();
    }
    public void rowWidth(Integer id) {

        Integer count = WidthTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                WidthTable.getSelectionModel().select(i);
                if (WidthTable.getSelectionModel().getSelectedItem().getWidth()== id) {
                    break;
                }
                if (count == i) {
                    WidthTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }
/************************************************************************************/
    public void Format() throws Exception {

       FormatColumnName.setCellValueFactory(cellData -> cellData.getValue().nameFormatProperty());
       FormatTable.setRowFactory( tv -> {
            TableRow<PlotterFormat> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                    FormatClick();
                }
            });
            return row ;
        });

    }

    public  void FormatUpdata() throws SQLException {
        //Get all Employees information
        ObservableList<PlotterFormat> data = null;
        try {

            data = PlotterFormatDB.select(getWidth());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FormatTable.setItems(data);
        if (saveFormat==0){
            FormatTable.getSelectionModel().select(2);
            FormatClick();
            saveFormat=1;
        }else{
            FormatTable.getSelectionModel().select(0);
            FormatClick();
        }
    }

    public  void FormatClick(){

        Integer count = FormatTable.getItems().size();
        if (count!=0) {
            if (FormatTable.getSelectionModel().getSelectedItem().getLength() != 0) {
                setLength("" + FormatTable.getSelectionModel().getSelectedItem().getLength());
            }
            TextFilds();
        }

    }


    /***********************************************************/

    public void LengthField() {


        LengthField.setTextFormatter(TextFieldFormatter.getItneger());

        LengthField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (LengthField.getText().length() != 0) {
                    TextFilds();
                }
            }

        });
        LengthField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (LengthField.getText().length() != 0) {
                    TextFilds();

                }
            }
        });
    }

    public void CostMeterField() {

         CostMeterField.setTextFormatter(TextFieldFormatter.getDouble());

        CostMeterField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (CountField.getText().length() != 0) {

                    TextFilds();
                }
            }

        });
        CostMeterField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (CountField.getText().length() != 0) {
                    TextFilds();

                }
            }
        });
    }
    public void CountField() {

        CountField.setTextFormatter(TextFieldFormatter.getItneger());

        CountField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (CountField.getText().length() != 0) {
                    TextFilds();
                }
            }

        });
        CountField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (CountField.getText().length() != 0) {
                    TextFilds();

                }
            }
        });
    }


    public Integer getIdPlotter() {
        Integer txIdPlotter = 0;
        if(PlotterTable.getItems().size()!=0){
            txIdPlotter = PlotterTable.getSelectionModel().getSelectedItem().getPlotterId();
        }
        return txIdPlotter;
    }

    public String getPlotterName() {
        String  txPlotterName = "";
        if(PlotterTable.getItems().size()!=0){
            txPlotterName = PlotterTable.getSelectionModel().getSelectedItem().getPlotterName();

        }
        return txPlotterName;
    }
    public Integer getIdPaper() {
        Integer txIdPrinter= 0;
        if(PaperTable.getItems().size()!=0){
            txIdPrinter = PaperTable.getSelectionModel().getSelectedItem().getPaperId();
        }
        return txIdPrinter;
    }

    public String getPaperName() {
        String txPlotterName = "";
        if(PaperTable.getItems().size()!=0){
            txPlotterName = PaperTable.getSelectionModel().getSelectedItem().getPaperName();
        }
        return txPlotterName;
    }
    public Integer getDensity() {
        Integer txIdPrinter = 0;
        if(PaperDensityTable.getItems().size()!=0){
            txIdPrinter = PaperDensityTable.getSelectionModel().getSelectedItem().getDensity();
        }
        return txIdPrinter;
    }

    public Integer getFill() {
        Integer txIdPrinter = 0;
        if(FillTable.getItems().size()!=0){
            txIdPrinter = FillTable.getSelectionModel().getSelectedItem().getFill();
        }
        return txIdPrinter;
    }

    public Integer getWidth() {
        Integer txIdPrinter ;
        if(WidthTable.getItems().size()==0){
            txIdPrinter = 0;
        }else{
            txIdPrinter = WidthTable.getSelectionModel().getSelectedItem().getWidth();
        }
        return txIdPrinter;
    }

    public void setLength(String s) {
        LengthField.setText(s);
    }

    public Integer getLength() {
        Integer txIdPrinter =0;
        if (LengthField.getLength()!=0){
            txIdPrinter = Integer.valueOf(LengthField.getText().toString());
        }
        return txIdPrinter;
    }

    public Integer getCount() {
        Integer txCount = 1;
        if (CountField.getText().length()!=0) {
            txCount = Integer.parseInt(CountField.getText().toString());
        }
        return txCount;
    }




    public Float getArea() {
        float Area = 0f;
        if (LengthField.getText().length()!=0){
            Area =  (Float.valueOf(LengthField.getText())* Float.valueOf(getWidth()))/1000000;
        }
        return Area;
    }

    public  String getNameOrder() {
        String name = ""+ getPlotterName()+" "+ getFill()+"% ("+ getPaperName()+" "+ getDensity()+", "+ getWidth()+"x"+ getLength()+")";

        return name;
    }

    public String getTextDesc() {
        return TextDesc.getText();
    }

    public void setTextDesc(String text) {
        TextDesc.setText(text);
    }


    public Float getCostPrint() {
        Float data = 0f;
        if(WidthTable.getItems().size()!=0){
            data = WidthTable.getSelectionModel().getSelectedItem().getCostPrint();
        }
        return data;
    }
    public Float getCostPaper() {
        Float data = 0f;
        if(WidthTable.getItems().size()!=0){
            data = WidthTable.getSelectionModel().getSelectedItem().getCostPaper();
        }
        return data;
    }


    public void setCostMeter(Float data) {
        CostMeterField.setText(String.valueOf(data));
    }

    public Float getCostMeter() {
        Float data = 0f;
        if ( CostMeterField.getLength()!=0){
            data = Float.valueOf(CostMeterField.getText().toString());
        }
        return data;
    }

    public Float getPrimeCostPrint() {
        Float data = 0f;
        if(WidthTable.getItems().size()!=0){
           data = WidthTable.getSelectionModel().getSelectedItem().getPrimeCostPrint();
        }
        return data;
    }

    public Float getPrimeCostPaper() {
        Float data = 0f;
        if(WidthTable.getItems().size()!=0){
            data = WidthTable.getSelectionModel().getSelectedItem().getPrimeCostPaper();
        }
        return data;
    }
    public Float getPrimeSumOne() {
        float data =  (getPrimeCostPaper()+getPrimeCostPrint())* getArea();
        return data;
    }

    public Float getPrimeSumAll() {
        Float txConstAll = getCount() * getPrimeSumOne();
        return txConstAll;
    }

    public Float getSumOne() {
        Float txConstOne = 0f;
        if(WidthTable.getItems().size()!=0) {
            txConstOne = Float.valueOf((getCostMeter()))*getArea();
        }
        return txConstOne;
    }

    public Float getSumAll() {
        Float txConstAll = getCount()* getSumOne();
        return txConstAll;
    }


    public void TextFilds() {



        WidthField.setText(String.valueOf(getWidth()));
        WidthField.setText(String.valueOf(getWidth()));

        AreaLabel.setText( Format( getArea()));
        LabelPlotter.setText(""+ getPlotterName()+" "+ getFill()+"%");
        LabelNamePaper.setText(""+ getPaperName()+" "+ getDensity()+", "+ getWidth()+"x"+ getLength()+"");
        LabelSumOne.setText(Format( getSumOne()));
        LabelSumOne2.setText(Format(getSumOne()));
        LabelSumAll.setText(Format(getSumAll()));



    }
    public String Format(Float number) {
        String numberAsString = String.format("%.2f", number);
        return numberAsString;
    }
    /**********************************************************/

    public void print(String text, String data ){
            System.out.println(text+": "+data);
        }

    public void print(String text, Integer data ){
            System.out.println(text+": "+data);
        }
    public  long TimeStart() {

            long start = System.currentTimeMillis();
            return start;
        }
    public  void TimeFinish(long start){

            long finish = System.currentTimeMillis() - start;
            System.out.println("Timer: "+finish);
            //return finish;
        }




}

/*


        @FXML  public Slider WidthSlider;
        @FXML  public Slider LengthSlider;
        WidthSlider.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                WidthField.setText(""+WidthSlider.getValue());


            }
        });
        LengthSlider.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                LengthField.setText(""+LengthSlider.getValue());


            }
        });*/
