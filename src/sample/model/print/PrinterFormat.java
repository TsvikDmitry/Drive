package sample.model.print;

import javafx.beans.property.*;

public class PrinterFormat {

    private IntegerProperty printerId;
    private IntegerProperty formatId;
    private StringProperty printerName;
    private StringProperty formatName;
    private BooleanProperty visible;

    public PrinterFormat() {
        this.printerId = new SimpleIntegerProperty();
        this.formatId = new SimpleIntegerProperty();
        this.printerName = new SimpleStringProperty();
        this.formatName = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();
    }

    public int getPrinterId() {
        return printerId.get();
    }

    public IntegerProperty printerIdProperty() {
        return printerId;
    }

    public void setPrinterId(int printerId) {
        this.printerId.set(printerId);
    }

    public int getFormatId() {
        return formatId.get();
    }

    public IntegerProperty formatIdProperty() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId.set(formatId);
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

    public String getFormatName() {
        return formatName.get();
    }

    public StringProperty formatNameProperty() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName.set(formatName);
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

