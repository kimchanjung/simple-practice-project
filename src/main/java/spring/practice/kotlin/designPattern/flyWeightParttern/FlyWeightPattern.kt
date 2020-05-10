package spring.practice.kotlin.designPattern.flyWeightParttern

import kotlin.reflect.full.primaryConstructor

/**
 * Created by kimchanjung on 2020-05-10 5:04 오후
 * [FlyWeight Pattern]
 *
 * 특정 클래스를 사용하기 위해서 client에서 인스턴스를 매번 생성하는 경우 개수가 많은 경우 메모리 낭비 하게됨
 * 공통으로 사용하는 팩토리클래스를 만들고 없는 경우 생성하고 이미 있는 경우는 인스턴스를 리턴해서 1개만 생성해서
 * 공유해서 사용할 수 있도록 제공하는 패턴
 *
 * 장점
 *  - 많은 객체를 만들때 성능을 향상시킬수 있다.
 *  - 많은 객체를 만들때 메모리를 줄일수 있다.
 *
 * 단점
 *  - 특정 인스턴스를 다르게 처리하는 것을 불가능 함
 *
 *
 */

interface Rider {
    fun delivery(): String
}

class FullTimeRider(var center: String) : Rider {
    override fun delivery() = "$center 오토바이배달"
}

class PartTimeRider(var center: String) : Rider {
    override fun delivery() = "$center 자전거배달"
}


class RiderFactory {
    private val riderClasses = mapOf("fulltime" to FullTimeRider::class, "parttime" to PartTimeRider::class)
    private val riderMap = mutableMapOf<String, Rider>()

    fun getRider(center: String, type: String): Rider {
        val riderClass = riderClasses[type]!!.primaryConstructor
        return riderMap.computeIfAbsent(center + type) {
            println("$center $type 라이더 객체를 새로 생성")
            riderClass!!.call(center)
        }
    }
}

class RiderService {
    private val riderFactory = RiderFactory()
    fun delivery(center: String, type: String) = riderFactory
            .getRider(center, type)
            .delivery()
}
