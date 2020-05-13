package spring.practice.kotlin.designPattern.abstractFactoryPattern

/**
 * Created by kimchanjung on 2020-05-08 12:54 오후
 * https://beomseok95.tistory.com/243
 * https://meylady.tistory.com/60
 * [Abstract Factory Pattern]
 * 추상팩토리 패턴이란
 * 추상팩토리 패턴은 어떤 연관된 클래스들을 그룹으로 묶어 교체 생성이 가능한 패턴  
 * 
 * 이해를 돕기위한 설명
 * 추상팩토리 패턴 미적용 
 * - 고용형태가 각각 다른 음식배달라이더가 있다 정규직, 파트타임
 * - 라이더를 생성하기 위해서 고용, 헬멧구입, 이동수단구입 등의 메소드는 동일하지만 세부 구현은 다르다.
 * - 구성은 같지만 라이터의 타입이 다르면 개별로 객체생성과 메소드를 호출 해야한다.  
 * - 라이터타입이 늘어나면 분기문도 늘어나고 코드도 수정해야한다.
 * 
 * 라이더생성(라이더타입)
 *     if (라이터타입 == 정규직)
 *         정규직라이더 정규직라이더 = new 정규직라이더()
 *         정규직라이더.고용()
 *         정규직라이더.헬멧()
 *         정규직라이더.이동수단()
 *     else if (라이터타입 == 파트타임)
 *         파트타임 파트타임 = new 파트타임()
 *         파트타임.고용()
 *         파트타임.헬멧()
 *         파트타임.이동수단()
 *     else if ()
 *      ...
 * ```
 * 
 * 추상팩토리 패턴 적용
 * - 분기 처리 없이 일관성있게 라이더의 업무를 지시한다
 * - 라이더타입이 늘어나도 코드 수정이 없다.
 * 
 * 
 * 라이더생성(라이더)
 *     라이더.고용()
 *  라이더.헬멧()
 *  라이더.이동수단()
 * 
 * 장점
 *  - 객체생성을 팩토리에 위임 느슨한결합
 *  - 일련의 객체 집합을 한번의 변경으로 모두 변경한다.
 *  - 객체 집합을 생성할 때 일관성 유지(엘지모니터, 삼성키보드 이렇게 잘못 생성경우 방지)
 *  - 분기처리 제거
 * 
 * 
 * 단점
 *  - 객체 집합군이 늘어 날수록 관련 클래스들이 늘어나고 설계가 복잡
 *  - 객체 집합군에 새로운 객체가 생기면 모든 팩토리를 수정해야한다.  
 *    정규직라이더 -> 배달, 헬멧착용, 이동, 인데 생필품배달 이라는 메소드가 생기면 
 *    삼성공장, 엘지공장 전부 마우스생성 추가해야됨
 * 
 */

interface Rider {
    fun delivery(): String
    fun repairVehicle(): String
}

class FullTimeRider : Rider {
    override fun delivery() = "오토바이배달"
    override fun repairVehicle() = "오토바이수리"
}

class PartTimeRider : Rider {
    override fun delivery() = "자전거배달"
    override fun repairVehicle() = "자전거수리"
}

interface Vehicle {
    fun start(): String
    fun move(): String
}

class MotorCycle : Vehicle {
    override fun start() = "시동버튼"
    override fun move() = "악셀"
}

class Bike : Vehicle {
    override fun start() = "없다"
    override fun move() = "페달"
}

interface Helmet {
    fun wear(): String
}

class MotorCycleHelmet : Helmet {
    override fun wear() = "오토바이헬멧착용"

}

class BikeHelmet : Helmet {
    override fun wear() = "자전거헬멧착용"
}


interface RiderFactory {
    fun getRider(): Rider
    fun getHelmet(): Helmet
    fun getVehicle(): Vehicle
}

object FullTimeRiderFactory : RiderFactory {
    override fun getRider() = FullTimeRider()
    override fun getHelmet() = MotorCycleHelmet()
    override fun getVehicle() = MotorCycle()
}

object PartTimeRiderFactory : RiderFactory {
    override fun getRider() = PartTimeRider()
    override fun getHelmet() = BikeHelmet()
    override fun getVehicle() = Bike()
}


class RiderService(private val riderFactory: RiderFactory) {

    fun work(): String {
        val rider = riderFactory.getRider()
        val helmet = riderFactory.getHelmet()
        val vehicle = riderFactory.getVehicle()
        return rider.delivery() + helmet.wear() + vehicle.move()
    }
}