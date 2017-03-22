package sample.model.list_order.orders;


import javafx.beans.property.*;

public class OrderList {


    public OrderList(){

        this.idOrders = new SimpleIntegerProperty();
        this.idClient = new SimpleIntegerProperty();

        this.dataCreate = new SimpleStringProperty();
        this.timeCreate = new SimpleStringProperty();
        this.dataEnd = new SimpleStringProperty();
        this.timeEnd = new SimpleStringProperty();

        this.statusPay = new SimpleStringProperty();

        this.orderSum =  new SimpleDoubleProperty();
        this.paySum =  new SimpleDoubleProperty();
        this.dolg =  new SimpleDoubleProperty();

        this.idOrderStatus = new  SimpleIntegerProperty();
        this.nameStatus =  new SimpleStringProperty();
        this.textDescription =  new SimpleStringProperty();
        this.idManager = new  SimpleIntegerProperty();
        this.idPrinting = new  SimpleIntegerProperty();
        this.idCutter = new  SimpleIntegerProperty();

        this.nameManager =  new SimpleStringProperty();
        this.namePrinting =  new SimpleStringProperty();
        this.nameCutter =  new SimpleStringProperty();
        this.nameClient =  new SimpleStringProperty();
        this.plotter =  new SimpleDoubleProperty();
        this.printer =  new SimpleDoubleProperty();
        this.service =  new SimpleDoubleProperty();
        this.bing =  new SimpleDoubleProperty();
        this.product =  new SimpleDoubleProperty();
        this.dataPay =  new SimpleStringProperty();
    }

    private IntegerProperty idOrders;
    private IntegerProperty idClient;
    private StringProperty timeCreate;
    private StringProperty timeEnd;
    private StringProperty dataCreate;
    private StringProperty dataEnd;
    private StringProperty statusPay;
    private IntegerProperty idOrderStatus;
    private StringProperty textDescription;
    private StringProperty nameStatus;
    private IntegerProperty idManager;
    private IntegerProperty idPrinting;
    private IntegerProperty idCutter;
    private StringProperty nameManager;
    private StringProperty namePrinting;
    private StringProperty nameCutter;
    private StringProperty nameClient;

    private StringProperty dataPay;


    private DoubleProperty plotter;
    private DoubleProperty printer;
    private DoubleProperty orderSum;
    private DoubleProperty paySum;
    private DoubleProperty dolg;
    private DoubleProperty service;
    private DoubleProperty bing;
    private DoubleProperty product;

    public double getOrderSum() {
        return orderSum.get();
    }

    public DoubleProperty orderSumProperty() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum.set(orderSum);
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

    public int getIdClient() {
        return idClient.get();
    }

    public IntegerProperty idClientProperty() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient.set(idClient);
    }

    public String getTimeCreate() {
        return timeCreate.get();
    }

    public StringProperty timeCreateProperty() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate.set(timeCreate);
    }

    public String getTimeEnd() {
        return timeEnd.get();
    }

    public StringProperty timeEndProperty() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd.set(timeEnd);
    }

    public String getDataCreate() {
        return dataCreate.get();
    }

    public StringProperty dataCreateProperty() {
        return dataCreate;
    }

    public void setDataCreate(String dataCreate) {
        this.dataCreate.set(dataCreate);
    }

    public String getDataEnd() {
        return dataEnd.get();
    }

    public StringProperty dataEndProperty() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd.set(dataEnd);
    }

    public String getStatusPay() {
        return statusPay.get();
    }

    public StringProperty statusPayProperty() {
        return statusPay;
    }

    public void setStatusPay(String statusPay) {
        this.statusPay.set(statusPay);
    }

    public double getPlotter() {
        return plotter.get();
    }

    public DoubleProperty plotterProperty() {
        return plotter;
    }

    public void setPlotter(double plotter) {
        this.plotter.set(plotter);
    }

    public double getPrinter() {
        return printer.get();
    }

    public DoubleProperty printerProperty() {
        return printer;
    }

    public void setPrinter(double printer) {
        this.printer.set(printer);
    }



    public double getPaySum() {
        return paySum.get();
    }

    public DoubleProperty paySumProperty() {
        return paySum;
    }

    public void setPaySum(double paySum) {
        this.paySum.set(paySum);
    }

    public double getDolg() {
        return dolg.get();
    }

    public DoubleProperty dolgProperty() {
        return dolg;
    }

    public void setDolg(double dolg) {
        this.dolg.set(dolg);
    }

    public int getIdOrderStatus() {
        return idOrderStatus.get();
    }

    public IntegerProperty idOrderStatusProperty() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus.set(idOrderStatus);
    }

    public String getTextDescription() {
        return textDescription.get();
    }

    public StringProperty textDescriptionProperty() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription.set(textDescription);
    }

    public String getNameStatus() {
        return nameStatus.get();
    }

    public StringProperty nameStatusProperty() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus.set(nameStatus);
    }

    public int getIdManager() {
        return idManager.get();
    }

    public IntegerProperty idManagerProperty() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager.set(idManager);
    }

    public int getIdPrinting() {
        return idPrinting.get();
    }

    public IntegerProperty idPrintingProperty() {
        return idPrinting;
    }

    public void setIdPrinting(int idPrinting) {
        this.idPrinting.set(idPrinting);
    }

    public int getIdCutter() {
        return idCutter.get();
    }

    public IntegerProperty idCutterProperty() {
        return idCutter;
    }

    public void setIdCutter(int idCutter) {
        this.idCutter.set(idCutter);
    }

    public String getNameManager() {
        return nameManager.get();
    }

    public StringProperty nameManagerProperty() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager.set(nameManager);
    }

    public String getNamePrinting() {
        return namePrinting.get();
    }

    public StringProperty namePrintingProperty() {
        return namePrinting;
    }

    public void setNamePrinting(String namePrinting) {
        this.namePrinting.set(namePrinting);
    }

    public String getNameCutter() {
        return nameCutter.get();
    }

    public StringProperty nameCutterProperty() {
        return nameCutter;
    }

    public void setNameCutter(String nameCutter) {
        this.nameCutter.set(nameCutter);
    }

    public String getNameClient() {
        return nameClient.get();
    }

    public StringProperty nameClientProperty() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient.set(nameClient);
    }

    public String getDataPay() {
        return dataPay.get();
    }

    public StringProperty dataPayProperty() {
        return dataPay;
    }

    public void setDataPay(String dataPay) {
        this.dataPay.set(dataPay);
    }

    public double getService() {
        return service.get();
    }

    public DoubleProperty serviceProperty() {
        return service;
    }

    public void setService(double service) {
        this.service.set(service);
    }

    public double getBing() {
        return bing.get();
    }

    public DoubleProperty bingProperty() {
        return bing;
    }

    public void setBing(double bing) {
        this.bing.set(bing);
    }

    public double getProduct() {
        return product.get();
    }

    public DoubleProperty productProperty() {
        return product;
    }

    public void setProduct(double product) {
        this.product.set(product);
    }
}
