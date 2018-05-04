package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json

case class AllergenObj(adverseReactionType: Option[String],allergen: String, reaction:String, severity:String,status: MedicalCode, lastUpdateDate: String)

object AllergenObj {
  def apply(allergen: String, reaction:String, severity:String,status: MedicalCode, lastUpdateDate: String) =
    new AllergenObj(None, allergen, reaction, severity, status, lastUpdateDate)


  implicit val format = Json.format[AllergenObj]



}



case class ActiveAdverseReaction(language: LanguageObj, items: List[AllergenObj]) extends DataClassObj {
  val recordType = DataClassCodeObj.ACTIVEADVERSEREACTION
}


object ActiveAdverseReaction {
  implicit val format = Json.format[ActiveAdverseReaction]
}
