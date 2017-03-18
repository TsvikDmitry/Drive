package sample.convection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

/**
 * Created by Dima on 23.02.2017.
 */
public class ToDate {


    Date toDay = new Date();
    DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat time = new SimpleDateFormat("HH:mm:ss");
    DateFormat Hous = new SimpleDateFormat("HH");
    DateFormat Minets = new SimpleDateFormat("mm");

    public String getToDay() {
        return ""+date.format(toDay);
    }

    public String getTime() {
        return ""+time.format(toDay);
    }

    public String getHous() {
        return ""+Hous.format(toDay);
    }

    public String getMinets() {
        return ""+Minets.format(toDay);
    }







/*
    public LocalDateTime ToDate(String str) {

        String pattern = "yyyy-MM-dd HH:mm:ss.0";
        //String str = "2017-02-03 12:12:00.0";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        LocalDateTime date = LocalDateTime.parse(str, formatter);

        //System.out.println(date.getYear()+"."+date.getMonth()+"."+date.getDayOfMonth());
       // System.out.println(date.getHour()+":"+date.getMinute());
        return date;
    }*/

}
