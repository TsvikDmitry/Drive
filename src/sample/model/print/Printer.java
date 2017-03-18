package sample.model.print;

import javafx.beans.property.*;

/**
 * Created by Admin on 23.01.2017.
 */
public class Printer {
    public Printer() {
        this.printerId = new SimpleIntegerProperty();
        this.printerName = new SimpleStringProperty();
        this.printerNameEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
    }
    private IntegerProperty printerId;
    private StringProperty printerName;
    private StringProperty printerNameEng;
    private BooleanProperty visible;

    public int getPrinterId() {
        return printerId.get();
    }

    public IntegerProperty printerIdProperty() {
        return printerId;
    }

    public void setPrinterId(int printerId) {
        this.printerId.set(printerId);
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