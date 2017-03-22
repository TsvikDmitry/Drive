package sample.model.statistic.save_banknot;

import javafx.beans.property.*;

/**
 * Created by Admin on 07.04.2017.
 */
public class SaveBanknot {

    public SaveBanknot(){
        this.idSaveBanknot  = new SimpleIntegerProperty();
        this.dataSave  = new SimpleStringProperty();
        this.bank_500  = new SimpleIntegerProperty();
        this.bank_200  = new SimpleIntegerProperty();
        this.bank_100  = new SimpleIntegerProperty();
        this.bank_50  = new SimpleIntegerProperty();
        this.bank_20  = new SimpleIntegerProperty();
        this.bank_10  = new SimpleIntegerProperty();
        this.bank_5  = new SimpleIntegerProperty();
        this.bank_2  = new SimpleIntegerProperty();
        this.bank_1  = new SimpleIntegerProperty();
        this.bank_01  = new SimpleIntegerProperty();
        this.bank_050  = new SimpleIntegerProperty();
        this.bank_025  = new SimpleIntegerProperty();
        this.bank_010  = new SimpleIntegerProperty();
        this.bank_005  = new SimpleIntegerProperty();
        this.all_money  = new SimpleDoubleProperty();

    }

    private IntegerProperty idSaveBanknot;
    private StringProperty dataSave;
    private IntegerProperty bank_500;
    private IntegerProperty bank_200;
    private IntegerProperty bank_100;
    private IntegerProperty bank_50;
    private IntegerProperty bank_20;
    private IntegerProperty bank_10;
    private IntegerProperty bank_5;
    private IntegerProperty bank_2;
    private IntegerProperty bank_1;
    private IntegerProperty bank_01;
    private IntegerProperty bank_050;
    private IntegerProperty bank_025;
    private IntegerProperty bank_010;
    private IntegerProperty bank_005;
    private DoubleProperty all_money;

    public int getIdSaveBanknot() {
        return idSaveBanknot.get();
    }

    public IntegerProperty idSaveBanknotProperty() {
        return idSaveBanknot;
    }

    public void setIdSaveBanknot(int idSaveBanknot) {
        this.idSaveBanknot.set(idSaveBanknot);
    }

    public String getDataSave() {
        return dataSave.get();
    }

    public StringProperty dataSaveProperty() {
        return dataSave;
    }

    public void setDataSave(String dataSave) {
        this.dataSave.set(dataSave);
    }

    public int getBank_500() {
        return bank_500.get();
    }

    public IntegerProperty bank_500Property() {
        return bank_500;
    }

    public void setBank_500(int bank_500) {
        this.bank_500.set(bank_500);
    }

    public int getBank_200() {
        return bank_200.get();
    }

    public IntegerProperty bank_200Property() {
        return bank_200;
    }

    public void setBank_200(int bank_200) {
        this.bank_200.set(bank_200);
    }

    public int getBank_100() {
        return bank_100.get();
    }

    public IntegerProperty bank_100Property() {
        return bank_100;
    }

    public void setBank_100(int bank_100) {
        this.bank_100.set(bank_100);
    }

    public int getBank_50() {
        return bank_50.get();
    }

    public IntegerProperty bank_50Property() {
        return bank_50;
    }

    public void setBank_50(int bank_50) {
        this.bank_50.set(bank_50);
    }

    public int getBank_20() {
        return bank_20.get();
    }

    public IntegerProperty bank_20Property() {
        return bank_20;
    }

    public void setBank_20(int bank_20) {
        this.bank_20.set(bank_20);
    }

    public int getBank_10() {
        return bank_10.get();
    }

    public IntegerProperty bank_10Property() {
        return bank_10;
    }

    public void setBank_10(int bank_10) {
        this.bank_10.set(bank_10);
    }

    public int getBank_5() {
        return bank_5.get();
    }

    public IntegerProperty bank_5Property() {
        return bank_5;
    }

    public void setBank_5(int bank_5) {
        this.bank_5.set(bank_5);
    }

    public int getBank_2() {
        return bank_2.get();
    }

    public IntegerProperty bank_2Property() {
        return bank_2;
    }

    public void setBank_2(int bank_2) {
        this.bank_2.set(bank_2);
    }

    public int getBank_1() {
        return bank_1.get();
    }

    public IntegerProperty bank_1Property() {
        return bank_1;
    }

    public void setBank_1(int bank_1) {
        this.bank_1.set(bank_1);
    }

    public int getBank_01() {
        return bank_01.get();
    }

    public IntegerProperty bank_01Property() {
        return bank_01;
    }

    public void setBank_01(int bank_01) {
        this.bank_01.set(bank_01);
    }

    public int getBank_050() {
        return bank_050.get();
    }

    public IntegerProperty bank_050Property() {
        return bank_050;
    }

    public void setBank_050(int bank_050) {
        this.bank_050.set(bank_050);
    }

    public int getBank_025() {
        return bank_025.get();
    }

    public IntegerProperty bank_025Property() {
        return bank_025;
    }

    public void setBank_025(int bank_025) {
        this.bank_025.set(bank_025);
    }

    public int getBank_010() {
        return bank_010.get();
    }

    public IntegerProperty bank_010Property() {
        return bank_010;
    }

    public void setBank_010(int bank_010) {
        this.bank_010.set(bank_010);
    }

    public int getBank_005() {
        return bank_005.get();
    }

    public IntegerProperty bank_005Property() {
        return bank_005;
    }

    public void setBank_005(int bank_005) {
        this.bank_005.set(bank_005);
    }

    public double getAll_money() {
        return all_money.get();
    }

    public DoubleProperty all_moneyProperty() {
        return all_money;
    }

    public void setAll_money(double all_money) {
        this.all_money.set(all_money);
    }
}
