package sample.controller.CreateOrder.TabOrder;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.controller.convection.TextFieldFormatter;
<<<<<<< HEAD:src/sample/controller/CreateOrder/TabOrder/BindingController.java
import sample.model.create_order.binding.*;
=======
import sample.model.binding.*;
>>>>>>> c3fcecab96c2b187c624c29846cb4881b4973fca:src/sample/controller/CreateOrder/SetOrder/BindingController.java


public class BindingController {
    @FXML
    public TableView<BindingFormat> FormatTable;
    @FXML public TableColumn<BindingFormat, String> FormatColumnName;

    @FXML public TableView<BindingCover> CoverTable;
    @FXML public TableColumn<BindingCover, String> CoverColumnName;
    @FXML public TableColumn<BindingCover, Double> CoverColumnCost;

    @FXML public TableView<BindingSpringSize> SpringTable;
    @FXML public TableColumn<BindingSpringSize, String> SpringColumnName;
    @FXML public TableColumn<BindingSpringSize, String> SpringColumnColor;

    @FXML public TableView<BindingSpringSize> SpringSizeTable;
    @FXML public TableColumn<BindingSpringSize, Integer> SpringSizeColumnSheet;
    @FXML public TableColumn<BindingSpringSize, String> SpringSizeColumnSize;
    @FXML public TableColumn<BindingSpringSize, Double> SpringSizeColumnCost;



    @FXML public TextField tfSpringCount;
    @FXML public TextField tfCoverCount;
    @FXML public TextField tfWorkCount;

    @FXML public TextField tfSpringCostOne;
    @FXML public TextField tfWorkCostOne;
    @FXML public TextField tfCoverCostOne;
    @FXML public TextField tfCount;

    @FXML public TextArea tfTextDesc;

    @FXML public Label lbSpringCostAll;
    @FXML public Label lbWorkCostAll;
    @FXML public Label lbCoverCostAll;


    @FXML public Label lbCoverName;
    @FXML public Label lbSpringName;

    @FXML public Label lbSumOne;
    @FXML public Label lbSumAll;

    public Integer saveFormat = 0;
    public String saveCover = "";
    public Integer saveCover2 = 0;
    public Integer saveSpring = 0;
    public Integer saveSheet = 0;
    public String nameOrder ="";


