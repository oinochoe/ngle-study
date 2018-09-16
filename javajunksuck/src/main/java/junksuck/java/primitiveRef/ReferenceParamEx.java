package junksuck.java.primitiveRef;

// class Data { int x; }
// 같은 패키지 내에 default 클래스로 생성되어있기 때문에 생략

public class ReferenceParamEx {
    public static void main (String[] args) {
        Data data = new Data();
        data.x = 10;
        System.out.println("main() : x  =" + data.x);

        change(data);
        System.out.println("After change(data)");
        System.out.println("main() : x = " + data.x); // 1000이 찍힌다. 참조 변수 1000을 바꾼 것이므로
    }
    /*
    * change 메서드의 매개변수가 참조형이라서 값이 아니라 '값이 저장된 주소'를 change메서드에게 넘겨주었기 때문에
    * 값을 읽어오는 것뿐만 아니라 변경하는 것도 가능하다.
    *
    */

    static void change(Data data) {
        data.x = 1000;
        System.out.println("change() : x = " + data.x); // 1000이 찍힌다.
    }
}
