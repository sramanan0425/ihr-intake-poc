package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json



case class ConditionObj(onsetDate: String, lastUpdateDate: String, healthCondition:MedicalCode, status: MedicalCode)

object ConditionObj {
  implicit val format = Json.format[ConditionObj]
}

case class ActiveHealthCondition(language: LanguageObj, items: List[ConditionObj]) extends DataClassObj {
  val recordType=DataClassCodeObj.ACTIVEHEALTHCONDITION

}

object ActiveHealthCondition {
  implicit val format = Json.format[ActiveHealthCondition]
}


