package com.example.scalawebapp.webtest

import com.example.scalawebapp.webtest.page._
import org.junit.Test
import org.junit.Assert._
import org.junit.matchers.JUnitMatchers._

class StaticFileWebTest extends WebDriverAccess {
  @Test
  def shouldReturnTheContentsOfTheFile {
    val homePage = HomePage.open()
    val staticFilePage = homePage.showStaticFile()
    assertThat(staticFilePage.text, containsString("This is a static HTML file."));
    staticFilePage.home()
  }
}

