package junksuck.java.primitiveRef;

public class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    // static int cv2 = iv                  // 에러. 클래스변수는 인스턴스 변수를 사용할 수 없음.
    static int cv2 = new MemberCall().iv;    // 이처럼 객체를 생성해야 가능

    static void staticMethod1() {
        System.out.println(cv);
        // System.out.println(iv);           // 에러. 클래스메서드에서 인스턴스 변수를 사용 하지 못함.
        MemberCall c = new MemberCall();
        System.out.println(c.iv);           // 객체 생성 후 인스턴스 변수를 참조만 가능
    }

    void instanceMethod1() {
        System.out.println(cv);             // 인스턴스 메서드에서는 클래스 변수르 사용가능하다.
        System.out.println(iv);             // 인스턴스 메서드에서는 인스턴스 변수를 바로 사용 가능
    }

    static void staticMethod2() {
        staticMethod1();
        // instanceMethod1();               // 에러. 클래스메서드에서는 인스턴스 메서드 호출 불가
        MemberCall c = new MemberCall();
        c.instanceMethod1();                // 인스턴스를 생성한 후에야 메서드 호출 가능
    }

    void instanceMethod2() {                // 인스턴스 메서드에서는 인스턴스 메서드와 클래스 메서드
        staticMethod1();                    // 둘다 그냥 호출 가능하다.
        instanceMethod1();
    }

    // 수학에서 대입법처럼 c = new MemberCall()이므로 c.으로 접근 해서 바로 대입사용 가능하다.

    // MemberCall c = new MemberCall();
    // int result = c.instanceMethod1();

    // 위의 두 줄을 한줄로!

    // int result = new MemberCall().instanceMethod1();
    // 하지만 이 인스턴스의 경우 재사용이 불가능하다. 참조변수 c를 선언하지 않았기 때문이다.

}
