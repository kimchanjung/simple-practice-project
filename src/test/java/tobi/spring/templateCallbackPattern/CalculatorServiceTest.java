package tobi.spring.templateCallbackPattern;



import org.junit.jupiter.api.Test;
import tobi.spring.templateCallbackPattern.*;


import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by kimchanjung on 2020-03-26 3:08 오후
 */
public class CalculatorServiceTest {


    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService(new CalcTemplate(), new CalCallbackAddImpl());
        assertEquals(calculatorService.add(5),6);
    }


    @Test
    public void testMultiply() {
        CalculatorService calculatorService = new CalculatorService(new CalcTemplate(), new CalCallbackMultiplyImpl());
        assertEquals(calculatorService.multiply(5), 10);
    }

    @Test
    public void testConcat() {
        CalculatorService calculatorService = new CalculatorService(new CalcTemplate(), new CalCallbackConcatImpl());
        assertEquals(calculatorService.concat("def"), "abcdef");
    }
}