package org.km.domain

import org.km.infra.AccountRepository
import org.specs2.mutable._

/**
 * Created by katsuki on 2015/02/17.
 */
class AccountTest extends Specification {

  "アカウントを作成する" should {
    "登録済みログインIDの場合エラーとなる" in {
      AccountRepository.clear()
      Account(new IPass("loginId1","password1"))
      Account(new IPass("loginId1","password2")) must throwA[DuplicateLoginIdException]
    }
  }
}
