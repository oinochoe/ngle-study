package junksuck.java.operator;

public class OperatorEx6 {
    public static void main (String[] args) throws RuntimeException {
        byte a = 10;
        byte b = 20;
        try {
            byte c = (byte)(a + b); // 컴파일 에러가 발생한다 명시적으로 형변환이 필요하다. byte c = (byte) (a+b);
            System.out.println(c);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
