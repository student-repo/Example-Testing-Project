package pages

/**
  * Created by ubuntu-master on 15.07.17.
  */
class HomePageTest extends TestSuite {
  "The user" should {
    "be able to display homePage" in {
      val homePage = new BasePage("/")
      go to homePage
    }
  }
}
