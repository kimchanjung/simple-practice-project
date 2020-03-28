package tobi.spring.templateCallbackPattern;

/**
 * Created by kimchanjung on 2020-03-26 2:30 오후
 */
public interface CalCallback<T> {
    T doCalculator(T val, T newVal);
}
