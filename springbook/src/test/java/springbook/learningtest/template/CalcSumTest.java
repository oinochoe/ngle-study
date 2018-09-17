package springbook.learningtest.template;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest {
<<<<<<< HEAD
    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        //int sum = calculator.calcSum(getClass().getResource("numbers.txt").getPath()); 사용이 되지 않아 주석처리.
        int sum = calculator.calcSum("C:\\Users\\nGle\\git\\web\\springbook\\src\\test\\java\\springbook\\learningtest\\template\\numbers.txt");
        assertThat(sum, is(10)); // 10으로 바꾸면 해결된다.
        System.out.println(sum);
=======
    Calculator calculator;
    String numFilepath;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = "F:\\web\\springbook\\src\\test\\java\\springbook\\learningtest\\template\\numbers.txt";
        //int sum = calculator.calcSum("C:\\Users\\nGle\\git\\web\\springbook\\src\\test\\java\\springbook\\learningtest\\template\\numbers.txt");
    }

    @Test public void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(this.numFilepath), is(10));
    }

    @Test public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(this.numFilepath), is(24));
    }

    @Test public void concatenateStrings() throws IOException {
        assertThat(calculator.concatenate(this.numFilepath), is("1234"));
>>>>>>> d6ebc232f16363a05d85dfd332f7a52b549deefd
    }
}
