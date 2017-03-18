package sample.model.orders;


import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderList {


    public OrderList(){

        this.idOrders = new SimpleIntegerProperty();
        this.idClient = new SimpleIntegerProperty();
        this.idOperator = new  SimpleIntegerProperty();

        this.dataCreate = new SimpleStringProperty();
        this.timeCreate = new SimpleStringProperty();
        this.dataEnd = new SimpleStringProperty();
        this.timeEnd = new SimpleStringProperty();

        this.statusPay = new SimpleStringProperty();
        this.plotter =  new SimpleFloatProperty();
        this.printer =  new SimpleFloatProperty();
        this.orderSum =  new SimpleFloatProperty();
        this.paySum =  new SimpleFloatProperty();
        this.dolg =  new SimpleFloatProperty();

        this.idOrderStatus = new  SimpleIntegerProperty();
        this.nameSstatus =  new SimpleStringProperty();
        this.textDescription =  new SimpleStringProperty();

    }

    private IntegerProperty idOrders;
    private IntegerProperty idClient;
    private IntegerProperty idOperator;

    private StringProperty timeCreate;
    private StringProperty timeEnd;
    private StringProperty dataCreate;
    private StringProperty dataEnd;

    private StringProperty statusPay;
    private FloatProperty plotter;
    private FloatProperty printer;
    private FloatProperty orderSum;
    private FloatProperty paySum;
    private FloatProperty dolg;
    private IntegerProperty idOrderStatus;
    private StringProperty nameSstatus;
    private StringProperty textDescription;


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

    public int getIdOperator() {
        return idOperator.get();
    }

    public IntegerProperty idOperatorProperty() {
        return idOperator;
    }

    public void setIdOperator(int idOperator) {
        this.idOperator.set(idOperator);
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

    public float getPlotter() {
        return plotter.get();
    }

    public FloatProperty plotterProperty() {
        return plotter;
    }

    public void setPlotter(float plotter) {
        this.plotter.set(plotter);
    }

    public float getPrinter() {
        return printer.get();
    }

    public FloatProperty printerProperty() {
        return printer;
    }

    public void setPrinter(float printer) {
        this.printer.set(printer);
    }

    public float getOrderSum() {
        return orderSum.get();
    }

    public FloatProperty orderSumProperty() {
        return orderSum;
    }

    public void setOrderSum(float orderSum) {
        this.orderSum.set(orderSum);
    }

    public float getPaySum() {
        return paySum.get();
    }

    public FloatProperty paySumProperty() {
        return paySum;
    }

    public void setPaySum(float paySum) {
        this.paySum.set(paySum);
    }

    public float getDolg() {
        return dolg.get();
    }

    public FloatProperty dolgProperty() {
        return dolg;
    }

    public void setDolg(float dolg) {
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

    public String getNameSstatus() {
        return nameSstatus.get();
    }

    public StringProperty nameSstatusProperty() {
        return nameSstatus;
    }

    public void setNameSstatus(String nameSstatus) {
        this.nameSstatus.set(nameSstatus);
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


}
