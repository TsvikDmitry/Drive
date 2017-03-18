package sample.view.tabls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sample.Main;

import java.io.IOException;

/**
 * Created by Dima on 09.03.2017.
 */
public class AddTabsController {
    private Main mainApp = new Main();

    @FXML private TabPane tabPane ;
 //   @FXML private Tab tab1_foo;

    //@FXML private Tab1fooController tab1foo_xController;
  //  TabsExample

    public void initialize() throws IOException {
        addTab();

    }

    @FXML
    private void addTab() throws IOException {




            tabPane.getTabs().addAll((Tab) FXMLLoader.load(getClass().getResource("tab_create_order.fxml")));
            Integer namber = tabPane.getTabs().size()-1;
            tabPane.getTabs().get(namber).setText("Tab pen: "+(namber+1)+"");



        //  tabPane.getTabs().

        //tabPane.getTabs().add(tab);
    }

    @FXML
    private void listTabs() {
        tabPane.getTabs().forEach(tab -> System.out.println(tab.getText()));
        System.out.println();


    }

}
