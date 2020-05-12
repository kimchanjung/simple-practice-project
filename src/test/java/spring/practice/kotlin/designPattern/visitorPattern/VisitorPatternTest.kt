package spring.practice.kotlin.designPattern.visitorPattern

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-12 5:29 오후
 */
internal class VisitorPatternTest {

    @Test
    fun 방문자패턴이_정상적으로_동작한다() {
        // Given
        val fullTimeRider = FullTimeRider()
        val partTimeRider = PartTimeRider()

        val totalRiderTask = TotalRiderTask()

        // When
        val fullTimeRiderTask = totalRiderTask.doTask(fullTimeRider)
        val partTimeRiderTask = totalRiderTask.doTask(partTimeRider)
        // Then
        assertEquals("오토바이배달오토바이를운전한다오토바이를수리한다", fullTimeRiderTask)
        assertEquals("자전거배달자전거를운전한다자전를수리한다", partTimeRiderTask)
    }
}