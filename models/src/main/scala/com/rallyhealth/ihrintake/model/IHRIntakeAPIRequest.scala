package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json


case class IHRIntakeAPIRequest (
                          requestHeader: Header,
                          consumerDetails: ConsumerDetails,
                          language: LanguageObj
                          )


object IHRIntakeAPIRequest {
  implicit val format = Json.format[IHRIntakeAPIRequest]
}