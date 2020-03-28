package tobi.spring.templateCallbackPattern;


/**
 * Created by kimchanjung on 2020-03-26 2:28 오후
 */
public class CalcTemplate {
    public <T> T calc(CalCallback<T> calCallback, T intValue,  T value) {
        return calCallback.doCalculator(intValue, value);
    }
}
