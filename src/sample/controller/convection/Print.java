package sample.controller.convection;

/**
 * Created by Admin on 26.03.2017.
 */
public class Print {

    public Print(Class<? extends TimeConv> clas, String data ) {
            System.out.println(clas.getName()+": "+data);
    }
    public Print(String data1, String data2 ) {
        System.out.println(data1+": "+data2);
    }
    public Print(String data1, Integer data2 ) {
        System.out.println(data1+": "+data2);
    }

    public Print(Integer data2 ) {
        System.out.println(" - :"+data2);
    }
    public Print(String data2 ) {
        System.out.println(" - :"+data2);
    }
    //new Print(getClass(),"");
}
