package junksuck.java.operator;

public class OperatorEx8 {
    public static void main (String[] args) {
        int a = 1_000_000; // 1,000,000 1백만
        int b = 2_000_000; // 2,000,000 2백만

        long c = a * b; // a * b = 2,000,000,000 ?
        System.out.println(c);
    }
}
// -1454759936
/*
 * long c = a * b;
 * long c = 1000000 * 2000000;
 * long c = -1454759936
 *
 * 올바른 결과를 얻으려면 아래와 같이 변수 a 또는 b 의 타입을 `long`형으로 형변환해야 한다.
 *
 * long c = (long)a * b;
 * -> long c = (long)1000000 * 2000000;
 * -> long c = 1000000L * 2000000;
 * -> long c = 1000000L * 2000000L;
 * -> long c = 200000000000L; 정답
 *
 */