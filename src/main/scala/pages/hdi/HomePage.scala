package pages.hdi

import components.{LanguageMenu, TopNavBar}
import org.openqa.selenium.{By, WebDriver, WebElement}
import pages.BasePage


/**
  * Created by ubuntu-master on 15.07.17.
  */
class HomePage(implicit webDriver: WebDriver) extends BasePage("/de/en") {
  import HomePage._

  val topMenu = new TopNavBar

  var foo: String = eventually {
    cssSelector(".we-are").element.underlying.getText
  }

  def clickAcceptCookie: Unit =
    click on cssSelector(acceptCookieSelector).element.underlying

  def clickSelectLanguage:LanguageMenu = {
    click on cssSelector(selectLanguageSelector).element.underlying
    new LanguageMenu
  }



}

object HomePage {
  val topHeaderSelector = ".js-top-header"
  val acceptCookieSelector = s"$topHeaderSelector #accept-cookies"
  val selectLanguageSelector: String = topHeaderSelector + " [href=\"#region-modal\"]"
}
