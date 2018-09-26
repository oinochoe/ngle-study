package junksuck.java.생성자;

class Data1 {
    int value;
}

class Data2 {
    int value;

    Data2 (int x) { // 매개변수가 있는 생성자.
        value = x;
    }
}

public class ConstructorTest {
    public static void main (String[] args) {
        Data1 d1 = new Data1();
        //Data2 d2 = new Data2(); //compile error 발생
        Data2 d2 = new Data2(10); //ok
        /// Data2에는 이미 생성자 Data2(int x)가 정의 되어있으므로 기본 생성자가 추가되지 않았다.
        // 컴파일러가 자동적으로 기본생성자를 추가해주는 경우는 `클래스 내에 생성자가 하나도 없을 때` 뿐이라는 것을 명심해야 한다.
        // 위처럼 Data2(int x)를 사용하던가, 아니면 클래스 Data2에 생성자 Data2를 추가로 정의해주면 된다.
        // 기본 생성자가 컴파일러에 의해서 추가되는 경우는 클래스에 정의된 생성자가 하나도 없을 때 뿐이다.
    }
}
