package junksuck.java.operator;

public class OperatorEx7 {
    public static void main (String[] args) {
        byte a = 10;
        byte b = 30;
        byte c = (byte) (a * b);
        System.out.println(c);
        // 왜 44?
        /*
         * 10 * 30 = 300
         * 큰 자료형에서 작은 자료형으로 변환하면 데이터의 손실이 발생.
         * 이러한 값 손실이 없게하기 위해서는 충분히 큰 자료형을 사용해야 한다.
         */
    }
}
