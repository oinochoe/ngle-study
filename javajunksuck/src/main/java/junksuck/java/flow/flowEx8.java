package junksuck.java.flow;

import java.util.Scanner;

public class flowEx8 {
    public static void main (String[] args) {
        System.out.print("당신의 주민번호를 입력하세요. (012345-111111)>");

        Scanner scanner = new Scanner(System.in);
        String regNo = scanner.nextLine();

        char gender = regNo.charAt(7); //입력받은 번호의 8번째 문자를 gender에 저장

        switch (gender) {
            case '1': case '3':
                System.out.println("당신은 남자");
                break;
            case '2': case '4':
                System.out.println("당신은 여자");
                break;
            default:
                System.out.println("제대로 입력해");
        }
    }
}
