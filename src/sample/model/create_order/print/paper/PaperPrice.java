package sample.model.create_order.print.paper;

import javafx.beans.property.*;

/**
 * Created by Dima on 29.01.2017.
 */
public class PaperPrice {



    public PaperPrice(){
        this.idPrinterPaperPrice = new SimpleIntegerProperty();
        this.idPrinter = new SimpleIntegerProperty();
        this.idFormat = new SimpleIntegerProperty();
        this.idPaper = new SimpleIntegerProperty();
        this.printerName = new SimpleStringProperty();
        this.formatName = new SimpleStringProperty();
        this.paperName = new SimpleStringProperty();
        this.densityPaperPrice = new SimpleIntegerProperty();
        this.paperCost = new SimpleFloatProperty();
        this.paperPrimeCost = new SimpleFloatProperty();
    }

    private IntegerProperty idPrinterPaperPrice;
    private IntegerProperty idPrinter;
    private IntegerProperty idFormat;
    private IntegerProperty idPaper;
    private StringProperty printerName;
    private StringProperty formatName;
    private StringProperty paperName;
    private IntegerProperty densityPaperPrice;
    private FloatProperty paperCost;
    private FloatProperty paperPrimeCost;

    public float getPaperCost() {
        return paperCost.get();
    }

    public FloatProperty paperCostProperty() {
        return paperCost;
    }

    public void setPaperCost(float paperCost) {
        this.paperCost.set(paperCost);
    }

    public float getPaperPrimeCost() {
        return paperPrimeCost.get();
    }

    public FloatProperty paperPrimeCostProperty() {
        return paperPrimeCost;
    }

    public void setPaperPrimeCost(float paperPrimeCost) {
        this.paperPrimeCost.set(paperPrimeCost);
    }

    public int getIdPrinterPaperPrice() {
        return idPrinterPaperPrice.get();
    }

    public IntegerProperty idPrinterPaperPriceProperty() {
        return idPrinterPaperPrice;
    }

    public void setIdPrinterPaperPrice(int idPrinterPaperPrice) {
        this.idPrinterPaperPrice.set(idPrinterPaperPrice);
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

    public int getIdPaper() {
        return idPaper.get();
    }

    public IntegerProperty idPaperProperty() {
        return idPaper;
    }

    public void setIdPaper(int idPaper) {
        this.idPaper.set(idPaper);
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

    public String getPaperName() {
        return paperName.get();
    }

    public StringProperty paperNameProperty() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName.set(paperName);
    }

    public int getDensityPaperPrice() {
        return densityPaperPrice.get();
    }

    public IntegerProperty densityPaperPriceProperty() {
        return densityPaperPrice;
    }

    public void setDensityPaperPrice(int densityPaperPrice) {
        this.densityPaperPrice.set(densityPaperPrice);
    }




}
