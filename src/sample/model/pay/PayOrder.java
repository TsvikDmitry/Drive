package sample.model.pay;

import javafx.beans.property.*;

/**
 * Created by Dima on 01.03.2017.
 */
public class PayOrder {

    public PayOrder(){
        this.idPay = new SimpleIntegerProperty();
        this.idOrder = new SimpleIntegerProperty();
        this.idPaymant = new  SimpleIntegerProperty();

        this.timeGet = new SimpleStringProperty();
        this.timePay = new SimpleStringProperty();

        this.dataPay = new SimpleStringProperty();
        this.dataGet = new SimpleStringProperty();

        this.sumPay = new SimpleFloatProperty();

        this.TextPay = new SimpleStringProperty();
        this.NamePayment = new SimpleStringProperty();
        this.NamberCard = new SimpleStringProperty();
        this.NamePeople = new SimpleStringProperty();

    }

    private IntegerProperty idPay;
    private IntegerProperty idOrder;
    private IntegerProperty idPaymant;

    private StringProperty dataPay;
    private StringProperty dataGet;
    private FloatProperty sumPay;

    private StringProperty timePay;
    private StringProperty timeGet;

    private StringProperty TextPay;
    private StringProperty NamePayment;
    private StringProperty NamberCard;
    private StringProperty NamePeople;

    public String getTextPay() {
        return TextPay.get();
    }

    public StringProperty textPayProperty() {
        return TextPay;
    }

    public void setTextPay(String textPay) {
        this.TextPay.set(textPay);
    }

    public String getNamePayment() {
        return NamePayment.get();
    }

    public StringProperty namePaymentProperty() {
        return NamePayment;
    }

    public void setNamePayment(String namePayment) {
        this.NamePayment.set(namePayment);
    }

    public String getNamberCard() {
        return NamberCard.get();
    }

    public StringProperty namberCardProperty() {
        return NamberCard;
    }

    public void setNamberCard(String namberCard) {
        this.NamberCard.set(namberCard);
    }

    public String getNamePeople() {
        return NamePeople.get();
    }

    public StringProperty namePeopleProperty() {
        return NamePeople;
    }

    public void setNamePeople(String namePeople) {
        this.NamePeople.set(namePeople);
    }

    public String getDataGet() {
        return dataGet.get();
    }

    public StringProperty dataGetProperty() {
        return dataGet;
    }

    public void setDataGet(String dataGet) {
        this.dataGet.set(dataGet);
    }

    public float getSumPay() {
        return sumPay.get();
    }

    public FloatProperty sumPayProperty() {
        return sumPay;
    }

    public void setSumPay(float sumPay) {
        this.sumPay.set(sumPay);
    }

    public String getTimePay() {
        return timePay.get();
    }

    public StringProperty timePayProperty() {
        return timePay;
    }

    public void setTimePay(String timePay) {
        this.timePay.set(timePay);
    }

    public String getTimeGet() {
        return timeGet.get();
    }

    public StringProperty timeGetProperty() {
        return timeGet;
    }

    public void setTimeGet(String timeGet) {
        this.timeGet.set(timeGet);
    }

    public int getIdPay() {
        return idPay.get();
    }

    public IntegerProperty idPayProperty() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay.set(idPay);
    }

    public int getIdOrder() {
        return idOrder.get();
    }

    public IntegerProperty idOrderProperty() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder.set(idOrder);
    }

    public int getIdPaymant() {
        return idPaymant.get();
    }

    public IntegerProperty idPaymantProperty() {
        return idPaymant;
    }

    public void setIdPaymant(int idPaymant) {
        this.idPaymant.set(idPaymant);
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



}
