
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/Workspace/play-scala-4/conf/routes
// @DATE:Fri Oct 20 08:13:02 UTC 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTest Test = new controllers.ReverseTest(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseService Service = new controllers.ReverseService(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTest Test = new controllers.javascript.ReverseTest(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseService Service = new controllers.javascript.ReverseService(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
