package tobi.spring.templateCallbackPattern;

/**
 * Created by kimchanjung on 2020-03-26 3:17 오후
 */
public class CalCallbackMultiplyImpl implements CalCallback<Integer> {

    @Override
    public Integer doCalculator(Integer val, Integer newVal) {
        return val * newVal;
    }
}
