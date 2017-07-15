package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

trait TestSuite extends WordSpec with Matchers with WebBrowser with Eventually with BeforeAndAfterAll {
  implicit val webDriver: WebDriver = new ChromeDriver
  override implicit val patienceConfig = PatienceConfig(timeout = Span(10, Seconds))

  override def afterAll(): Unit = {
    close()
  }
}
