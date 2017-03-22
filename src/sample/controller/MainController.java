package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import sample.Main;

/**
 * Created by Dima on 22.01.2017.
 */
public class MainController {

    private Main mainApp = new Main();

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }


    @FXML
    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Program Information");
        alert.setHeaderText("This is a sample JAVAFX application for SWTESTACADEMY!");
        alert.setContentText("You can search, delete, update, insert a new employee with this program.");
        alert.show();



    }

    @FXML
    private void initialize () {


       // System.out.println("initialize ");

    }


    public void NewOrder(ActionEvent actionEvent) {
      //  System.out.println(" MainController  NewOrder");
        //mainApp.show1();
    }


    public void PrintCount(ActionEvent actionEvent) {
      //  System.out.println(" MainController  PrintCount");
        mainApp.PrintCountForma();
    }

    public void StatisticToday(ActionEvent actionEvent) {
        //  System.out.println(" MainController  PrintCount");
        mainApp.StatisticToday();
    }

    public void Deal(ActionEvent actionEvent) {
        mainApp.Deal();
    }
}
