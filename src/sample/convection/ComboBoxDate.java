package sample.convection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Dima on 02.03.2017.
 */
public class ComboBoxDate {

    ObservableList<String> Hour =
            FXCollections.observableArrayList(
                    "8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"
            );
    ObservableList<String> Minute  =
            FXCollections.observableArrayList(
                    "00","10","20","30","40","50"
            );

    public ObservableList<String> getHour() {
        return Hour;
    }

    public ObservableList<String> getMinute() {
        return Minute;
    }
}
