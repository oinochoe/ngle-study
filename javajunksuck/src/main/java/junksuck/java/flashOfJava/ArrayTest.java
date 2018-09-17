package junksuck.java.flashOfJava;

public class ArrayTest {
    public static void main (String[] args) {
        int[] numbers  = {4,6,5,3,3,2,3,4,2};
        int[] counter = new int[10];
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            counter[numbers[i]]++;
            System.out.print(numbers[i]);
            System.out.println(counter[3]);
        }
    }
}
