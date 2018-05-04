package com.rallyhealth.ihrintake.controllers

import com.rallyhealth.spartan.v2.util.logging.DefaultLogger
import play.api.mvc.Action

class GreetControllerImpl extends GreetController with DefaultLogger {

  override def greet = Action {
    implicit request =>
      logger.info(s"Received greet request")
      Ok("greets to you")
  }
}
