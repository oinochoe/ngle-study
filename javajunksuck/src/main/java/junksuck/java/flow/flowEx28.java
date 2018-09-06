package junksuck.java.flow;

import java.util.Scanner;

public class flowEx28 {
    public static void main (String[] args) {
        int input = 0;
        int answer = 0;

        answer = (int) (Math.random() * 100) + 1; // 1~100 사이의 임의으 수를 저장
        Scanner scanner = new Scanner (System.in);

        do {
            System.out.println(answer);
            System.out.print("1과 100사이의 정수를 입력하세요.>");
            input = scanner.nextInt();

            if (input > answer) {
                System.out.print("1과 100사이의 정수를 입력하세요.>");
                input = scanner.nextInt();
            } else if (input < answer) {
                System.out.println("더 큰 수로 다시 시도해보세요.");
            }
        } while (input != answer);

        System.out.println("정답입니다.");

    }

}
