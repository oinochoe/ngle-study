package junksuck.java.flow;

import java.util.Scanner;

public class flowEx11 {
    public static void main (String[] args) {
        System.out.print("당신의 주민벊호를 입력하세요~");

        Scanner scanner = new Scanner(System.in);
        String regNo = scanner.nextLine();
        char gender = regNo.charAt(7);

        switch (gender) {
            case '1': case '3':
                switch (gender) {
                    case '1':
                        System.out.println("당신은 2000년 이전에 출생한 남자");
                        break;
                    case '3':
                        System.out.println("당신은 2000년 이후에 출생한 남자.");
                        break; //생략가능
                }
                break; // 이 break 생략 불가.
            case '2': case '4':
                switch(gender) {
                    case '2':
                        System.out.println("당신은 2000년 이전에 출생한 여자");
                        break;
                    case '4':
                        System.out.println("당신은 2000년 이후에 출생한 여자");
                }
                break;
            default:
                System.out.println("제대로 입력해");
        }
    }
}
