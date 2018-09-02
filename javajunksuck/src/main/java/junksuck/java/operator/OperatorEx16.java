package junksuck.java.operator;
public class OperatorEx16 {
    public static void main (String[] args) {
        float pi = 3.141592f;
        float shortPi = (int) (pi * 1000) / 1000f;
        System.out.println(shortPi);
        // int형 간의 나눗셈 'int / int'를 수행하면 결과가 float나 double이 아닌 int임에 주의
        // 그리고 나눗셈의 결과를 반올림하는 것이 아니라 버린다는 점도 꼭 기억하자.
        // 예를 들어 '3 / 2'의 결과는 1.5 또는 2가 아니라 1이다.
    }
}


