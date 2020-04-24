package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-23 4:07 오후
 */

class ImplementInterfaceImpl(private var age: Int) : ImplementInterface {

    override val number: Int
        get() = 1

    override fun getNameInEnglish(): String {
        return "kim"
    }

    override fun isAdult() = age > 19
}