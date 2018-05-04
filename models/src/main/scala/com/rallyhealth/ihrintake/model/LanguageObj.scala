package com.rallyhealth.ihrintake.model

import enumeratum.{Enum, EnumEntry, PlayJsonEnum}

sealed abstract class LanguageObj(override val entryName: String) extends EnumEntry

object LanguageObj extends Enum[LanguageObj] with PlayJsonEnum[LanguageObj]{

  val values = findValues

  case object ENGLISH extends LanguageObj("EN")
  case object SPANISH extends LanguageObj("SP")

}
