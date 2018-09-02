package junksuck.java.flow;

import java.util.Scanner;

public class flowEx4 {
    public static void main (String[] args) {
        int score = 0; //점수 저장 변수
        char grade = ' '; //학점 저장하기 위한 변수, 공백 초기화

        System.out.print("점수 입력해보세요.>");
        Scanner scanner = new Scanner(System.in);
        score = scanner.nextInt();

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else {
            grade = 'C';
        }
        System.out.println("당신의 학점은 "  + grade + "입니다.");
    }
}
