package sample.model.create_order.service.order;

import javafx.beans.property.*;

public class OrderService {

    public OrderService(){
        this.idOrderService = new SimpleIntegerProperty();
        this.idOrders = new SimpleIntegerProperty();
        this.idCategory = new  SimpleIntegerProperty();
        this.nameOrder = new  SimpleStringProperty();
        this.count = new  SimpleIntegerProperty();

        this.sumOne = new  SimpleDoubleProperty();
        this.sumAll =  new SimpleDoubleProperty();
        this.primeCostSumOne =  new SimpleDoubleProperty();
        this.primeCostSumAll = new SimpleDoubleProperty();
        this.profit = new SimpleDoubleProperty();


        this.idService = new SimpleIntegerProperty();
        this.nameService = new SimpleStringProperty();
        this.nameServiceEng = new SimpleStringProperty();

        this.idServiceItems = new SimpleIntegerProperty();
        this.nameItems = new SimpleStringProperty();
        this.nameItemsEng = new SimpleStringProperty();
        this.textDesc = new  SimpleStringProperty();

    }

    private IntegerProperty idOrderService;
    private IntegerProperty idOrders;
    private IntegerProperty idCategory;
    private StringProperty nameOrder;

    private DoubleProperty sumOne;
    private DoubleProperty sumAll;
    private DoubleProperty primeCostSumOne;
    private DoubleProperty primeCostSumAll;


    private IntegerProperty idServiceItems;
    private IntegerProperty idService;
    private StringProperty nameService;
    private StringProperty nameItems;
    private StringProperty nameItemsEng;
    private StringProperty nameServiceEng;
    private DoubleProperty profit;
    private IntegerProperty count;

    private StringProperty textDesc;

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


    public int getIdOrderService() {
        return idOrderService.get();
    }

    public IntegerProperty idOrderServiceProperty() {
        return idOrderService;
    }

    public void setIdOrderService(int idOrderService) {
        this.idOrderService.set(idOrderService);
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

    public String getNameOrder() {
        return nameOrder.get();
    }

    public StringProperty nameOrderProperty() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder.set(nameOrder);
    }

    public double getSumOne() {
        return sumOne.get();
    }

    public DoubleProperty sumOneProperty() {
        return sumOne;
    }

    public void setSumOne(double sumOne) {
        this.sumOne.set(sumOne);
    }

    public double getSumAll() {
        return sumAll.get();
    }

    public DoubleProperty sumAllProperty() {
        return sumAll;
    }

    public void setSumAll(double sumAll) {
        this.sumAll.set(sumAll);
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

    public int getIdServiceItems() {
        return idServiceItems.get();
    }

    public IntegerProperty idServiceItemsProperty() {
        return idServiceItems;
    }

    public void setIdServiceItems(int idServiceItems) {
        this.idServiceItems.set(idServiceItems);
    }

    public int getIdService() {
        return idService.get();
    }

    public IntegerProperty idServiceProperty() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService.set(idService);
    }

    public String getNameService() {
        return nameService.get();
    }

    public StringProperty nameServiceProperty() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService.set(nameService);
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

    public String getNameItemsEng() {
        return nameItemsEng.get();
    }

    public StringProperty nameItemsEngProperty() {
        return nameItemsEng;
    }

    public void setNameItemsEng(String nameItemsEng) {
        this.nameItemsEng.set(nameItemsEng);
    }

    public String getNameServiceEng() {
        return nameServiceEng.get();
    }

    public StringProperty nameServiceEngProperty() {
        return nameServiceEng;
    }

    public void setNameServiceEng(String nameServiceEng) {
        this.nameServiceEng.set(nameServiceEng);
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
