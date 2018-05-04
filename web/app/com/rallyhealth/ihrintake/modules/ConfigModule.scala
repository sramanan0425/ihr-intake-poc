package com.rallyhealth.ihrintake.modules

import com.rallyhealth.ihrintake.configs.IhrIntakeSecureLoggerConfig
import com.rallyhealth.ihrintake.configs.IhrIntakeConfig
import com.rallyhealth.illuminati.v9.SecretConfig
import com.rallyhealth.optum.client.v8.common.{OptumClientConfig, OptumClientRallyConfig}
import com.rallyhealth.spartan.v2.config.RallyConfig
import com.softwaremill.macwire._

/**
  * Module for configs which the
  * services or clients depend on
  */
@Module
trait ConfigModule {
  def ihrIntakeConfig: IhrIntakeConfig
  def secureLoggerConfig: IhrIntakeSecureLoggerConfig

}

case class ConfigModuleImpl(rallyConfig: RallyConfig, secretConfig: SecretConfig) extends ConfigModule {
  override lazy val ihrIntakeConfig = wire[IhrIntakeConfig]
  override lazy val secureLoggerConfig = wire[IhrIntakeSecureLoggerConfig]

}

