package pages
import components.{LanguageMenu, TopMenu}
import pages.hdi.HomePage



/**
  * Created by ubuntu-master on 15.07.17.
  */
class HomePageTest extends TestSuite {
  var homePage:HomePage = _
  var languageMenu:LanguageMenu = _
  var topMenu:TopMenu =_



  "The user" should {
    "be able to display homePage" in {


      go to "https://www.hdi.global/de/en"

      homePage = new HomePage

      eventually {
        homePage.foo should be ("WE ARE")
      }
      eventually {
        pageTitle should startWith ("HDI Global SE")
      }

    }

    "be able to click accept cookies" in {
      eventually {
        homePage.clickAcceptCookie
      }
    }

    "be able to click select language" in {
      eventually {
        languageMenu = homePage.clickSelectLanguage //should be ("123")
      }
    }

    "be able to list all regions" in {
      eventually {
        languageMenu.regions should contain allOf ("AMERICA", "ASIA-PACIFIC & AFRICA", "EUROPE")
      }
    }

    "be able to select language" in {
      eventually {
       languageMenu.selectLanguage(2, 2, "/jp/en")
      }
      eventually {
        webDriver.getCurrentUrl should not be homePage.url
      }
    }

    "be able to select language from language suggestions" in {
      languageMenu = homePage.clickSelectLanguage
      eventually {
        languageMenu.clickLanguageSuggestion("/de/en")
        webDriver.getCurrentUrl should be (homePage.url)
      }
//      eventually {
//        "12434" should be ("222")
//      }
    }

    "be able to select services > Claims Management" in {
      eventually {
//        homePage.topMenu.clickServices should be ("123")
        topMenu = homePage.topMenu.clickServices
      }
      eventually {
        topMenu.selectOption("International")
      }

//      eventually {
//        "123" should be ("2222")
//      }
    }
  }
}