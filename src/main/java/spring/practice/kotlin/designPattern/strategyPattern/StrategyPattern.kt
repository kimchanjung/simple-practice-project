package spring.practice.kotlin.designPattern.strategyPattern

/**
 * Created by kimchanjung on 2020-05-06 12:33 오후
 * https://sirupe.github.io/strategy-pattern/
 * https://gmlwjd9405.github.io/2018/07/06/strategy-pattern.html
 * [Strategy Pattern]
 * 알고리즘, 로직을 따로 정의 하여 필요에 의해 사용 또는 교체 할 수 있는 패턴
 * 명령패턴과 차이점은 전략패턴은 어떤 행위를 처리할때 로직의 일부 전략을 캡슐화하여 이용하는 패턴이며
 * 명령패턴은 어떤행위자체를 직접 처리하지 않고 캡슐화된 메소드를 사용하는 것이다.
 *
 * 전략패턴
 * 저장(){
 *  객체생성
 *  덧셈전략()
 *  파일에저장()
 * }
 *
 * 명령패턴
 * 저장() {
 *   실행() // 실행위치, 파일명, 객체생성 등의 일련의 행위를 캠슐화 하여 간단하게 제공
 * }
 *
 * 장점
 *  - 로직이나 알고리즘 변경시 해당 코드를 직접 변경하지 않고 이미 정의된 알고리즘을 교체하여 사용할 수 있다.
 *  - 분기로직 제거
 *
 * 단점
 *  - 객체의 수가 증가
 *  - 코드 복잡도 증가
 *  - 구현된 객체 사이의 결합도 증가
 *
 */


abstract class OldRider(var name: String) {
    open fun goToWorkBy() = "지하철"
    abstract fun deliveryBy(): String
    abstract fun getFee(): Int

}

class OldFullTimeRider(name: String) : OldRider(name) {
    override fun deliveryBy() = "오토바이"
    override fun getFee() = 3000
}

class OldPartTimeRider(name: String) : OldRider(name) {
    override fun deliveryBy() = "자전거"
    override fun getFee() = 2000
}

/**
 * 배민 커넥트라이더가 추가 되었습니다.
 * 이 라이더는 지점으로 출근하지 않고 거주지에서 바로 일하는 라이더 입니다.
 * 근데 출근 메소드가 이미 있네요.
 * 어쩔 수 없이 출근 메소드를 오버라이드 합니다.
 */
class OldConnectRider(name: String) : OldRider(name) {
    /**
     * 매번 이렇게 오버라이드 해야하는 단점이 보이기 시작합니다.
     */
    override fun goToWorkBy() = "출근 안함"
    override fun deliveryBy() = "킥보드"
    override fun getFee() = 1000
}

/**
 * 그리고 이동/수수료 메소드들은 같은 로직인 경우 매번 추가되는 라이더의 메소드에 구현 해주어야 하죠
 * 중복이 생기는 겁니다.
 */

/**
 * 전략 패턴을 사용하여 해결
 * 문제가 되는 메소드를 분리하여 인터페이스를 만든다.
 * 출근전략 인터페이스 -> 지하철, 자가용 구현체를 구현
 * 배달전략 인터페이스 -> 오토바이, 자전거 구현체를 구현
 * 이 전략 구현체들은 필요에 의해서 갈아 끼우는 용도로 사용된다.(중복제거, 변경용이)
 */

// 출근 전략
interface GoToWorkStrategy {
    fun goToBy(): String
}

class BySubwayStrategy : GoToWorkStrategy {
    override fun goToBy() = "지하철"
}

class ByCarStrategy : GoToWorkStrategy {
    override fun goToBy() = "자가용"
}

class DontGoToWorkStrategy : GoToWorkStrategy {
    override fun goToBy() = "출근안함"
}

// 배달 전략
interface DeliveryStrategy {
    fun move(): String
}

class MotorCycleStrategy : DeliveryStrategy {
    override fun move() = "오토바이"
}

class BikeStrategy : DeliveryStrategy {
    override fun move() = "자전거"
}


/**
 * 추상 클래스 라이더의 출근, 배달 메소드를
 * 출근 전략, 배달 전략 으로 변경하고
 * 중간에 변경도 가능하도록 메소드도 제공한한다.
 * 출근, 배달의 로직은 각각 전략 클래스의 메소드를 사용하도록 하고
 * 나중에 라이더클래스의 소스코드 수정 없이 전략만 교체 해서 변경하여 사용 할 수 있도록 구성한다.
 */
abstract class Rider(
        var name: String,
        private var goToWorkStrategy: GoToWorkStrategy,
        private var deliveryStrategy: DeliveryStrategy) {

    // 추후 변경이 생기면 전략을 갈아 끼운다
    fun changeGoToWorkStrategy(goToWorkStrategy: GoToWorkStrategy) {
        this.goToWorkStrategy = goToWorkStrategy
    }

    fun changeDeliveryStrategy(deliveryStrategy: DeliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy
    }

    // 내부로직이 아니라 전략 로직을 사용한다.
    fun goToWorkBy() = goToWorkStrategy.goToBy()
    fun deliveryBy() = deliveryStrategy.move()
    abstract fun getFee(): Int
}


// 정규직 라이더
class FullTimeRider(name: String,
                    goToWorkStrategy: GoToWorkStrategy,
                    deliveryStrategy: DeliveryStrategy) :
        Rider(name, goToWorkStrategy, deliveryStrategy) {

    override fun getFee() = 3000
}

// 파트타임 라이더
class PartTimeRider(name: String,
                    goToWorkStrategy: GoToWorkStrategy,
                    deliveryStrategy: DeliveryStrategy) :
        Rider(name, goToWorkStrategy, deliveryStrategy) {

    override fun getFee() = 2000
}

// 배민커넥트 라이더
class ConnectRider(name: String,
                   goToWorkStrategy: GoToWorkStrategy,
                   deliveryStrategy: DeliveryStrategy) :
        Rider(name, goToWorkStrategy, deliveryStrategy) {

    override fun getFee() = 1000
}


