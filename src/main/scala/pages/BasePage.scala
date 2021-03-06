package pages

import org.openqa.selenium.{JavascriptExecutor, WebDriver}
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.{Page, WebBrowser}
import org.scalatest.time.{Seconds, Span}

class BasePage(val path: String)(implicit webDriver: WebDriver) extends Page with WebBrowser with Eventually {
  override implicit val patienceConfig = PatienceConfig(timeout = Span(10, Seconds))

  val host: String = "https://www.hdi.global"
  override val url: String = host + path

  def open(): Unit =
    go to (url)

  def waitForFinishLoading(): Unit = {
    eventually {
      assert(webDriver.asInstanceOf[JavascriptExecutor].executeScript("return document.readyState") == "complete")
    }
  }
}
