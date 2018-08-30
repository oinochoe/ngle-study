import javax.swing.*;
import java.sql.SQLOutput;

public class StringEx_2_3 {
    public static void main (String[] args) {
        String name = "Ja" + "va";
        String str = name + 8.0;

        System.out.println(name);
        System.out.println(str);
        System.out.println(7 + " ");
        System.out.println(" " + 7);
        System.out.println(7 + "");
        System.out.println("" + 7);
        System.out.println(7 + 7 + ""); //중요
        System.out.println("" + 7 + 7); //중요

        //System.out.printf("age:%d", age);
        System.out.printf("age:%d%n", 14);
        System.out.printf("age:14%n"); //"age:14"가 화면에 출력.

        System.out.printf("age: %d  year : %d", 14, 2017);
    }
}
