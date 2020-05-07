package spring.practice.kotlin.designPattern.strategyPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import spring.practice.kotlin.designPattern.strategyPattern.*
import kotlin.jvm.JvmStatic as JvmStatic

/**
 * Created by kimchanjung on 2020-05-06 2:22 오후
 */
internal class StrategyPatternTest {
    private var motorCycleStrategy = MotorCycleStrategy()
    private var bikeStrategy = BikeStrategy()
    private var bySubwayStrategy = BySubwayStrategy()
    private var byCarStrategy = ByCarStrategy()
    private var dontGoToWorkStrategy = DontGoToWorkStrategy()

    companion object {
        @BeforeAll
        @JvmStatic
        fun init() {
            println("init")
        }
    }

    @Test
    fun 전략주입이_정상적으로_동작한다() {
        // Given // When
        val fullTimeRider = FullTimeRider("김찬정", bySubwayStrategy, motorCycleStrategy)
        val partTimeRider = PartTimeRider("홍길동", byCarStrategy, bikeStrategy)

        // Then
        assertEquals("오토바이", fullTimeRider.deliveryBy())
        assertEquals("지하철", fullTimeRider.goToWorkBy())
        assertEquals("자전거", partTimeRider.deliveryBy())
        assertEquals("자가용", partTimeRider.goToWorkBy())
    }

    @Test
    fun 전략변경이_정상적으로_동작한다() {
        // Given
        val fullTimeRider = FullTimeRider("김찬정", bySubwayStrategy, motorCycleStrategy)
        val connectRider = ConnectRider("이순신", dontGoToWorkStrategy, bikeStrategy)

        // When
        fullTimeRider.changeDeliveryStrategy(bikeStrategy)
        connectRider.changeGoToWorkStrategy(bySubwayStrategy)

        // Then
        assertEquals("자전거", fullTimeRider.deliveryBy())
        assertEquals("지하철", fullTimeRider.goToWorkBy())
        assertEquals("자전거", connectRider.deliveryBy())
        assertEquals("지하철", connectRider.goToWorkBy())
    }
}