package spring.practice.kotlin.designPattern

/**
 * Created by kimchanjung on 2020-05-05 1:22 오후
 * [Apdater Pattern]
 * 사용자는 일관성있는 인터페이스를 사용하여 변경이 필요 없고
 * 인터페이스의 구현체는 각각 세부로직은 다르지만 인터페이스에 맞게 구현하여
 * 사용자는 약간식 세구 구현이 다른 클래스를 일관성있게 사용한다.
 * 만능 리모컨을 생각하면 쉬울 수 있다.
 * 삼성 TV 와 LG TV의 리모컨은 대부분 서로 비슷하지만 약간 다르다
 * 사용자는 삼성 TV 와 LG TV 사용할때 각각의 리모컨을 사용해야하지만
 * 만능 리모컨은 각각 TV에 맞게 동작 하도록 세부로직은 다르지만 사용자에게
 * 제공하는 리모컨 기능은 동일하여 사용자가 개별 제조사의 TV 리모컨을 따로 사용할 필요없이
 * 만능 리모컨만 사용하면 된다. TV 종류가 추가 되어도 마찬가지
 */

// 기존 로그인 서비스
class FaceBookLoginService {
    fun goLoginPage() = this
    fun requestLogin(id: String, pw: String) = true
}

//
class GoogleLoginService {
    fun goLoginPage() = this
    fun requestLogin(id: String, pw: String) = this
    fun redirect(url: String) = url
}

/**
 * 기존 로그인 서비스를 사용하고 있다.

 * class ClientService {
 *     private val faceBookLoginService = FaceBookLoginService()
 *
 *     fun login(id:String, pw:String) {
 *         faceBookLoginService
 *                 .goLoginPage()
 *                 .requestLog(id, pw)
 *     }
 * }
 *
 *
 * 각각의 서비스들은 아래 처럼 동일 하게 로그인 서비스를 사용하고 있을 것이다.
 *
 * class ClientService2 {
 *     private val faceBookLoginService = FaceBookLoginService()
 *
 *     fun login(id:String, pw:String) {
 *         faceBookLoginService
 *                 .goLoginPage()
 *                 .requestLog(id, pw)
 *     }
 * }
 */

/**
 * 그런데 NewLoginService로 업그레이드를 하였고
 * 때에 따라 기존 로그인 서비스를 사용하는 곳도 있다.
 * 그렇게 일관성 없고 기존 로그인 서비스는 rediect 메소드를 사용하는 측에서 구현 해주어야 한다.
 * (로그인 서비스는 외부 서비스이고 우리가 메소드를 추가하거나 수정 할 수 없다고 가정)
 */
class ClientService1 {
    private val googleLoginService = GoogleLoginService()

    fun login(id: String, pw: String) {
        googleLoginService
                .goLoginPage()
                .requestLogin(id, pw)
                .redirect("www.home.com") // <- 메소드가 추가 되었다.
    }
}

class ClientService2 {
    private val faceBookLoginService = FaceBookLoginService()

    fun login(id: String, pw: String) {
        faceBookLoginService
                .goLoginPage()
                .requestLogin(id, pw)
        redirect("www.home.com")
    }

    private fun redirect(url: String) {
        // redirect logic
    }
}

/**
 * 어댑터 인터페이스를 선언한다
 */
interface LoginAdapter {
    fun goLoginPage(): LoginAdapter
    fun requestLogin(id: String, pw: String): LoginAdapter
    fun redirect(url: String): String
}

/**
 * 각각 어탭터 인터페이스를 구현한다
 * 기존 로그인 서비스를 사용하는 구현체
 */
class FaceBookLoginAdapterImpl : LoginAdapter {
    private val faceBookLoginService = FaceBookLoginService()

    override fun goLoginPage(): LoginAdapter {
        faceBookLoginService.goLoginPage()
        return this
    }

    override fun requestLogin(id: String, pw: String): LoginAdapter {
        faceBookLoginService.requestLogin(id, pw)
        return this
    }

    override fun redirect(url: String): String {
        // redirect logic
        return url
    }
}

/**
 * 새로운 로그인서비스를 사용하는 구현체
 */
class GoogleLoginAdapterImpl : LoginAdapter {
    private val googleLoginService = GoogleLoginService()

    override fun goLoginPage(): LoginAdapter {
        googleLoginService.goLoginPage()
        return this
    }

    override fun requestLogin(id: String, pw: String): LoginAdapter {
        googleLoginService.requestLogin(id, pw)
        return this
    }

    override fun redirect(url: String) = googleLoginService.redirect(url)
}

/**
 * 서비스는 어떤 로그인서비스를 사용할지 판단단하여 필요한 로직을 또 추가 구현 할 필요없이
 * 로그인 어댑터 인터페이스만 사용하면 된다.
 */
class ClientService(private val loginAdapter: LoginAdapter) {
    fun login(id: String, pw: String, redirectUrl: String) = loginAdapter
            .goLoginPage()
            .requestLogin(id, pw)
            .redirect(redirectUrl)

}










