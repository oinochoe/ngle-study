package junksuck.java.variable;

public class OperatorEx5 {
    public static void main (String[] args) throws ArithmeticException{
        try {
            System.out.println(3/0); // 실행하면, 오류(ArithmeticException) 발생!!!

        } catch (ArithmeticException e){
            e.printStackTrace();
            return;
        } finally {
            System.out.println("게임끝");
            System.out.println(3/0.0); //Infinity가 출력
        }

    }
}
