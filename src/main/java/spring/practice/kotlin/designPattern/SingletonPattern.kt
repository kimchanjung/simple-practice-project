package spring.practice.kotlin.designPattern

/**
 * Created by kimchanjung on 2020-05-02 5:29 오후
 * https://beomseok95.tistory.com/239 <= 코틀린 싱글톤 패턴 설명
 */

// object 키워드로 싱글톤이 제공된다. thread-safe 하고 lazy 한 초기화 가능
object SingletonPattern {
    var name = "김찬정"
}

// 싱글톤 생성시 파라메터가 필요하다면
class LikeJavaSingletonPattern private constructor(private val name: String) {
    companion object {
        @Volatile
        private var instance: LikeJavaSingletonPattern? = null

        @Synchronized
        fun getInstance(param: String) = instance ?: LikeJavaSingletonPattern(param).also { instance = it }
    }
}

