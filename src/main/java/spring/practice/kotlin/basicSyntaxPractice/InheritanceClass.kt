package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-23 3:27 오후
 */


open class Parent(name: String, age: Int) {
    var name: String
    var age: Int

    init {
        this.name = name
        this.age = age
    }

    fun isAdultParentMethod() = age > 20
    open fun getNameInEnglish(): String {
        return "kim"
    }
}

class Child(name: String, age: Int) : Parent(name, age) {

    init {
        this.age = age + 1
    }

    override fun getNameInEnglish(): String {
        return "child kim"
    }
}