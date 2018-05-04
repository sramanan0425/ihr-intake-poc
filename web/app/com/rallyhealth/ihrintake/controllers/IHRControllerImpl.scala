package com.rallyhealth.ihrintake.controllers

import com.rallyhealth.ihrintake.model._
import com.rallyhealth.correlation.CorrelationId
import com.rallyhealth.ihrintake.configs.IhrIntakeConfig.Defaults
import com.rallyhealth.ihrintake.services.CentriIHRService
import com.rallyhealth.enigma.v4.logging.SecureLogger._
import com.rallyhealth.enigma.v4.{Encrypted, NeoEncryptionService}
import com.rallyhealth.optum.client.v8.common.OptumClientConfig
import com.rallyhealth.optum.client.v8.common.model.{BaseOptumResponseError, OptumResponseAppError, OptumResponseError}
import com.rallyhealth.optum.client.v8.member.ws.MemPERequestBodyBuilder.MemberProductEligibilityRequest
import com.rallyhealth.spartan.v2.util.logging.DefaultLogger
import play.api.libs.json._
import play.api.mvc.{Action, EssentialAction}

import scala.concurrent.{ExecutionContext, Future}

class IHRControllerImpl(
                                 centriIHRService: CentriIHRService
                                 )(implicit ec: ExecutionContext, neoEncryptionService: NeoEncryptionService) extends IHRController with DefaultLogger {
  def getIHRSummary: EssentialAction = Action.async(parse.json) { request =>
    logger.info(s"Received request ${request.body}")
    //val encryptedPayload: JsLookupResult = Json.toJson(request.body) \ optumClientConfig.encryptedPayloadKey
    //val payload: String = decryptPayload(encryptedPayload.getOrElse(
    //  throw new IllegalArgumentException("Empty JSON Payload")).as[String])
   val HTTP_STATUS_200=200
    val HTTP_STATUS_400=400;
    val ihrDataRequest=Json.toJson(request.body)
    ihrDataRequest.validate[IHRIntakeAPIRequest] match {

      case JsSuccess(body, _) =>

        centriIHRService.fetchSummary(body,None).flatMap {
          case Right(success) =>
            //OK(Json.toJson(success.member))
             Future.successful(Status((HTTP_STATUS_200))(Json.toJson(Map("IHRIntakeAPIResponse" -> success))))
          case Left(ihrDataRequestError: IHRDataRequestError) =>
            Future.successful((Status(HTTP_STATUS_400))(ihrDataRequestError.errorDescription))

        }

      case JsError(error) =>
        Future.successful(BadRequest(error.toString))

    }

  }

  def getIHRAllergy: EssentialAction = Action.async(parse.json) { request =>
    logger.info(s"Received request ${request.body}")
    //val encryptedPayload: JsLookupResult = Json.toJson(request.body) \ optumClientConfig.encryptedPayloadKey
    //val payload: String = decryptPayload(encryptedPayload.getOrElse(
    //  throw new IllegalArgumentException("Empty JSON Payload")).as[String])
    val HTTP_STATUS_200 = 200
    val HTTP_STATUS_400 = 400;
    val ihrDataRequest = Json.toJson(request.body)
    ihrDataRequest.validate[IHRIntakeAPIRequest] match {

      case JsSuccess(body, _) =>

        centriIHRService.fetchSummary(body, Some(DataClassCodeObj.ACTIVEADVERSEREACTION)).flatMap {
          case Right(success) =>
            //OK(Json.toJson(success.member))
            Future.successful(Status((HTTP_STATUS_200))(Json.toJson(Map("IHRIntakeAPIResponse" -> success))))
          case Left(ihrDataRequestError: IHRDataRequestError) =>
            Future.successful((Status(HTTP_STATUS_400)) (ihrDataRequestError.errorDescription))

        }

      case JsError(error) =>
        Future.successful(BadRequest(error.toString))

    }
  }


    def getIHRCondition: EssentialAction = Action.async(parse.json) { request =>
      logger.info(s"Received request ${request.body}")
      //val encryptedPayload: JsLookupResult = Json.toJson(request.body) \ optumClientConfig.encryptedPayloadKey
      //val payload: String = decryptPayload(encryptedPayload.getOrElse(
      //  throw new IllegalArgumentException("Empty JSON Payload")).as[String])
      val HTTP_STATUS_200=200
      val HTTP_STATUS_400=400;
      val ihrDataRequest=Json.toJson(request.body)
      ihrDataRequest.validate[IHRIntakeAPIRequest] match {

        case JsSuccess(body, _) =>

          centriIHRService.fetchSummary(body,Some(DataClassCodeObj.ACTIVEHEALTHCONDITION)).flatMap {
            case Right(success) =>
              //OK(Json.toJson(success.member))
              Future.successful(Status((HTTP_STATUS_200))(Json.toJson(Map("IHRIntakeAPIResponse" -> success))))
            case Left(ihrDataRequestError: IHRDataRequestError) =>
              Future.successful((Status(HTTP_STATUS_400))(ihrDataRequestError.errorDescription))

          }

        case JsError(error) =>
          Future.successful(BadRequest(error.toString))

      }

  }


}

