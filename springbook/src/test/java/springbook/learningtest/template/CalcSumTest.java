package springbook.learningtest.template;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest {
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
}
