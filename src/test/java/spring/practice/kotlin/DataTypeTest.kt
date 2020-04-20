package spring.practice.kotlin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import spring.practice.kotlin.basicSyntaxPractice.DataType

/**
 * Created by kimchanjung on 2020-04-19 3:29 오후
 */
internal class DataTypeTest {
    private val dataTypePractice = DataType()

    @Test
    fun 숫자가_정상적으로_합산된다() {
        val add = dataTypePractice.showInt(8)
        assertEquals(add, 18)
    }

    @Test
    fun 주소가_정상적으로_반환된다() {
        dataTypePractice.showString("찬정")
    }
}