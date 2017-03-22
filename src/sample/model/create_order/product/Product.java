package sample.model.create_order.product;


import javafx.beans.property.*;

public class Product {
    public Product(){
        this.idProduct = new SimpleIntegerProperty();
        this.nameProduct = new SimpleStringProperty();
        this.nameProductEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();


    }
    private IntegerProperty idProduct;
    private StringProperty nameProduct;
    private StringProperty nameProductEng;
    private BooleanProperty visible;

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


}


