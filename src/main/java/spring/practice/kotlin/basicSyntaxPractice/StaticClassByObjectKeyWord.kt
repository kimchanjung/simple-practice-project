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


class StaticFactoryMethodClass() {
    var name = "김찬정"
    var age = 20

    companion object {
        fun of(name: String, age: Int):StaticFactoryMethodClass {
            val instace = StaticFactoryMethodClass()
            instace.name = name
            instace.age = age
            return instace
        }

        fun ofNew(name: String, age: Int) = of(name+"" , age)
    }

    fun getNameWithEnglishName() = "$name (kimchanjung)"
    fun isAdult() = age > 19
}