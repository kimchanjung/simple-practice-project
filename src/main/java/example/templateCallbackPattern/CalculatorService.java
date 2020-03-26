package example.templateCallbackPattern;

/**
 * Created by kimchanjung on 2020-03-26 2:26 오후
 * https://github.com/kenu/tobyspring31/blob/master/
 *
 * 3.5 템플릿과 콜백
 * p240
 */
public class CalculatorService {

    private CalcTemplate calcTemplate;
    private CalCallback calCallback;

    public CalculatorService(CalcTemplate calcTemplate, CalCallback calCallback) {
        this.calcTemplate = calcTemplate;
        this.calCallback = calCallback;
    }

    public Integer add(Integer value) {
        return (Integer) calcTemplate.calc(calCallback, 1, value);
    }


    public Integer multiply(Integer value) {
        return (Integer) calcTemplate.calc(calCallback, 2, value);
    }

    public String concat(String value) {
        return (String) calcTemplate.calc(calCallback, "abc", value);
    }
}
