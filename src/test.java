import java.util.Scanner;

public class test {

    public static void main(String[] args){
        double a = 1/Math.pow(62,1)+Math.pow(61,1)/Math.pow(62,2)+Math.pow(61,2)/Math.pow(62,3)+Math.pow(61,3)/Math.pow(62,4)+
                Math.pow(61,4)/Math.pow(62,5)+Math.pow(61,5)/Math.pow(62,6)+Math.pow(61,6)/Math.pow(62,7)+Math.pow(61,7)/Math.pow(62,8)+
                Math.pow(61,8)/Math.pow(62,9)+Math.pow(61,9)/Math.pow(62,10);
        double b = 1 - Math.pow(61,10)/Math.pow(62,10);
        System.out.print(a);
        System.out.print('\n');
        System.out.print(b);
    }
}
