package sample.model.create_order.product.order;


import javafx.beans.property.*;

public class OrderProduct {
    public OrderProduct(){
        this.idOrderProduct = new SimpleIntegerProperty();
        this.idOrders = new SimpleIntegerProperty();
        this.idCategory = new  SimpleIntegerProperty();
        this.nameOrder = new SimpleStringProperty();
        this.count = new  SimpleIntegerProperty();

        this.sumOne = new SimpleDoubleProperty();
        this.sumAll =  new SimpleDoubleProperty();
        this.primeCostSumOne =  new SimpleDoubleProperty();
        this.primeCostSumAll = new SimpleDoubleProperty();
        this.profit = new SimpleDoubleProperty();


        this.idProduct = new SimpleIntegerProperty();
        this.nameProduct = new SimpleStringProperty();
        this.nameProductEng = new SimpleStringProperty();

        this.idProductItems = new SimpleIntegerProperty();
        this.nameItems = new SimpleStringProperty();
        this.nameItemsEng = new SimpleStringProperty();
        this.textDesc = new  SimpleStringProperty();

    }

    private IntegerProperty idOrderProduct;
    private IntegerProperty idOrders;
    private IntegerProperty idCategory;
    private StringProperty nameOrder;

    private DoubleProperty sumOne;
    private DoubleProperty sumAll;
    private DoubleProperty primeCostSumOne;
    private DoubleProperty primeCostSumAll;


    private IntegerProperty idProductItems;
    private IntegerProperty idProduct;
    private StringProperty nameProduct;
    private StringProperty nameItems;
    private StringProperty nameItemsEng;
    private StringProperty nameProductEng;
    private DoubleProperty profit;
    private IntegerProperty count;

    private StringProperty textDesc;

    public int getIdOrderProduct() {
        return idOrderProduct.get();
    }

    public IntegerProperty idOrderProductProperty() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(int idOrderProduct) {
        this.idOrderProduct.set(idOrderProduct);
    }

    public int getIdOrders() {
        return idOrders.get();
    }

    public IntegerProperty idOrdersProperty() {
        return idOrders;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders.set(idOrders);
    }

    public int getIdCategory() {
        return idCategory.get();
    }

    public IntegerProperty idCategoryProperty() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory.set(idCategory);
    }

    public String getNameOrder() {
        return nameOrder.get();
    }

    public StringProperty nameOrderProperty() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder.set(nameOrder);
    }

    public double getSumOne() {
        return sumOne.get();
    }

    public DoubleProperty sumOneProperty() {
        return sumOne;
    }

    public void setSumOne(double sumOne) {
        this.sumOne.set(sumOne);
    }

    public double getSumAll() {
        return sumAll.get();
    }

    public DoubleProperty sumAllProperty() {
        return sumAll;
    }

    public void setSumAll(double sumAll) {
        this.sumAll.set(sumAll);
    }

    public double getPrimeCostSumOne() {
        return primeCostSumOne.get();
    }

    public DoubleProperty primeCostSumOneProperty() {
        return primeCostSumOne;
    }

    public void setPrimeCostSumOne(double primeCostSumOne) {
        this.primeCostSumOne.set(primeCostSumOne);
    }

    public double getPrimeCostSumAll() {
        return primeCostSumAll.get();
    }

    public DoubleProperty primeCostSumAllProperty() {
        return primeCostSumAll;
    }

    public void setPrimeCostSumAll(double primeCostSumAll) {
        this.primeCostSumAll.set(primeCostSumAll);
    }

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

    public double getProfit() {
        return profit.get();
    }

    public DoubleProperty profitProperty() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit.set(profit);
    }

    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public String getTextDesc() {
        return textDesc.get();
    }

    public StringProperty textDescProperty() {
        return textDesc;
    }

    public void setTextDesc(String textDesc) {
        this.textDesc.set(textDesc);
    }
}
