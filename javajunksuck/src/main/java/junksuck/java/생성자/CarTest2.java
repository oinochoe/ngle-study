package junksuck.java.생성자;

class Car2 {
    String color;       // 색상
    String gearType;    // 변속기 종류 - auto (자동), manual(수동)
    int door;           // 문의 개수

    Car2 () {
        this("white", "auto", 4);
    }

    Car2 (String color) {
        this(color, "auto", 5);
    }

    Car2 (String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    // this.color는 인스턴스 변수, color는 생성자의 매개변수로 정의된 지역변수.
    // 만일 위의 코드에서 this.color = color 대신에 color=color로 하면 둘다 지역변수로 간주된다.
    // this는 참조변수로 인스턴스 자신을 가리킨다.
}

class CarTest2 {
    public static void main (String[] args) {
        Car2 c1 = new Car2();
        Car2 c2 = new Car2("blue");
        Car2 c3 = new Car2("blue", "dragon", 3);

        System.out.println("c1의 color =" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
        System.out.println("c2의 color =" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);
        System.out.println("c3의 color =" + c3.color + ", gearType=" + c3.gearType + ", door=" + c3.door);
    }
}