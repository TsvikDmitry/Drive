package sample.model.binding.order;

import javafx.beans.property.*;

/**
 * Created by Dima on 16.03.2017.
 */
public class OrderBinding {

    public OrderBinding(){
        this.idOrderBinging =  new  SimpleIntegerProperty();
        this.idOrder = new  SimpleIntegerProperty();
        this.idCategory = new  SimpleIntegerProperty();
        this.nameOrder = new SimpleStringProperty();
        this.idBindingCover = new  SimpleIntegerProperty();
        this.costCover = new SimpleDoubleProperty();
        this.primeCostCover = new SimpleDoubleProperty();
        this.idBindingFormat = new  SimpleIntegerProperty();
        this.costWork = new SimpleDoubleProperty();
        this.idBindingSpring = new  SimpleIntegerProperty();
        this.idBindingSpringSize = new  SimpleIntegerProperty();
        this.costSpringSize = new SimpleDoubleProperty();
        this.primeCostSpringSize = new SimpleDoubleProperty();
        this.sheet = new SimpleIntegerProperty();
        this.countCover = new SimpleDoubleProperty();
        this.countSpring = new SimpleDoubleProperty();
        this.countWork = new SimpleDoubleProperty();
        this.count = new  SimpleIntegerProperty();
        this.costSumOne = new SimpleDoubleProperty();
        this.costSumAll = new SimpleDoubleProperty();
        this.primeCostSumOne = new SimpleDoubleProperty();
        this.primeCostSumAll = new SimpleDoubleProperty();
        this.nameCover = new SimpleStringProperty();
        this.nameFormat = new SimpleStringProperty();
        this.nameSpring = new SimpleStringProperty();
        this.nameSpringSize = new SimpleStringProperty();

        this.textDesc = new SimpleStringProperty();
        this.profit = new SimpleDoubleProperty();
        this.costWorkOne = new SimpleDoubleProperty();
        this.costSpringSizeOne = new SimpleDoubleProperty();
        this.primeCostSpringSizeOne = new SimpleDoubleProperty();
        this.costCoverOne = new SimpleDoubleProperty();
        this.primeCostCoverOne = new SimpleDoubleProperty();

    }

    private IntegerProperty idOrderBinging;

    private IntegerProperty idOrder;
    private IntegerProperty idCategory;
    private StringProperty nameOrder;

    private IntegerProperty idBindingCover;
    private DoubleProperty costCover;
    private DoubleProperty primeCostCover;

    private IntegerProperty idBindingFormat;
    private DoubleProperty costWork;

    private IntegerProperty idBindingSpring;
    private IntegerProperty idBindingSpringSize;
    private DoubleProperty costSpringSize;
    private DoubleProperty primeCostSpringSize;
    private IntegerProperty sheet;

    private DoubleProperty countCover;
    private DoubleProperty countSpring;
    private DoubleProperty countWork;
    private IntegerProperty count;

    private DoubleProperty costSumOne;
    private DoubleProperty costSumAll;
    private DoubleProperty primeCostSumOne;
    private DoubleProperty primeCostSumAll;

    private StringProperty nameCover;
    private StringProperty nameFormat;
    private StringProperty nameSpring;
    private StringProperty nameSpringSize;

    private StringProperty textDesc;
    private DoubleProperty profit;

    private DoubleProperty costSpringSizeOne;
    private DoubleProperty primeCostSpringSizeOne;
    private DoubleProperty costCoverOne;
    private DoubleProperty primeCostCoverOne;

    public double getCostWorkOne() {
        return costWorkOne.get();
    }

    public DoubleProperty costWorkOneProperty() {
        return costWorkOne;
    }

    public void setCostWorkOne(double costWorkOne) {
        this.costWorkOne.set(costWorkOne);
    }

    private DoubleProperty costWorkOne;


    public double getCostSpringSizeOne() {
        return costSpringSizeOne.get();
    }

    public DoubleProperty costSpringSizeOneProperty() {
        return costSpringSizeOne;
    }

    public void setCostSpringSizeOne(double costSpringSizeOne) {
        this.costSpringSizeOne.set(costSpringSizeOne);
    }

    public double getPrimeCostSpringSizeOne() {
        return primeCostSpringSizeOne.get();
    }

    public DoubleProperty primeCostSpringSizeOneProperty() {
        return primeCostSpringSizeOne;
    }

    public void setPrimeCostSpringSizeOne(double primeCostSpringSizeOne) {
        this.primeCostSpringSizeOne.set(primeCostSpringSizeOne);
    }

    public double getCostCoverOne() {
        return costCoverOne.get();
    }

    public DoubleProperty costCoverOneProperty() {
        return costCoverOne;
    }

    public void setCostCoverOne(double costCoverOne) {
        this.costCoverOne.set(costCoverOne);
    }

    public double getPrimeCostCoverOne() {
        return primeCostCoverOne.get();
    }

    public DoubleProperty primeCostCoverOneProperty() {
        return primeCostCoverOne;
    }

    public void setPrimeCostCoverOne(double primeCostCoverOne) {
        this.primeCostCoverOne.set(primeCostCoverOne);
    }

    public double getProfit() {
        return profit.get();
    }

