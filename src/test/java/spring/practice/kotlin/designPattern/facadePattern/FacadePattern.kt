package spring.practice.kotlin.designPattern.facadePattern

/**
 * Created by kimchanjung on 2020-05-10 4:04 오후
 * [Facade Pattern]
 * https://lktprogrammer.tistory.com/42
 *
 * 퍼사드 패턴은 아마도 우리가 프로그래밍 하면서 자연스럽게 사용되어지는 패턴중에 가장 흔한 패턴이 아닌가 싶다.
 * 일련의 복잡한 로직을 간추려 별도의 클래스로 만들어 제공한다.
 *
 * aws s3에 이미지를 저장한다고 하면 아래 처럼 처리가 복잡 할 수 있고
 * 이미지를 저정하기 위한 일련의 복잡한 코드들을 반복적으로 작성해야한다.
 *
 * 라이더서비스 {
 *      이미지저장(이미지) {
 *        AwsS3 s3 = AwsS3()
 *        이미지.이미지명
 *        이미지.이미지위치
 *        이미지.bytecode
 *        s3.setName(이미지.이미지명)
 *        s3.setLocation(이미지.이미지위치)
 *        ..
 *        s3.upload()
 *      }
 * }
 *
 * 배달서비스 {
 *      이미지저장(이미지) {
 *        AwsS3 s3 = AwsS3()
 *        이미지.이미지명
 *        이미지.이미지위치
 *        이미지.bytecode
 *        s3.setName(이미지.이미지명)
 *        s3.setLocation(이미지.이미지위치)
 *        ..
 *        s3.upload()
 *      }
 * }
 *
 */

class Image(var name: String, var fileDir: String?)

class S3 {
    lateinit var name: String
    lateinit var location: String
    fun upload() = true
}

/**
 * 퍼사드 패턴을 사용하지 않으면 아래와 같이 복잡한 단계를
 * 여러 곳에서 사용하고 있었을 것이다.
 */

class RiderService {
    private val s3 = S3()

    fun createRider() = "라이더생성"
    fun uploadRiderProfile(image: Image) {
        s3.name = image.name
        s3.location = image.fileDir
                ?.replace("/local/image", "")
                .toString()

        s3.upload()
    }
}

class DeliveryService {
    private val s3 = S3()

    fun createDelivery() = "배달생성"
    fun uploadFoodImage(image: Image) {
        s3.name = image.name
        s3.location = image.fileDir
                ?.replace("/local/image", "")
                .toString()

        s3.upload()
    }
}

/**
 * S3 인스턴스 생성 후 image 관련 값들을 조작 생성 하여
 * upload 까지 일련의 로직을 하나의 메소드로 묶어 제공하는 형태로 구성한다.
 */
class AwsS3UploadService {
    private var s3 = S3()
    fun upload(image: Image): Boolean {
        s3.name = image.name
        s3.location = image.fileDir
                ?.replace("/local/image", "")
                .toString()

        return s3.upload()
    }
}

/**
 * 퍼사드 패턴으로 구성된 AwsS3UploadService를 간편하게 사용한다.
 */
class NewRiderService {
    private val awsS3UploadService = AwsS3UploadService()
    fun createRider() = "라이더생성"
    fun uploadRiderProfile(image: Image) = awsS3UploadService.upload(image)
}
