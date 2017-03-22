package sample.model.pay;

import javafx.beans.property.*;

import java.math.BigDecimal;

/**
 * Created by Dima on 22.02.2017.
 */
public class PayMent {

    public PayMent(){
        this.idPayment = new SimpleIntegerProperty();
        this.name_payment = new SimpleStringProperty();
        this.namber_card = new  SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
        this.fioPeople = new SimpleStringProperty();

    }

    private IntegerProperty idPayment;
    private StringProperty name_payment;
    private StringProperty namber_card;
    private BooleanProperty visible;
    private StringProperty fioPeople;


    public String getFioPeople() {
        return fioPeople.get();
    }

    public StringProperty fioPeopleProperty() {
        return fioPeople;
    }

    public void setFioPeople(String fioPeople) {
        this.fioPeople.set(fioPeople);
    }




    @Override
    public String toString() {
        return getName_payment();

    }

    public int getIdPayment() {
        return idPayment.get();
    }

    public IntegerProperty idPaymentProperty() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment.set(idPayment);
    }

    public String getName_payment() {
        return name_payment.get();
    }

    public StringProperty name_paymentProperty() {
        return name_payment;
    }

    public void setName_payment(String name_payment) {
        this.name_payment.set(name_payment);
    }

    public String getNamber_card() {
        return namber_card.get();
    }

    public StringProperty namber_cardProperty() {
        return namber_card;
    }

    public void setNamber_card(String namber_card) {
        this.namber_card.set(namber_card);
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
