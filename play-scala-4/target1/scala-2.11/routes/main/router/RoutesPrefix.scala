
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/Workspace/play-scala-4/conf/routes
// @DATE:Fri Oct 20 08:13:02 UTC 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
