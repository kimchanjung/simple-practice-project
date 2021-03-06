package spring.practice.kotlin.designPattern.adapterPattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-05 1:50 오후
 */
internal class AdapterPatternTest {


    @Test
    fun 로그인어댑가_정상적으로_동작한다() {
        // Given
        val clientService = LoginService(FaceBookLoginAdapterImpl())
        val clientService2 = LoginService(GoogleLoginAdapterImpl())

        // When
        val redirectUrl = clientService.login("id", "pw,", "www.home.com")
        val redirectUrl2 = clientService.login("id", "pw,", "new.home.com")

        // Then
        assertEquals(redirectUrl, "www.home.com")
        assertEquals(redirectUrl2, "new.home.com")
    }

}