package sample.model.create_order.print;

import javafx.beans.property.*;

/**
 * Created by Admin on 23.01.2017.
 */
public class Printer {
    public Printer() {
        this.idPrinter = new SimpleIntegerProperty();
        this.printerName = new SimpleStringProperty();
        this.printerNameEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
        this.checkCount = new SimpleBooleanProperty();

    }

    public int getIdPrinter() {
        return idPrinter.get();
    }

    public IntegerProperty idPrinterProperty() {
        return idPrinter;
    }

    public void setIdPrinter(int idPrinter) {
        this.idPrinter.set(idPrinter);
    }

    private IntegerProperty idPrinter;
    private StringProperty printerName;
    private StringProperty printerNameEng;
    private BooleanProperty visible;
    private BooleanProperty checkCount;

    @Override
    public String toString() {
        return getPrinterName();

    }

    public boolean isCheckCount() {
        return checkCount.get();
    }

    public BooleanProperty checkCountProperty() {
        return checkCount;
    }

    public void setCheckCount(boolean checkCount) {
        this.checkCount.set(checkCount);
    }


    public String getPrinterName() {
        return printerName.get();
    }

    public StringProperty printerNameProperty() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName.set(printerName);
    }

    public String getPrinterNameEng() {
        return printerNameEng.get();
    }

    public StringProperty printerNameEngProperty() {
        return printerNameEng;
    }

    public void setPrinterNameEng(String printerNameEng) {
        this.printerNameEng.set(printerNameEng);
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