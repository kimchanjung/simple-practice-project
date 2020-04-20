package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-19 3:45 오후
 */
class Expression {
    private var name = "찬정"

    fun shortIfExpression(msgType: Int): String {
        val result = if (msgType == 1) "안녕" else "잘가"
        println("result = $name $result")
        return result
    }

    fun onLineIfExpression(msgType: Int) = if (msgType == 1) "안녕" else "잘가"
}