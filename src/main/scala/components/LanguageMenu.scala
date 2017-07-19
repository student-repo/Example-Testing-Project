package components

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by ubuntu-master on 15.07.17.
  */
class LanguageMenu(implicit webDriver: WebDriver) extends BaseComponent {
  import LanguageMenu._

  def regions:List[String] = findAll(cssSelector(regionsNamesSelector)).toList.map(e => e.underlying.getText)

  def clickLanguageSuggestion(hrefValue: String): Unit =
    click on cssSelector(languageSuggestionSelector(hrefValue))

  def selectLanguage(regionIndex: Int, countryIndex: Int, hrefValue: String): Unit =
  click on countryElement(regionIndex, countryIndex)
    .findElement(By.cssSelector(hrefLanguageSelector(hrefValue)))

  private def countryElement(regionIndex: Int, countryIndex: Int):WebElement =
    findAll(cssSelector(countryElementsSelector(regionIndex))).toList(countryIndex).underlying
}

object LanguageMenu {
  val regionsSelector = ".wrap-regions"
  val regionsNamesSelector = s"$regionsSelector > h3"
  def countryElementsSelector(regionIndex: Int) = s"$regionsSelector > div:nth-of-type($regionIndex) .row-region"
  def hrefLanguageSelector(hrefValue: String): String =  " [href=\"" + hrefValue +"\""
  def languageSuggestionSelector(hrefValue: String): String = s".language-suggestions .languages.country " + hrefLanguageSelector(hrefValue)

}
