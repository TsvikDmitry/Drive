package sample.model.plotter;

import javafx.beans.property.*;

/**
 * Created by Dima on 09.03.2017.
 */
public class PlotterFormat {

    public PlotterFormat() {
        this.nameFormat = new SimpleStringProperty();
        this.width = new SimpleIntegerProperty();
        this.length = new SimpleIntegerProperty();
    }


    private StringProperty nameFormat;
    private IntegerProperty width;
    private IntegerProperty length;

    public String getNameFormat() {
        return nameFormat.get();
    }

    public StringProperty nameFormatProperty() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat.set(nameFormat);
    }

    public int getWidth() {
        return width.get();
    }

    public IntegerProperty widthProperty() {
        return width;
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    public int getLength() {
        return length.get();
    }

    public IntegerProperty lengthProperty() {
        return length;
    }

    public void setLength(int length) {
        this.length.set(length);
    }
}
