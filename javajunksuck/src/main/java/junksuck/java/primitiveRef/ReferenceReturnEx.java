package junksuck.java.primitiveRef;

public class ReferenceReturnEx {
    public static void main (String[] args) {
        Data d = new Data();
        d.x = 10;

        Data d2 = copy(d);      // 아래에서 반환한 것 캐치 static Data copy (Data d)
        System.out.println("d.x = " + d.x);
        System.out.println("d2.x = " + d2.x);
    }

    static Data copy(Data d) {
        Data tmp = new Data();  // 새로운 객체 tmp를 생성한다.
        tmp.x = d.x;            // d.x의 값을 tmp.x에 복사한다.

        return tmp;             // 복사한 객체의 주소를 반환한다.
    }

    // 이 메서드의 반환타입이 `Data`이므로, 호출결과를 저장하는 변수의 타입 역시 `Data`타입의 참조변수이어야 한다.

    // copy 메서드 내에서 생성한 객체를 main메서드에서 사용할 수 있으려면, 이렇게 새로운 객체의 주소를 반환해줘야 한다.
    //
}
