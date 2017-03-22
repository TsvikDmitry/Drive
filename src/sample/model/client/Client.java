package sample.model.client;

import javafx.beans.property.*;

/**
 * Created by Admin on 05.04.2017.
 */
public class Client {

    public Client(){
        this.idClient= new SimpleIntegerProperty();
        this.nameClient = new SimpleStringProperty();
        this.fioClient = new  SimpleStringProperty();
        this.phoneClient= new SimpleStringProperty();
        this.price = new SimpleIntegerProperty();


    }
    @Override
    public String toString() {
        return getNameClient();

    }

    private IntegerProperty idClient;
    private StringProperty nameClient;
    private StringProperty fioClient;
    private StringProperty phoneClient;
    private IntegerProperty price;

    public int getIdClient() {
        return idClient.get();
    }

    public IntegerProperty idClientProperty() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient.set(idClient);
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

    public String getFioClient() {
        return fioClient.get();
    }

    public StringProperty fioClientProperty() {
        return fioClient;
    }

    public void setFioClient(String fioClient) {
        this.fioClient.set(fioClient);
    }

    public String getPhoneClient() {
        return phoneClient.get();
    }

    public StringProperty phoneClientProperty() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient.set(phoneClient);
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }
}
