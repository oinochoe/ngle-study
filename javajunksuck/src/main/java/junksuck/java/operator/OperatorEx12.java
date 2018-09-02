package junksuck.java.operator;

public class OperatorEx12 {
    public static void main (String[] args) {
        char c1 = 'a'; // c1에는 문자 'a'의 코드 값인 97이 저장
        char c2 = c1; // c1에 저장되어있는 값이 c2에 저장된다.
        char c3 = ' '; //c3를 공백으로 초기화한다.

        int i = c1 + 1;  // 'a' + 1 -> 97+1 -> 98

        c3 = (char) (c1 + 1); // 덧셈 연산 c1+1의 결과가 int이므로 이 결과를 char형 변수 c3에 담기 위해서는 char형으로의 형변환이 필요하다.
        c2++;
        c2++;
        System.out.println("i=" + i);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);

    }
}
// c2++; 대신에 c2=c2+1을 사용하면 에러가 발생할 것이다. c2+1의 연산결과는 int형이며, 그 결과를 다시 c2에 담으려면 형 변환 연산자를 사용하여 char형으로 형변환해야 하기 때문이다.


