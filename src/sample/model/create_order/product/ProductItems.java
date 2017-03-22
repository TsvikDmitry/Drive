package sample.model.create_order.product;

import javafx.beans.property.*;

/**
 * Created by Dima on 25.03.2017.
 */
public class ProductItems {

    public ProductItems(){
        this.idProduct = new SimpleIntegerProperty();
        this.idProductItems = new SimpleIntegerProperty();
        this.nameProduct = new SimpleStringProperty();
        this.nameProductEng = new SimpleStringProperty();
        this.nameItems = new SimpleStringProperty();
        this.nameItemsEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
        this.costItems = new SimpleDoubleProperty();
        this.primeCostItems = new SimpleDoubleProperty();


    }
    private IntegerProperty idProductItems;
    private IntegerProperty idProduct;
    private StringProperty nameProduct;
    private StringProperty nameItems;
    private StringProperty nameItemsEng;

    private StringProperty nameProductEng;
    private BooleanProperty visible;

    private DoubleProperty costItems;
    private DoubleProperty primeCostItems;

    public int getIdProductItems() {
        return idProductItems.get();
    }

    public IntegerProperty idProductItemsProperty() {
        return idProductItems;
    }

    public void setIdProductItems(int idProductItems) {
        this.idProductItems.set(idProductItems);
    }

    public int getIdProduct() {
        return idProduct.get();
    }

    public IntegerProperty idProductProperty() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct.set(idProduct);
    }

    public String getNameProduct() {
        return nameProduct.get();
    }

    public StringProperty nameProductProperty() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct.set(nameProduct);
    }

    public String getNameItems() {
        return nameItems.get();
    }

    public StringProperty nameItemsProperty() {
        return nameItems;
    }

    public void setNameItems(String nameItems) {
        this.nameItems.set(nameItems);
    }

    public String getNameItemsEng() {
        return nameItemsEng.get();
    }

    public StringProperty nameItemsEngProperty() {
        return nameItemsEng;
    }

    public void setNameItemsEng(String nameItemsEng) {
        this.nameItemsEng.set(nameItemsEng);
    }

    public String getNameProductEng() {
        return nameProductEng.get();
    }

    public StringProperty nameProductEngProperty() {
        return nameProductEng;
    }

    public void setNameProductEng(String nameProductEng) {
        this.nameProductEng.set(nameProductEng);
    }

    public boolean isVisible() {
        return visible.get();
    }

    public BooleanProperty visibleProperty() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible.set(visible);
    }

    public double getCostItems() {
        return costItems.get();
    }

    public DoubleProperty costItemsProperty() {
        return costItems;
    }

    public void setCostItems(double costItems) {
        this.costItems.set(costItems);
    }

    public double getPrimeCostItems() {
        return primeCostItems.get();
    }

    public DoubleProperty primeCostItemsProperty() {
        return primeCostItems;
    }

    public void setPrimeCostItems(double primeCostItems) {
        this.primeCostItems.set(primeCostItems);
    }
}
