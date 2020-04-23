package spring.practice.kotlin.basicSyntaxPractice

import kotlin.concurrent.thread

/**
 * Created by kimchanjung on 2020-04-19 4:48 오후
 */

/**
 * 코틀린은 자바와 다르게 멤버필드 멤버변수가 아니라 프로퍼티라고 명칭한다
 * 프로퍼티는 멤버필드 + 접근자(getter/setter) 로 구성되며 코틀린은 프로퍼티를 선언하면
 * 마치 java에서 멤버변수를 선언한 것 처럼 보이지만 사실은 멤버 필드에 getter/setter가 선언 되어 있는 것이라고 보면된다
 *
 * 코틀린에서
 * var name:String으로 선언하면
 *
 * 자바에서는 아래처럼
 * private String name
 * public String getName()
 * public void setName()
 * private 필드에 getter/setter가 있는 형태로 구성된다.
 */

/**
 * 아주 간단한 클래스 선언
 * class SimpleBasicConstructor (var name: String, var address: String) <= 이 부분이 기본 생성자
 * 파라메터 선언에서 var name: String <= var 를 붙이면 파라메터 및 프로퍼티 선언이 동시에 되는 것임
 * name: String <= 선언하면 생성자의 파라메터로만 선언된 것이고 프로퍼티로 선언 된것이 아님
 * simpleBasicConstructor.name 으로 할 수 없음 프로퍼티 자체가 없기 때문임
 * var age: Int = 41 <= 객체 생성시 생성자의 파라메터에 값을 넣지 않는 경우 default값을 선언 할 수 있다.
 */
class SimpleClass(val name: String, var address: String, var age: Int = 41)


/**
 * 클래스 선언
 */
class BasicConstructor(_name: String, _address: String, age: Int) {
    var name: String = _name // 프로퍼티선언과 동시에 생성자 파라메터로 값 설정을 동시

    var address: String
        get() {
            return "$field 특별시"
        }

    var age: Int

    /**
     * 초기화 메소드 디폴트 생성자의 함수 블럭이라고 보면 된다. java로 보면 아래와 같다
     *
     * public class BasicConstructor {
     *     public BasicConstructor(String name, String address, Intger age) {
     *          this.name = name;
     *          this.address = address;
     *          this.age = age;
     *     }
     * }
     */
    init {
        address = _address
        this.age = age
    }
}

/**
 * 생성자를 오버로딩한다.
 * constructor(name: String, address: String, age: Int) : this(name)
 *  : this(name) 은 디폴트 생성자를 호출 하는 것 이 구문이 없으면 오류난다.
 */
class OverLoadingConstructor(name: String) {
    var name: String
    var address: String = ""
    var age: Int = 0

    init {
        this.name = name
    }

    constructor(name: String, address: String, age: Int) : this(name) {
        this.name = name
        this.address = address
        this.age = age
    }
}

/**
 * 디폴트 생성자의 init 블럭이 없이 생성자 오버로딩 하는 경우
 */
class OverLoadingConstructorWithoutInit {
    var name: String = ""
    var address: String = ""
    var age: Int = 0


    constructor(name: String, address: String, age: Int) {
        this.name = name
        this.address = address
        this.age = age
    }

    constructor(name: String) {
        this.name = name
    }

}

/**
 * 정적 팩토리 메소드
 * class PrivateDefaultConstructor private constructor()
 *  : 디폴트 생성자를 막는다
 *
 *
 */
class PrivateDefaultConstructor private constructor() {
    lateinit var name: String

    companion object {
        var address = "서울"
        fun of(name: String): PrivateDefaultConstructor {
            val instance = PrivateDefaultConstructor()
            instance.name = name
            return instance
        }
    }
}

/**
 * 자바에서 코틀린 객체의 스태틱멤버를 호출 할때 위 처럼 하면
 * PrivateDefaultConstructor.companion.address 로 해야 하기 때문에
 * 아래 처럼 해야 PrivateDefaultConstructorForJava.address 로 접근 가능하다.
 */
class PrivateDefaultConstructorForJava private constructor() {
    lateinit var name: String

    companion object {
        const val address = "서울"

        @JvmStatic
        fun of(name: String): PrivateDefaultConstructorForJava {
            val instance = PrivateDefaultConstructorForJava()
            instance.name = name
            return instance
        }

        @JvmStatic
        fun ofNew(name: String) = of(name)
    }
}

/**
 * 정적 팩토리 생성자 메소드 추가
 * private 멤버 변수, 기본 세터 없음, 필요에 의한 기능 메소드 포함
 */
class BasicPatternClass private constructor() {
    lateinit var name: String
        private set

    var address: String = ""
        get() = if (field.contains("특별시")) field else "$field 특별시"
        set(address: String) {
            field = "$address 특별시"
        }

    private var age: Int = 0


    companion object {
        @JvmStatic
        fun of(name: String, address: String, age: Int): BasicPatternClass {
            val instance = BasicPatternClass()
            instance.name = name
            instance.address = address
            instance.age = age
            return instance
        }
    }

    fun changeName(name: String): String {
        if (age > 19) this.name = name
        return this.name
    }

    fun isAdult() = age > 19
}

