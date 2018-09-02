package junksuck.java.flow;

import java.util.Scanner;

public class flowEx6 {
    public static void main (String[] args) {
        System.out.print("현재 월을 입력하세요. > ");

        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt(); //화면을 통해 입력받은 숫자를 month에 저장

        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("현재의 계쩔 봄");
                break;
            case 6: case 7: case 8:
                System.out.println("현재 여름");
                break;
            case 9: case 10: case 11:
                System.out.println("가을");
                break;
            default:
                System.out.println("겨울");
        }
    }
}
