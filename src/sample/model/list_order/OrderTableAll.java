package sample.model.list_order;

import javafx.beans.property.*;

/**
 * Created by Dima on 20.03.2017.
 */
public class OrderTableAll {

    public OrderTableAll(){
        this.idOrderAll = new SimpleIntegerProperty();
        this.idOrders = new SimpleIntegerProperty();
        this.idCategory = new  SimpleIntegerProperty();
        this.nameOrder = new  SimpleStringProperty();
        this.count = new  SimpleIntegerProperty();
        this.costSumOne =  new SimpleDoubleProperty();
        this.costSumAll = new SimpleDoubleProperty();
        this.primeCostSumOne =  new SimpleDoubleProperty();
        this.primeCostSumAll = new SimpleDoubleProperty();
        this.profit = new SimpleDoubleProperty();
        this.textDesc = new  SimpleStringProperty();



    }
    private IntegerProperty idCategory;
    private IntegerProperty idOrderAll;
    private IntegerProperty idOrders;
    private StringProperty nameOrder;
    private StringProperty textDesc;
    private IntegerProperty count;
    private DoubleProperty profit;
    private DoubleProperty costSumOne;
    private DoubleProperty costSumAll;
    private DoubleProperty primeCostSumOne;
    private DoubleProperty primeCostSumAll;

    public int getIdCategory() {
        return idCategory.get();
    }

    public IntegerProperty idCategoryProperty() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory.set(idCategory);
    }

    public int getIdOrderAll() {
        return idOrderAll.get();
    }

    public IntegerProperty idOrderAllProperty() {
        return idOrderAll;
    }

    public void setIdOrderAll(int idOrderAll) {
        this.idOrderAll.set(idOrderAll);
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

    public String getNameOrder() {
        return nameOrder.get();
    }

    public StringProperty nameOrderProperty() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder.set(nameOrder);
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

    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
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

    public double getCostSumOne() {
        return costSumOne.get();
    }

    public DoubleProperty costSumOneProperty() {
        return costSumOne;
    }

    public void setCostSumOne(double costSumOne) {
        this.costSumOne.set(costSumOne);
    }

    public double getCostSumAll() {
        return costSumAll.get();
    }

    public DoubleProperty costSumAllProperty() {
        return costSumAll;
    }

    public void setCostSumAll(double costSumAll) {
        this.costSumAll.set(costSumAll);
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
}



