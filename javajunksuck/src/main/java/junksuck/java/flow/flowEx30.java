package junksuck.java.flow;

public class flowEx30 {
    public static void main (String[] args) {
        int sum = 0;
        int i = 0;

        while(true) {
            if(sum > 100) {
                break; // 이부분이 실행되면 while문을 완전 벗어난다.
            }
            ++i;
            sum += i;
        } // end of while
        System.out.println("i=" + i);
        System.out.println("sum" + sum);
    } // main
}
