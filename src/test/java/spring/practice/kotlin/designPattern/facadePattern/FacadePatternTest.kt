package spring.practice.kotlin.designPattern.facadePattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-05-10 4:31 오후
 */
internal class FacadePatternTest {

    @Test
    fun 퍼사드패턴이_정상적으로_동작한다() {
        // Given
        val image = Image("라이더이미지", "/local/image/rider-profile/라이더이미지.jpg")
        val newRiderService = RiderService()
        // When

        val uploadRiderProfile = newRiderService.uploadRiderProfile(image)

        // Then
        assertTrue(uploadRiderProfile)
    }
}