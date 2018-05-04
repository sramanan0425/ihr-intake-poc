
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sudha-ramanan/ihr-intake-poc/web/conf/routes
// @DATE:Fri May 04 11:40:52 CDT 2018

package com.rallyhealth.ihrintake.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final com.rallyhealth.ihrintake.controllers.ReverseIHRController IHRController = new com.rallyhealth.ihrintake.controllers.ReverseIHRController(RoutesPrefix.byNamePrefix());
  public static final com.rallyhealth.ihrintake.controllers.ReverseGreetController GreetController = new com.rallyhealth.ihrintake.controllers.ReverseGreetController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final com.rallyhealth.ihrintake.controllers.javascript.ReverseIHRController IHRController = new com.rallyhealth.ihrintake.controllers.javascript.ReverseIHRController(RoutesPrefix.byNamePrefix());
    public static final com.rallyhealth.ihrintake.controllers.javascript.ReverseGreetController GreetController = new com.rallyhealth.ihrintake.controllers.javascript.ReverseGreetController(RoutesPrefix.byNamePrefix());
  }

}
