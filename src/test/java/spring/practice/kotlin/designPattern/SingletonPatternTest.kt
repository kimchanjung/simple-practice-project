package spring.practice.kotlin.designPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import spring.practice.kotlin.basicSyntaxPractice.SimpleClass

/**
 * Created by kimchanjung on 2020-05-02 5:25 오후
 */
internal class SingletonPatternTest {

    @Test
    fun 싱글톤이_정상적으로_생성된다() {
        // Given
        val likeJavaSingletonPattern = LikeJavaSingletonPattern.getInstance("김찬정")
        val likeJavaSingletonPattern2 = LikeJavaSingletonPattern.getInstance("김찬정")

        // When & Then
        assertTrue(SingletonPattern == SingletonPattern)
        assertTrue(likeJavaSingletonPattern == likeJavaSingletonPattern2)
    }
}