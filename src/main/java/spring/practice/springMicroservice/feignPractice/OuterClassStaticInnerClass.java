package spring.practice.springMicroservice.feignPractice;

import org.hibernate.event.spi.SaveOrUpdateEvent;

/**
 * Created by kimchanjung on 2020-04-25 2:57 오후
 */
public class OuterClassStaticInnerClass {
    private static final String name = "아우터네임";

    public static void outerMethod() {
        System.out.println("outer method");
    }

    public static class StaticInnerClass {
        public static void showOuterName() {
            System.out.println(name);
            // static 이라도 접근 안됨
            // OuterClassStaticInnerClass.this.test();
        }
    }
}
