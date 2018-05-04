package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json

case class Header(
     applicationName: String,
     messageId: String

)

object Header {
  implicit val format = Json.format[Header]
}