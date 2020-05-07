package spring.practice.kotlin.designPattern.templateMethodPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-07 3:36 오후
 */
internal class TemplateMethodPatternTest {

    @Test
    fun 탬플릿메소드패턴이_정상적으로_동작한다() {
        // Given &  When
        val fullTimeRider:Rider = FullTimeRider("김찬정", 20, "서울", "3213213123")
        val partTimeRider:Rider = PartTimeRider("홍길동", 20, "한양", 3000)

        // Then
        assertEquals("출근오토바이배달오토바이수리퇴근", fullTimeRider.work())
        assertEquals("출근자전거배달자전거수리퇴근", partTimeRider.work())
    }
}