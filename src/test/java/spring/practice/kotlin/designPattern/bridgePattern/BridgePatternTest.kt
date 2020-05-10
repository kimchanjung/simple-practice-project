package spring.practice.kotlin.designPattern.bridgePattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-10 3:36 오후
 */
internal class BridgePatternTest {

    @Test
    fun 브릿지패턴이_정상적으로_동작한다() {
        // Given
        val riderWorkImpl = RiderWorkImpl()
        val upgradeRiderWorkImpl = UpgradeRiderWorkImpl()

        // When
        val fullTimeRider = FullTimeRider(riderWorkImpl)
        val upgradeFullTimeRider = FullTimeRider(upgradeRiderWorkImpl)

        // Then
        assertEquals("카카오맵으로 배달목적지 확인시동 페달을 밟는다", fullTimeRider.delivery())
        assertEquals("라이더앱에서 목적지 바로확인시동버튼을 누른다", upgradeFullTimeRider.delivery())
    }
}