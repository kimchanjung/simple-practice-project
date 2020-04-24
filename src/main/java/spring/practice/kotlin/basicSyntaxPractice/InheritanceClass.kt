package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-23 3:27 오후
 */


/**
 * 클래스, 메소드, 멤버프로퍼티를 오버라이드 가능케 하려면 open 키워드를
 * 붕여야한다
 *
 */
open class Parent(name: String, age: Int) {
    var name: String
    var age: Int

    init {
        println("start parent int = $name , age = $age")
        this.name = name
        this.age = age
        println("end parent int - this.name = " + this.name + ", this.age = " + this.age)
    }

    fun isAdultParentMethod() = age > 20
    open fun getNameInEnglish(): String {
        return "kim"
    }
}

class Child(name: String, age: Int, address: String) : Parent(name, age) {
    var address: String

    init {
        println("start  child int - super.name = " + super.name + ", super.age = " + super.age)
        this.name = name + "이"
        this.age = age + 1
        this.address = address
        println("end child int - super.name = " + super.name + ", super.age = " + super.age)
        println("end child int - this.name = " + this.name + ", this.age = " + this.age)
    }

    override fun getNameInEnglish(): String {

        return "child kim"
    }
}