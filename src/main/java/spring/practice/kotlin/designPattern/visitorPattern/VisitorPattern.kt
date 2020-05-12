package spring.practice.kotlin.designPattern.visitorPattern

/**
 * Created by kimchanjung on 2020-05-12 4:58 오후
 * [Visitor Pattern]
 * 방문자 패턴
 * 패턴정의가 가장 어려운 패턴 중에 하나 인듯 하다 수많은 블로그의 방문자 패턴을 정의 하는
 * 문구를 아무리 봐도 이해가 가장 어려웠다.
 *
 * 1. 객체는 자기의 상태와 행위를 가진다.
 * 2. 객체의 행위의 구조는 같으나 세부 구현이 다른경우 일관성있게 처리 할 수 있다.
 *  - 즉 모든 라이더는 배달, 운전, 수리라는 행위를 하지만 라이더의 타입에 따라
 *    행위의 세부 구현은 다르다. 모든 타입의 라이더의 일련의 행위를 모두 수행 시킨다면 각각 수행 시켜야한다.
 *
 *    정규직라이더.운전()
 *    정규직라이더.배달()
 *    시간제라이더.운전()
 *    시간제라이더.배달()
 *    =>
 *    라이더.운전()
 *    라이더.배달()
 *    인터페이스를 타입별로 구현하면 위 처럼 가능하다.
 *
 *    하지만 방문자 패턴은 타입별 여러객체와 행위까지 둘다 일관성있게 처리하게 해준다.
 *    for
 *      라이더.업무()
 *
 *
 */

/**
 * 방문자 패턴을 사용하지 않는 경우
 * class FullTimeRider {
 *     fun delivery() = ""
 *     fun drive() = ""
 *     // fun repair(): = "" // 추가된 메소
 * }
 * class PartTimeRider {
 *     fun delivery() = ""
 *     fun drive() = ""
 *     // fun repair(): = "" // 추가된 메소
 * }
 *
 * class TotalRiderTask {
 *     fun doTask() {
 *         val fullTimeRider = FullTimeRider()
 *         val partTimeRider = PartTimeRider()
 *         fullTimeRider.delivery()
 *         fullTimeRider.drive()
 *         // fullTimeRider.repair() // 추가된 메소드
 *         partTimeRider.delivery()
 *         partTimeRider.drive()
 *         // partTimeRider.repair()드 // 추가 된 메소드
 *         // 라이더 타입이 추가되면
 *         // newRider.delivery()
 *         // ..
 *     }
 * }
 */

// 라이더의 행위들을 정의 한다.
interface Rider {
    fun doTask(deliveryTask: DeliveryTask): String
    fun doTask(driveVehicleTask: DriveVehicleTask): String
    fun doTask(repairVehicleTask: RepairVehicleTask): String
}

// 라이더의 타입에 따라 각각의 행위를 구현한다.
// 행위들은 이제 fullTimeRider.delivery(),fullTimeRider.driveVehicle() 대신
// rider.doTask() 추상화 되어 수행 될 것이다.
class FullTimeRider : Rider {
    override fun doTask(deliveryTask: DeliveryTask) = "오토바이배달"
    override fun doTask(driveVehicleTask: DriveVehicleTask) = "오토바이를운전한다"
    override fun doTask(repairVehicleTask: RepairVehicleTask) = "오토바이를수리한다"
}

class PartTimeRider : Rider {
    override fun doTask(deliveryTask: DeliveryTask) = "자전거배달"
    override fun doTask(driveVehicleTask: DriveVehicleTask) = "자전거를운전한다"
    override fun doTask(repairVehicleTask: RepairVehicleTask) = "자전거를수리한다"
}

// 라이더의 개별 행위 즉 배달, 운전, 수리를 업무수행이라는 메소드로 추상황 한다.
interface RiderTask {
    fun doTask(rider: Rider): String
}

// 추상화된 메소드 업무수행을 배달, 운전, 수리 구현체에서 구현한다.
class DeliveryTask : RiderTask {
    override fun doTask(rider: Rider) = rider.doTask(this)

}

class DriveVehicleTask : RiderTask {
    override fun doTask(rider: Rider) = rider.doTask(this)

}

class RepairVehicleTask : RiderTask {
    override fun doTask(rider: Rider) = rider.doTask(this)

}

// 배달, 운전, 수리 행위를 리스트 가지고 있다.
// 업무 수행을 호출할때 라이더 타입을 매개 변수로 하면 해당 라이더의
// 모든 행위가 일관성있는 코드에 수행된다.
// 이로써 퇴근이라는 메소드가 추가 되거나
// 새로운 타입의 라이더가 추가 되어도 doTask 메소드는 변경이 없다.
class TotalRiderTask : RiderTask {
    private val riderTaskList =
            mutableListOf(DeliveryTask(), DriveVehicleTask(), RepairVehicleTask())

    override fun doTask(rider: Rider) =
            riderTaskList.joinToString(separator = ""){ it.doTask(rider) }
}


