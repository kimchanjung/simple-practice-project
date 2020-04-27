package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-25 2:15 오후
 *
 *
 */

class OuterClass {
    val outerName = "아우터네임"

    companion object {
        val staticOuterName = "정적아우터네임"
    }

    /**
     * static 키워드가 붇지 않았지만 static 멤버 클래스다
     * OuterClass.StaticNestedClass() 로 객체 생성한다.
     * Outerclass의 멤버에 접근을 할 수 없다.
     * static 멤버에는 접근이 가능함
     *
     */
    class StaticNestedClass {
        val nestedName = "내부네임"
        fun getOuterName() = println("StaticNestedClass - $nestedName $staticOuterName");
    }

    /**
     * non static 멤버 클래스
     * OuterClass().InnerClass()로 객체 생성
     * OuterClass의 non-static 멤버도 접근 가능함
     * 사실 이건 접근제어라기 보다 클래스가 static/non-static 차이에서 발생하는 자연스런 접근 제한
     */
    inner class InnerClass {
        val nestedName = "내부네임 "
        fun getOuterName() = println("InnerClass - $outerName $staticOuterName");
    }
}
