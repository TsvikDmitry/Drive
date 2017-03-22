package sample.model.create_order.plotter;

import javafx.beans.property.*;

/**
 * Created by Dima on 09.03.2017.
 */
public class Plotter {
        public Plotter() {
            this.plotterId = new SimpleIntegerProperty();
            this.plotterName = new SimpleStringProperty();
            this.plotterNameEng = new SimpleStringProperty();
            this.visible = new SimpleBooleanProperty();
        }
        private IntegerProperty plotterId;
        private StringProperty plotterName;
        private StringProperty plotterNameEng;
        private BooleanProperty visible;



    public int getPlotterId() {
        return plotterId.get();
    }

    public IntegerProperty plotterIdProperty() {
        return plotterId;
    }

    public void setPlotterId(int plotterId) {
        this.plotterId.set(plotterId);
    }

    public String getPlotterName() {
        return plotterName.get();
    }

    public StringProperty plotterNameProperty() {
        return plotterName;
    }

    public void setPlotterName(String plotterName) {
        this.plotterName.set(plotterName);
    }

    public String getPlotterNameEng() {
        return plotterNameEng.get();
    }

    public StringProperty plotterNameEngProperty() {
        return plotterNameEng;
    }

    public void setPlotterNameEng(String plotterNameEng) {
        this.plotterNameEng.set(plotterNameEng);
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
