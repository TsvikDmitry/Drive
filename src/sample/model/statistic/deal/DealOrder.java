package sample.model.statistic.deal;

import javafx.beans.property.*;

/**
 * Created by Dima on 28.03.2017.
 */
public class DealOrder {
    public DealOrder(){

        this.idDealOrder = new SimpleIntegerProperty();
        this.idPeople = new SimpleIntegerProperty();
        this.idPayment = new SimpleIntegerProperty();

        this.idDeal = new SimpleIntegerProperty();
        this.idDealGroup = new SimpleIntegerProperty();

        this.nameDeal = new SimpleStringProperty();
        this.nameGroup = new SimpleStringProperty();
        this.namePeople = new SimpleStringProperty();
        this.nameOrder = new SimpleStringProperty();
        this.namePayment = new SimpleStringProperty();
        this.dataCreate = new SimpleStringProperty();
        this.sum = new SimpleDoubleProperty();

    }
    private IntegerProperty idDealOrder;
    private IntegerProperty idPeople;
    private StringProperty namePeople;
    private StringProperty nameOrder;

    private IntegerProperty idPayment;
    private StringProperty namePayment;

    private DoubleProperty sum;
    private StringProperty dataCreate;


    private IntegerProperty idDeal;
    private StringProperty nameDeal;

    private IntegerProperty idDealGroup;
    private StringProperty nameGroup;

    public int getIdDealOrder() {
        return idDealOrder.get();
    }

    public IntegerProperty idDealOrderProperty() {
        return idDealOrder;
    }

    public void setIdDealOrder(int idDealOrder) {
        this.idDealOrder.set(idDealOrder);
    }

    public int getIdPeople() {
        return idPeople.get();
    }

    public IntegerProperty idPeopleProperty() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople.set(idPeople);
    }

    public String getNamePeople() {
        return namePeople.get();
    }

    public StringProperty namePeopleProperty() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople.set(namePeople);
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

    public int getIdPayment() {
        return idPayment.get();
    }

    public IntegerProperty idPaymentProperty() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment.set(idPayment);
    }

    public String getNamePayment() {
        return namePayment.get();
    }

    public StringProperty namePaymentProperty() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment.set(namePayment);
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

    public String getDataCreate() {
        return dataCreate.get();
    }

    public StringProperty dataCreateProperty() {
        return dataCreate;
    }

    public void setDataCreate(String dataCreate) {
        this.dataCreate.set(dataCreate);
    }

    public int getIdDeal() {
        return idDeal.get();
    }

    public IntegerProperty idDealProperty() {
        return idDeal;
    }

    public void setIdDeal(int idDeal) {
        this.idDeal.set(idDeal);
    }

    public String getNameDeal() {
        return nameDeal.get();
    }

    public StringProperty nameDealProperty() {
        return nameDeal;
    }

    public void setNameDeal(String nameDeal) {
        this.nameDeal.set(nameDeal);
    }

    public int getIdDealGroup() {
        return idDealGroup.get();
    }

    public IntegerProperty idDealGroupProperty() {
        return idDealGroup;
    }

    public void setIdDealGroup(int idDealGroup) {
        this.idDealGroup.set(idDealGroup);
    }

    public String getNameGroup() {
        return nameGroup.get();
    }

    public StringProperty nameGroupProperty() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup.set(nameGroup);
    }
}





