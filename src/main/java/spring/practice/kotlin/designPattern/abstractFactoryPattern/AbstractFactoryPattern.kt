package spring.practice.kotlin.designPattern.abstractFactoryPattern

/**
 * Created by kimchanjung on 2020-05-08 12:54 오후
 * https://beomseok95.tistory.com/243
 * https://meylady.tistory.com/60
 * [Abstract Factory Pattern]
 * 이해하기 어려운 패턴
 *
 * 추상팩토리 패턴은 어떤 연관된 클래스 그룹으로 묶어 교체 생성이 가능한 패턴
 *
 * 풀어서 이야기 하자면
 * 삼성 컴퓨터, 엘지 컴퓨터가 있다.
 * 업체에 따라 각각 본체, 모니터, 키보드를 생성해야한다.
 *
 * 컴퓨터제조(업체구분)
 * if (삼성)
 *     삼성본체()
 *     삼성모니터()
 *     삼성키보드()
 * else if (엘지)
 *     엘지본체
 *     엘지모니터
 *     엘지키보드
 * else if ()
 *  ....
 *
 *
 *
 * 추상팩토리 패턴을 사용하지 않으면 위 같은 모양세가 된다. 업체가 추가 될수로 분기 문도 늘어나게 된다.
 * 추상팩토리 패턴을 사용하면 아래와 같은 모양세가 된다.
 *
 * 컴퓨터제조(컴퓨터)
 *   컴퓨터.본체()
 *   컴퓨터.모니터()
 *   컴퓨터.키보드()
 *
 *
 * 컴퓨터제조(삼섬컴퓨터) <= 사용하다가 엘지컴퓨터 생산하고 싶으면 엘지로 변경하면된다. 다른 제조사 를 추가해도
 * 제조 로직은 변경이 없다.
 *
 * 장점
 *  - 객체생성을 팩토리에 위임 느슨한결합
 *  - 일련의 객체 집합을 한번의 변경으로 모두 변경한다.
 *  - 객체 집합을 생성할 때 일관성 유지(엘지모니터, 삼성키보드 이렇게 잘못 생성경우 방지)
 *  - 분기처리 제거
 *
 * 단점
 *  - 객체 집합군이 늘어 날수록 관련 클래스들이 늘어나고 설계가 복잡
 *  - 객체 집합군에 새로운 객체가 생기면 모든 팩토리를 수정해야한다.
 *    삼성공장 -> 본체생성,모니터생성,키보드생성 인데 마우스가 추가되면
 *    삼성공장, 엘지공장 전부 마우스생성 추가해야됨
 *
 */

interface Rider {
    fun delivery(): String
    fun rentVehicle(): String
}

class FullTimeRider : Rider {
    override fun delivery() = "오토바이배달"
    override fun rentVehicle() = "오토바이수리"
}

class PartTimeRider : Rider {
    override fun delivery() = "자전거배달"
    override fun rentVehicle() = "자전거수리"
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
    fun hireRider(): Rider
    fun rentHelmet(): Helmet
    fun rentVehicle(): Vehicle
}

object FullTimeRiderFactory : RiderFactory {
    override fun hireRider() = FullTimeRider()
    override fun rentHelmet() = MotorCycleHelmet()
    override fun rentVehicle() = MotorCycle()
}

object PartTimeRiderFactory : RiderFactory {
    override fun hireRider() = PartTimeRider()
    override fun rentHelmet() = BikeHelmet()
    override fun rentVehicle() = Bike()
}


class RiderService(private val riderFactory: RiderFactory) {

    fun work(): String {
        val rider = riderFactory.hireRider()
        val helmet = riderFactory.rentHelmet()
        val vehicle = riderFactory.rentVehicle()
        return rider.delivery() + helmet.wear() + vehicle.move()
    }
}