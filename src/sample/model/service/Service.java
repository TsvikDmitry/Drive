package sample.model.service;

import javafx.beans.property.*;

/**
 * Created by Dima on 14.03.2017.
 */
public class Service {
    public Service(){
        this.idService = new SimpleIntegerProperty();
        this.nameService = new SimpleStringProperty();
        this.nameServiceEng = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();


    }
    private IntegerProperty idService;
    private StringProperty nameService;
    private StringProperty nameServiceEng;
    private BooleanProperty visible;

    public int getIdService() {
        return idService.get();
    }

    public IntegerProperty idServiceProperty() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService.set(idService);
    }

    public String getNameService() {
        return nameService.get();
    }

    public StringProperty nameServiceProperty() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService.set(nameService);
    }

    public String getNameServiceEng() {
        return nameServiceEng.get();
    }

    public StringProperty nameServiceEngProperty() {
        return nameServiceEng;
    }

    public void setNameServiceEng(String nameServiceEng) {
        this.nameServiceEng.set(nameServiceEng);
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
