package junksuck.java.생성자;

public class StaticBlockTest {
   static int [] arr = new int[10];

   static {
       for (int i=0; i < arr.length; i++) {
           // 1과 10사이의 임의의 값을 배열 arr에 저장
           arr[i] = (int) (Math.random() * 10) + 1;
       }
   }

   public static void main (String args[]) {
       for (int i=0; i < arr.length; i++) {
           System.out.println("arr[" + i + "] :" + arr[i]);
       }
   }

   // 배열이나 예외처리가 필요한 초기화에서는 명시적 초기화만으로는 복잡한 초기화 작업을 할 수 없다
    // 추가적으로 클래스 초기화 블럭을 사용하도록 한다.
}


