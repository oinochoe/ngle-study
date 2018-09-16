package junksuck.java.flashOfJava;

public class InitTest {
    static int cv = 1;
    int iv = 1;

    static { cv = 2; }
    { iv = 2; }

    InitTest () {
        iv = 3;
    }

    public static void main (String[] args) {
        InitTest i = new InitTest();
        System.out.println(cv);
        System.out.println(i.iv);
    }
}
