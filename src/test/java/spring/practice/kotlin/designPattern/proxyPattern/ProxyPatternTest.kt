package spring.practice.kotlin.designPattern.proxyPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-09 4:29 오후
 */
internal class ProxyPatternTest {

    @Test
    fun 프록시패턴이_정상적으로_동작한다() {
        // Given
        val proxyRider = ProxyRider("김찬정")

        // When && Then
        proxyRider.delivery()
        proxyRider.delivery()
    }

    @Test
    fun 보호프록시패턴이_정상적으로_동작한다() {
        // Given
        val protectedProxyRider = ProtectedProxyRider("김찬정")

        // When && Then
        assertEquals("접근불가", protectedProxyRider.getPersonalInfo(1))
        assertEquals("김찬정", protectedProxyRider.getPersonalInfo(4))
    }
}