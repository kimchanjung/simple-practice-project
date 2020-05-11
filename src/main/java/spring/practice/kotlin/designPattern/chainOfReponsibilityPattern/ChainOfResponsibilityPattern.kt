package spring.practice.kotlin.designPattern.chainOfReponsibilityPattern

/**
 * Created by kimchanjung on 2020-05-11 3:07 오후
 * [Chain Of Reponsibility Pattern]
 * 책임 연쇄 패턴
 *
 * 장점
 *  - 요청의 처리 방식을 다음 객체로 위임 하면서 분기처리가 없어진다.
 *  - 요청의 처리를 layer 방식으 나누어 처리하므로 객체간 결합도를 낮춘다.
 *
 * 단점
 *  - 요청을 처리하는 객체들을 어떻게 구성하느냐에 따라 요청이 처리 될수도 아닐 수도 있다.
 *  - 무한루프에 빠질 수 있으니 잘 고려해서 구성 해야함
 */


interface Rider {
    fun delivery(foodType: String): String
}

/**
 * 처리할 수 없으면 다음 객체에 처리를 넘긴다.
 * 처리의 전체적인 구성은 인스턴스 생성시 어떻게 다음 객체들을 구성 했느냐에 따라
 * 달라진다.
 */
class FullTimeRider(var next: Rider?) : Rider {
    override fun delivery(foodType: String) =
            if (foodType == "양식") "양식배달" else next!!.delivery(foodType)
}

class PartTimeRider(var next: Rider?) : Rider {
    override fun delivery(foodType: String) =
            if (foodType == "한식") "한식배달" else next!!.delivery(foodType)
}

class ConnectRider(var next: Rider?) : Rider {
    override fun delivery(foodType: String) =
            if (foodType == "분식") "분식배달" else next!!.delivery(foodType)
}


