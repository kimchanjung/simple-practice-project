package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-24 1:54 오후
 */

abstract class AbstractClass(name: String) {
    open var name: String = "NO NAME"
        set(value) {
            println("AbstractClass name setter $value")
            field = value
        }
    var age: Int = 0

    init {
        this.name = name + "이다"
        println("AbstractClass this.name = " + this.name)
    }

    fun isAdult() = age > 19
    abstract fun getNameInEnglish(): String
}

class AbstractClassImpl(name: String, age: Int, address: String) : AbstractClass(name) {
    override lateinit var name: String
    var address: String = address

    init {
        println("impl super.age = " + super.age + ", super.name = " + super.name)
        this.name = name
        this.age = age
        println("impl super.age end = " + super.age + ", super.name = " + super.name)
        println("impl this.age end = " + this.age + ", this.name = " + this.name)
    }

    override fun getNameInEnglish(): String {
        println("super.name = " + super.name)
        return "kimchanjung"
    }
}