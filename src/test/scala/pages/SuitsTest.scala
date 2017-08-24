package pages

import com.relevantcodes.extentreports.ExtentReports
import org.scalatest._



/**
  * Created by ubuntu-master on 08.08.17.
  */
class SuitsTest extends Suites(new HomePageTest, new TreeTest) with BeforeAndAfterAll with BeforeAndAfterEach {
  import SuitsTest._

  override def afterAll(): Unit = {
        extentReport.flush()
  }
}

object SuitsTest {
  var extentReport: ExtentReports = new ExtentReports("/home/ubuntu-master/Desktop/lern-automation.html")
}
