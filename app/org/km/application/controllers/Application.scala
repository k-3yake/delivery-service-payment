package org.km.application.controllers

import play.api.mvc.{Action, Controller}

object Application extends Controller {

  def index = Action {
    Ok(views.html.Index())
  }
  
}
