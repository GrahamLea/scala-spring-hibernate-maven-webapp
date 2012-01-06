package com.example.scalawebapp.webtest
  
import com.example.scalawebapp.webtest.page._
import org.junit.Test
import org.junit.Assert._
import org.hamcrest.CoreMatchers._

class ServerNamePageWebTest extends WebDriverAccess {
  @Test
  def shouldShowTheServerName {
    val homePage = HomePage.open()
    val serverNamePage = homePage.showServerName()
    assertThat(serverNamePage.serverName, is("localhost"));
    serverNamePage.home()
  }
}

