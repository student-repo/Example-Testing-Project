package pages

import com.relevantcodes.extentreports.{ExtentTest, LogStatus}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Seconds, Span}
import org.scalatest._

object CancelGloballyAfterFailure {
  @volatile var cancelRemaining = false
}

trait TestSuite extends WordSpec with Matchers with WebBrowser with Eventually
with BeforeAndAfterAllConfigMap {
  import CancelGloballyAfterFailure._
  import SuitsTest._


  implicit var webDriver: WebDriver = _
  override implicit val patienceConfig = PatienceConfig(timeout = Span(10, Seconds))

  var extentTest: ExtentTest = _

  override protected def beforeAll(configMap: ConfigMap): Unit = {
    println(configMap)


    /*to run on ie*/
//    val capabilities = DesiredCapabilities.internetExplorer
//    capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true)
//    webDriver = new InternetExplorerDriver(capabilities)

    webDriver = new ChromeDriver
    extentTest = extentReport.startTest(getClass.getName)
  }

  override protected def afterAll(configMap: ConfigMap): Unit = {
    extentReport.endTest(extentTest)
    cancelRemaining = false
    //    close()
    quit()
  }

//  var option = new ChromeOptions
//  option.addArguments("--headless")

  override def run(testName: Option[String], args: Args): Status = {
    val status = super.run(testName, args)
    if (status.succeeds())
      status
    else {
      cancelRemaining = false
      super.run(testName, args)
    }
  }

  override def withFixture(test: NoArgTest) = {
  if (cancelRemaining) {
    extentTest.log(LogStatus.SKIP, test.name)
    Canceled("Canceled by CancelGloballyAfterFailure because a test failed previously")
  }
  else {
    super.withFixture(test) match {
      case canceled: Canceled =>
        extentTest.log(LogStatus.SKIP, test.name)
        canceled

      case failed: Failed =>
        extentTest.log(LogStatus.FAIL, test.name)
        cancelRemaining = true
        failed

      case succeeded  =>
        extentTest.log(LogStatus.PASS, test.name)
        succeeded
    }

    }
  }
}
