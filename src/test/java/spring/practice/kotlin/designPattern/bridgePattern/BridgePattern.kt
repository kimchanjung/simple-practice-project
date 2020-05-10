package spring.practice.kotlin.designPattern.bridgePattern

/**
 * Created by kimchanjung on 2020-05-10 3:09 오후
 * [Bridge Pattern]
 * https://simsimjae.tistory.com/226
 * https://sexycoder.tistory.com/111
 *
 * 브릿지 패턴에 대한 정의가 어려운데 간단히 설명하면
 * 어떤 클래스의 메소드에 로직이 들어 있는 것을 별도로 분리하여 가져다 사용하는 모양세로 구성하는 것임
 * 마치 외부 API를 가져다가 사용하는 패턴
 *
 * 장점
 *  - 실제로 구현 로직을 분리하였기 때문에 결합도가 낮아진다.
 *  - 낮은 결합도 때문에 구현 로직 확장이 용이하다.
 *  - 구현 로직이 변경되어도 client 코드는 변경이 없다.
 * 단점
 *  - 디자인 복잡도 증가
 */

interface Rider {
    fun delivery(): String
    fun repairVehicle(): String
}


/**
 * 배달과 수리 메소드에 직접 로직을 구현 하는 것이 아니고
 * 로직을 다른 클래스로 따로 구현하여 가져와서 사용한다
 * 이런 경우 로직의 변경이 있을 경우 다른 구현체를 주입시켜 사용하면된다
 * 그러면 Client는 코드의 변화 없이 유연하게 로직을 변경할 수 있다.
 */
class FullTimeRider(var riderWork: RiderWork) : Rider {
    override fun delivery() =
            riderWork.checkDeliveryAddress() + riderWork.startVehicle()

    override fun repairVehicle() =
            riderWork.readRepairManual() + riderWork.repairPart()
}


interface RiderWork {
    fun checkDeliveryAddress(): String
    fun startVehicle(): String
    fun readRepairManual(): String
    fun repairPart(): String
}


class RiderWorkImpl : RiderWork {
    override fun checkDeliveryAddress() = "카카오맵으로 배달목적지 확인"

    override fun startVehicle() = "시동 페달을 밟는다"

    override fun readRepairManual() = "수리메뉴얼 책자를 본다"

    override fun repairPart() = "부품을 세척하고 기름칠 한다."
}

class UpgradeRiderWorkImpl : RiderWork {
    override fun checkDeliveryAddress() = "라이더앱에서 목적지 바로확인"

    override fun startVehicle() = "시동버튼을 누른다"

    override fun readRepairManual() = "수리메뉴얼을 PDF로 확인한다."

    override fun repairPart() = "부품을 새부품으로 교환한다."
}