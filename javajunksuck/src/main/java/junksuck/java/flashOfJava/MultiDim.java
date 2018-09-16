package junksuck.java.flashOfJava;

public class MultiDim {
    public static void main(String[] args) {
        int[][] score = new int[5][];
        score[0] = new int[4];
        score[1] = new int[3];
        score[2] = new int[2];
        score[3] = new int[2];
        score[4] = new int[3];
        System.out.println("score.length=" + score.length);
        System.out.println("score[0].length=" + score[0].length);
        System.out.println("score[1].length=" + score[1].length);
        System.out.println("score[2].length=" + score[2].length);
        System.out.println("score[3].length=" + score[3].length);
        System.out.println("score[4].length=" + score[4].length);
    }
}
