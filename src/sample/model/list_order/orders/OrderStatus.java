package sample.model.list_order.orders;

import javafx.beans.property.*;

/**
 * Created by Admin on 22.03.2017.
 */
public class OrderStatus {

    public OrderStatus(){
        this.idOrderStatus= new SimpleIntegerProperty();
        this.nameStatus = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();


    }
    @Override
    public String toString() {
        return getNameStatus();

    }
    private IntegerProperty idOrderStatus;
    private StringProperty nameStatus;
    private BooleanProperty visible;

    public int getIdOrderStatus() {
        return idOrderStatus.get();
    }

    public IntegerProperty idOrderStatusProperty() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus.set(idOrderStatus);
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
