package spring.practice.kotlin.designPattern.factoryMethodPattern

/**
 * Created by kimchanjung on 2020-05-07 4:31 오후
 * [Factory Method Pattern]
 * https://meylady.tistory.com/59
 * https://beomseok95.tistory.com/244
 *
 * 어떤 객체를 생성 할지를 서브클래스에게 위임 하는 패턴
 *
 * 장점
 *  - 클라이언트는 추상 클래스를 통하여 객체를 생성하기 때문에 구현클래스와 클라이언트와 결합도가 낮아진다.
 *  - 하나의 메소드로 여러가지의 클래스의 객체를 생성할 수 있다.
 *  - 객체의 자료형이 하위 클래스 의해서 결정됨 -> 확장에 용이함
 *  단점
 *  - 객체가 늘어날 때마다 하위 클래스 재정의로 인한 불필요한 많은 클래스 생성 가능성이 있음
 */


abstract class Rider {
    abstract fun delivery(): String
    abstract fun repairVehicle(): String
}

class FullTimeRider : Rider() {
    override fun delivery() = "오토바이배달"
    override fun repairVehicle() = "오토바이수리"
}

class PartTimeRider : Rider() {
    override fun delivery() = "자전거배달"
    override fun repairVehicle() = "자전거수리"
}

abstract class RiderFactory {
    abstract fun createRider(className: String): Rider
}

class FoodDeliveryRiderFactory : RiderFactory() {
    override fun createRider(className: String): Rider {
        return when (className) {
            "fulltime" -> FullTimeRider()
            "parttime" -> PartTimeRider()
            else -> throw IllegalArgumentException("생성할 수 있는 객체명이 아닙니다.")
        }
    }
}