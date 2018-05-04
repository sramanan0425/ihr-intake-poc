
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sudha-ramanan/ihr-intake-poc/web/conf/routes
// @DATE:Fri May 04 11:40:52 CDT 2018

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package com.rallyhealth.ihrintake.controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseIHRController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getIHRCondition: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "com.rallyhealth.ihrintake.controllers.IHRController.getIHRCondition",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ihr/conditions/v1"})
        }
      """
    )
  
    // @LINE:8
    def getIHRSummary: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "com.rallyhealth.ihrintake.controllers.IHRController.getIHRSummary",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ihr/summary/v1"})
        }
      """
    )
  
    // @LINE:9
    def getIHRAllergy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "com.rallyhealth.ihrintake.controllers.IHRController.getIHRAllergy",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ihr/allergies/v1"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseGreetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def greet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "com.rallyhealth.ihrintake.controllers.GreetController.greet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "greet"})
        }
      """
    )
  
  }


}
