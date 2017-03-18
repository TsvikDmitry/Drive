package sample.model.binding;

import javafx.beans.property.*;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingSpringSize {

    public BindingSpringSize(){
        this.idBindingSpringSize = new SimpleIntegerProperty();
        this.idBindingSpring = new SimpleIntegerProperty();
        this.sheet = new SimpleIntegerProperty();
        this.nameSpring = new SimpleStringProperty();
        this.nameSpringEng = new SimpleStringProperty();
        this.nameColor = new SimpleStringProperty();
        this.nameSize = new SimpleStringProperty();

        this.visible = new SimpleBooleanProperty();
        this.costSize = new SimpleDoubleProperty();
        this.primeCostSize = new SimpleDoubleProperty();

    }

    private IntegerProperty idBindingSpringSize;
    private IntegerProperty idBindingSpring;
    private StringProperty nameSpring;
    private StringProperty nameSpringEng;
    private StringProperty nameColor;

    private StringProperty nameSize;
    private IntegerProperty sheet;
    private DoubleProperty costSize;
    private DoubleProperty primeCostSize;
    private BooleanProperty visible;

    public int getIdBindingSpringSize() {
        return idBindingSpringSize.get();
    }

    public IntegerProperty idBindingSpringSizeProperty() {
        return idBindingSpringSize;
    }

    public void setIdBindingSpringSize(int idBindingSpringSize) {
        this.idBindingSpringSize.set(idBindingSpringSize);
    }

    public int getIdBindingSpring() {
        return idBindingSpring.get();
    }

    public IntegerProperty idBindingSpringProperty() {
        return idBindingSpring;
    }

    public void setIdBindingSpring(int idBindingSpring) {
        this.idBindingSpring.set(idBindingSpring);
    }

    public String getNameSpring() {
        return nameSpring.get();
    }

    public StringProperty nameSpringProperty() {
        return nameSpring;
    }

    public void setNameSpring(String nameSpring) {
        this.nameSpring.set(nameSpring);
    }

    public String getNameSpringEng() {
        return nameSpringEng.get();
    }

    public StringProperty nameSpringEngProperty() {
        return nameSpringEng;
    }

    public void setNameSpringEng(String nameSpringEng) {
        this.nameSpringEng.set(nameSpringEng);
    }

    public String getNameColor() {
        return nameColor.get();
    }

    public StringProperty nameColorProperty() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor.set(nameColor);
    }

    public String getNameSize() {
        return nameSize.get();
    }

    public StringProperty nameSizeProperty() {
        return nameSize;
    }

    public void setNameSize(String nameSize) {
        this.nameSize.set(nameSize);
    }

    public int getSheet() {
        return sheet.get();
    }

    public IntegerProperty sheetProperty() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet.set(sheet);
    }

    public double getCostSize() {
        return costSize.get();
    }

    public DoubleProperty costSizeProperty() {
        return costSize;
    }

    public void setCostSize(double costSize) {
        this.costSize.set(costSize);
    }

    public double getPrimeCostSize() {
        return primeCostSize.get();
    }

    public DoubleProperty primeCostSizeProperty() {
        return primeCostSize;
    }

    public void setPrimeCostSize(double primeCostSize) {
        this.primeCostSize.set(primeCostSize);
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
