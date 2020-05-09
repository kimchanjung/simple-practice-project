package spring.practice.kotlin.designPattern.proxyPattern

/**
 * Created by kimchanjung on 2020-05-09 3:28 오후
 * [Proxy Pattern]
 * https://developside.tistory.com/80
 * 실제객체를 대신하는 객체가 로직의 흐름을 제어하여 실제 객체를 조작하는 패턴
 *
 * 장점
 *  - 원래 객체의 기능에 부가적인 작업을 출가 할 때 용이함
 *  - 메소드 호출이 발생하기 전까지 실제객체가 생성성되지 않는다 (메모리 이점)
 *
 * 단점
 *  - 한단계를 거치므로 간혹 객체 응답이 느려 질 수 있댜.
 *  - 인터페이스를 구현하므로 프록시 객체에서 구지 필요없는 메소드도 구현해야하며 코드 중복이 될 수 있다.
 */

interface Rider {
    fun delivery()
    fun getPersonalInfo(level: Int): String?

}

class FullTimeRider(var name: String) : Rider {

    init {
        goToWork()
    }

    private fun goToWork() = println("지점으로 출근")
    override fun delivery() = println("음식배달")
    override fun getPersonalInfo(level: Int) = name

}


class ProxyRider(var name: String) : Rider {

    private var fullTimeRider: FullTimeRider? = null

    override fun delivery() {
        fullTimeRider = fullTimeRider ?: FullTimeRider(name)
        fullTimeRider?.delivery()
    }

    override fun getPersonalInfo(level: Int) = name
}


class ProtectedProxyRider(var name: String) : Rider {

    private var fullTimeRider: FullTimeRider? = null

    private fun getRider(name: String) = fullTimeRider ?: FullTimeRider(name)

    override fun delivery() {
        getRider(name).delivery()
    }

    override fun getPersonalInfo(level: Int) = if (level > 3)
        getRider(name).getPersonalInfo(level)
    else
        "접근불가"

}




