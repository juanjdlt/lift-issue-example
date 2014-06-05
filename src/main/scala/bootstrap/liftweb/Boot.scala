package bootstrap.liftweb

import net.liftweb.common.Full
import net.liftweb.common.Empty
import net.liftweb.http.LiftRules
import net.liftweb.http.LiftSession
import net.liftweb.http.Html5Properties
import net.liftweb.http.OnDiskFileParamHolder
import net.liftweb.http.Req
import net.liftweb.http.js.JE
import net.liftweb.http.RewriteRequest
import net.liftweb.http.RewriteResponse
import net.liftweb.http.ParsePath
import net.liftweb.sitemap.SiteMap
import net.liftweb.sitemap.Menu
import net.liftweb.sitemap.Loc.Hidden
import net.liftweb.sitemap.Loc.CalcStateless
import net.liftweb.util.NamedPF
import net.liftweb.sitemap._


class Boot {

  def boot {

    LiftRules.addToPackages("code")

    def sitemap = SiteMap(
      Menu.i("Home") / "index",
      Menu.i("Talenteca Health Status") / "tk-web-app-status" >> Hidden >> CalcStateless(() => { LiftRules.javaScriptSettings.request.set(() => Empty)
        true })
    )

    LiftRules.setSiteMapFunc(() => sitemap)

    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))

    LiftRules.maxMimeFileSize = 10 * 1024 * 1024
    LiftRules.maxMimeSize = 11 * 1024 * 1024

    LiftRules.autoIncludeAjaxCalc.default.set(() => 
      (session: LiftSession) => false)

  }
  
}
