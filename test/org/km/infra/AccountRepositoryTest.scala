package org.km.infra

import org.km.domain.{IPass, Account}
import org.specs2.mutable._

/**
 * Created by katsuki on 2015/02/17.
 */
class AccountRepositoryTest extends Specification {

  "LoginIdでの取得" should {
    "登録されていないならNoneを返す" in {
      AccountRepository.findByLoginId("notExist") must equalTo(None)
    }
    "登録されていればAccountを返す" in {
      val loginId: String = "exist"
      val account = Account(new IPass(loginId,"pass"))
      AccountRepository.findByLoginId("exist").get must equalTo(account)
    }

  }


}
