
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sudha-ramanan/ihr-intake-poc/web/conf/routes
// @DATE:Fri May 04 11:40:52 CDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  GreetController_1: com.rallyhealth.ihrintake.controllers.GreetController,
  // @LINE:8
  IHRController_0: com.rallyhealth.ihrintake.controllers.IHRController,
  // @LINE:13
  opsStatic_Routes_0: opsStatic.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    GreetController_1: com.rallyhealth.ihrintake.controllers.GreetController,
    // @LINE:8
    IHRController_0: com.rallyhealth.ihrintake.controllers.IHRController,
    // @LINE:13
    opsStatic_Routes_0: opsStatic.Routes
  ) = this(errorHandler, GreetController_1, IHRController_0, opsStatic_Routes_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, GreetController_1, IHRController_0, opsStatic_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """greet""", """com.rallyhealth.ihrintake.controllers.GreetController.greet"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ihr/summary/v1""", """com.rallyhealth.ihrintake.controllers.IHRController.getIHRSummary"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ihr/allergies/v1""", """com.rallyhealth.ihrintake.controllers.IHRController.getIHRAllergy"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ihr/conditions/v1""", """com.rallyhealth.ihrintake.controllers.IHRController.getIHRCondition"""),
    prefixed_opsStatic_Routes_0_4.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val com_rallyhealth_ihrintake_controllers_GreetController_greet0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("greet")))
  )
  private[this] lazy val com_rallyhealth_ihrintake_controllers_GreetController_greet0_invoker = createInvoker(
    GreetController_1.greet,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "com.rallyhealth.ihrintake.controllers.GreetController",
      "greet",
      Nil,
      "POST",
      """ An example controller showing a sample home page""",
      this.prefix + """greet"""
    )
  )

  // @LINE:8
  private[this] lazy val com_rallyhealth_ihrintake_controllers_IHRController_getIHRSummary1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ihr/summary/v1")))
  )
  private[this] lazy val com_rallyhealth_ihrintake_controllers_IHRController_getIHRSummary1_invoker = createInvoker(
    IHRController_0.getIHRSummary,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "com.rallyhealth.ihrintake.controllers.IHRController",
      "getIHRSummary",
      Nil,
      "POST",
      """""",
      this.prefix + """ihr/summary/v1"""
    )
  )

  // @LINE:9
  private[this] lazy val com_rallyhealth_ihrintake_controllers_IHRController_getIHRAllergy2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ihr/allergies/v1")))
  )
  private[this] lazy val com_rallyhealth_ihrintake_controllers_IHRController_getIHRAllergy2_invoker = createInvoker(
    IHRController_0.getIHRAllergy,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "com.rallyhealth.ihrintake.controllers.IHRController",
      "getIHRAllergy",
      Nil,
      "POST",
      """""",
      this.prefix + """ihr/allergies/v1"""
    )
  )

  // @LINE:10
  private[this] lazy val com_rallyhealth_ihrintake_controllers_IHRController_getIHRCondition3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ihr/conditions/v1")))
  )
  private[this] lazy val com_rallyhealth_ihrintake_controllers_IHRController_getIHRCondition3_invoker = createInvoker(
    IHRController_0.getIHRCondition,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "com.rallyhealth.ihrintake.controllers.IHRController",
      "getIHRCondition",
      Nil,
      "POST",
      """""",
      this.prefix + """ihr/conditions/v1"""
    )
  )

  // @LINE:13
  private[this] val prefixed_opsStatic_Routes_0_4 = Include(opsStatic_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "rest/ops"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case com_rallyhealth_ihrintake_controllers_GreetController_greet0_route(params) =>
      call { 
        com_rallyhealth_ihrintake_controllers_GreetController_greet0_invoker.call(GreetController_1.greet)
      }
  
    // @LINE:8
    case com_rallyhealth_ihrintake_controllers_IHRController_getIHRSummary1_route(params) =>
      call { 
        com_rallyhealth_ihrintake_controllers_IHRController_getIHRSummary1_invoker.call(IHRController_0.getIHRSummary)
      }
  
    // @LINE:9
    case com_rallyhealth_ihrintake_controllers_IHRController_getIHRAllergy2_route(params) =>
      call { 
        com_rallyhealth_ihrintake_controllers_IHRController_getIHRAllergy2_invoker.call(IHRController_0.getIHRAllergy)
      }
  
    // @LINE:10
    case com_rallyhealth_ihrintake_controllers_IHRController_getIHRCondition3_route(params) =>
      call { 
        com_rallyhealth_ihrintake_controllers_IHRController_getIHRCondition3_invoker.call(IHRController_0.getIHRCondition)
      }
  
    // @LINE:13
    case prefixed_opsStatic_Routes_0_4(handler) => handler
  }
}
