package example.templateCallbackPattern;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by kimchanjung on 2020-03-26 3:08 오후
 */
public class CalculatorServiceTest {


    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService(new CalcTemplate(), new CalCallbackAddImpl());
        assertThat(calculatorService.add(5), is(6));
    }


    @Test
    public void testMultiply() {
        CalculatorService calculatorService = new CalculatorService(new CalcTemplate(), new CalCallbackMultiplyImpl());
        assertThat(calculatorService.multiply(5), is(10));
    }

    @Test
    public void testConcat() {
        CalculatorService calculatorService = new CalculatorService(new CalcTemplate(), new CalCallbackConcatImpl());
        assertThat(calculatorService.concat("def"), is("abcdef"));
    }
}