package sample.model.create_order.plotter.order;

import javafx.beans.property.*;

/**
 * Created by Dima on 11.03.2017.
 */
public class OrderPlotter {

    public OrderPlotter(){

        this.idOrderPlotter = new SimpleIntegerProperty();
        this.idOrders = new SimpleIntegerProperty();
        this.idPlotter = new  SimpleIntegerProperty();
        this.idCategory = new  SimpleIntegerProperty();

        this.idPaper = new  SimpleIntegerProperty();
        this.width = new  SimpleIntegerProperty();
        this.length = new  SimpleIntegerProperty();
        this.fill = new  SimpleIntegerProperty();

        this.density = new  SimpleIntegerProperty();
        this.count = new  SimpleIntegerProperty();
        this.profit = new  SimpleFloatProperty();
        this.namePlotter = new  SimpleStringProperty();
        this.namePaper = new  SimpleStringProperty();
        this.nameOrder = new  SimpleStringProperty();
        this.textDesc = new  SimpleStringProperty();

        this.area = new  SimpleFloatProperty();
        this.costMeter = new SimpleFloatProperty();

        this.primeCostPaper = new  SimpleFloatProperty();

        this.sumOne = new  SimpleFloatProperty();
        this.sumAll =  new SimpleFloatProperty();

        this.primeCostSumOne =  new SimpleFloatProperty();
        this.primeCostSumAll = new  SimpleFloatProperty();
        this.primeCostPrint =  new SimpleFloatProperty();

    }

    private IntegerProperty idOrderPlotter;
    private IntegerProperty idOrders;
    private IntegerProperty idCategory;
    private IntegerProperty idPaper;
    private IntegerProperty idPlotter;

    private IntegerProperty width;
    private IntegerProperty length;
    private IntegerProperty density;
    private IntegerProperty count;
    private IntegerProperty fill;

    private StringProperty nameOrder;
    private StringProperty namePlotter;
    private StringProperty namePaper;
    private StringProperty textDesc;
    private FloatProperty profit;

    private FloatProperty area;
    private FloatProperty costMeter;

    private FloatProperty primeCostPaper;

    private FloatProperty sumOne;
    private FloatProperty sumAll;

    private FloatProperty primeCostSumOne;
    private FloatProperty primeCostSumAll;
    private FloatProperty primeCostPrint;

    public float getPrimeCostPrint() {
        return primeCostPrint.get();
    }

    public FloatProperty primeCostPrintProperty() {
        return primeCostPrint;
    }

    public void setPrimeCostPrint(float primeCostPrint) {
        this.primeCostPrint.set(primeCostPrint);
    }

    public int getIdOrderPlotter() {
        return idOrderPlotter.get();
    }

    public IntegerProperty idOrderPlotterProperty() {
        return idOrderPlotter;
    }

    public void setIdOrderPlotter(int idOrderPlotter) {
        this.idOrderPlotter.set(idOrderPlotter);
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

    public int getIdPaper() {
        return idPaper.get();
    }

    public IntegerProperty idPaperProperty() {
        return idPaper;
    }

    public void setIdPaper(int idPaper) {
        this.idPaper.set(idPaper);
    }

    public int getIdPlotter() {
        return idPlotter.get();
    }

    public IntegerProperty idPlotterProperty() {
        return idPlotter;
    }

    public void setIdPlotter(int idPlotter) {
        this.idPlotter.set(idPlotter);
    }

    public int getWidth() {
        return width.get();
    }

    public IntegerProperty widthProperty() {
        return width;
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    public int getLength() {
        return length.get();
    }

    public IntegerProperty lengthProperty() {
        return length;
    }

    public void setLength(int length) {
        this.length.set(length);
    }

    public int getDensity() {
        return density.get();
    }

    public IntegerProperty densityProperty() {
        return density;
    }

    public void setDensity(int density) {
        this.density.set(density);
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

    public int getFill() {
        return fill.get();
    }

    public IntegerProperty fillProperty() {
        return fill;
    }

    public void setFill(int fill) {
        this.fill.set(fill);
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

    public String getNamePlotter() {
        return namePlotter.get();
    }

    public StringProperty namePlotterProperty() {
        return namePlotter;
    }

    public void setNamePlotter(String namePlotter) {
        this.namePlotter.set(namePlotter);
    }

    public String getNamePaper() {
        return namePaper.get();
    }

    public StringProperty namePaperProperty() {
        return namePaper;
    }

    public void setNamePaper(String namePaper) {
        this.namePaper.set(namePaper);
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

    public float getProfit() {
        return profit.get();
    }

    public FloatProperty profitProperty() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit.set(profit);
    }

    public float getArea() {
        return area.get();
    }

    public FloatProperty areaProperty() {
        return area;
    }

    public void setArea(float area) {
        this.area.set(area);
    }

    public float getCostMeter() {
        return costMeter.get();
    }

    public FloatProperty costMeterProperty() {
        return costMeter;
    }

    public void setCostMeter(float costMeter) {
        this.costMeter.set(costMeter);
    }



    public float getPrimeCostPaper() {
        return primeCostPaper.get();
    }

    public FloatProperty primeCostPaperProperty() {
        return primeCostPaper;
    }

    public void setPrimeCostPaper(float primeCostPaper) {
        this.primeCostPaper.set(primeCostPaper);
    }

    public float getSumOne() {
        return sumOne.get();
    }

    public FloatProperty sumOneProperty() {
        return sumOne;
    }

    public void setSumOne(float sumOne) {
        this.sumOne.set(sumOne);
    }

    public float getSumAll() {
        return sumAll.get();
    }

    public FloatProperty sumAllProperty() {
        return sumAll;
    }

    public void setSumAll(float sumAll) {
        this.sumAll.set(sumAll);
    }

    public float getPrimeCostSumOne() {
        return primeCostSumOne.get();
    }

    public FloatProperty primeCostSumOneProperty() {
        return primeCostSumOne;
    }

    public void setPrimeCostSumOne(float primeCostSumOne) {
        this.primeCostSumOne.set(primeCostSumOne);
    }

    public float getPrimeCostSumAll() {
        return primeCostSumAll.get();
    }

    public FloatProperty primeCostSumAllProperty() {
        return primeCostSumAll;
    }

    public void setPrimeCostSumAll(float primeCostSumAll) {
        this.primeCostSumAll.set(primeCostSumAll);
    }
}
