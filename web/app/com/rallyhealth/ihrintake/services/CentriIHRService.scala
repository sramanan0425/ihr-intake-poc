package com.rallyhealth.ihrintake.services


import java.time.Instant
import com.rallyhealth.ihrintake.util.{IhrIntakeStats, StatsConstants}

import com.rallyhealth.spartan.v2.util.logging.DefaultLogger
import com.rallyhealth.ihrintake.model._

import scala.concurrent.{ExecutionContext, Future}
import com.rallyhealth.optum.client.v8.common.model.{BaseOptumResponseError, OptumResponseSuccess}
trait CentriIHRService {

  /**
    * Calls the CentriHealth IHR API to fetch IHR data
    *
    */

    def fetchSummary(ihrIntakeAPIRequest: IHRIntakeAPIRequest, dataClassCodeObj:Option[DataClassCodeObj])(implicit ec: ExecutionContext):
    Future[Either[IHRDataRequestError, IHRIntakeAPIResponse]]


}


class CentriIHRServiceImpl extends CentriIHRService
    with DefaultLogger
    with IhrIntakeStats {

  override def statPath: Seq[String] = StatsConstants.centrIhrService

  private def mockAllergy(): ActiveAdverseReaction= {
    val allergyItems:List[AllergenObj]=List(AllergenObj("pollen","rashes","moderate",MedicalCode(MedicalCodeSystem.SNOMED,"S6789","Active"),"2018-01-01"))
      .:::(List(AllergenObj("nuts","wheezing","severe",MedicalCode(MedicalCodeSystem.SNOMED,"S6789","Active"),"2018-01-01")))
    ActiveAdverseReaction(LanguageObj.ENGLISH,allergyItems)
  }

  private def mockCondition(): ActiveHealthCondition = {
    val conditionItems:List[ConditionObj] = List(ConditionObj("01-01-2018","05-01-2018"
      , MedicalCode(MedicalCodeSystem.ICD10,"I77777","Diabetes")
      , MedicalCode(MedicalCodeSystem.SNOMED,"S6789","Active")))

      .:::(List(ConditionObj("01-01-2018","05-01-2018"
        , MedicalCode(MedicalCodeSystem.ICD10,"I888888","Hypertension")
        , MedicalCode(MedicalCodeSystem.SNOMED,"S6789","Active"))))

    ActiveHealthCondition(LanguageObj.ENGLISH,conditionItems)
  }

  def fetchSummary(ihrIntakeAPIRequest: IHRIntakeAPIRequest , dataClassCodeObj:Option[DataClassCodeObj])(implicit ec: ExecutionContext):
  Future[Either[IHRDataRequestError, IHRIntakeAPIResponse]] = {
    val startTime = Instant.now().toEpochMilli



    val ihrIntakeAPIResponse=IHRIntakeAPIResponse(ihrIntakeAPIRequest.requestHeader
                              , ihrIntakeAPIRequest.consumerDetails
                              , ihrIntakeAPIRequest.language
                              ,  (dataClassCodeObj match {
                                case Some(DataClassCodeObj.ACTIVEADVERSEREACTION) => Some(mockAllergy)
                                case Some(x) => None
                                case None => Some(mockAllergy)
                              }),
                              (dataClassCodeObj match {
                                case Some(DataClassCodeObj.ACTIVEHEALTHCONDITION) => Some(mockCondition)
                                case Some(x) => None
                                case None => Some(mockCondition)
                              }))

    ihrIntakeAPIRequest.consumerDetails.firstName match {
      case Some(firstName) => {
        emitSuccess(Some(startTime))
        Future{Right(ihrIntakeAPIResponse)}
      }
      case None => {
        emitError(Some(startTime))
        Future{Left(IHRDataRequestError(404, "Not Found"))}
      }

    }


  }





}