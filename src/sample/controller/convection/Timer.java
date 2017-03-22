package sample.controller.convection;

/**
 * Created by Dima on 21.03.2017.
 */
public class Timer {

    public static long TimeStart() {
/*
Long start = Timer.TimeStart();
            Timer.TimeFinish(getClass().getName(),start);
*
* */
        long start = System.currentTimeMillis();
        return start;
    }
    public static void TimeFinish(String s,long start){

        long finish = System.currentTimeMillis() - start;
        System.out.println("Timer: "+ s+"  "+finish);
        //return finish;
    }
}
