package spring.practice.springMicroservice.feignPractice;

import org.springframework.stereotype.Service;
import spring.practice.kotlin.basicSyntaxPractice.StaticFactoryMethodClass;

/**
 * Created by kimchanjung on 2020-04-16 4:05 오후
 */
@Service
public class TestService {
    private final StaticFactoryMethodClass a = StaticFactoryMethodClass.of("ddd", 11);
    public Integer getValue() {
        return 10;
    }
}
