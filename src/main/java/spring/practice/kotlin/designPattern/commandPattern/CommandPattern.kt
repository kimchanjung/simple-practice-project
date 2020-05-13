package spring.practice.kotlin.designPattern.commandPattern

/**
 * Created by kimchanjung on 2020-05-11 4:08 오후
 * [Command Pattern]
 * https://gmlwjd9405.github.io/2018/07/07/command-pattern.html
 * 커맨드 패턴은 각각 형태가 다른 메소드를 추상화 하여 클라이언트가 사용할 수 있도록 하는 패턴
 *
 * 메소드는 수행로직이나 필요한 정보가 종류에 따라 다양 할 수 있는 일련의 로직을
 * 실행() 이라는 메소드로 캡슐화하여 client에게 간단하게 제공하는 패턴이다
 * 이로써 클라이언트와 작업을 수행하는 객체 사이의 의존성을 제거하고
 * 클라이언트는 복잡한 수행방법을 알 필요 없다.
 *
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
 *  - 기존 Code를 수정하지 않고, 새 명령을 쉽게 추가할 수 있다
 *  - 명령의 호출자와 수신자의 의존성을 제거한다.
 * 단점
 *  - 명령에 대한 클래스가 늘어난다.
 *
 */


interface DeliveryCommand {
    fun driveVehicle(): String
}

class MotorCycle {
    fun start() = "오토바이시동"
    fun accelerate() = "오토바이출발"
}

class Bike {
    fun pedaling() = "자전거출발"
}

class MotorCycleCommand(private var motorCycle: MotorCycle) : DeliveryCommand {

    override fun driveVehicle() :String{
       return motorCycle.start() + motorCycle.accelerate()
    }
}

class BikeCommand(private var bike: Bike) : DeliveryCommand {
    override fun driveVehicle() = bike.pedaling()
}


class Rider(private var deliveryCommand: DeliveryCommand) {
    fun changeDeliveryCommand(deliveryCommand: DeliveryCommand): Rider {
        this.deliveryCommand = deliveryCommand
        return this
    }

    fun delivery() = deliveryCommand.driveVehicle()
}