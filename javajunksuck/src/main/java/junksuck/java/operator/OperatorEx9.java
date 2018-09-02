package junksuck.java.operator;

public class OperatorEx9 {
    public static void main (String[] args) {
        long a = 1_000_000 * 1_000_000; // 형변환 필요
        long b = 1_000_000 * 1_000_000L;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}


