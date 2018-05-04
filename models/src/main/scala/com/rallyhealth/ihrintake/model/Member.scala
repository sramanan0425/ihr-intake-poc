package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json

case class Member(
                        firstName: Option[String],
                        lastName: Option[String],
                        dateOfBirth: Option[String],
                        searchId: Option[String],
                        contractNumber: Option[String]
                      )
object Member {
  implicit val format = Json.format[Member]
}