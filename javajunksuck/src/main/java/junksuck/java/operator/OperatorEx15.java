package junksuck.java.operator;
public class OperatorEx15 {
    public static void main (String[] args) {
        char lowerCase = 'a';
        char upperCase = (char)(lowerCase - 32);
        // 이렇게 계산하지 않고 upper와 lower메서드를 주로 쓴다.
        System.out.println(upperCase);
        //(char) 형변환 이유는 char형과 int형 간의 뺄셈연산의 결과가 int형이기 때문입니다.
    }
}


