package sample.model.statistic.deal;

import javafx.beans.property.*;

/**
 * Created by Dima on 28.03.2017.
 */
public class DealGroup {

    public DealGroup(){
        this.idDealGroup = new SimpleIntegerProperty();
        this.idDeal = new SimpleIntegerProperty();
        this.nameDeal = new SimpleStringProperty();
        this.nameGroup = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();


    }
    @Override
    public String toString() {
        return getNameGroup();

    }
    private IntegerProperty idDealGroup;
    private IntegerProperty idDeal;
    private StringProperty nameDeal;
    private StringProperty nameGroup;
    private BooleanProperty visible;

    public String getNameGroup() {
        return nameGroup.get();
    }

    public StringProperty nameGroupProperty() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup.set(nameGroup);
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
