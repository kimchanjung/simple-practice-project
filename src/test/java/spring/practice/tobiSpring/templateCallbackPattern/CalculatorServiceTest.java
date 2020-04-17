package spring.practice.tobiSpring.templateCallbackPattern;



import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by kimchanjung on 2020-03-26 3:08 오후
 */
public class CalculatorServiceTest {


    @Test
    public void 덧셈이_성공한다() {
        CalculatorService<Integer> calculatorService = new CalculatorService<>(new CalcTemplate(), new CalCallbackAddImpl());
        assertThat(calculatorService.add(5)).isEqualTo(6);
    }


    @Test
    public void 곱셈이_성공한다() {
        CalculatorService<Integer> calculatorService = new CalculatorService<>(new CalcTemplate(), new CalCallbackMultiplyImpl());
        assertThat(calculatorService.multiply(5)).isEqualTo(10);
    }

    @Test
    public void 문자열_이어붙임이_성공한다() {
        CalculatorService<String> calculatorService = new CalculatorService<>(new CalcTemplate(), new CalCallbackConcatImpl());
        assertThat(calculatorService.concat("def")).isEqualTo("abcdef");
    }
}