package sample.model.create_order.service;

import javafx.beans.property.*;

/**
 * Created by Dima on 14.03.2017.
 */
public class ServiceItems {
    public ServiceItems(){
        this.idService = new SimpleIntegerProperty();
        this.idServiceItems = new SimpleIntegerProperty();
        this.nameService = new SimpleStringProperty();
        this.nameServiceEng = new SimpleStringProperty();
        this.nameItems = new SimpleStringProperty();
        this.nameItemsEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
        this.costItems = new SimpleDoubleProperty();
        this.primeCostItems = new SimpleDoubleProperty();


    }
    private IntegerProperty idServiceItems;
    private IntegerProperty idService;
    private StringProperty nameService;
    private StringProperty nameItems;
    private StringProperty nameItemsEng;

    private StringProperty nameServiceEng;
    private BooleanProperty visible;

    private DoubleProperty costItems;
    private DoubleProperty primeCostItems;

    public double getCostItems() {
        return costItems.get();
    }

    public DoubleProperty costItemsProperty() {
        return costItems;
    }

    public void setCostItems(double costItems) {
        this.costItems.set(costItems);
    }

    public double getPrimeCostItems() {
        return primeCostItems.get();
    }

    public DoubleProperty primeCostItemsProperty() {
        return primeCostItems;
    }

    public void setPrimeCostItems(double primeCostItems) {
        this.primeCostItems.set(primeCostItems);
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
