package junksuck.java.operator;
public class OperatorEx13 {
    public static void main (String[] args) {
        char c1 = 'a';
        //char c2 = c1 + 1; // 라인 5 : 컴파일 에러 발생!
        char c2 = 'a' +1; //라인 6  : 컴파일 에러 없음.
        //왜 char c2 = (char)('a'+1); 를 처럼 형변환 안해줘도 될까?
        //그것은 바로 'a'+1이 리터럴 연산이기 때문이다. 상수 또는 리터럴 간의 연산은 실행과정 동안 값이 변하지 않기 때문에 컴파일 시에,
        // 컴팡일러가 계산해서 그 결과로 대체함으로써 코드를 보다 효율적으로 만든다.
        System.out.println(c2);
    }
}


