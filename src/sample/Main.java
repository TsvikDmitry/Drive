package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controller.CreateOrder.CreateOrderController;
import sample.controller.PayOrder.PayOrderController;
import sample.controller.Statisic.Today.StatisticDayController;
import sample.controller.convection.Timer;

import java.io.IOException;

public class Main extends Application {

    //This is our PrimaryStage (It contains everything)
    public Stage primaryMain;
    public Stage stageOrder;
    //This is the BorderPane of RootLayout
    private BorderPane rootMain;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryMain = primaryStage;
        this.primaryMain.setTitle("Copy Drive project.");

        Long start = Timer.TimeStart();
        showMainLayout();
        showOrderController();



        Timer.TimeFinish(getClass().getName(),start);

    }


    private void showMainLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/main.fxml"));
            rootMain = (BorderPane) loader.load();

            Scene scene = new Scene(rootMain); //We are sending rootLayout to the Scene.
            primaryMain.setScene(scene); //Set the scene in primary stage.
            primaryMain.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void showCreadOrders(Integer id) {
        try {
            Long start = Timer.TimeStart();
           // System.out.println( ""+System.currentTimeMillis());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/create_order/create_order.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            stageOrder = new Stage();
            stageOrder.setTitle("Заказ № "+id);
            stageOrder.initModality(Modality.NONE);
            stageOrder.initOwner(primaryMain);
            Scene scene = new Scene(page);
            stageOrder.setScene(scene);
            CreateOrderController controller = loader.getController();
            controller.onCreate(id);
            //controller.FileCreat(id);
            controller.setClose(stageOrder);
            Timer.TimeFinish(getClass().getName(),start);
            stageOrder.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPayOrder(Integer id) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/pay/pay_order.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Оплата заказа: id");
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryMain);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            PayOrderController controller = loader.getController();
            controller.onCreate(id);
            controller.setClose(dialogStage);
            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showOrderController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/order_list.fxml"));
            AnchorPane ordersView = (AnchorPane) loader.load();
            rootMain.setCenter(ordersView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void PrintCountForma() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/statistic/сounter_printer/print_counter_allday.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Статистика копий печати");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryMain);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  void StatisticToday() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/statistic/today_main.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Статистика за день");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryMain);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            StatisticDayController controller = loader.getController();
            controller.setClose(dialogStage);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Stage getPrimaryStage() {
        return primaryMain;
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void Deal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/statistic/deal/deal_allday.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Статистика за день");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryMain);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
