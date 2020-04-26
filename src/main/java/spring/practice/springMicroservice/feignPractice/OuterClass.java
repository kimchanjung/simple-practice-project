package spring.practice.springMicroservice.feignPractice;

/**
 * Created by kimchanjung on 2020-04-25 2:50 오후
 */
public class OuterClass {

    private String outerName = "아우터네임";

    public void outerMethod() {
        System.out.println("outer method");
    }

    public class InnerClass {
        public void showOuterName() {
            System.out.println(outerName);
            OuterClass.this.outerMethod();
        }
    }
}


