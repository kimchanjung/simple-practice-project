package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-28 2:05 오후
 */


/**
 * 기본 함수 선언 방식
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 기본 함수 선언 방식을 람다식으로 표현
 */
val sumLambda: (Int, Int) -> Int = { a, b -> a + b }


/**
 * 코틀린 함수 선언 방식
 */
fun sum2(a: Int, b: Int) = a + b

/**
 * 코틀린 함수 선언 방식을 람다식으로 표현
 */
val sum2Lambda = { a: Int, b: Int -> a + b }