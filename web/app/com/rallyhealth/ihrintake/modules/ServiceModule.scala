package com.rallyhealth.ihrintake.modules

import com.rallyhealth.ihrintake.services._

import scala.concurrent.ExecutionContext
import com.softwaremill.macwire._

/**
  * Module for services
  */
@Module
trait ServiceModule {
  def centriIHRService: CentriIHRService
}

/**
  * Defines the Service Module and its dependencies
  */
case class ServiceModuleImpl()(implicit ec: ExecutionContext) extends ServiceModule {

  override lazy val centriIHRService: CentriIHRService = wire[CentriIHRServiceImpl]

}
