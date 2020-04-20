package spring.practice.kotlin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import spring.practice.kotlin.basicSyntaxPractice.Expression

/**
 * Created by kimchanjung on 2020-04-19 3:47 오후
 */
internal class ExpressionPracticeTest {

    private val expressionPractice = Expression()

    @Test
    fun `안녕이 정상적으로 반환된다`() {
        val shortIfExpression = expressionPractice.shortIfExpression(1)
        assertEquals("안녕", shortIfExpression)
    }

    @Test
    fun `잘가가 정상적으로 반환된다`() {
        val onLineIfExpression = expressionPractice.onLineIfExpression(2)
        println(onLineIfExpression)
        assertEquals("잘가", onLineIfExpression)
    }
}