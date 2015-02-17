package org.km.infra

import org.km.domain.Account
import scala.collection.mutable.Map

/**
 * Created by katsuki on 2015/02/17.
 */
object AccountRepository {
  var accounts: Map[Int,Account] = Map.empty

  def save(account: Account) = {
    accounts.put(account.id,account)
  }

  def findByLoginId(loginId: String): Option[Account] = {
    accounts.values.foreach { account =>
      if(account.iPass.loginId.equals(loginId)){
        return Some(account)
      }
    }
    return None
  }

  def clear(): Unit ={
    accounts = Map.empty
  }
}
