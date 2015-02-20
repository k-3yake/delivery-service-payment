package org.km.application.controllers

import org.km.domain.{DuplicateLoginIdException, IPass, Account}
import play.api.mvc._

object AccountController extends Controller {

  def register() = Action { request =>
    println("registCalled." + request.body)
    val jsValue = request.body.asJson.get
    val loginId = (jsValue \ "loginId").as[String]
    try{
      Account(new IPass(loginId,"pass"))
      Ok
    }catch {
      case ex: DuplicateLoginIdException => {
        Conflict
      }
    }
  }

  def update(loginId: String) = Action { request =>
    Ok
  }
}