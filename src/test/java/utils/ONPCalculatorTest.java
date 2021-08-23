package utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ONPCalculatorTest {

    @Test
    public void testIfHeapWorksOk() {
        ONPCalculator onpCalculator = new ONPCalculator("12 2 +");
        assertThat(onpCalculator.getExpressionElements().size(), is(3));
    }

    @Test
    public void testCaseOne() {
        ONPCalculator onpCalculator = new ONPCalculator("12 2 3 4 x 10 5 / + x +");
        onpCalculator.solve();
        assertThat(onpCalculator.getResult(), is(40));
    }

    @Test
    public void testCaseTwo() {
        ONPCalculator onpCalculator = new ONPCalculator("5 1 2 + 4 x + 3 -");
        onpCalculator.solve();
        assertThat(onpCalculator.getResult(),  is(14));
    }

    @Test
    public void checkIfAddingWorks() {
        ONPCalculator onpCalculator = new ONPCalculator();

        onpCalculator.calculate("+", 2,4);
        assertThat(onpCalculator.getResult(),  is(6));
    }

    @Test
    public void checkIfSubtractWorks() {
        ONPCalculator onpCalculator = new ONPCalculator();

        onpCalculator.calculate("-", 2,4);
        assertThat(onpCalculator.getResult(),  is(2));
    }

    @Test
    public void checkIfMultiplyWorks() {
        ONPCalculator onpCalculator = new ONPCalculator();

        onpCalculator.calculate("x", 2,4);
        assertThat(onpCalculator.getResult(),  is(8));
    }

    @Test
    public void checkIfDivideWorks() {
        ONPCalculator onpCalculator = new ONPCalculator();

        onpCalculator.calculate("/", 2,4);
        assertThat(onpCalculator.getResult(),  is(2));
    }
}