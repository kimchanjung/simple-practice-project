package spring.practice.kotlin.basicSyntaxPractice

import spring.practice.kotlin.basicSyntaxPractice.DeliveryStatus.WAIT
import spring.practice.kotlin.basicSyntaxPractice.DeliveryStatus.CONSIGN
import spring.practice.kotlin.basicSyntaxPractice.DeliveryStatus.PICKUP
import spring.practice.kotlin.basicSyntaxPractice.SealedDeliveryStatus


/**
 * Created by kimchanjung on 2020-04-27 5:09 오후
 *
 * Sealed class 사용하는 이유와 이점을 설명하기 위해 몇가지 예제 케이스를 설명합니다.
 */

/**
 * 보통 특정 상태 값을 선언할 때는 Enum 클래스를 사용하는 것이 보통이나 아래와 같이
 * 오브젝트로(싱글톤 스태택 클래스) 선언 하고 이것을 사용 하는 코드에서 발생 할 수 있는 문제점은 다음과 같다
 *
 * - DeliveryStatus를 사용하는 비즈니스 로직 selectDeliveryStatus에서 새로 추가한 상태값 COMPLETE에
 *   대한 처리를 해주지 않아도 컴파일이 된다.
 * - 이런경우 런타임 시 COMPLETE는 else 로 처리 되게 됨으로 개발자가 상태 값만 추가하고 비즈니스 로직처리를 빼먹는
 *   사태가 발 생 할 수 있다.
 * - DeliveryStatus 상태가 추가 될 때 마다 비즈니스로직에 관련 처리를 계속적으로 추가 해주어야한다.
 * - when 구문에서도 else 구문 추가가 필수 적이다, 그 이유는 selectDeliveryStatus(DeliveryStatus.PICKUP) 로 메소드를
 *   호출 하는 경우 when구문 입장에서는 int 값에 어떤 값이 들어올지 미리 알 수 없기 때문에 else 구문을 추가 하지 않으면
 *   컴파일 오류가 발생한다.
 */
object DeliveryStatus {
    val WAIT = 1
    val CONSIGN = 2
    val PICKUP = 3
    val COMPLETE = 4 // 추후에 추가한 상태값
}


fun selectDeliveryStatus(deliveryStatus: Int): String {
    return when (deliveryStatus) {
        WAIT -> "대기($deliveryStatus)"
        CONSIGN -> "배차($deliveryStatus)"
        PICKUP -> "픽업($deliveryStatus)"
        /**
         *  DeliveryStatus 에 COMPLETE를 추가 했으면 이 라인도 당연히 추가 했어야 하지만
         *  추가 하지 않아도 컴파일 에러는 없기 때문에 개발자가 빼먹어 런타임에 의도치 않은 결과를 초래할 수 있다.
         */
        // COMPLETE -> deliveryStatus
        else -> "오류(0)"
    }
}

/**
 * 일반적으로 Enum 클래스를 사용 했을 경우을 살펴 보자
 *
 * - COMPLETE 상태가 추후에 추가되었을 경우 EnumDeliveryStatus 클래스를 사용하는 비즈니스로직에서
 *   COMPLETE 상태 처리에 대한 구문이 추가 되지 않으면 컴파일 오류가 발생하므로 개발자가 실수로 빠트리는 일은 없다.
 *
 * - Enum 클래스의 값은 선언 당시에 완전히 정해 지므로 런타임시 어떤 값이 들어올지 모르는 상황이 아니므로
 *   when 처리시 else 구문이 필요없게 된다.
 *
 */
enum class EnumDeliveryStatus(val code: Int, val codeName: String) {
    WAIT(1, "대기"),
    CONSIGN(2, "배차"),
    PICKUP(3, "픽업"),

    /**
     * COMPLETE를 나중에 추가 했을 경우에 selectEnumDeliveryStatus에
     * EnumDeliveryStatus.COMPLETE -> deliveryStatus.code 이 구문을 추가 해주지 않으면
     * 컴파일 오류 발생한다.
     */
    COMPLETE(4, "완료");

    fun getCodeWithName() = "$codeName($code)"
}

/**
 * EnumDeliveryStatus 선언 당시 값이 명확히 정해 지므로 when 에서 else 처리도 불필요 해진다.
 */
fun selectEnumDeliveryStatus(deliveryStatus: EnumDeliveryStatus): String {
    return when (deliveryStatus) {
        EnumDeliveryStatus.WAIT -> "${deliveryStatus.codeName.toString()}(${deliveryStatus.code.toString()})"
        EnumDeliveryStatus.CONSIGN -> "${deliveryStatus.codeName.toString()}(${deliveryStatus.code.toString()})"
        EnumDeliveryStatus.PICKUP -> "${deliveryStatus.codeName.toString()}(${deliveryStatus.code.toString()})"
        EnumDeliveryStatus.COMPLETE -> "${deliveryStatus.codeName.toString()}(${deliveryStatus.code.toString()})"
    }
}

/**
 * 사실상 Enum 클래스를 사용한다면 when 처리도 필요 없다.
 * $deliveryStatus.codeName($deliveryStatus.code) => Enum Class 내부에 메소드를 만들어 제공하고
 * 아래 메소드에서는 바로 호출 하도록 하면 된다.
 */
fun selectEnumDeliveryStatus2(deliveryStatus: EnumDeliveryStatus) = deliveryStatus.getCodeWithName()


/**
 * sealed class는 enum 클래스의 확장형이라고 설명하고 있는데
 * Enum 클래스는 아래와 같이 멤퍼 프로퍼티나, 메소드를 다르게 줄 수 없지만 sealed 클래스는 가능하기 때문이다.
 */

// 아래 방식으로도 선언 가능함
//sealed class SealedDeliveryStatus {
//    class WAIT(var code: Int, var codeName: String) : SealedDeliveryStatus()
//    class CONSIGN(var code: Int, var codeName: String, val riderName: String) : SealedDeliveryStatus()
//    class PICKUP(var code: Int, var codeName: String) : SealedDeliveryStatus()
//    class COMPLETE(var code: Int, var codeName: String, var completeTime: String) : SealedDeliveryStatus()
//}


sealed class SealedDeliveryStatus
class WAIT(var code: Int, var codeName: String) : SealedDeliveryStatus()
class CONSIGN(var code: Int, var codeName: String, val riderName: String) : SealedDeliveryStatus()
class PICKUP(var code: Int, var codeName: String) : SealedDeliveryStatus()
class COMPLETE(var code: Int, var codeName: String, var completeTime: String) : SealedDeliveryStatus(){
    fun getCodeWithCompleteTime() = "$code $completeTime"
}

/**
 * 각 상태에 맞는 멤버프로퍼티/메소드를 다르게 리턴 하도록 처리 가능하다.
 */
fun selectSealedDeliveryStatus(deliveryStatus: SealedDeliveryStatus): String {
    return when (deliveryStatus) {
        is WAIT -> deliveryStatus.codeName
        is CONSIGN -> deliveryStatus.riderName
        is PICKUP -> deliveryStatus.code.toString()
        is COMPLETE -> deliveryStatus.getCodeWithCompleteTime()
    }
}
