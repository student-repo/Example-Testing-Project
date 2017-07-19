package pages

import org.openqa.selenium.{By, WebElement}
import tree.TreePage


/**
  * Created by ubuntu-master on 15.07.17.
  */
class TreeTest extends TestSuite {
  var treePage:TreePage = _
  "The user" should {
    "be able to display homePage" in {
      treePage = new TreePage
      go to treePage

      eventually {
        pageTitle should startWith ("animation.js - example - rc-tree@1.5.0")
      }
    }

    "be able to  homePage" in {
//      eventually {

        val l = List("parent 1-1", "parent 2-1, leaf")
//        cssSelector(".example").element.underlying.findElement(By.xpath(".//span[text()='parent 1']/parent::span/parent::li/ul")).getAttribute("innerHTML") should be ("123")
//        cssSelector(".example").element.underlying.findElement(By.xpath(".//span[text()='parent 1']/parent::span/parent::li/span[contains(@class, 'rc-tree-switcher')]")).getAttribute("innerHTML") should be ("123")
//        cssSelector(".example").element.underlying.findElement(By.xpath(".//span[text()='parent 1']/parent::span/parent::li/span[contains(@class, 'rc-tree-switcher')]")).click
        sum(l)

//      }

      def sum(xs: List[String],foo: WebElement): Unit = {
        xs match {
          case x :: tail => {
//            cssSelector(".example").element.underlying.findElement(By.xpath(s".//span[text()='$x']/parent::span/parent::li/span[contains(@class, 'rc-tree-switcher')]")).click
            if(tail != 0) {
              cssSelector(".example").element.underlying.findElement(By.xpath(s".//span[text()='$x']/parent::span/parent::li/span[contains(@class, 'rc-tree-switcher')]")).click
              sum(tail)
            }
            else {
              cssSelector(".example").element.underlying.findElement(By.xpath(s".//span[text()='$x']/parent::span")).click
              sum(tail)
            }
          }
//          {
//            if(tail != 0) cssSelector(".example").element.underlying.findElement(By.xpath(s".//span[text()='$x']/parent::span/parent::li/span[contains(@class, 'rc-tree-switcher')]")).click
//            else cssSelector(".example").element.underlying.findElement(By.xpath(s".//span[text()='$x']/parent::span")).click
//          }
          case Nil => 0
        }
      }


      var x = 0
      while(x == 0) {

      }
        eventually {
        "123" should be ("122122112")
      }
    }
  }
}