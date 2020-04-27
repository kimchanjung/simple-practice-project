package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-26 6:07 오후
 */

enum class EnumClass(var number: Int, var desc: String) {
    WAIT(1, "대기"),
    CONSIGN(2, "배차완료중"),
    COMPLETE_PICKUP(3, "픽업완료"),
    COMPLETE_DELIVERY(4, "전달완료");

    fun getStatus() = "$name($number)"
}


fun selectStatus(status: EnumClass) = when (status) {
    EnumClass.COMPLETE_DELIVERY -> "COMPLETE_DELIVERY"
    EnumClass.CONSIGN, EnumClass.COMPLETE_PICKUP -> "CONSIGN or COMPLETE_PICKUP"
    else -> "NOT"
}

fun selectStatus(status1: EnumClass, status2: EnumClass) = when (setOf(status1, status2)) {
    setOf(EnumClass.COMPLETE_DELIVERY) -> "COMPLETE_DELIVERY"
    setOf(EnumClass.CONSIGN, EnumClass.COMPLETE_PICKUP) -> "CONSIGN or COMPLETE_PICKUP"
    else -> "NOT"
}

