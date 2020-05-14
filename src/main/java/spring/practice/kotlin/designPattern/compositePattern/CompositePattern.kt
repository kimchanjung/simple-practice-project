package spring.practice.kotlin.designPattern.compositePattern

/**
 * Created by kimchanjung on 2020-05-08 4:57 오후
 * [Composite Pattern]
 * 하나의 객체이거나 여러개의 객체이거나 상관없이 하나의 객체처럼 다룰 수 있게 해주는 패턴
 *
 * 장점
 *  - 하나던 여려개던 일관성있는 방법으로 객체를 사용가능하여 클라이언트 코드가 단순해짐
 *  - 새로운 객체를 추가하는 것이 용이함 클라이언트 코드를 변경할 필요 없음
 *
 * 단점
 *  - 여러 종류의 객체를 일반화 시켰기 때문에 특정 객체에 제약 조건을 주거나 할 수 없다.
 *
 */


interface Rider {
    fun delivery(vehicle: String): String
}


class FullTimeRider : Rider {
    override fun delivery(vehicle: String) = "정규직" + vehicle + "배달"
}

class PartTimeRider : Rider {
    override fun delivery(vehicle: String) = "시간제" + vehicle + "배달"
}

class ConnectRider : Rider {
    override fun delivery(vehicle: String) = "커넥트" + vehicle + "배달"
}


class AllTypeRider : Rider {
    private val riders = mutableListOf(FullTimeRider(), PartTimeRider(), ConnectRider())

    override fun delivery(vehicle: String): String {
        return riders.joinToString(separator = "") { it.delivery(vehicle) }
    }

    fun add(rider: Rider) = riders.add(rider)

    fun remove(rider: Rider) = riders.remove(rider)
}

class RiderService(private val allTypeRider: AllTypeRider) {
    fun deliveryAllRiders(vehicle: String) =
            allTypeRider.delivery("오토바")
}