package junksuck.java.primitiveRef;

public class FactorialTest {
    public static void main (String[] args) {
        int result = factorial(5);

        System.out.println(result);
    }

    static int factorial(int n) {
        int result = 0;

        if ( n == 1) {
            result = 1;
        } else {
            result = n * factorial(n-1); // 다시 메서드 자신을 호출
        }
        return result;
    }
    // 5! = 5 * 4 * 3 * 2 * 1 = 120
    // f(n) = n * f(n-1), 단 f(1) = 1

    /*
    * 현재 n의 값이 0인 경우는 if문의 조건식이 절대 참이 될 수 없기 때문에 계속해서 재귀호출만 일어날 뿐 메서드가 종료되지 않으므로
    * 스택에 계속 데이터만 쌓여 간다.
    */
}
