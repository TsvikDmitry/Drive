package sample.controller.Statisic;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sample.controller.Statisic.CounterPrinter.PrintCounterTodayController;
import sample.controller.Statisic.Deal.DealTodayController;
import sample.controller.Statisic.Device.DeviceDayController;
import sample.controller.Statisic.Today.StatisticDayController;

/**
 * Created by Dima on 31.03.2017.
 */
public class StatisicMainController {


    public TabPane tabPaneMain;
    public Tab tabStaticticDay;
    public Tab tabDeal;
    public Tab tabDevice;
    public Tab tabPrintCountToday;
    @FXML    StatisticDayController tabStaticticDayViewController;
    @FXML    DeviceDayController tabDeviceViewController;
    @FXML    PrintCounterTodayController tabPrintCountTodayViewController;
    @FXML    DealTodayController tabDealViewController;

    @FXML
    private void initialize() {



    }

    public void tabPaneClick() throws Exception {
        if (tabPaneMain.getSelectionModel().getSelectedIndex() == 0) {
            tabStaticticDayViewController.UpdateData();
        }
        if (tabPaneMain.getSelectionModel().getSelectedIndex() == 1) {
            tabDeviceViewController.UpdateData();
        }
        if (tabPaneMain.getSelectionModel().getSelectedIndex() == 2) {
            tabPrintCountTodayViewController.UpdateData();
        }

        if (tabPaneMain.getSelectionModel().getSelectedIndex() == 3) {
            tabDealViewController.UpdateData();
        }

    }







}
