package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

/**
 * Created by kimchanjung on 2020-05-02 2:44 오후
 */

internal class ObservableTest {

    @Test
    fun observable이_정상적으로_동작한다() {
        // Given
        var name: String by observable("김찬정") { property, oldValue, newValue ->
            println("property =  $property, oldValue = $oldValue, newValue = $newValue")
        }

        // When
        name = "김찬정님"
    }


    @Test
    fun vetoable이_정상적으로_동작한다() {
        // Given
        var age: Int by vetoable(0) { property, oldValue, newValue -> newValue > oldValue }

        // When & Then
        age = 10
        assertEquals(10, age)
        age = 5
        assertEquals(10, age)
        age = 20
        assertEquals(20, age)
    }

}