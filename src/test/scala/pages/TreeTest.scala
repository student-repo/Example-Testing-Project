package pages

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
        pageTitle should startWith ("animation.js - example - rc-tree@1.7.2")
      }
    }
//    "fofo" in {
//      "2132" should be ("222222")
//    }
    "be able to select item in directory tree" in {
      treePage.selectTreeElement("parent 1-1/parent 2-1/leaf")
    }
  }
}