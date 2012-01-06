package com.example.scalawebapp.webtest.page

import org.openqa.selenium.WebDriver

// Copyright (c) 2010 Belmont Technology Pty Ltd. All rights reserved.

class ServerNamePage(driver: WebDriver) extends Page[ServerNamePage]("server-name", driver) {
  def serverName: String = textOf(id("serverName"))
}