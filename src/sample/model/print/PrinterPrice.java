package sample.model.print;

import javafx.beans.property.*;

/**
 * Created by Admin on 25.01.2017.
 */
public class PrinterPrice {



    public PrinterPrice() {
        this.idPrinterPrice = new SimpleIntegerProperty();
        this.idPrinter = new SimpleIntegerProperty();
        this.idFormat = new SimpleIntegerProperty();
        this.idPrice = new SimpleIntegerProperty();
        this.namePrinter = new SimpleStringProperty();
        this.nameFormat = new SimpleStringProperty();
        this.namePrice = new SimpleStringProperty();
        this.countPrint =  new SimpleIntegerProperty();
        this.costPrint = new SimpleFloatProperty();
        this.PrintPrimeCost =  new SimpleFloatProperty();
        this.Visible =  new SimpleBooleanProperty();

    }

    private IntegerProperty idPrinterPrice;
    private IntegerProperty idPrinter;
    private IntegerProperty idFormat;
    private IntegerProperty idPrice;
    private StringProperty namePrinter;
    private StringProperty nameFormat;
    private StringProperty namePrice;
    private IntegerProperty countPrint;
    private FloatProperty costPrint;

    public int getCountPrint() {
        return countPrint.get();
    }

    public IntegerProperty countPrintProperty() {
        return countPrint;
    }

    public void setCountPrint(int countPrint) {
        this.countPrint.set(countPrint);
    }

    public float getCostPrint() {
        return costPrint.get();
    }

    public FloatProperty costPrintProperty() {
        return costPrint;
    }

    public void setCostPrint(float costPrint) {
        this.costPrint.set(costPrint);
    }

    private BooleanProperty Visible;

    public float getPrintPrimeCost() {
        return PrintPrimeCost.get();
    }

    public FloatProperty printPrimeCostProperty() {
        return PrintPrimeCost;
    }

    public void setPrintPrimeCost(float printPrimeCost) {
        this.PrintPrimeCost.set(printPrimeCost);
    }

    private FloatProperty PrintPrimeCost;

    public int getIdPrinterPrice() {
        return idPrinterPrice.get();
    }

    public IntegerProperty idPrinterPriceProperty() {
        return idPrinterPrice;
    }

    public void setIdPrinterPrice(int idPrinterPrice) {
        this.idPrinterPrice.set(idPrinterPrice);
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

    public int getIdFormat() {
        return idFormat.get();
    }

    public IntegerProperty idFormatProperty() {
        return idFormat;
    }

    public void setIdFormat(int idFormat) {
        this.idFormat.set(idFormat);
    }

    public int getIdPrice() {
        return idPrice.get();
    }

    public IntegerProperty idPriceProperty() {
        return idPrice;
    }

    public void setIdPrice(int idPrice) {
        this.idPrice.set(idPrice);
    }

    public String getNamePrinter() {
        return namePrinter.get();
    }

    public StringProperty namePrinterProperty() {
        return namePrinter;
    }

    public void setNamePrinter(String namePrinter) {
        this.namePrinter.set(namePrinter);
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

    public String getNamePrice() {
        return namePrice.get();
    }

    public StringProperty namePriceProperty() {
        return namePrice;
    }

    public void setNamePrice(String namePrice) {
        this.namePrice.set(namePrice);
    }


    public boolean isVisible() {
        return Visible.get();
    }

    public BooleanProperty visibleProperty() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        this.Visible.set(visible);
    }
}
