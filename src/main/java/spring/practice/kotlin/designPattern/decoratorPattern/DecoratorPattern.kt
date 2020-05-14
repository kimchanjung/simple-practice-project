package spring.practice.kotlin.designPattern.decoratorPattern

/**
 * Created by kimchanjung on 2020-05-06 4:34 오후
 * [Decorator Patten]
 * https://jusungpark.tistory.com/9
 * https://namget.tistory.com/entry/%EB%94%94%EC%9E%90%EC%9D%B8%ED%8C%A8%ED%84%B4-%EB%8D%B0%EC%BD%94%EB%A0%88%EC%9D%B4%EC%85%98-%ED%8C%A8%ED%84%B4
 * https://gmlwjd9405.github.io/2018/07/09/decorator-pattern.html
 *
 * 데코레이터 패턴은 특정 클래스의 기본 기능에 추가 기능을 기존 클래스를 수정 하지 않고 패턴을 통하여 덧 붙이고 싶을 때 사용한다.
 *
 * 단점
 *  - 자잘하나 클래스들이 많이 필요하게 된다.
 *  - 코드복잡도가 증가하여 가독성이 떨어진다
 */


/**
 * 라이더는 업무를 하는 기능에 음식배달만 할줄한다.
 * 그런데 음식배달+오토바이수리 기능을 넣고 싶다.
 *
 * 그러면 라이더 클래스를 수정하여 "음식배달+오토바이수리" 로 기능을 덧 붙이고 싶지는 않다.
 * 왜냐 하면 그냥 음식배달만 하는 라이더를 사용할 수도 있기 때문이고 특별히 필요할때만
 * 음식배달+오토바이수리 기능을 덧 붙여 사용하고 싶은 경우도 있기 때문이다.
 * 상속을 통하여 기능을 추가한 클래스를 만들면
 * 기능 조합에 따른 상속 클래스 수가 늘어난다
 *
 * 음식배달+오토바이수리
 * 음식배달+라이더관리
 * 음식배달+오토바이수리+라이더관리
 * ....
 */
open class OldRider {
    open fun working() = "음식배달" // +"오토바이수리"
}

class OldRiderWithRepairVehicle : OldRider() {
    override fun working() = super.working() + "|오토바이수리"
}

class OldRiderWithManagement : OldRider() {
    override fun working() = super.working() + "|라이더관리업무"
}

class OldRiderWithRepairVehicleManagement : OldRider() {
    override fun working() = super.working() + "|오토바이수리|라이더관리업무"
}


/**
 * 기능 조합별 상속 클래스수가 늘어나는 것을 방지 하고 원할때 기능을 추가하여
 * 조합 해서 만드는 데코레이터 패턴을 사용한다.
 */


/**
 * 기본 기능 즉 "일한다" 정의한 추상 클래스를 만든다
 */
abstract class Employee(private var jobType:String) {
    open fun showJobType() = jobType
    abstract fun working(): String
}

/**
 * 추상클래스를 상속한 라이더클래스를 만든다
 * 라이더 클래스의 기본업무는 음식배달이다.
 */
class Rider(jobType: String) : Employee(jobType) {
    override fun working() = "음식배달"
}

/**
 * 추상클래스를 상속한 개발자클래스를 만든다
 * 개발자 클래스의 기본업무는 java이다.
 */
class Developer(jobType: String) : Employee(jobType) {
    override fun working() = "java"
}

/**
 * 업무를 추가할 수 있는 데코레이터 추상 클래스를 만든다.
 */
abstract class CompanyWorkDecorator : Employee("") {
    abstract override fun showJobType(): String
}

/**
 * 데코레이터 추상클래스를 상속하여 각각 업무를 정의한 클래스를 만든다.
 * 이 클래스들은 나중에 필요한 기능을 조합할때 덧붙여 조합하여 최종 기능을 만드는데 활용된다.
 */
class RiderWithRepairVehicle(private var rider: Employee) : CompanyWorkDecorator() {
    override fun showJobType() = rider.showJobType() + "|수리기사"
    override fun working() = rider.working() + "|오토바이수리"
}

class RiderWithManagement(private val rider: Employee) : CompanyWorkDecorator() {
    override fun showJobType() = rider.showJobType() + "|관리자"
    override fun working() = rider.working() + "|라이더관리업무"
}

class DeveloperWithReactJs(private var rider: Employee) : CompanyWorkDecorator() {
    override fun showJobType() = rider.showJobType() + "|프론트엔드"
    override fun working() = rider.working() + "|reactjs"
}

class DeveloperWithSpringBoot(private val rider: Employee) : CompanyWorkDecorator() {
    override fun showJobType() = rider.showJobType() + "|백엔드"
    override fun working() = rider.working() + "|springboot"
}