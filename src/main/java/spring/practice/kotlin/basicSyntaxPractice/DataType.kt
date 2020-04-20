package spring.practice.kotlin.basicSyntaxPractice

/**
 * Created by kimchanjung on 2020-04-19 3:27 오후
 */
class DataType {
    fun showInt(param: Int):Int {
        val result = param + 10
        println("result = $result")
        return result
    }

    fun showString(param: String): String {
        val name = "김\n$param"
        println(name)
        val address = """
            서울
            특별시
            관악
        """
        println(address)

        return name + address
    }
}