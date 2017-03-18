package sample.convection;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Dima on 23.02.2017.
 */
public class Calendar {
    public Calendar(DatePicker dataCreateOrder) {


        dataCreateOrder.setOnAction(event -> {
            LocalDate date = dataCreateOrder.getValue();
            //System.out.println("Selected date: " + date);
        });


        String pattern = "yyyy-MM-dd";
        dataCreateOrder.setShowWeekNumbers(false);
        dataCreateOrder.setPromptText(pattern.toLowerCase());
        dataCreateOrder.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

    }


}
