package sample.controller.Statisic.Device;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import sample.model.statistic.PrintCountDB;

/**
 * Created by Dima on 31.03.2017.
 */
public class DeviceDayController {
    @FXML  public ComboBox SortBox;
    @FXML  private DeviceTableController deviceTableController;
    String[] sort = {"По устройствам","По категориям"};
    String data ;

    @FXML
    private void initialize() throws Exception {
        data = "curdate()";
        ObservableList<String> variant = FXCollections.observableArrayList(sort);
        SortBox.setItems(variant);
        SortBox.getSelectionModel().selectFirst();
        UpdateData();

    }

    public void UpdateData() throws Exception {

        deviceTableController.setData(data);

        Sort();

    }

    @FXML
    void Sort(){
        if (getSortBox()==sort[0]){
            deviceTableController.UpdateTableGroupDevice();
        }else {
            deviceTableController.UpdateTableGroupCategory();

        }


    }
    String getSortBox(){
        return SortBox.getSelectionModel().getSelectedItem().toString();
    }



}
