package tree

import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebDriver, WebElement}

/**
  * Created by ubuntu-master on 19.07.17.
  */
class TreePage(implicit webDriver: WebDriver) extends TreeBasePage(""){

  def selectTreeElement(path: String): Unit = eventually {
//    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    selectTreeElement(path.split("/").toList, cssSelector("ul.rc-tree").element.underlying)
  }
  private def selectTreeElement(xs: List[String], element: WebElement): Unit = {
    xs match {
      case x :: Nil => eventually {
        click on element.findElement(By.xpath(s".//span[text()='$x']/parent::span"))
      }
      case x :: tail =>
        eventually {
          click on element.findElement(By.xpath(s".//span[text()='$x']/parent::span/parent::li/span[contains(@class, 'rc-tree-switcher')]"))
        }
        Thread.sleep(100)
        selectTreeElement(tail,element.findElement(By.xpath(s".//span[text()='$x']/parent::span/parent::li/ul")))
    }
  }


}
