package junksuck.java.flow;

public class flowEx15 {
    public static void main (String[] args) {
        System.out.println("i\t\t2*i\t\t2*i-1\ti*i\t\t11-i\ti%3\t\ti/3");
        System.out.println("---------------------------------------------------");

        for (int i=1; i <= 10; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d%n", i, 2*i, 2*i-1, i*i, 11-i, i%3, i/3);
        }
    }
}
