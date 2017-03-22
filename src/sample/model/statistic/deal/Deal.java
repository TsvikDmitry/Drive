package sample.model.statistic.deal;

import javafx.beans.property.*;

/**
 * Created by Dima on 28.03.2017.
 */
public class Deal {
    public Deal(){
        this.idDeal = new SimpleIntegerProperty();
        this.nameDeal = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();


    }
    @Override
    public String toString() {
        return getNameDeal();

    }
    private IntegerProperty idDeal;
    private StringProperty nameDeal;
    private BooleanProperty visible;

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
