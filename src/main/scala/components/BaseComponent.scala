package components

import org.openqa.selenium.WebDriver
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Seconds, Span}

/**
  * Created by ubuntu-master on 15.07.17.
  */
class BaseComponent(implicit webDriver: WebDriver) extends WebBrowser with Eventually {
  override implicit val patienceConfig = PatienceConfig(timeout = Span(10, Seconds))
}
