package org.km.application.controllers

import play.api.mvc._

object ServiceController extends Controller {

  def auth(loginId: String) = Action { request =>
    Ok("")
  }
}