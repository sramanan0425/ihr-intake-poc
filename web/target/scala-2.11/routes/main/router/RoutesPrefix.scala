
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sudha-ramanan/ihr-intake-poc/web/conf/routes
// @DATE:Fri May 04 11:40:52 CDT 2018


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
