package junksuck.java.flow;

import java.util.Scanner;

public class flowEx9 {
    public static void main (String[] args) {
        char grade = ' ';

        System.out.print("당신의 점수를 입력하세요.(1~100>");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt(); // 화면을 통해 입력받은 숫자를 score에 저장

        switch (score) {
            case 100: case 99: case 98: case 97: case 96:
            case 95: case 94: case 93: case 92: case 91: case 90:
                grade = 'A';
                break;
            case 89:
                grade = 'B';
                break;
            case 79: case 78:
                grade = 'C';
                break;
            default:
                grade = 'F';
        }
        System.out.println("당신의 학점은 " + grade + "입니다");
    }
}
