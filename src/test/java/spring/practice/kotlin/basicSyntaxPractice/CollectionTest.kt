package spring.practice.kotlin.basicSyntaxPractice

import org.junit.jupiter.api.Test

/**
 * Created by kimchanjung on 2020-04-26 5:31 오후
 */
class CollectionTest {

    @Test
    fun 리스트가_정상적으로_동작한다() {
        // Given
        val mutableListOf = MutableList(2){v -> v +1}

        // When
        mutableListOf.forEach{ println("$it ")}

        // Then
    }
}