package spring.practice.tobiSpring.templateCallbackPattern;

/**
 * Created by kimchanjung on 2020-03-26 2:33 오후
 */
public class CalCallbackAddImpl implements CalCallback<Integer> {
    @Override
    public Integer doCalculator(Integer val, Integer newVal) {
        return val + newVal;
    }
}
