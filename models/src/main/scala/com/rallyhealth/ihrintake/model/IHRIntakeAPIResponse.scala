package com.rallyhealth.ihrintake.model
import play.api.libs.json.Json

case class IHRIntakeAPIResponse (
                                responseHeader: Header,
                                consumerDetails: ConsumerDetails,
                                language: LanguageObj,
                                activeAdverseReaction: Option[ActiveAdverseReaction],
                                activeHealthCondition: Option[ActiveHealthCondition]


                          )



object IHRIntakeAPIResponse {


  implicit val format = Json.format[IHRIntakeAPIResponse]

}