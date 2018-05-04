package com.rallyhealth.ihrintake.model

import play.api.libs.json.Json

case class IHRDataRequestError (errorCode: Int, errorDescription: String)

object IHRDataRequestError {
  implicit val format = Json.format[IHRDataRequestError]
}


