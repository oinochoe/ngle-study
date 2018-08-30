package junksuck.java.variable;

public class StringEx_2_7 {
    public static void main (String[] args) {
        char ch = 'A'; // char ch = 65
        int code = (int)ch; // ch에 저장된 값을 int 타입으로 변환하여 저장

        System.out.printf("%c=%d(%#X)%n", ch, code, code); // ch 는 16 진수로 0X41(#X)

        char hch= '가'; //char hch = 0xAC00;
        System.out.printf("%c=%d(%#X)%n", hch, (int)hch, (int)hch);

        /*
         * char hch = 0xAC00
         * char hch = '\uAC00' 이렇게도 가능. 유니코드
         */
    }
}
