package sample.model.create_order.print.paper;

import javafx.beans.property.*;

/**
 * Created by Admin on 29.01.2017.
 */
public class PaperDuplex {
    public PaperDuplex() {
        this.idPaper = new SimpleIntegerProperty();
        this.namePaper =  new SimpleStringProperty();
        this.nameEngPaper =  new SimpleStringProperty();
        this.visiblePaper =  new SimpleBooleanProperty();
        this.idDuplex = new SimpleIntegerProperty();
        this.nameDuplex = new SimpleStringProperty();
    }
    private IntegerProperty idPaper;
    private IntegerProperty idDuplex;
    private StringProperty nameDuplex;
    private StringProperty namePaper;
    private StringProperty nameEngPaper;
    private BooleanProperty visiblePaper;

    public int getIdPaper() {
        return idPaper.get();
    }

    public IntegerProperty idPaperProperty() {
        return idPaper;
    }

    public void setIdPaper(int idPaper) {
        this.idPaper.set(idPaper);
    }

    public int getIdDuplex() {
        return idDuplex.get();
    }

    public IntegerProperty idDuplexProperty() {
        return idDuplex;
    }

    public void setIdDuplex(int idDuplex) {
        this.idDuplex.set(idDuplex);
    }

    public String getNameDuplex() {
        return nameDuplex.get();
    }

    public StringProperty nameDuplexProperty() {
        return nameDuplex;
    }

    public void setNameDuplex(String nameDuplex) {
        this.nameDuplex.set(nameDuplex);
    }

    public String getNamePaper() {
        return namePaper.get();
    }

    public StringProperty namePaperProperty() {
        return namePaper;
    }

    public void setNamePaper(String namePaper) {
        this.namePaper.set(namePaper);
    }

    public String getNameEngPaper() {
        return nameEngPaper.get();
    }

    public StringProperty nameEngPaperProperty() {
        return nameEngPaper;
    }

    public void setNameEngPaper(String nameEngPaper) {
        this.nameEngPaper.set(nameEngPaper);
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
}
