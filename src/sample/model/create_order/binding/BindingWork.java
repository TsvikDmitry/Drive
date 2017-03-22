package sample.model.create_order.binding;

import javafx.beans.property.*;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingWork {


    public BindingWork(){
        this.idBindingWork = new SimpleIntegerProperty();
        this.idBindingFormat = new SimpleIntegerProperty();
        this.sheetWork = new SimpleIntegerProperty();
        this.nameWork = new SimpleStringProperty();
        this.nameWorkEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
        this.costWork = new SimpleDoubleProperty();
        this.primeCostWork = new SimpleDoubleProperty();
        this.nameFormat = new SimpleStringProperty();

    }

    private IntegerProperty idBindingWork;
    private IntegerProperty idBindingFormat;
    private StringProperty nameWork;
    private StringProperty nameWorkEng;
    private DoubleProperty costWork;
    private DoubleProperty primeCostWork;
    private BooleanProperty visible;
    private StringProperty nameFormat;
    private IntegerProperty sheetWork;

    public int getSheetWork() {
        return sheetWork.get();
    }

    public IntegerProperty sheetWorkProperty() {
        return sheetWork;
    }

    public void setSheetWork(int sheetWork) {
        this.sheetWork.set(sheetWork);
    }

    public String getNameFormat() {
        return nameFormat.get();
    }

    public StringProperty nameFormatProperty() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat.set(nameFormat);
    }

    public int getIdBindingWork() {
        return idBindingWork.get();
    }

    public IntegerProperty idBindingWorkProperty() {
        return idBindingWork;
    }

    public void setIdBindingWork(int idBindingWork) {
        this.idBindingWork.set(idBindingWork);
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

    public String getNameWork() {
        return nameWork.get();
    }

    public StringProperty nameWorkProperty() {
        return nameWork;
    }

    public void setNameWork(String nameWork) {
        this.nameWork.set(nameWork);
    }

    public String getNameWorkEng() {
        return nameWorkEng.get();
    }

    public StringProperty nameWorkEngProperty() {
        return nameWorkEng;
    }

    public void setNameWorkEng(String nameWorkEng) {
        this.nameWorkEng.set(nameWorkEng);
    }

    public double getCostWork() {
        return costWork.get();
    }

    public DoubleProperty costWorkProperty() {
        return costWork;
    }

    public void setCostWork(double costWork) {
        this.costWork.set(costWork);
    }

    public double getPrimeCostWork() {
        return primeCostWork.get();
    }

    public DoubleProperty primeCostWorkProperty() {
        return primeCostWork;
    }

    public void setPrimeCostWork(double primeCostWork) {
        this.primeCostWork.set(primeCostWork);
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



