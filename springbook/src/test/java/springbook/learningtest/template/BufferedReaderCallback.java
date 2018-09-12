package springbook.learningtest.template;

import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest {
    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        //int sum = calculator.calcSum(getClass().getResource("numbers.txt").getPath()); 사용이 되지 않아 주석처리.
        int sum = calculator.calcSum("C:\\Users\\nGle\\git\\web\\springbook\\src\\test\\java\\springbook\\learningtest\\template\\numbers.txt");
        assertThat(sum, is(9)); // 10으로 바꾸면 해결된다.
        System.out.println(sum);
    }
}
