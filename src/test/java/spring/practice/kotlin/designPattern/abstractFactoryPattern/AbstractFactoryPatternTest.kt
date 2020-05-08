package spring.practice.kotlin.designPattern.abstractFactoryPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-08 3:13 오후
 */
internal class AbstractFactoryPatternTest {
    @Test
    fun 추상팩토리패턴이_정상적으로_동작한다() {
        // Given & When
        val riderService1 = RiderService(FullTimeRiderFactory)
        val riderService2 = RiderService(PartTimeRiderFactory)

        // Then
        assertEquals("오토바이배달오토바이헬멧착용악셀", riderService1.work())
        assertEquals("자전거배달자전거헬멧착용페달", riderService2.work())
    }
}