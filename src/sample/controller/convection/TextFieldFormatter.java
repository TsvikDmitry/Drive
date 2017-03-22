package sample.controller.convection;

import javafx.scene.control.TextFormatter;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.util.regex.Pattern;

/**
 * Created by Dima on 15.03.2017.
 */
public class TextFieldFormatter {
    public static TextFormatter<Integer> getItneger(Integer number) {

        Pattern validDoubleText = Pattern.compile("-?(\\d*)");

        TextFormatter<Integer> textFormatter = new TextFormatter<Integer>(new IntegerStringConverter(), number,
                change -> {
                    String newText = change.getControlNewText();
                    if (validDoubleText.matcher(newText).matches()) {
                        return change;
                    } else return null;
                });
        return textFormatter;
    }
    public static TextFormatter<Integer> getItneger() {

        Pattern validDoubleText = Pattern.compile("-?(\\d*)");

        TextFormatter<Integer> textFormatter = new TextFormatter<Integer>(new IntegerStringConverter(), null,
                change -> {
                    String newText = change.getControlNewText();
                    if (validDoubleText.matcher(newText).matches()) {
                        return change;
                    } else return null;
                });
        return textFormatter;
    }
    public static TextFormatter<Double> getDouble() {

        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");

        TextFormatter<Double> textFormatter = new TextFormatter<Double>(new DoubleStringConverter(), null,
                change -> {
                    String newText = change.getControlNewText();
                    if (validDoubleText.matcher(newText).matches()) {
                        return change;
                    } else return null;
                });
        return textFormatter;
    }

    public static TextFormatter<Double> getDouble(Double namber) {

        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");

        TextFormatter<Double> textFormatter = new TextFormatter<Double>(new DoubleStringConverter(), namber,
                change -> {
                    String newText = change.getControlNewText();
                    if (validDoubleText.matcher(newText).matches()) {
                        return change;
                    } else return null;
                });
        return textFormatter;
    }

    public static TextFormatter<String> getDataTime() {

        Pattern validDoubleText = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");

        TextFormatter<String> textFormatter = new TextFormatter<String>(new DefaultStringConverter(), "",
                change -> {
                    String newText = change.getControlNewText();
                    if (validDoubleText.matcher(newText).matches()) {
                        return change;
                    } else return null;
                });
        return textFormatter;
    }
}
