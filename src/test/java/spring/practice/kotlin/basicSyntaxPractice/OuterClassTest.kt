package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-25 2:18 오후
 */
internal class OuterClassTest {

    @Test
    fun 중첩_클래스가_정상적으로_동작한다() {
        // Given
        val staticNestedClass = OuterClass.StaticNestedClass()
        val innerClass = OuterClass().InnerClass()

        // When
        staticNestedClass.getOuterName()
        innerClass.getOuterName()
    }
}