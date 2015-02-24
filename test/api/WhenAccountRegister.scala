package api

import org.junit.runner._
import org.km.infra.AccountRepository
import org.specs2.mutable._
import org.specs2.runner._
import play.api.libs.json.Json.JsValueWrapper
import play.api.test.Helpers._
import play.api.test._
import play.api.libs.json._

class WhenAccountRegister extends Specification {
  val accountPath ="/account/"

  "未登録のログインIDを登録した" should {
    "成功する" in new WithApplication{
      //Given:
      AccountRepository.clear()
      //When:
      val loginId = "loginId1"
      val res = route(FakeRequest(POST, accountPath).withJsonBody(Json.obj("loginId" -> loginId,"password" -> "password1"))).get
      //Then:
      status(res) must equalTo(OK)
      //And:
      AccountRepository.findByLoginId(loginId) must not be equalTo(None)
    }
  }

  "登録済みのログインIDを登録した" should {
    "失敗する" in new WithApplication{
      //Given:"loginId1"のアカウント1は登録されている
      AccountRepository.clear()
      val loginId = "loginId1"
      route(FakeRequest(POST, accountPath).withJsonBody(Json.obj("loginId" -> loginId,"password" -> "password1"))).get
      //When:同一のアカウントIDのカウントを登録する
      val res = route(FakeRequest(POST, accountPath).withJsonBody(Json.obj("loginId" -> loginId,"password" -> "password2"))).get
      //Then:失敗する
      status(res) must equalTo(CONFLICT)
      //And:アカウントは登録されていない
    }
  }
}
