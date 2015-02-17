package integration

import org.km.infra.AccountRepository
import play.api.http.ContentTypeOf
import play.api.libs.json.JsValue
import play.api.test.Helpers._
import play.api.test.Helpers.await
import play.api.libs.ws.WS
import play.api.libs.json._
import play.api.libs.ws._
import play.api.test._
import play.api.http.ContentTypeOf._
import org.specs2.mutable.Specification

import scala.concurrent.Future


/**
 * Created by katsuki on 2015/02/14.
 */

class WhenServiceAuth extends Specification{

  "サービス認証" should {
    "無料期間開始前は認証に失敗する" in new WithServer {
      val accountUrl = "http://localhost:" + port + "/account/"
      val serviceAuthUrl = "http://localhost:" + port + "/serviceAuth/"
      val loginId = "loginId1"
      //Given:アカウントが新規登録する
      AccountRepository.clear()
      val r1 = WS.url(accountUrl).post(Json.obj("loginId" -> "loginId1","password" -> "password1"))
      Helpers.await(r1).status must equalTo(OK)
      //When:アカウントがサービス認証する
      val response = WS.url(serviceAuthUrl + loginId).get()
      //Then:認証は失敗する
      Helpers.await(response).status must not equalTo(OK)
    }
    "無料期間内は認証に成功する" in new WithServer {
      val accountUrl = "http://localhost:" + port + "/account/"
      val serviceAuthUrl = "http://localhost:" + port + "/serviceAuth/"
      val loginId = "loginId1"

      //Given:アカウントが新規登録する
      AccountRepository.clear()
      val r1 = WS.url(accountUrl).post(Json.obj("loginId" -> "loginId1","password" -> "password1"))
      Helpers.await(r1).status must equalTo(OK)
      //And:アカウントがアプリでログインする
      val r2 = WS.url(accountUrl + loginId).put(Json.obj("contract" -> "trial"))
      Helpers.await(r2).status must equalTo(OK)
      //When:アカウントがサービス認証する
      val response = WS.url(serviceAuthUrl + loginId).get()
      //Then:認証は成功する
      Helpers.await(response).status must equalTo(OK)
    }
  }
}



