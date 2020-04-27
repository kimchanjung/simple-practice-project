package spring.practice.kotlin.basicSyntaxPractice

import javax.xml.crypto.Data

/**
 * Created by kimchanjung on 2020-04-25 4:03 오후
 * data 클래스는 아래 메소드를 기본제공
 * equals()
 * hashCode()
 * copy()
 * toString()
 * componentsN()
 *
 * 기본생성자에 반드시 var id:Long 파라메터와 프로퍼티 두 역할 선언 방법으로 선언 해야함
 * data class DataClass(id:Long, name:String ) <= 이렇게 선언할 수 없음
 * 그래서 여러가지 고려해야할 지점 들이 생김....
 */

data class DataClass(val id: Long, val name: String) {
    lateinit var address: String
        private set

    companion object {
        fun fromDto(dto: ResponseDto) = DataClass(
                id = dto.id,
                name = convertName(dto.name))

        fun fromEntity(entity: Entity): DataClass {
            val instance = DataClass(entity.id, entity.name + "님")
            instance.address = "서울"
            return instance
        }

        private fun convertName(name: String) = name + "님"

    }


}

data class ResponseDto(val id: Long, val name: String)
data class Entity(val id: Long, val name: String)
