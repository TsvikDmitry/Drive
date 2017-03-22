package sample.model.people;

import javafx.beans.property.*;

/**
 * Created by Admin on 22.03.2017.
 */
public class People {

    public People(){
        this.idPeople= new SimpleIntegerProperty();
        this.namePeople = new SimpleStringProperty();
        this.password = new  SimpleStringProperty();
        this.wage= new SimpleDoubleProperty();
        this.visible = new SimpleBooleanProperty();


    }
    @Override
    public String toString() {
        return getNamePeople();

    }
    private IntegerProperty idPeople;
    private StringProperty namePeople;
    private StringProperty password;
    private BooleanProperty visible;
    private DoubleProperty wage;

    public int getIdPeople() {
        return idPeople.get();
    }

    public IntegerProperty idPeopleProperty() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople.set(idPeople);
    }

    public String getNamePeople() {
        return namePeople.get();
    }

    public StringProperty namePeopleProperty() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople.set(namePeople);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
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

    public double getWage() {
        return wage.get();
    }

    public DoubleProperty wageProperty() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage.set(wage);
    }
}
