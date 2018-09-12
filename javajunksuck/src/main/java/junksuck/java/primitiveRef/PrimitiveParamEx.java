package junksuck.java.primitiveRef;

class Data { int x; }

public class PrimitiveParamEx {
    public static void main (String[] args) {
        Data data = new Data();
        data.x = 10;
        System.out.println("main() : x = " + data.x);

        change(data.x); // 1000이 찍힌 부분을 호출 한 후 스택에서 사라진다.
        System.out.println("After change (data.x)");
        System.out.println("main() : x = " + data.x);
        // 10이 찍힌다. change에서 바꾼 data.x 가 아니기 때문이다. 이처럼 기본형은 저장된 값만 읽을 수 있을 뿐 변경은 안된다.
    }

    static void change(int x) {
        x = 1000;
        System.out.println("change() : x = " + x); // 1000이 찍힌다.
    }
}
