package sample.controller.Statisic.Device;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import sample.model.statistic.Today.StatisticDevice;
import sample.model.statistic.Today.StatisticDeviceDB;

/**
 * Created by Admin on 26.03.2017.
 */
public class DeviceTableController {


    @FXML
    public TableView<StatisticDevice> TableStatisticDevice;
    @FXML  public TableColumn<StatisticDevice, String> CategoryNameColumn;
    @FXML  public TableColumn<StatisticDevice, String> ItemNameColumn;
    @FXML  public TableColumn<StatisticDevice, Integer> CountColumn;
    @FXML  public TableColumn<StatisticDevice, Double> SumColumn;
    @FXML  public TableColumn<StatisticDevice, Double> PrimeCostSum;
    @FXML  public TableColumn<StatisticDevice, Double> ProfitColumn;
    String data ;
    @FXML
    private void initialize() throws Exception {

        CategoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameCategoryProperty());
        ItemNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameItemsProperty());
        CountColumn.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
        SumColumn.setCellValueFactory(cellData -> cellData.getValue().sumProperty().asObject());
        PrimeCostSum.setCellValueFactory(cellData -> cellData.getValue().primeCostSumProperty().asObject());
        ProfitColumn.setCellValueFactory(cellData -> cellData.getValue().profitProperty().asObject());

        ClickTable();
      //  UpdateTableData();
    }

    public void ClickTable() {
        TableStatisticDevice.setRowFactory( tv -> {
            TableRow<StatisticDevice> row = new TableRow<>(); row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && (! row.isEmpty()) ) {

            } }); return row; }); }


    public void UpdateTableGroupDevice()  {
        ObservableList<StatisticDevice> lazData = null;
        try {    lazData = StatisticDeviceDB.selectGroupDevice(data); } catch (Exception e) { e.printStackTrace(); }
        TableStatisticDevice.setItems(lazData);
    }

    public void UpdateTableGroupCategory()  {
        ObservableList<StatisticDevice> lazData = null;
        try {    lazData = StatisticDeviceDB.selectGroupCategory(data); } catch (Exception e) { e.printStackTrace(); }
        TableStatisticDevice.setItems(lazData);
    }
    public void setData(String data) {
        this.data = data;
    }


}
