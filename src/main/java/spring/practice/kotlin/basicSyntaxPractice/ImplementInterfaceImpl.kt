package spring.practice.kotlin.basicSyntaxPractice

class ImplementInterfaceImpl(private var age: Int) : ImplementInterface {

    override val number: Int
        get() = 1

    override fun getNameInEnglish(): String {
        return "kim"
    }

    override fun isAdult() = age > 19
}