package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-24 5:18 오후
 *
 * JAVA 에서 static 멤버와 메소드를 가진 싱클톤 객체로 본다면 비슷 하다
 */

object StaticClass {
    var name = "김찬정"
    var age = 20

    fun getNameWithEnglishName() = "$name (kimchanjung)"
    fun isAdult() = age > 19
}


/**
 * default 생성자를 private로 선언하여 외부에서 객체생성을 막고
 * static factory method를 제공
 */
class StaticFactoryMethodClass private constructor() {
    var name = "김찬정"
    var age = 20


    companion object {
        /**
         * Object로 만들면 프로퍼티는 StaticFactoryMethodClass.name 처럼 스태틱으로 객체 생성없이 바로 사용 가능하지만
         * 이렇게 일반 클래스에 특정 프로퍼티만 static으로 하는 경우 아래와 같이 사용한다.
         */
        const val address = "서울"

        /**
         * @JvmStatic JAVA에서 호출 시 StaticFactoryMethodClass.Companion.of
         * -> StaticFactoryMethodClass.of 호출 되로록 해준다
         */
        @JvmStatic
        fun of(name: String, age: Int): StaticFactoryMethodClass {
            val instance = StaticFactoryMethodClass()
            instance.name = name
            instance.age = age
            return instance
        }

        fun ofNew(name: String, age: Int) = of(name + "", age)
    }

    fun getNameWithEnglishName() = "$name (kimchanjung)"
    fun isAdult() = age > 19
}