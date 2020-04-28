package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-28 2:31 오후
 */

/**
 * Higher Order 함수 선언
 * 매개변수로 다른 함수나 람다식을 인자로 받는 함수를 말한다
 */
fun calculator(a: Int, b: Int, exec: (value1: Int, value2: Int) -> Int): Int {
    return exec(a, b)
}

fun calculator2(exec: () -> Int) = exec()

/**
 * Higher Order 함수는 사용시(호출)에 파라메터로 전달되는 함수가
 * 사실상 new 해서 새로운 객체가 매번 생기는 방식으로 동작한다. 사실상 비효울 적이다
 * 이런 경우 inline 키워드를 사용하면 파라메터로 전달되는 모든 함수가 매번 new 생성 되는 것이 아니라
 * Higher Order 함수 내부에 있게 된다.
 * 결론 적으로 매번 새로운 객체가 생성되는 것이 아니게 된다.
 * inline선언해서 모든 파라메터 함수가  매번 new 하지 않게 되었지만
 * 파라메터로 전달되는 함수 앞에 noinline을 선언하면  new 해서 생성되게 된다.
 */
inline fun calculator3(a: Int, exec: (value: Int) -> Int, noinline exec2: (value: Int) -> Int): Int {
    return exec(a) + exec2(a)
}
