package org.km.domain

import akka.actor.ActorContext
import org.km.infra.AccountRepository

/**
 * Created by katsuki on 2015/02/17.
 */
class Account(val id: Int,val iPass: IPass) {


}

object Account{

  def apply(iPass: IPass) : Account = {
    if(AccountRepository.findByLoginId(iPass.loginId) != None){
      throw new DuplicateLoginIdException()
    }
    val account: Account = new Account(1, iPass)
    AccountRepository.save(account)
    return account
  }
}
