package junksuck.java.flow;

public class flowEx24 {
    public static void main (String[] args) {
        int i=11;

        System.out.println("카운트 다운을 시작합니다.");

        while(i--!=0) {
            System.out.println(i);

            for (int j=0; j<2_000_000_000;j++) {
                ; // 아무런 내용도 없는 빈 문장
                //한줄로 바꿀 수 있다.
                //for (int j=0; j<2_000_000_000;j++);
            }
        }
        System.out.println("GAME OVER");
    }
}
