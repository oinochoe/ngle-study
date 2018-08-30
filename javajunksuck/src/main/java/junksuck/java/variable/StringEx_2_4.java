package junksuck.java.variable;

public class StringEx_2_4 {
    public static void main (String[] args) {
        byte b = 1;
        short s = 2;
        char c = 'A';

        int finger = 10;
        long big = 100_000_000_000L; //long big = 100000000000
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;

        int octNum = 010; // 8진수 10, 10진수로는 8
        int hexNum = 0x10; // 16진수 10, 10진수로는 16
        int binNum = 0b10; // 2진수 10, 10진수로는 2

        System.out.printf("b=%d%n", b);
        System.out.printf("s=%d%n", s);
        System.out.printf("c=%c, %d %n", c, (int)c);
        System.out.printf("finger= [%5d]%n", finger);
        System.out.printf("finger= [%-5d]%n", finger);
        System.out.printf("finger= [%05d]%n", finger);
        System.out.printf("big=%d%n", big);
        System.out.printf("hex=%#x%n", hex);
        System.out.printf("octNum=%o, %d%n", octNum, octNum);
        System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);
        System.out.printf("bigNum=%s, %d%n", Integer.toBinaryString(binNum), binNum);
        // '0' 과 '-' 가 어떤역할을 하는지 설명하지 않아도 알 수 있다.
        // 지시자 %x와 %o에 #를 사용하면 접두사 0x와 0이 각각 붙는다.







    }
}
