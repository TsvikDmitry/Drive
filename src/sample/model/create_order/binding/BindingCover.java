package sample.model.create_order.binding;

import javafx.beans.property.*;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingCover {

    public BindingCover(){
        this.idBindingCover = new SimpleIntegerProperty();
        this.idBindingFormat= new SimpleIntegerProperty();
        this.nameFormat = new SimpleStringProperty();
        this.nameCover = new SimpleStringProperty();
        this.nameCoverEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
        this.costCover = new SimpleDoubleProperty();
        this.primeCostCover = new SimpleDoubleProperty();

    }

    private IntegerProperty idBindingCover;
    private IntegerProperty idBindingFormat;
    private StringProperty nameCover;
    private StringProperty nameCoverEng;
    private DoubleProperty costCover;
    private DoubleProperty primeCostCover;
    private BooleanProperty visible;
    private StringProperty nameFormat;

    public String getNameFormat() {
        return nameFormat.get();
    }

    public StringProperty nameFormatProperty() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat.set(nameFormat);
    }


    public int getIdBindingFormat() {
        return idBindingFormat.get();
    }

    public IntegerProperty idBindingFormatProperty() {
        return idBindingFormat;
    }

    public void setIdBindingFormat(int idBindingFormat) {
        this.idBindingFormat.set(idBindingFormat);
    }
    public int getIdBindingCover() {
        return idBindingCover.get();
    }

    public IntegerProperty idBindingCoverProperty() {
        return idBindingCover;
    }

    public void setIdBindingCover(int idBindingCover) {
        this.idBindingCover.set(idBindingCover);
    }

    public String getNameCover() {
        return nameCover.get();
    }

    public StringProperty nameCoverProperty() {
        return nameCover;
    }

    public void setNameCover(String nameCover) {
        this.nameCover.set(nameCover);
    }

    public String getNameCoverEng() {
        return nameCoverEng.get();
    }

    public StringProperty nameCoverEngProperty() {
        return nameCoverEng;
    }

    public void setNameCoverEng(String nameCoverEng) {
        this.nameCoverEng.set(nameCoverEng);
    }

    public double getCostCover() {
        return costCover.get();
    }

    public DoubleProperty costCoverProperty() {
        return costCover;
    }

    public void setCostCover(double costCover) {
        this.costCover.set(costCover);
    }

    public double getPrimeCostCover() {
        return primeCostCover.get();
    }

    public DoubleProperty primeCostCoverProperty() {
        return primeCostCover;
    }

    public void setPrimeCostCover(double primeCostCover) {
        this.primeCostCover.set(primeCostCover);
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
