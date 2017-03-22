package sample.model.statistic;

import javafx.beans.property.*;


/**
 * Created by Dima on 23.03.2017.
 */
public class PrintCount {

    public PrintCount(){
        this.idPrinterCounter = new SimpleIntegerProperty();
            this.idPrinterCounter = new SimpleIntegerProperty();
            this.idPrinter = new SimpleIntegerProperty();
            this.namePrinter = new SimpleStringProperty();
            this.countStart = new SimpleIntegerProperty();
            this.countEnd = new SimpleIntegerProperty();
            this.dataCount = new SimpleStringProperty();
            this.difference = new SimpleIntegerProperty();
            this.counterPrinting = new SimpleIntegerProperty();

    }

    private IntegerProperty idPrinterCounter;
    private IntegerProperty idPrinter;
    private StringProperty namePrinter;
    private IntegerProperty countStart;
    private IntegerProperty countEnd;
    private StringProperty dataCount;
    private IntegerProperty difference;
    private IntegerProperty counterPrinting;

    public int getCounterPrinting() {

        return counterPrinting.get();
    }

    public IntegerProperty counterPrintingProperty() {
        return counterPrinting;
    }

    public void setCounterPrinting(int counterPrinting) {
        this.counterPrinting.set(counterPrinting);
    }

    public int getDifference() {
        return difference.get();
    }

    public IntegerProperty differenceProperty() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference.set(difference);
    }




    public int getIdPrinterCounter() {
        return idPrinterCounter.get();
    }

    public IntegerProperty idPrinterCounterProperty() {
        return idPrinterCounter;
    }

    public void setIdPrinterCounter(int idPrinterCounter) {
        this.idPrinterCounter.set(idPrinterCounter);
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

    public String getNamePrinter() {
        return namePrinter.get();
    }

    public StringProperty namePrinterProperty() {
        return namePrinter;
    }

    public void setNamePrinter(String namePrinter) {
        this.namePrinter.set(namePrinter);
    }

    public int getCountStart() {
        return countStart.get();
    }

    public IntegerProperty countStartProperty() {
        return countStart;
    }

    public void setCountStart(int countStart) {
        this.countStart.set(countStart);
    }

    public int getCountEnd() {
        return countEnd.get();
    }

    public IntegerProperty countEndProperty() {
        return countEnd;
    }

    public void setCountEnd(int countEnd) {
        this.countEnd.set(countEnd);
    }

    public String getDataCount() {
        return dataCount.get();
    }

    public StringProperty dataCountProperty() {
        return dataCount;
    }

    public void setDataCount(String dataCount) {
        this.dataCount.set(dataCount);
    }
}
