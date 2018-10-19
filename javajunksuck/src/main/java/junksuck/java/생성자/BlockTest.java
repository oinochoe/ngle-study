package junksuck.java.생성자;

public class BlockTest {
    // 클래스 초기화
    static {
        System.out.println("static { }");
    }

    // 인스턴스 초기화
    {
        System.out.println("{ }");
    }

    public BlockTest() {
        System.out.println("생성자");
    }

    public static void main (String args[]) {
        // 클래스 초기화 블럭은 처음 메모리에 로딩될 때 한번 수행
        // 인스턴스 초기화 블럭은 인스턴스가 생성될 때마다 수행
        System.out.println("BlockTest bt = new BlockTest(); ");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt2 = new BlocTest(); ");
        BlockTest bt2 = new BlockTest();
    }
}


