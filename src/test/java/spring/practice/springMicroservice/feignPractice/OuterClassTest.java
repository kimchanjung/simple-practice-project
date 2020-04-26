package spring.practice.springMicroservice.feignPractice;

import org.junit.jupiter.api.Test;

/**
 * Created by kimchanjung on 2020-04-25 2:51 오후
 */
class OuterClassTest {

    @Test
    public void test() {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.showOuterName();

        OuterClassStaticInnerClass.StaticInnerClass.showOuterName();
    }
}