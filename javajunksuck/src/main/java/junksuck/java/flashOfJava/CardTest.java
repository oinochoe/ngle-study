package junksuck.java.flashOfJava;

public class CardTest {

    public static void main (String[] args) {
        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;
        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;
        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + " )");
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + " )");
        c1.width = 200;
        c1.height = 50;
        c1.kind = "안녕";
        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + " )");
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + " )");
    }
}
class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 200;
}