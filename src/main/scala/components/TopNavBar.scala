package components

import org.openqa.selenium.WebDriver

/**
  * Created by ubuntu-master on 15.07.17.
  */
class TopNavBar(implicit webDriver: WebDriver) extends BaseComponent {
  import TopNavBar._

  def clickInsuranceSolutions: TopMenu = {
    click on cssSelector(topNavBarSelector(1)).element.underlying
    new TopMenu(cssSelector(topMenuSelector(1)).element.underlying)
  }

  def clickServices: TopMenu = {
    click on cssSelector(topNavBarSelector(2)).element.underlying
    new TopMenu(
      cssSelector(topMenuSelector(2))
      .element
      .underlying)
  }

  def clickMedia: TopMenu = {
    click on cssSelector(topNavBarSelector(3)).element.underlying
    new TopMenu(cssSelector(topMenuSelector(3)).element.underlying)
  }

  def clickAboutUs: TopMenu = {
    click on cssSelector(topNavBarSelector(4)).element.underlying
    new TopMenu(cssSelector(topMenuSelector(4)).element.underlying)
  }

  def foo(num: Int): String =
    cssSelector(topMenuSelector(num)).element.underlying.getAttribute("innerHTML")
}

object TopNavBar {
  def topNavBarSelector(navBarIndex: Int) = s".main-nav li:nth-child($navBarIndex) > a"
  def topMenuSelector(topMenuIndex: Int) = s".navbar-drop-menu .container > div:nth-of-type($topMenuIndex)"
}