    public DoubleProperty profitProperty() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit.set(profit);
    }

    public String getTextDesc() {
        return textDesc.get();
    }

    public StringProperty textDescProperty() {
        return textDesc;
    }

    public void setTextDesc(String textDesc) {
        this.textDesc.set(textDesc);
    }



    public int getIdOrderBinging() {
        return idOrderBinging.get();
    }

    public IntegerProperty idOrderBingingProperty() {
        return idOrderBinging;
    }

    public void setIdOrderBinging(int idOrderBinging) {
        this.idOrderBinging.set(idOrderBinging);
    }


    public String getNameCover() {
        return nameCover.get();
    }

    public StringProperty nameCoverProperty() {
        return nameCover;
    }

    public void setNameCover(String nameCover) {
        this.nameCover.set(nameCover);
    }

    public String getNameFormat() {
        return nameFormat.get();
    }

    public StringProperty nameFormatProperty() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat.set(nameFormat);
    }

    public String getNameSpring() {
        return nameSpring.get();
    }

    public StringProperty nameSpringProperty() {
        return nameSpring;
    }

    public void setNameSpring(String nameSpring) {
        this.nameSpring.set(nameSpring);
    }

    public String getNameSpringSize() {
        return nameSpringSize.get();
    }

    public StringProperty nameSpringSizeProperty() {
        return nameSpringSize;
    }

    public void setNameSpringSize(String nameSpringSize) {
        this.nameSpringSize.set(nameSpringSize);
    }


    public int getIdOrder() {
        return idOrder.get();
    }

    public IntegerProperty idOrderProperty() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder.set(idOrder);
    }

    public int getIdCategory() {
        return idCategory.get();
    }

    public IntegerProperty idCategoryProperty() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory.set(idCategory);
    }

    public String getNameOrder() {
        return nameOrder.get();
    }

    public StringProperty nameOrderProperty() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder.set(nameOrder);
    }

    public int getIdBindingCover() {
        return idBindingCover.get();
    }

    public IntegerProperty idBindingCoverProperty() {
        return idBindingCover;
    }

    public void setIdBindingCover(int idBindingCover) {
        this.idBindingCover.set(idBindingCover);
    }

    public double getCostCover() {
        return costCover.get();
    }

    public DoubleProperty costCoverProperty() {
        return costCover;
    }

    public void setCostCover(double costCover) {
        this.costCover.set(costCover);
    }

    public double getPrimeCostCover() {
        return primeCostCover.get();
    }

    public DoubleProperty primeCostCoverProperty() {
        return primeCostCover;
    }

    public void setPrimeCostCover(double primeCostCover) {
        this.primeCostCover.set(primeCostCover);
    }

    public int getIdBindingFormat() {
        return idBindingFormat.get();
    }

    public IntegerProperty idBindingFormatProperty() {
        return idBindingFormat;
    }

    public void setIdBindingFormat(int idBindingFormat) {
        this.idBindingFormat.set(idBindingFormat);
    }

    public double getCostWork() {
        return costWork.get();
    }

    public DoubleProperty costWorkProperty() {
        return costWork;
    }

    public void setCostWork(double costWork) {
        this.costWork.set(costWork);
    }

    public int getIdBindingSpring() {
        return idBindingSpring.get();
    }

    public IntegerProperty idBindingSpringProperty() {
        return idBindingSpring;
    }

    public void setIdBindingSpring(int idBindingSpring) {
        this.idBindingSpring.set(idBindingSpring);
    }

    public int getIdBindingSpringSize() {
        return idBindingSpringSize.get();
    }

    public IntegerProperty idBindingSpringSizeProperty() {
        return idBindingSpringSize;
    }

    public void setIdBindingSpringSize(int idBindingSpringSize) {
        this.idBindingSpringSize.set(idBindingSpringSize);
    }

    public double getCostSpringSize() {
        return costSpringSize.get();
    }

    public DoubleProperty costSpringSizeProperty() {
        return costSpringSize;
    }

    public void setCostSpringSize(double costSpringSize) {
        this.costSpringSize.set(costSpringSize);
    }

    public double getPrimeCostSpringSize() {
        return primeCostSpringSize.get();
    }

    public DoubleProperty primeCostSpringSizeProperty() {
        return primeCostSpringSize;
    }

    public void setPrimeCostSpringSize(double primeCostSpringSize) {
        this.primeCostSpringSize.set(primeCostSpringSize);
    }

    public int getSheet() {
        return sheet.get();
    }

    public IntegerProperty sheetProperty() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet.set(sheet);
    }

    public double getCountCover() {
        return countCover.get();
    }

    public DoubleProperty countCoverProperty() {
        return countCover;
    }

    public void setCountCover(double countCover) {
        this.countCover.set(countCover);
    }

    public double getCountSpring() {
        return countSpring.get();
    }

    public DoubleProperty countSpringProperty() {
        return countSpring;
    }

    public void setCountSpring(double countSpring) {
        this.countSpring.set(countSpring);
    }

    public double getCountWork() {
        return countWork.get();
    }

    public DoubleProperty countWorkProperty() {
        return countWork;
    }

    public void setCountWork(double countWork) {
        this.countWork.set(countWork);
    }

    public int getCount() {
        return count.get();
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public double getCostSumOne() {
        return costSumOne.get();
    }

    public DoubleProperty costSumOneProperty() {
        return costSumOne;
    }

    public void setCostSumOne(double costSumOne) {
        this.costSumOne.set(costSumOne);
    }

    public double getCostSumAll() {
        return costSumAll.get();
    }

    public DoubleProperty costSumAllProperty() {
        return costSumAll;
    }

    public void setCostSumAll(double costSumAll) {
        this.costSumAll.set(costSumAll);
    }

    public double getPrimeCostSumOne() {
        return primeCostSumOne.get();
    }

    public DoubleProperty primeCostSumOneProperty() {
        return primeCostSumOne;
    }

    public void setPrimeCostSumOne(double primeCostSumOne) {
        this.primeCostSumOne.set(primeCostSumOne);
    }

    public double getPrimeCostSumAll() {
        return primeCostSumAll.get();
    }

    public DoubleProperty primeCostSumAllProperty() {
        return primeCostSumAll;
    }

    public void setPrimeCostSumAll(double primeCostSumAll) {
        this.primeCostSumAll.set(primeCostSumAll);
    }


}
