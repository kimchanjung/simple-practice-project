package spring.practice.kotlin.designPattern.flyWeightParttern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-10 7:29 오후
 */
internal class FlyWeightPatternTest {

    @Test
    fun 플라이웨이트패턴이_정상적으로_동작한다() {
        // Given
        val riderService = RiderService()
        riderService.delivery("강남","fulltime")
        riderService.delivery("강남","fulltime")
        riderService.delivery("관악","fulltime")
    }
}