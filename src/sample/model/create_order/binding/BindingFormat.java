package sample.model.create_order.binding;

import javafx.beans.property.*;

/**
 * Created by Dima on 14.03.2017.
 */
public class BindingFormat {


    public BindingFormat(){
        this.idBindingFormat = new SimpleIntegerProperty();
        this.nameFormat = new SimpleStringProperty();
        this.visible = new SimpleBooleanProperty();


    }

    private IntegerProperty idBindingFormat;
    private StringProperty nameFormat;
    private BooleanProperty visible;

    public String getNameFormat() {
        return nameFormat.get();
    }

    public StringProperty nameFormatProperty() {
        return nameFormat;
    }

    public void setNameFormat(String nameFormat) {
        this.nameFormat.set(nameFormat);
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



    public boolean isVisible() {
        return visible.get();
    }

    public BooleanProperty visibleProperty() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible.set(visible);
    }
}
