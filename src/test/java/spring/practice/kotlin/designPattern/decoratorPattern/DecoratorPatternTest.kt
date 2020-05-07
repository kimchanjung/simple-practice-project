package spring.practice.kotlin.designPattern.decoratorPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import spring.practice.kotlin.designPattern.decoratorPattern.*
import spring.practice.kotlin.designPattern.decoratorPattern.Rider

/**
 * Created by kimchanjung on 2020-05-06 4:54 오후
 */
internal class DecoratorPatternTest {

    @Test
    fun 데코레이터패턴이_정상적으로_동작한다() {
        // Given
        val rider = Rider("정규직라이더")
        val developer = Developer("개발자")

        // When
        val riderWithRepairVehicle = RiderWithRepairVehicle(rider)
        val riderWithManagement = RiderWithManagement(rider)
        val riderWithRepairVehicleManagement = RiderWithManagement(riderWithRepairVehicle)
        val developerWithReactJs = DeveloperWithReactJs(developer)
        val developerWithSpringBoot = DeveloperWithSpringBoot(developer)
        val developerWithReactSpringBoot = DeveloperWithSpringBoot(developerWithReactJs)

        // Then
        assertEquals("음식배달", rider.working())
        assertEquals("음식배달|오토바이수리", riderWithRepairVehicle.working())
        assertEquals("음식배달|라이더관리업무", riderWithManagement.working())
        assertEquals("음식배달|오토바이수리|라이더관리업무", riderWithRepairVehicleManagement.working())
        assertEquals("정규직라이더|수리기사|관리자", riderWithRepairVehicleManagement.displayJobType())

        assertEquals("java", developer.working())
        assertEquals("java|reactjs", developerWithReactJs.working())
        assertEquals("java|springboot", developerWithSpringBoot.working())
        assertEquals("java|reactjs|springboot", developerWithReactSpringBoot.working())
        assertEquals("java|reactjs|springboot", developerWithReactSpringBoot.working())
        assertEquals("개발자|프론트엔드|백엔드", developerWithReactSpringBoot.displayJobType())
    }
}