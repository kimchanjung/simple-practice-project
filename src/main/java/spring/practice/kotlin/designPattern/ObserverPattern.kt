package spring.practice.kotlin.designPattern

/**
 * Created by kimchanjung on 2020-05-05 9:35 오후
 * [Observer Pattern]
 * 옵저버 패턴은 그야 말로 pub/sub 패턴 이라고 생각하면 쉽다.
 * spring 의 ApplicationEvent 이용한 이벤트 발행 구독이나
 * javascript onClick 같은 이벤트 리스너를 사용한다거나
 * 크게는 aws sns/sqs 같은 것들도 발생/구독 모델이다.
 *
 */

// 발행 인터페이스를 정의한다.
interface Publisher {
    fun add(subscriber: Subscriber): Boolean
    fun delete(subscriber: Subscriber): Boolean
    fun update(deliveryStatus: String): Boolean
}

// 구독 인터페이스를 정의한다.
interface Subscriber {
    fun onUpdate(deliveryStatus: String): Boolean
}


/**
 * 배달상태변경발행을 구현한다.
 * 이 서비스는 배달상태변경이 있을 때 마다 구독자들에게 알린다.
 */

class DeliveryStatusPublisher : Publisher {

    private val observerList = mutableListOf<Subscriber>()
    private var deliveryStatus = "WAIT"

    override fun add(subscriber: Subscriber) = observerList.add(subscriber)

    override fun delete(subscriber: Subscriber) = observerList.remove(subscriber)

    override fun update(deliveryStatus: String): Boolean {
        this.deliveryStatus = deliveryStatus
        observerList.forEach { it.onUpdate(deliveryStatus) }
        return true
    }

}

/**
 * 배달상태 변경 구독자를 구현한다.
 * 이 서비스는 배달상태 변경이 있을 때마다 변경 이벤트를 수신 받는다.
 */
class DeliveryStatusSubscriber : Subscriber {
    var isSent = false
        private set

    override fun onUpdate(deliveryStatus: String): Boolean {
        if (deliveryStatus == "COMPLETE") {
            sendEmail()
        }

        return true
    }

    private fun sendEmail() {
        isSent = true
    }

}