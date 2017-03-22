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
import sample.controller.convection.Timer;
import sample.database.ConnectionDB;
import sample.view.tabls.AddTabsController;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main extends Application {

    //This is our PrimaryStage (It contains everything)
    public Stage primaryMain;

    //This is the BorderPane of RootLayout
    private BorderPane rootMain;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryMain = primaryStage;
        this.primaryMain.setTitle("Copy Drive project.");

        //главная активити
        showMainLayout();

        //активити которое встаивается во внутрь
        //showOrderController();
        showOrderController();
        // showPersonEditDialog();
        java.sql.Connection con = ConnectionDB.getInstance().getConnection();


        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
                System.out.println("formKeyPressed(evt) ");
            }
        });
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
      //  System.out.println("formKeyPressed(evt) - formKeyPressed");

        switch (evt.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                System.out.println("formKeyPressed(evt) VK_BACK_SPACE");

                break;
            case KeyEvent.VK_ENTER: //Нажата клавиша Enter
                System.out.println("formKeyPressed(evt) VK_ENTER");

                break;
            case KeyEvent.VK_ESCAPE: //Нажата клавиша Enter
                System.out.println("formKeyPressed(evt) VK_ESCAPE");

                break;
            default:
        }
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




    public void showAddItemsOrder(Integer id) {
        try {
            Long start = Timer.TimeStart();
           // System.out.println( ""+System.currentTimeMillis());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/create_order/create_order.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Заказ № "+id);
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryMain);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            CreateOrderController controller = loader.getController();
            controller.onCreate(id);
            Timer.TimeFinish(getClass().getName(),start);
            dialogStage.showAndWait();


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
            //loader.setLocation(Main.class.getResource("view/orderCreate/order_create.fxml"));

            AnchorPane ordersView = (AnchorPane) loader.load();
            rootMain.setCenter(ordersView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showOrderController2() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/TabsExample.fxml"));

            AnchorPane ordersView = (AnchorPane) loader.load();
            rootMain.setCenter(ordersView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void show1() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/tabls/TabsExample.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Оплата заказа: id");
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryMain);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            AddTabsController controller = loader.getController();
            dialogStage.showAndWait();


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



    public void keyHandler(KeyEvent keyEvent) {
    }


    public void jjjlh(KeyEvent keyEvent) {
    }
}
