package sample.controller.convection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dima on 23.02.2017.
 */
public class TimeConv {

    String myTime;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat Hous = new SimpleDateFormat("HH");
    SimpleDateFormat Minets = new SimpleDateFormat("mm");

    Date date = null;

    public TimeConv(String myTime) throws ParseException {
        //new Print(getClass(),"");
        this.date = sdf.parse(myTime);
    }

    public String getHous() {
        return ""+Hous.format(date);
    }

    public String getMinets() {
        return ""+Minets.format(date);
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
