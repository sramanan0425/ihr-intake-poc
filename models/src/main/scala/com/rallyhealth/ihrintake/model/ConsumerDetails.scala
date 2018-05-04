package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json


case class ConsumerDetails (
                           rallyId: String,
                             firstName: Option[String],
                             lastName: Option[String],
                             dateOfBirth: Option[String],
                             searchId: Option[String],
                             contractNumber: Option[String]

                           )



object ConsumerDetails {
  implicit val format = Json.format[ConsumerDetails]
}


