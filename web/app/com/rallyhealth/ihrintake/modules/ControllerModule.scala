package com.rallyhealth.ihrintake.modules

import com.rallyhealth.ihrintake.controllers.{ GreetController, GreetControllerImpl}
import com.rallyhealth.enigma.v4.NeoEncryptionService
import com.rallyhealth.ops.StandardOpsController
import com.rallyhealth.ihrintake.controllers.{IHRController, IHRControllerImpl}
import com.softwaremill.macwire._

import scala.concurrent.ExecutionContext

/**
  * Module that setups up all the Controller instances.
  */
@Module
trait ControllerModule {
  def greetController: GreetController
  def opsMonitorController: StandardOpsController
  def ihrController: IHRController

}

/**
  * All Controller Dependencies are defined here.
  */
case class ControllerModuleImpl(serviceModule: ServiceModule, configModule: ConfigModule)(implicit ec: ExecutionContext) extends ControllerModule {
  implicit val apiNeoEncryptionService: NeoEncryptionService = configModule.ihrIntakeConfig.ihrIntakeApiEncryptionService
  override lazy val greetController: GreetController = wire[GreetControllerImpl]
  override lazy val opsMonitorController: StandardOpsController = wire[StandardOpsController]
  override lazy val ihrController: IHRController=wire[IHRControllerImpl]
}
