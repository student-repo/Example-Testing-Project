package components

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by ubuntu-master on 16.07.17.
  */
class TopMenu(element: WebElement)(implicit webDriver: WebDriver) extends BaseComponent {

  def selectOption(option: String):Unit =
    click on element.findElement(By.xpath(s"//a[text()='$option']"))
}
