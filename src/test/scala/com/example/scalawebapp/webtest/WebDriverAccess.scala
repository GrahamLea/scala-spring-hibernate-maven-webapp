package com.example.scalawebapp.webtest

// Copyright (c) 2010 Belmont Technology Pty Ltd. All rights reserved.

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

trait WebDriverAccess {
  implicit val driver = WebDriverAccess.defaultDriver
}

object WebDriverAccess {

  val closeBrowserAfterTests = true

  val defaultDriver: WebDriver = {
    print("Creating WebDriver... ")
    try {
      new FirefoxDriver()
    } finally {
      println("Done.")
    }
  }

  if (!isRunningInIde || closeBrowserAfterTests) {
    Runtime.getRuntime.addShutdownHook(new Thread(new Runnable { def run() {defaultDriver.close()} } ))
  }

  private def isRunningInIde: Boolean = {
    Thread.currentThread.getStackTrace.find{_.getClassName.startsWith("com.intellij")} != None
  }
}

