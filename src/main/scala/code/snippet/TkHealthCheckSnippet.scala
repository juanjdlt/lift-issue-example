package code
package snippet

import java.net.InetAddress

import scala.xml.Text

import net.liftweb.util._
import net.liftweb.common._
import Helpers._

object TkHealthCheckSnippet extends Loggable {

  val runtime = Runtime.getRuntime()
  val MaxCharge = 0.9

  import runtime._

  def render = {

    val hostname = InetAddress.getLocalHost.getHostName
    val ip = InetAddress.getLocalHost.getHostAddress 
    val serverTime = System.currentTimeMillis
    val runMode = Props.mode.toString
    val info = "(hostname: " + hostname + ", ip: " + ip + ", timestamp: " + serverTime + ", runMode: " + runMode + ")"

      val testCases = isMemoryFullEnough :: Nil
      if (testCases.contains(false)) {
        throw new Exception("this is down " + info)
      } else {
        "*" #> Text("this is OK " + info)
      }
  }
  
  def isMemoryFullEnough = {
    val usedMemory = totalMemory - freeMemory
    val charge = usedMemory.toDouble / maxMemory.toDouble
    charge < MaxCharge
  }

}

