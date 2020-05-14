package spring.practice.kotlin.designPattern.factoryMethodPattern

import java.time.LocalDateTime

/**
 * Created by kimchanjung on 2020-05-07 4:31 오후
 * [Factory Method Pattern]
 * https://meylady.tistory.com/59
 * https://beomseok95.tistory.com/244
 * [팩토리 메소드 패턴]
 * 객체 생성을 직접 하여 획득 하지 않고 객체를 생성/제공하는 클래스를 사용하여 획득하는 패턴
 *
 * 장점
 *  - 클라이언트는 직접 객체를 생성하지 않고  때문에 구현클래스와 클라이언트와 결합도가 낮아진다.
 *  - 하나의 메소드로 여러가지의 클래스의 객체를 생성할 수 있다.
 *
 *  단점
 *  - 객체가 늘어날 때마다 하위 클래스 재정의로 인한 불필요한 많은 클래스 생성 가능성이 있음
 */


interface Rider {
    fun delivery(deliveryId:String): String
    fun repairVehicle(): String
}

class FullTimeRider : Rider {
    override fun delivery(deliveryId:String) = "오토바이배달"
    override fun repairVehicle() = "오토바이수리"
}

class PartTimeRider : Rider {
    override fun delivery(deliveryId:String) = "자전거배달"
    override fun repairVehicle() = "자전거수리"
}

class NightTimeRider : Rider {
    override fun delivery(deliveryId:String) = "퀵보드배달"
    override fun repairVehicle() = "퀵보드수리"
}


class RiderFactory {
    fun createRider(className: String): Rider {
        return when (className) {
            "fulltime" -> FullTimeRider()
            "parttime" -> PartTimeRider()
            "nighttime" ->
                if (LocalDateTime.now().hour > 21)
                    NightTimeRider()
                else
                    throw IllegalArgumentException("오후 9시 이후만 생성 가능합니다")
            else -> throw IllegalArgumentException("생성할 수 있는 객체명이 아닙니다.")
        }
    }
}

class DeliveryService {
    private var riderFactory = RiderFactory()
    fun assignDelivery(deliveryId: String) {
        val rider = riderFactory.createRider("fulltime")
        rider.delivery(deliveryId)
    }
}