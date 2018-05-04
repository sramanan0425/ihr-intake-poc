package com.rallyhealth.ihrintake.model

import enumeratum.{Enum, EnumEntry, PlayJsonEnum}

sealed abstract class DataClassCodeObj(override val entryName: String) extends EnumEntry

object DataClassCodeObj extends Enum[DataClassCodeObj] with PlayJsonEnum[DataClassCodeObj]{

  val values = findValues

  case object CARETEAM extends DataClassCodeObj("CARETEAM")
  case object TESTANDEXAM extends DataClassCodeObj("TESTANDEXAM")
  case object ACTIVEADVERSEREACTION extends DataClassCodeObj("ACTIVEADVERSEREACTION")
  case object ACTIVEHEALTHCONDITION extends DataClassCodeObj("ACTIVEHEALTHCONDITION")
}
