package sample.model.print.order;

import javafx.beans.property.*;

public class OrderPrinter {



    public OrderPrinter(){
        this.idOrderPrinter = new SimpleIntegerProperty();
        this.idOrders = new SimpleIntegerProperty();
        this.idFormat = new  SimpleIntegerProperty();
        this.idPrinter = new  SimpleIntegerProperty();
        this.idPaper = new  SimpleIntegerProperty();
        this.idPrice = new  SimpleIntegerProperty();
        this.idDuplex = new  SimpleIntegerProperty();

        this.density = new  SimpleIntegerProperty();
        this.count = new  SimpleIntegerProperty();
        this.costPrint =  new SimpleFloatProperty();
        this.costPaper = new  SimpleFloatProperty();
        this.costSumOne =  new SimpleFloatProperty();
        this.costSumAll = new SimpleFloatProperty();
        this.countPrinterA4 = new  SimpleIntegerProperty();
        this.text = new  SimpleStringProperty();
        this.primeCostPrint =  new SimpleFloatProperty();
        this.primeCostPaper = new  SimpleFloatProperty();
        this.primeCostSumOne =  new SimpleFloatProperty();
        this.primeCostSumAll = new SimpleFloatProperty();
        this.nameOrder = new  SimpleStringProperty();
        this.text = new  SimpleStringProperty();
        this.namePrice = new  SimpleStringProperty();
        this.nameFormat = new  SimpleStringProperty();
        this.nameDuplex = new  SimpleStringProperty();
        this.profit = new  SimpleFloatProperty();
        this.namePrinter = new  SimpleStringProperty();
        this.namePaper = new  SimpleStringProperty();

    }

    private IntegerProperty idOrderPrinter;
    private IntegerProperty idOrders;

    private StringProperty nameOrder;
    private IntegerProperty idPaper;
    private IntegerProperty idDuplex;
    private IntegerProperty idPrinter;
    private IntegerProperty idFormat;
    private IntegerProperty idPrice;
    private IntegerProperty density;
    private IntegerProperty count;
    private FloatProperty costPrint;
    private FloatProperty costPaper;

    private IntegerProperty countPrinterA4;
    private StringProperty text;
    private FloatProperty primeCostPrint;
    private FloatProperty primeCostPaper;

    private StringProperty namePrice;
    private StringProperty nameFormat;
    private StringProperty nameDuplex;
    private FloatProperty profit;
    private StringProperty namePrinter;
    private StringProperty namePaper;
    private FloatProperty costSumOne;
    private FloatProperty costSumAll;
    private FloatProperty primeCostSumOne;
    private FloatProperty primeCostSumAll;

    public float getCostSumOne() {
        return costSumOne.get();
    }

    public FloatProperty costSumOneProperty() {
        return costSumOne;
    }

    public void setCostSumOne(float costSumOne) {
        this.costSumOne.set(costSumOne);
    }

    public float getCostSumAll() {
        return costSumAll.get();
    }

    public FloatProperty costSumAllProperty() {
        return costSumAll;
    }

    public void setCostSumAll(float costSumAll) {
        this.costSumAll.set(costSumAll);
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

    public String getNamePaper() {
        return namePaper.get();
    }

    public StringProperty namePaperProperty() {
        return namePaper;
    }

    public void setNamePaper(String namePaper) {
        this.namePaper.set(namePaper);
    }

    public String getNamePrinter() {
        return namePrinter.get();
    }

    public StringProperty namePrinterProperty() {
        return namePrinter;
    }

    public void setNamePrinter(String namePrinter) {
        this.namePrinter.set(namePrinter);
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

    public String getNameDuplex() {
        return nameDuplex.get();
    }

    public StringProperty nameDuplexProperty() {
        return nameDuplex;
    }

    public void setNameDuplex(String nameDuplex) {
        this.nameDuplex.set(nameDuplex);
    }

    public String getNamePrice() {
        return namePrice.get();
    }

    public StringProperty namePriceProperty() {
        return namePrice;
    }

    public void setNamePrice(String namePrice) {
        this.namePrice.set(namePrice);
    }

    public String getNameFormat() {
        return nameFormat.get();
    }

    public StringProperty nameFormatProperty() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat.set(nameFormat);
    }

    public float getPrimeCostPrint() {
        return primeCostPrint.get();
    }

    public FloatProperty primeCostPrintProperty() {
        return primeCostPrint;
    }

    public void setPrimeCostPrint(float primeCostPrint) {
        this.primeCostPrint.set(primeCostPrint);
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


    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
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
    public int getIdDuplex() {
        return idDuplex.get();
    }

    public IntegerProperty idDuplexProperty() {
        return idDuplex;
    }

    public void setIdDuplex(int idDuplex) {
        this.idDuplex.set(idDuplex);
    }


    public int getIdPrinter() {
        return idPrinter.get();
    }

    public IntegerProperty idPrinterProperty() {
        return idPrinter;
    }

    public void setIdPrinter(int idPrinter) {
        this.idPrinter.set(idPrinter);
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

    public int getIdOrderPrinter() {
        return idOrderPrinter.get();
    }

    public IntegerProperty idOrderPrinterProperty() {
        return idOrderPrinter;
    }

    public void setIdOrderPrinter(int idOrderPrinter) {
        this.idOrderPrinter.set(idOrderPrinter);
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


    public int getIdFormat() {
        return idFormat.get();
    }

    public IntegerProperty idFormatProperty() {
        return idFormat;
    }

    public void setIdFormat(int idFormat) {
        this.idFormat.set(idFormat);
    }

    public int getIdPrice() {
        return idPrice.get();
    }

    public IntegerProperty idPriceProperty() {
        return idPrice;
    }

    public void setIdPrice(int idPrice) {
        this.idPrice.set(idPrice);
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

    public float getCostPrint() {
        return costPrint.get();
    }

    public FloatProperty costPrintProperty() {
        return costPrint;
    }

    public void setCostPrint(float costPrint) {
        this.costPrint.set(costPrint);
    }

    public float getCostPaper() {
        return costPaper.get();
    }

    public FloatProperty costPaperProperty() {
        return costPaper;
    }

    public void setCostPaper(float costPaper) {
        this.costPaper.set(costPaper);
    }



    public int getCountPrinterA4() {
        return countPrinterA4.get();
    }

    public IntegerProperty countPrinterA4Property() {
        return countPrinterA4;
    }

    public void setCountPrinterA4(int countPrinterA4) {
        this.countPrinterA4.set(countPrinterA4);
    }







}
