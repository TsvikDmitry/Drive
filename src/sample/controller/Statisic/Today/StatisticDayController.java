package sample.controller.Statisic.Today;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.controller.convection.TextFieldFormatter;
import sample.model.statistic.Today.StatisticAllDB;
import sample.model.statistic.save_banknot.SaveBanknotDB;

import java.util.Optional;

/**
 * Created by Dima on 29.03.2017.
 */
public class StatisticDayController {

    @FXML private Label lbCash;
    @FXML private Label lbPayMony;
    @FXML private Label lbPayCard;
    @FXML  private Label lbPayNot;

    @FXML  private Label lbPayMonyLastDay;
    @FXML  private Label lbPayCardLastDay;


    @FXML  private Label lbDealPayCard;
    @FXML  private Label lbDealPayMony;
    @FXML  private Label lbDealRePayCard;
    @FXML  private Label lbDealRePayMony;
    @FXML  private Label lbSalaryRepayMony;
    @FXML  private Label lbSumMony;
    @FXML  private Label lbSumCard;
    @FXML  private Label lbProfit;

    @FXML  private TextField tf005;
    @FXML  private TextField tf500;
    @FXML  private TextField tf200;
    @FXML  private TextField tf100;
    @FXML  private TextField tf50;
    @FXML  private TextField tf20;
    @FXML  private TextField tf10;
    @FXML  private TextField tf5;
    @FXML  private TextField tf2;
    @FXML  private TextField tf1;
    @FXML  private TextField tf01;
    @FXML  private TextField tf050;
    @FXML  private TextField tf025;
    @FXML  private TextField tf010;
    @FXML  private TextField tfChange;
    @FXML  private Label lbSumCashMoney2;
    @FXML  private Label lbSumCashMoney1;
    private String dataOrder ;
    private Stage StageView;

    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }


    @FXML
    private void initialize() throws Exception {
        setDataOrder("curdate()");
        OnActionTextField();
        UpdateData();
    }

   public void UpdateData() throws Exception{

        lbCash.setText(String.valueOf(getCashDayMony()));
        lbPayMony.setText(String.valueOf(getPayMony()));
        lbPayCard.setText(String.valueOf(getPayCard()));
        lbPayNot.setText(String.format("%.2f",(getPayMony()+getPayCard())-getCashDayMony()));

        lbPayMonyLastDay.setText(String.valueOf(getPayMonyLastDay()));
        lbPayCardLastDay.setText(String.valueOf(getPayCardLastDay()));
       lbDealPayMony.setText(String.valueOf(getDealPayMony()));
       lbDealPayCard.setText(String.valueOf(getDealPayCard()));

       lbDealRePayMony.setText(String.valueOf(getDealRePayMony()));
       lbDealRePayCard.setText(String.valueOf(getDealRePayCard()));

       lbSumMony.setText(String.format("%.2f",getChange()+getPayMony()+getDealRePayMony()+getDealPayMony()+getPayMonyLastDay()));

       lbSumCard.setText(String.format("%.2f", getPayCard()+getDealRePayCard()+getPayCardLastDay()));


        SumMoney();

    }


    void SumMoney()  {

        lbSumCashMoney1.setText(String.format("%.2f", getSumMoney()));
        lbSumCashMoney2.setText(String.format("%.2f", getSumMoney()));
        try {

            lbProfit.setText(String.format("%.2f", getSumMoney()-(getChange()+getPayMony()+getDealPayMony()+getDealRePayMony())-getPayMonyLastDay()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    Double getSumMoney(){

        Double a500 =0.0;
        if(tf500.getText().length()!=0) {
            a500  = 500*Double.valueOf(tf500.getText());
        }
        Double a200 =0.0;
        if(tf200.getText().length()!=0) {
            a200  = 200*Double.valueOf(tf200.getText());
        }
        Double a100 =0.0;
        if(tf100.getText().length()!=0) {
            a100  = 100*Double.valueOf(tf100.getText());
        }

        Double a50 =0.0;
        if(tf50.getText().length()!=0) {
            a50  = 50*Double.valueOf(tf50.getText());
        }
        Double a20 =0.0;
        if(tf20.getText().length()!=0) {
            a20  = 20*Double.valueOf(tf20.getText());
        }
        Double a10 =0.0;
        if(tf10.getText().length()!=0) {
            a10  = 10*Double.valueOf(tf10.getText());
        }

        Double a5 =0.0;
        if(tf5.getText().length()!=0) {
            a5  = 5*Double.valueOf(tf5.getText());
        }

        Double a1 =0.0;
        if(tf1.getText().length()!=0) {
            a1  = 1*Double.valueOf(tf1.getText());
        }
        Double a2 =0.0;
        if(tf2.getText().length()!=0) {
            a2  = 2*Double.valueOf(tf2.getText());
        }

        Double a050 =0.0;
        if(tf050.getText().length()!=0) {
            a050  = 0.50*Double.valueOf(tf050.getText());
        }
        Double a01 =0.0;
        if(tf01.getText().length()!=0) {
            a01  = 1*Double.valueOf(tf01.getText());
        }

        Double a005 =0.0;
        if(tf005.getText().length()!=0) {
            a005  = 0.05*Double.valueOf(tf005.getText());
        }
        Double a010 =0.0;
        if(tf010.getText().length()!=0) {
            a010  = 0.10*Double.valueOf(tf010.getText());
        }
        Double a025 =0.0;
        if(tf025.getText().length()!=0) {
            a025  = 0.25*Double.valueOf(tf025.getText());
        }

        Double SumMoney = a500+a200+a100+a50+a20+a10+a5+a2+a1+a01+a050+a025+a010+a005;
        return SumMoney;
    }

    void OnActionTextField(){
        tf500.setTextFormatter(TextFieldFormatter.getItneger());
        tf500.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf500.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf200.setTextFormatter(TextFieldFormatter.getItneger());
        tf200.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf200.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf100.setTextFormatter(TextFieldFormatter.getItneger());
        tf100.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf100.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});

        tf50.setTextFormatter(TextFieldFormatter.getItneger());
        tf50.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (tf50.getText().length() != 0) {
                    SumMoney();
                }}});
        tf50.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf20.setTextFormatter(TextFieldFormatter.getItneger());
        tf20.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf20.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();}});
        tf10.setTextFormatter(TextFieldFormatter.getItneger());
        tf10.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf10.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});

        tf01.setTextFormatter(TextFieldFormatter.getItneger());
        tf01.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf01.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf2.setTextFormatter(TextFieldFormatter.getItneger());
        tf2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf2.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});

        tf5.setTextFormatter(TextFieldFormatter.getItneger());
        tf5.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf5.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf005.setTextFormatter(TextFieldFormatter.getItneger());
        tf005.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf005.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf010.setTextFormatter(TextFieldFormatter.getItneger());
        tf010.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf010.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf025.setTextFormatter(TextFieldFormatter.getItneger());
        tf025.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf025.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf050.setTextFormatter(TextFieldFormatter.getItneger());
        tf050.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf050.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf1.setTextFormatter(TextFieldFormatter.getItneger());
        tf1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tf1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tfChange.setTextFormatter(TextFieldFormatter.getDouble(600.0));
        tfChange.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});
        tfChange.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                SumMoney();
            }});

    }

    Double getChange()   {
        Double chage = 0.0;
        if(tfChange.getText().length()!=0) {
            chage = Double.valueOf(tfChange.getText());
        }
        return  chage;


    }


    @FXML
    void Cancel(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Отмена");
        alert.setHeaderText("При закрытие формы номиналы купюр не сохраняться!");
        alert.setContentText("Закрыть форму?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            StageView.close();
        }

    }



    @FXML
    void SaveBanknot(){

        Integer a500 =0;
        if(tf500.getText().length()!=0) {
            a500  = Integer.valueOf(tf500.getText());
        }
        Integer a200 =0;
        if(tf200.getText().length()!=0) {
            a200  = Integer.valueOf(tf200.getText());
        }
        Integer a100 =0;
        if(tf100.getText().length()!=0) {
            a100  = Integer.valueOf(tf100.getText());
        }

        Integer a50 =0;
        if(tf50.getText().length()!=0) {
            a50  = Integer.valueOf(tf50.getText());
        }
        Integer a20 =0;
        if(tf20.getText().length()!=0) {
            a20  = Integer.valueOf(tf20.getText());
        }
        Integer a10 =0;
        if(tf10.getText().length()!=0) {
            a10  = Integer.valueOf(tf10.getText());
        }

        Integer a5 =0;
        if(tf5.getText().length()!=0) {
            a5  = Integer.valueOf(tf5.getText());
        }

        Integer a1 =0;
        if(tf1.getText().length()!=0) {
            a1  = Integer.valueOf(tf1.getText());
        }
        Integer a2 =0;
        if(tf2.getText().length()!=0) {
            a2  = Integer.valueOf(tf2.getText());
        }

        Integer a050 =0;
        if(tf050.getText().length()!=0) {
            a050  = Integer.valueOf(tf050.getText());
        }
        Integer a01 =0;
        if(tf01.getText().length()!=0) {
            a01  = Integer.valueOf(tf01.getText());
        }

        Integer a005 =0;
        if(tf005.getText().length()!=0) {
            a005  = Integer.valueOf(tf005.getText());
        }
        Integer a010 =0;
        if(tf010.getText().length()!=0) {
            a010  =Integer.valueOf(tf010.getText());
        }
        Integer a025 =0;
        if(tf025.getText().length()!=0) {
            a025  = Integer.valueOf(tf025.getText());
        }

        Double SumMoney = Double.valueOf(500*a500+200*a200+100*a100+50*a50+20*a20+10*a10+5*a5+2*a2+1*a1+1*a01+0.5*a050+0.25*a025+0.1*a010+0.05*a005);

        SaveBanknotDB.InsertSaveBaknot(a500,a200,a100,a50,a20,a10,a5,a2,a1,a01,a050,a025,a010,a005,SumMoney);

        }

    Double getDealPayMony() throws Exception {
        return  StatisticAllDB.selectDeal(dataOrder, StatisticAllDB.PayMany);
    }

    Double getDealPayCard() throws Exception {
        return  StatisticAllDB.selectDeal(dataOrder,StatisticAllDB.PayCard);
    }

    Double getDealRePayMony() throws Exception {
        return  StatisticAllDB.selectDeal(dataOrder, StatisticAllDB.RePayMony);
    }

    Double getDealRePayCard() throws Exception {
        return  StatisticAllDB.selectDeal(dataOrder, StatisticAllDB.RePayCard);
    }


    Double getCashDayMony() throws Exception {
        return  StatisticAllDB.selectCashDayMony(dataOrder);
    }
    Double getPayMony   () throws Exception {
        return  StatisticAllDB.selectPay(dataOrder, StatisticAllDB.PayMany);
    }

    Double getPayCard   () throws Exception {
        return  StatisticAllDB.selectPay(dataOrder, StatisticAllDB.PayCard);
    }

    Double getPayMonyLastDay() throws Exception {
        return  StatisticAllDB.selectPay(dataOrder, StatisticAllDB.PayManyLastDay);
    }

    Double getPayCardLastDay() throws Exception {
        return  StatisticAllDB.selectPay(dataOrder, StatisticAllDB.PayCardLastDay);
    }

    public void setClose(Stage StageView) {
        this.StageView = StageView;
    }
    /*
    Double getPayMony   () throws Exception {
        return  StatisticAllDB.selectPayMony(dataOrder);
    }

    Double getPayCard   () throws Exception {
        return  StatisticAllDB.selectPayCard(dataOrder);
    }

    Double getPayMonyLastDay   () throws Exception {
        return  StatisticAllDB.selectPayMonyLastDay(dataOrder);
    }

    Double getPayCardLastDay   () throws Exception {
        return  StatisticAllDB.selectPayCardLastDay(dataOrder);
    }
*/

}
        