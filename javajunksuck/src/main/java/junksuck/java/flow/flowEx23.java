package junksuck.java.flow;

public class flowEx23 {
    public static void main (String[] args) {
        int i = 5;

        while(--i!=0) {
            System.out.println(i + " - I can do it.");
        }
        // 전위형이기 때문에 분리하면 안된다.
    }
}
