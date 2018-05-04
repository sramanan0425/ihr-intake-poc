package com.rallyhealth.ihrintake.model

import enumeratum.{Enum, EnumEntry, PlayJsonEnum}

sealed abstract class MemberIdType(override val entryName: String) extends EnumEntry

object MemberIdType extends Enum[MemberIdType] with PlayJsonEnum[MemberIdType]{

  val values = findValues

  case object RallyId extends MemberIdType("RallyId")
  case object Big5 extends MemberIdType("Big5")

}
