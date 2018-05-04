
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sudha-ramanan/ihr-intake-poc/web/conf/routes
// @DATE:Fri May 04 11:40:52 CDT 2018

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package com.rallyhealth.ihrintake.controllers {

  // @LINE:8
  class ReverseIHRController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def getIHRCondition(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "ihr/conditions/v1")
    }
  
    // @LINE:8
    def getIHRSummary(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "ihr/summary/v1")
    }
  
    // @LINE:9
    def getIHRAllergy(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "ihr/allergies/v1")
    }
  
  }

  // @LINE:6
  class ReverseGreetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def greet(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "greet")
    }
  
  }


}
