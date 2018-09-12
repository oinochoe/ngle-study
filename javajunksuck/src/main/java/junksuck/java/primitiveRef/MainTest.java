package junksuck.java.primitiveRef;

public class MainTest {
    public static void main (String args[]) {
        main(null); // 재귀 호출. 자기 자신을 다시 호출.. stackoverflowerror 나올 것임
    }
}
