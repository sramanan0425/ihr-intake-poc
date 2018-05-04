package com.rallyhealth.ihrintake.model

import enumeratum.{Enum, EnumEntry, PlayJsonEnum}
import play.api.libs.json.Json

sealed abstract class MedicalCodeSystem(override val entryName: String) extends EnumEntry

object MedicalCodeSystem extends Enum[MedicalCodeSystem] with PlayJsonEnum[MedicalCodeSystem]{

  val values = findValues

  case object SNOMED extends MedicalCodeSystem("SNOMED")
  case object ICD9 extends MedicalCodeSystem("ICD-9")
  case object ICD10 extends MedicalCodeSystem("ICD-10")

}

case class MedicalCode(sourceVocabulary: MedicalCodeSystem, sourceVocabularyCode: String, ihrTerm: String)
object MedicalCode {
  implicit val format = Json.format[MedicalCode]
}