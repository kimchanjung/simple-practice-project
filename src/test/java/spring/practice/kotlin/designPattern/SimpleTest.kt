package spring.practice.kotlin.designPattern

import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-06 3:14 오후
 */

internal class SimpleTest {
    private val motorCycleStrategy = MotorCycleStrategy()

    @Test
    fun test() {
        println(motorCycleStrategy.move())
    }
}