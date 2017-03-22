package sample.controller.convection;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import sample.model.pay.PayMent;
import sample.model.pay.PayMentDB;

/**
 * Created by Dima on 29.03.2017.
 */
public class List {


    public static ObservableList<PayMent> PayMent() {
        ObservableList<PayMent> list = null;
        try {

            list = PayMentDB.selectOrderPrinter();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }

}
