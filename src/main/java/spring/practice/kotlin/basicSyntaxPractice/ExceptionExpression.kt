package spring.practice.kotlin.basicSyntaxPractice

import java.lang.Integer.parseInt

/**
 * Created by kimchanjung on 2020-04-28 4:49 오후
 * 코틀린 예외는 cheked와 unchecked 구문없다
 * 모든 예외는 unchecked다 
 */

/**
 * 예외 처리 블럭이 if, when 처 표현식 처럼 동작한다.
 * value가 숫자형이 아니면 null이 result 할당된다
 */
fun exception(value: String): Int? {
    val result: Int? = try {
        parseInt(value)
    } catch (e: NumberFormatException) {
        null
    }

    return result
}

/**
 * 변수에 할당 하지 않고 바로 반환
 */
fun exception2(value: String): Int? {
    return try {
        parseInt(value)
    } catch (e: NumberFormatException) {
        null
    }
}

/**
 * name이 null 이면 예외 발생 시킨다.
 */
fun exception3(name: String?): String {
    return name ?: throw IllegalArgumentException("이름을 입력 하세요")
}