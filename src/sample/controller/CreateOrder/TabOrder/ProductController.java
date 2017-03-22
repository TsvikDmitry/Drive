package sample.controller.CreateOrder.TabOrder;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import sample.controller.convection.TextFieldFormatter;
import sample.model.create_order.product.Product;
import sample.model.create_order.product.ProductDB;
import sample.model.create_order.product.ProductItems;
import sample.model.create_order.product.ProductItemsDB;
public class ProductController {

    @FXML public TableView<Product> ProductTable;
    @FXML public TableColumn<Product, String> ProductColumnName;

    @FXML public TableView<ProductItems> ProductItemTable;
    @FXML public TableColumn<ProductItems, String> ProductItemColumnName;
    @FXML public TableColumn<ProductItems, Double> ProductItemColumnCost;


    @FXML public Label lbProductItemName;
    @FXML public Label lbSumOne;
    @FXML public Label lbSumAll;


    @FXML public TextField tfCount;
    @FXML public TextArea tfTextDesc;
    public Integer saveIdProduct = 0;
    public Integer saveIdProductItems= 0;

    @FXML private void initialize () throws Exception {

        Product();
        ProductUpdata();

        ProductItems();
        OnActionTextField();

    }




    /**********************************Format************************************************/
    public void Product() {
        ProductColumnName.setCellValueFactory(cellData -> cellData.getValue().nameProductProperty());
        ProductTable.setRowFactory( tv -> {
            TableRow<Product> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

                    ProductItemsUpdata();

                }
            });
            return row ;
        });
    }

    public void ProductUpdata() {
        ObservableList<Product> lazData = null;
        try {

            lazData = ProductDB.select();
            System.out.println(getIdProduct() +" "+getIdProductItems());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProductTable.setItems(lazData);
        ProductTable.getSelectionModel().select(0);

      /*  if (saveIdProduct==0){
            ProductTable.getSelectionModel().select(0);

            TablText();
        }else{
            rowProductItems(saveIdProduct);
            TablText();
        }*/
    }


    public void rowProduct(Integer id) {

        Integer count = ProductTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                ProductTable.getSelectionModel().select(i);
                if (ProductTable.getSelectionModel().getSelectedItem().getIdProduct()== id) {
                    break;
                }
                if (count == i) {
                    ProductTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    /**********************************Cover************************************************/

    public void ProductItems() {
        ProductItemColumnName.setCellValueFactory(cellData -> cellData.getValue().nameItemsProperty());
        ProductItemColumnCost.setCellValueFactory(cellData -> cellData.getValue().costItemsProperty().asObject());
        ProductItemTable.setRowFactory( tv -> {
            TableRow<ProductItems> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    TablText();
                    saveIdProductItems = getIdProductItems();

                }
            });
            return row ;
        });
    }

    public void ProductItemsUpdata() {
        ObservableList<ProductItems> lazData = null;
        try {

            lazData = ProductItemsDB.select(getIdProduct());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProductItemTable.setItems(lazData);
        if (saveIdProductItems==0){
            ProductItemTable.getSelectionModel().select(0);
            TablText();
        }else{
            rowProductItems(saveIdProductItems);
            TablText();
        }
    }

    public void rowProductItems(Integer id) {

        Integer count = ProductItemTable.getItems().size();
        if (count!=0) {
            for (int i = 0; i <= count; i++) {
                ProductItemTable.getSelectionModel().select(i);
                if (ProductItemTable.getSelectionModel().getSelectedItem().getIdProductItems()== id) {
                    break;
                }
                if (count == i) {
                    ProductItemTable.getSelectionModel().select(0);
                    break;
                }
            }
        }
    }

    /**********************************TextField************************************************/
    void TablText(){

        lbProductItemName.setText(""+ getNameItems());
        lbSumOne.setText(""+getSumOne());
        ActiveText();
    }
    void ActiveText(){

        lbSumAll.setText(""+getSumAll());

    }

    /**********************************Get************************************************/

    public String getNameOrder() {
        String nameOrder = getNameProduct()+": "+getNameItems();
        return nameOrder;
    }

    public Integer getCount() {
        return Integer.valueOf(tfCount.getText().toString());
    }

    public Integer getIdProduct() {
        Integer txIdPlotter = 0;
        if(ProductTable.getItems().size()!=0){
            txIdPlotter = ProductTable.getSelectionModel().getSelectedItem().getIdProduct();
        }
        return txIdPlotter;
    }

    public Integer getIdProductItems() {
        Integer txIdPlotter = 0;
        if(ProductItemTable.getItems().size()!=0){
            txIdPlotter = ProductItemTable.getSelectionModel().getSelectedItem().getIdProductItems();
        }
        return txIdPlotter;
    }

    public Double getCostItems() {
        Double txIdPlotter = 0.0;
        if(ProductItemTable.getItems().size()!=0){
            txIdPlotter = ProductItemTable.getSelectionModel().getSelectedItem().getCostItems();
        }
        return txIdPlotter;
    }
    public Double getPrimeCostSumAll() {
        Double txIdPlotter = getPrimeCostSumOne()*getCount();

        return txIdPlotter;
    }
    public Double getPrimeCostSumOne() {
        Double txIdPlotter = 0.0;
        if(ProductItemTable.getItems().size()!=0){
            txIdPlotter = ProductItemTable.getSelectionModel().getSelectedItem().getPrimeCostItems();
        }
        return txIdPlotter;
    }
    public String getNameProduct() {
        String txIdPlotter = "";
        if(ProductItemTable.getItems().size()!=0){
            txIdPlotter = ProductItemTable.getSelectionModel().getSelectedItem().getNameProduct();
        }
        return txIdPlotter;
    }
    public String getNameItems() {
        String txIdPlotter = "";
        if(ProductItemTable.getItems().size()!=0){
            txIdPlotter = ProductItemTable.getSelectionModel().getSelectedItem().getNameItems();
        }
        return txIdPlotter;
    }

    public Double getSumAll() {
        Double txIdPlotter = 0.0;
        if(tfCount.getText().length()!=0){
            txIdPlotter = getCostItems()*getCount();
        }
        return txIdPlotter;
    }
    public Double getSumOne() {
        Double txIdPlotter = 0.0;
        if(tfCount.getText().length()!=0){
            txIdPlotter = getCostItems();
        }
        return txIdPlotter;
    }
    public void setCount(String tfCount) {
        this.tfCount.setText(tfCount);
    }


    void OnActionTextField(){
        tfCount.setTextFormatter(TextFieldFormatter.getItneger(1));
        tfCount.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    ActiveText();
                }}});
        tfCount.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tfCount.getText().length() != 0) {
                    ActiveText();
                }}});
    }


    public String getTextDesc() {
        return tfTextDesc.getText().toString();
    }

}
