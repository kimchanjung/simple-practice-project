package spring.practice.kotlin.designPattern.templateMethodPattern

/**
 * Created by kimchanjung on 2020-05-07 3:07 오후
 * [Template Method Pattern]
 * 전체적으로는 동일하지만 부분적으로 다른 경우 중복을 최소화 하는 패턴
 * 동일한 기능을 상위 클래스에 정의 하고 부분적으로 다른 부분은 서브클래스에 정의 하여 사용한다.
 * 쉽게 말하면 같은 부분은 공통으로 사용하고 약간 다른 부분만 따로 생성
 *
 * 장점
 *  - 코드중복을 줄인다.
 *  - 자식클래스의 역할을 줄이면서 핵심로직 관리 용이
 *  - 객체 추가 및 확장이 쉽다.
 *
 * 단점
 *  - 추상메소드가 많아지면 관리가 복잡
 *  - 추상클래스와 구현클래스간의 복잡성 증대
 *
 * 주의!
 *  - 반드시 추상클래스에서 하위클래스를의 메소드나 멤버를 호출하는 의존 관계를 가져야한다
 *  - 하위클래스에서 추상클래스를 호출 하면 안된다.
 *
 */


abstract class Rider(var name: String,
                     var age: Int,
                     var address: String) {

    // 일련의 로직을 수행한다.
    fun work(): String {
        return goToWork() + delivery() + repairVehicle() + offWork()
    }

    // 로직이 같은 부분이므로 하위 클래스가 구현할 필요 없다. 중복제거
    // 하위 클래스가 호출하지 못하도록 제한
    private fun goToWork() = "출근"
    private fun offWork() = "퇴근"
    // 로직이 다른 메소드는 하위 클래스가 구현하도록 한다
    protected abstract fun delivery(): String
    protected abstract fun repairVehicle(): String
}

class FullTimeRider(name: String,
                    age: Int,
                    address: String,
                    var employeeNumber: String)
    : Rider(name, age, address) {

    override fun delivery() = "오토바이배달"
    override fun repairVehicle() = "오토바이수리"
}

class PartTimeRider(name: String,
                    age: Int,
                    address: String,
                    var feePerDelivery: Int)
    : Rider(name, age, address) {

    override fun delivery() = "자전거배달"
    override fun repairVehicle() = "자전거수리"
}