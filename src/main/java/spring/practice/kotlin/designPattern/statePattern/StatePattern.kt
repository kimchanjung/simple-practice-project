package spring.practice.kotlin.designPattern.statePattern

/**
 * Created by kimchanjung on 2020-05-12 2:20 오후
 * [State Pattern]
 * 상태 패턴
 * 객체가 직접 상태에 따른 행위를 직접 구현하지 않고 상태와 행위를 구현한 별개의 상태객체에게 위임하는 패턴
 *
 * 장점
 *  - 상태 변경에 따른 행위 로직을 직접 구현 하지 않아도 됨으로써 확장에 유리하다.
 *  - 번잡한 분기로직이 제거된다.
 *
 *  단점
 *   - 관련 클래스가 많아저 복잡도가 증가
 *
 * 상태 패턴을 적용하지 않으면
 * 분기 문을 적용하고 기타 복잡한 알고리즘도 한꺼 번에 같이 포함 된다.
 * 새로운 로직이나 상태추가시 클래스를 변경해야한다.
 * if (상태 == 대기) {
 *      상태 = 배차완료
 * } else if (상태 == 배차완료) {
 *      상태 = 배차완료
 * } else if (상태 == 배달완료) {
 *      println("다음 상태 없음")
 * }
 * ...
 *
 * 상태 패턴을 사용하면 상태에 따른 행위 로직을 개별 상태 객체가 대신 하도록 위임 한다.
 * 이로써 상태의 추가나 로직변경에 의해 client객체는 변경할 필요가 없다.
 */

/**
 * 상태 인터페이스 정의
 * 배달의 상태는 배차대기 -> 배차완료 -> 픽업완료(음식) -> 전달완료(음식)
 * 의 순서로 상태가 진행되며 바로 앞뒤 상태로만 변경이 가능하다.
 * 즉 배차대기 -> 픽업완료로 변경될 수 없다.
 */

interface DeliveryStatus {
    val name: String
    fun forward(delivery: Delivery): String
    fun backward(delivery: Delivery): String
}

/**
 * 개별 상태 클래스를 만들고 해당행위에 적절한 로직을 구현한다.
 * object로 선언해서 싱글톤 생성 하도록 선언해서 사용한다
 */
object Wait : DeliveryStatus {
    override val name = "배차대기"

    // 배차대기의 다음 상태는 배차 완료 이므로 배차완료 상태로 변경한다.
    override fun forward(delivery: Delivery): String {
        delivery.status = Assign
        return delivery.status.name
    }

    // 배차다기에서 뒤로 갈 상태가 없으므로 뒤로불가 리턴한다.
    override fun backward(delivery: Delivery) = "뒤로불가"

}

object Assign : DeliveryStatus {
    override val name = "배차완료"
    override fun forward(delivery: Delivery): String {
        delivery.status = Pickup
        return delivery.status.name
    }

    override fun backward(delivery: Delivery): String {
        delivery.status = Wait
        return delivery.status.name
    }

}

object Pickup : DeliveryStatus {
    override val name = "픽업완료"
    override fun forward(delivery: Delivery): String {
        delivery.status = Complete
        return delivery.status.name
    }

    override fun backward(delivery: Delivery): String {
        delivery.status = Assign
        return delivery.status.name
    }

}


object Complete : DeliveryStatus {
    override val name = "전달완료"
    // 전달완료는 다음 상태 가 없기 때문에 진행불가
    override fun forward(delivery: Delivery) = "진행불가"

    override fun backward(delivery: Delivery): String {
        delivery.status = Pickup
        return delivery.status.name
    }

}

/**
 * 배달의 상태는 앞로진행, 뒤로 진행의 행위 메소드가 존재하며
 * 해당 상태 앞으로를 진행하면 해당 상태 클래스가 적절히 배달의 상태를 변경하기 때문에
 * 배달은 상태에 따른 행위에 신경 쓸 필요가 없어지게 된다.
 * 배달의 상태 추가나 상태 변경 로직이 변경되더라도
 * 배달의 로직은 변경 될 것이 없다.
 */
class Delivery {
    var status: DeliveryStatus = Wait

    fun forwardStatus() = status.forward(this)

    fun backwardStatus() = status.backward(this)
}