    @FXML private void initialize () throws Exception {
        BindingFormat();
        BindingFormatUpdata();

        Cover();
        SpringSize();
        Spring();
        OnActionTextField();

    }

/**********************************Format************************************************/
    public void BindingFormat() {
        FormatColumnName.setCellValueFactory(cellData -> cellData.getValue().nameFormatProperty()); FormatTable.setRowFactory( tv -> { TableRow<BindingFormat> row = new TableRow<>(); row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                    CoverUpdata();
                } }); return row; }); }

    public void BindingFormatUpdata()  {
        ObservableList<BindingFormat> lazData = null;
        try {    lazData = BindingFormatDB.select(); } catch (Exception e) { e.printStackTrace(); }
        FormatTable.setItems(lazData);
    }

    public void rowIdBindingFormat(Integer id) {

        Integer count = FormatTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                FormatTable.getSelectionModel().select(i);
                if (FormatTable.getSelectionModel().getSelectedItem().getIdBindingFormat()== id) {
                    break;
                }
                if (count == i) {
                    FormatTable.getSelectionModel().select(0);
                    break; } } }
    }

    /**********************************Cover************************************************/

    public void Cover() {
        CoverColumnName.setCellValueFactory(cellData -> cellData.getValue().nameCoverProperty());
        CoverColumnCost.setCellValueFactory(cellData -> cellData.getValue().costCoverProperty().asObject());
        CoverTable.setRowFactory( tv -> {
            TableRow<BindingCover> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveCover = getNameCover();
                    SpringUpdata();
                } }); return row; });
    }

    public void CoverUpdata() {
        ObservableList<BindingCover> lazData = null;
        try { lazData = BindingCoverDB.select(getIdFormat()); } catch (Exception e) { System.out.println("Exception"+e); e.printStackTrace(); }

        CoverTable.setItems(lazData);
        if (saveCover==""){
            if (saveCover2==0){
                CoverTable.getSelectionModel().select(0);
                SpringUpdata();
            }else{
                rowCover(saveCover2);
                SpringUpdata();
            }
        }else{
            rowCover(saveCover);
            SpringUpdata();
        }
    }

    public void rowCover(String id) {
          Integer count = CoverTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                CoverTable.getSelectionModel().select(i);
                if (new String(CoverTable.getSelectionModel().getSelectedItem().getNameCover()).equals(id)) {
                    break;
                }
                if (count == i) {
                    CoverTable.getSelectionModel().select(0);
                    break;
      } } } }

    public void rowCover(Integer id) {

        Integer count = CoverTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                CoverTable.getSelectionModel().select(i);
                if (CoverTable.getSelectionModel().getSelectedItem().getIdBindingCover()== id) {
                    break;
                }
                if (count == i) {
                    CoverTable.getSelectionModel().select(0);
                    break;
                } } }
    }


    /**********************************Spring************************************************/

    public void Spring() {
        SpringColumnName.setCellValueFactory(cellData -> cellData.getValue().nameSpringProperty());
        SpringColumnColor.setCellValueFactory(cellData -> cellData.getValue().nameColorProperty());
        SpringTable.setRowFactory( tv -> {
            TableRow<BindingSpringSize> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveSpring = getIdSpring();
                    SpringSizeUpdata();
                } }); return row; });
    }

    public void SpringUpdata() {
        ObservableList<BindingSpringSize> lazData = null;
        try { lazData = BindingSpringSizeDB.selectSpring(); } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        SpringTable.setItems(lazData);
        if (saveSpring==0){
            SpringTable.getSelectionModel().select(0);
            SpringSizeUpdata();
        }else{
            rowSpring(saveSpring);
            SpringSizeUpdata();
        }
    }

    public void rowSpring(Integer id) {

        Integer count = SpringTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                SpringTable.getSelectionModel().select(i);
                if (SpringTable.getSelectionModel().getSelectedItem().getIdBindingSpring()== id) {
                    break;
                }
                if (count == i) {
                    SpringTable.getSelectionModel().select(0);
                    break; } } }
    }
    /**********************************SpringSize************************************************/

    public void SpringSize() {
        SpringSizeColumnCost.setCellValueFactory(cellData -> cellData.getValue().costSizeProperty().asObject());
        SpringSizeColumnSheet.setCellValueFactory(cellData -> cellData.getValue().sheetProperty().asObject());
        SpringSizeColumnSize.setCellValueFactory(cellData -> cellData.getValue().nameSizeProperty());


        SpringSizeTable.setRowFactory( tv -> {
            TableRow<BindingSpringSize> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    saveSheet = getSheet();
                    OnSheet();
                } }); return row; });
    }

    public void SpringSizeUpdata() {
        ObservableList<BindingSpringSize> lazData = null;
        try { lazData = BindingSpringSizeDB.selectSpringSize(getIdSpring()); } catch (ClassNotFoundException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
        SpringSizeTable.setItems(lazData);
        if (saveSheet==0){
            SpringSizeTable.getSelectionModel().select(0);
            OnSheet();
        }else{
            rowSheet(saveSheet);
            OnSheet();
        }
    }

    public void rowSheet(Integer id) {

        Integer count = SpringSizeTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                SpringSizeTable.getSelectionModel().select(i);
                if (SpringSizeTable.getSelectionModel().getSelectedItem().getSheet()>= id) {
                    break;
                }
                if (count == i) {
                    SpringSizeTable.getSelectionModel().select(0);
                    break; } } }
    }

    void OnSheet(){
        Double costCover = 0.0;
        if(CoverTable.getItems().size()!=0){
            costCover = CoverTable.getSelectionModel().getSelectedItem().getCostCover();
        }
        if(costCover<=0){
            tfCoverCount.setText("0");
            tfCoverCount.setVisible(false);
            tfCoverCostOne.setVisible(false);

        }else{
            if(getCountCover()<=0){
                tfCoverCount.setText("1");
            }
            tfCoverCount.setVisible(true);
            tfCoverCostOne.setVisible(true);
        }

        Double springCostOne = 0.0;
        if(SpringSizeTable.getItems().size()!=0){
            springCostOne = SpringSizeTable.getSelectionModel().getSelectedItem().getCostSize();
        }
        if(springCostOne<=0){
            tfSpringCount.setText("0");
            tfSpringCount.setVisible(false);
            tfSpringCostOne.setVisible(false);

        }else{
            if(getCountSpring()<=0){
                tfSpringCount.setText("1");
            }
            tfSpringCount.setVisible(true);
            tfSpringCostOne.setVisible(true);
        }

        if(getCountWork()<=0){
            tfWorkCount.setText("1");
        }
        //tfWorkCount.setText("1");

        Double costWork = 0.0;
        if(SpringSizeTable.getItems().size()!=0){
            try {
                costWork = BindingWorkDB.getCostWork(getIdFormat(),getSheet()).getCostWork();
            } catch (Exception e) {  e.printStackTrace();  }
        }
        tfSpringCostOne.setText(""+springCostOne);
        tfCoverCostOne.setText(""+ costCover);
        tfWorkCostOne.setText(""+ costWork);
        TextData();
    }

    /**********************************Get************************************************/

   public void TextData(){

        lbCoverCostAll.setText(""+ DoubleTo(getCoverCostOne())+"               "+  DoubleTo(getCoverPrimeCostOne()));
        lbSpringCostAll.setText(""+ DoubleTo(getSpringCostOne())+"               "+  DoubleTo(getSpringPrimeCostOne()));
        lbWorkCostAll.setText(""+ DoubleTo(getWorkCostOne()));
        lbSumOne.setText(""+ DoubleTo(getSumOne())+"               "+  DoubleTo(getPrimeSumOne()));
        lbSumAll.setText(""+ DoubleTo(getSumAll())+"               "+  DoubleTo(getPrimeSumAll()));
    }

    public String DoubleTo(Double number) {
        String numberAsString = String.format("%.2f", number);
        return numberAsString;
    }


    public Integer getIdFormat() {
        Integer data = 0;
        if(FormatTable.getItems().size()!=0){
            data = FormatTable.getSelectionModel().getSelectedItem().getIdBindingFormat();
        }
        return data;
    }
    public Integer getIdCaver() {
        Integer data = 0;
        if(CoverTable.getItems().size()!=0){
            data = CoverTable.getSelectionModel().getSelectedItem().getIdBindingCover();
        }
        return data;
    }
    public String getNameCover() {
        String data = "";
        if(CoverTable.getItems().size()!=0){
            data = CoverTable.getSelectionModel().getSelectedItem().getNameCover();
        }
        return data;
    }
    public Integer getIdSpring() {
        Integer data = 0;
        if(SpringTable.getItems().size()!=0){
            data = SpringTable.getSelectionModel().getSelectedItem().getIdBindingSpring();
        }
        return data;
    }
    public Integer getIdSpringSize() {
        Integer data = 0;
        if(SpringSizeTable.getItems().size()!=0){
            data = SpringSizeTable.getSelectionModel().getSelectedItem().getIdBindingSpringSize();
        }
        return data;
    }
    public String getNameSpring() {
        String data = "";
        if(SpringSizeTable.getItems().size()!=0){
            data = SpringSizeTable.getSelectionModel().getSelectedItem().getNameSpring();
        }
        return data;
    }
    public Integer getSheet() {
        Integer data = 0;
        if(SpringSizeTable.getItems().size()!=0){
            data = SpringSizeTable.getSelectionModel().getSelectedItem().getSheet();
        }
        return data;
    }
    public String getNameOrder() {
        String nameOrder = getNameCover()+", "+getNameSpring()+", "+getNameSpringSize()+", "+getSheet();
        return nameOrder;
    }
    public String getNameSpringSize() {
        String nameSpringSize ="";
        if(SpringSizeTable.getItems().size()!=0) {
            nameSpringSize = SpringSizeTable.getSelectionModel().getSelectedItem().getNameSize();
        }
        return nameSpringSize;
    }
    public String getTextDesc(){
        return tfTextDesc.getText().toString();
    }

    /*********************Spring Coust****************************/
    public Double getCountSpring() {
        Double data = 0.0;
        if(tfSpringCount.getText().length()!=0){
            data = Double.valueOf(tfSpringCount.getText().toString());
        }
        return data;
    }
    public Double getSpringCost() {
        Double data = 0.0;
        if(tfSpringCostOne.getText().length()!=0){
            data = Double.valueOf(tfSpringCostOne.getText().toString());
        }
        return data;
    }
    public Double getSpringCostOne() {
        Double data = 0.0;
        if(tfSpringCostOne.getText().length()!=0){
            data = getSpringCost()*getCountSpring();
        }
        return data;
    }
    public Double getSpringPrimeCost() {
        Double data = 0.0;
        if(SpringSizeTable.getItems().size()!=0){
            data = SpringSizeTable.getSelectionModel().getSelectedItem().getPrimeCostSize();
        }
        return data;
    }
    public Double getSpringPrimeCostOne() {
        Double data = 0.0;
        if(tfSpringCostOne.getText().length()!=0){
            data = getSpringPrimeCost()*getCountSpring();
        }
        return data;
    }
    /********************************************/
    public Double getCountCover() {
        Double data = 0.0;
        if(tfCoverCount.getText().length()!=0){
            data = Double.valueOf(tfCoverCount.getText().toString());
        }
        return data;
    }
    public Double getCoverCost() {
        Double data = 0.0;
        if(tfCoverCostOne.getText().length()!=0){
            data = Double.valueOf(tfCoverCostOne.getText().toString());
        }
        return data;
    }
    public Double getCoverCostOne() {
        Double data = 0.0;
        if(tfCoverCostOne.getText().length()!=0){
            data = getCoverCost()*getCountCover();
        }
        return data;
    }
    public Double getCoverPrimeCost() {
        Double data = 0.0;
        if(CoverTable.getItems().size()!=0){
            data = CoverTable.getSelectionModel().getSelectedItem().getPrimeCostCover();
        }
        return data;
    }
    public Double getCoverPrimeCostOne() {
        Double data = 0.0;
        if(tfCoverCostOne.getText().length()!=0){
            data = getCoverPrimeCost()*getCountCover();
        }
        return data;
    }
    /********************************************/
    public Double getCountWork() {
        Double data = 0.0;
        if(tfWorkCount.getText().length()!=0){
            data = Double.valueOf(tfWorkCount.getText().toString());
        }
        return data;
    }
    public Double getWorkCost() {
        Double data = 0.0;
        if(tfWorkCostOne.getText().length()!=0){
            data = Double.valueOf(tfWorkCostOne.getText().toString());
        }
        return data;
    }
    public Double getWorkCostOne() {
        Double data = 0.0;
        if(tfWorkCostOne.getText().length()!=0){
            data = getWorkCost()*getCountWork();
        }
        return data;
    }
    /********************************************/

    public Double getCount() {
        Double data = 0.0;
        if(tfCount.getText().length()!=0){
            data = Double.valueOf(tfCount.getText().toString());
        }
        return data;
    }

    public Double getSumOne() {
        Double data = getSpringCostOne()+ getCoverCost()+ getWorkCostOne();
        return data;
    }
    public Double getSumAll() {
        Double data =0.0;
        if(tfCount.getText().length()!=0){
            data =getSumOne()*getCount();
        }
        return data;
    }

    public Double getPrimeSumOne() {
        Double data = getSpringPrimeCostOne()+ getCoverPrimeCostOne();
        return data;
    }
    public Double getPrimeSumAll() {
        Double data =0.0;
        if(tfCount.getText().length()!=0){
            data =getPrimeSumOne()*getCount();
        }
        return data;
    }


    public void OnActionTextField() {

        tfSpringCount.setTextFormatter(TextFieldFormatter.getDouble(1.0));
        tfSpringCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfSpringCount.getText().length() != 0) {
                    TextData();
                }}});
        tfSpringCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfSpringCount.getText().length() != 0) {
                    TextData();
                }}});

        tfCoverCount.setTextFormatter(TextFieldFormatter.getDouble(1.0));
        tfCoverCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCoverCount.getText().length() != 0) {
                    TextData();
                }}});
        tfCoverCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCoverCount.getText().length() != 0) {
                    TextData();
                }}});

        tfWorkCount.setTextFormatter(TextFieldFormatter.getDouble(1.0));
        tfWorkCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfWorkCount.getText().length() != 0) {
                    TextData();
                }}});
        tfWorkCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfWorkCount.getText().length() != 0) {
                    TextData();
                }}});

        tfSpringCostOne.setTextFormatter(TextFieldFormatter.getDouble(0.0));
        tfSpringCostOne.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfSpringCostOne.getText().length() != 0) {
                    TextData();
                }}});
        tfSpringCostOne.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfSpringCostOne.getText().length() != 0) {
                    TextData();
                }}});

        tfWorkCostOne.setTextFormatter(TextFieldFormatter.getDouble(0.0));
        tfWorkCostOne.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfWorkCostOne.getText().length() != 0) {
                    TextData();
                }}});
        tfWorkCostOne.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfWorkCostOne.getText().length() != 0) {
                    TextData();
                }}});

        tfCoverCostOne.setTextFormatter(TextFieldFormatter.getDouble(0.0));
        tfCoverCostOne.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCoverCostOne.getText().length() != 0) {
                    TextData();
                }}});
        tfCoverCostOne.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCoverCostOne.getText().length() != 0) {
                    TextData();
                }}});

        tfCount.setTextFormatter(TextFieldFormatter.getItneger(1));
        tfCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    TextData();
                }}});
        tfCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    TextData();
                }}});
    }


    public void setTextDesc(String textDesc) {
        this.tfTextDesc.setText(textDesc);
    }

    public void setTfSpringCount(String tfSpringCount) {
        this.tfSpringCount .setText( tfSpringCount);
    }

    public void setTfCoverCount(String tfCoverCount) {
        this.tfCoverCount .setText( tfCoverCount);
    }

    public void setTfWorkCount(String tfWorkCount) {
        this.tfWorkCount .setText( tfWorkCount);
    }

    public void setTfSpringCostOne(String tfSpringCostOne) {
        this.tfSpringCostOne .setText( tfSpringCostOne);
    }

    public void setTfWorkCostOne(String tfWorkCostOne) {
        this.tfWorkCostOne .setText( tfWorkCostOne);
    }

    public void setTfCoverCostOne(String tfCoverCostOne) {
        this.tfCoverCostOne .setText( tfCoverCostOne);
    }

    public void setTfCount(String tfCount) {
        this.tfCount .setText( tfCount);
    }
}
