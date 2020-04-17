package spring.practice.tobiSpring.templateCallbackPattern;

/**
 * Created by kimchanjung on 2020-03-26 3:23 오후
 */
public class CalCallbackConcatImpl implements CalCallback<String> {

    @Override
    public String doCalculator(String val, String newVal) {
        return val + newVal;
    }
}
