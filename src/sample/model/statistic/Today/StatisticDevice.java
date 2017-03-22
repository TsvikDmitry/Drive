package sample.model.statistic.Today;

import javafx.beans.property.*;

/**
 * Created by Admin on 26.03.2017.
 */
public class StatisticDevice {
    public StatisticDevice(){
        this.idCategory = new SimpleIntegerProperty();
        this.idItems = new SimpleIntegerProperty();
        this.nameItems = new SimpleStringProperty();
        this.nameCategory = new SimpleStringProperty();
        this.sum = new SimpleDoubleProperty();
        this.primeCostSum = new SimpleDoubleProperty();
        this.profit = new SimpleDoubleProperty();
        this.count = new SimpleIntegerProperty();

    }

    private IntegerProperty idCategory;
    private IntegerProperty idItems;
    private StringProperty nameItems;
    private StringProperty nameCategory;

    private DoubleProperty sum;
    private DoubleProperty primeCostSum;
    private DoubleProperty profit;
    private IntegerProperty count;

    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
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

    public int getIdItems() {
        return idItems.get();
    }

    public IntegerProperty idItemsProperty() {
        return idItems;
    }

    public void setIdItems(int idItems) {
        this.idItems.set(idItems);
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

    public String getNameCategory() {
        return nameCategory.get();
    }

    public StringProperty nameCategoryProperty() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory.set(nameCategory);
    }

    public double getSum() {
        return sum.get();
    }

    public DoubleProperty sumProperty() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum.set(sum);
    }

    public double getPrimeCostSum() {
        return primeCostSum.get();
    }

    public DoubleProperty primeCostSumProperty() {
        return primeCostSum;
    }

    public void setPrimeCostSum(double primeCostSum) {
        this.primeCostSum.set(primeCostSum);
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
}
