package org.km.view.controllers

import org.km.domain.{Account, DuplicateLoginIdException, IPass}
import play.api.mvc._

object AccountViewController extends Controller {

  def init = Action {
    println("call ViewController")
    Ok(views.html.Index())
  }
}