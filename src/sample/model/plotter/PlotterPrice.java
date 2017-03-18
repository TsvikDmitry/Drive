package sample.model.plotter;

import javafx.beans.property.*;

/**
 * Created by Dima on 09.03.2017.
 */
public class PlotterPrice {

    public PlotterPrice() {
        this.plotterPriceId = new SimpleIntegerProperty();
        this.cost = new SimpleFloatProperty();
        this.primeCost = new SimpleFloatProperty();
        this.visiblePlotterPrice = new SimpleBooleanProperty();
        this.plotterName = new SimpleStringProperty();
        this.plotterNameEng = new SimpleStringProperty();
        this.visiblePlotter = new SimpleBooleanProperty();
        this.plotterId = new SimpleIntegerProperty();
        this.fill =  new SimpleIntegerProperty();
        this.primeCostPrint = new SimpleFloatProperty();
        this.costPrint = new SimpleFloatProperty();
        this.visiblePlotterCost = new SimpleBooleanProperty();
        this.paperName =  new SimpleStringProperty();
        this.paperNameEng = new SimpleStringProperty();
        this.visiblePaper = new SimpleBooleanProperty();
        this.paperId = new SimpleIntegerProperty();
        this.width = new SimpleIntegerProperty();
        this.density = new SimpleIntegerProperty();
        this.costPaper = new SimpleFloatProperty();
        this.primeCostPaper = new SimpleFloatProperty();
        this.visiblePaperCost = new SimpleBooleanProperty();
    }
    private IntegerProperty plotterPriceId;

    private BooleanProperty visiblePlotterPrice;


    private StringProperty plotterName;
    private StringProperty plotterNameEng;
    private BooleanProperty visiblePlotter;

    private IntegerProperty plotterId;
    private IntegerProperty fill;
    private FloatProperty primeCostPrint;
    private FloatProperty costPrint;
    private BooleanProperty visiblePlotterCost;


    private StringProperty paperName;
    private StringProperty paperNameEng;
    private BooleanProperty visiblePaper;

    private IntegerProperty paperId;
    private IntegerProperty width;
    private IntegerProperty density;
    private FloatProperty costPaper;
    private FloatProperty primeCostPaper;
    private BooleanProperty visiblePaperCost;
    private FloatProperty cost;
    private FloatProperty primeCost;

    public float getCost() {
        return cost.get();
    }

    public FloatProperty costProperty() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost.set(cost);
    }

    public float getPrimeCost() {
        return primeCost.get();
    }

    public FloatProperty primeCostProperty() {
        return primeCost;
    }

    public void setPrimeCost(float primeCost) {
        this.primeCost.set(primeCost);
    }

    public int getPlotterPriceId() {
        return plotterPriceId.get();
    }

    public IntegerProperty plotterPriceIdProperty() {
        return plotterPriceId;
    }

    public void setPlotterPriceId(int plotterPriceId) {
        this.plotterPriceId.set(plotterPriceId);
    }


    public boolean isVisiblePlotterPrice() {
        return visiblePlotterPrice.get();
    }

    public BooleanProperty visiblePlotterPriceProperty() {
        return visiblePlotterPrice;
    }

    public void setVisiblePlotterPrice(boolean visiblePlotterPrice) {
        this.visiblePlotterPrice.set(visiblePlotterPrice);
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

    public boolean isVisiblePlotter() {
        return visiblePlotter.get();
    }

    public BooleanProperty visiblePlotterProperty() {
        return visiblePlotter;
    }

    public void setVisiblePlotter(boolean visiblePlotter) {
        this.visiblePlotter.set(visiblePlotter);
    }

    public int getPlotterId() {
        return plotterId.get();
    }

    public IntegerProperty plotterIdProperty() {
        return plotterId;
    }

    public void setPlotterId(int plotterId) {
        this.plotterId.set(plotterId);
    }

    public int getFill() {
        return fill.get();
    }

    public IntegerProperty fillProperty() {
        return fill;
    }

    public void setFill(int fill) {
        this.fill.set(fill);
    }

    public float getPrimeCostPrint() {
        return primeCostPrint.get();
    }

    public FloatProperty primeCostPrintProperty() {
        return primeCostPrint;
    }

    public void setPrimeCostPrint(float primeCostPrint) {
        this.primeCostPrint.set(primeCostPrint);
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

    public boolean isVisiblePlotterCost() {
        return visiblePlotterCost.get();
    }

    public BooleanProperty visiblePlotterCostProperty() {
        return visiblePlotterCost;
    }

    public void setVisiblePlotterCost(boolean visiblePlotterCost) {
        this.visiblePlotterCost.set(visiblePlotterCost);
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

    public String getPaperNameEng() {
        return paperNameEng.get();
    }

    public StringProperty paperNameEngProperty() {
        return paperNameEng;
    }

    public void setPaperNameEng(String paperNameEng) {
        this.paperNameEng.set(paperNameEng);
    }

    public boolean isVisiblePaper() {
        return visiblePaper.get();
    }

    public BooleanProperty visiblePaperProperty() {
        return visiblePaper;
    }

    public void setVisiblePaper(boolean visiblePaper) {
        this.visiblePaper.set(visiblePaper);
    }

    public int getPaperId() {
        return paperId.get();
    }

    public IntegerProperty paperIdProperty() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId.set(paperId);
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

    public int getDensity() {
        return density.get();
    }

    public IntegerProperty densityProperty() {
        return density;
    }

    public void setDensity(int density) {
        this.density.set(density);
    }

    public float getCostPaper() {
        return costPaper.get();
    }

    public FloatProperty costPaperProperty() {
        return costPaper;
    }

    public void setCostPaper(float costPaper) {
        this.costPaper.set(costPaper);
    }

    public float getPrimeCostPaper() {
        return primeCostPaper.get();
    }

    public FloatProperty primeCostPaperProperty() {
        return primeCostPaper;
    }

    public void setPrimeCostPaper(float primeCostPaper) {
        this.primeCostPaper.set(primeCostPaper);
    }

    public boolean isVisiblePaperCost() {
        return visiblePaperCost.get();
    }

    public BooleanProperty visiblePaperCostProperty() {
        return visiblePaperCost;
    }

    public void setVisiblePaperCost(boolean visiblePaperCost) {
        this.visiblePaperCost.set(visiblePaperCost);
    }
}
