package com.example.scalawebapp.webtest.page

// Copyright (c) 2010 Belmont Technology Pty Ltd. All rights reserved.

import customer.{ViewCustomerPage, AddCustomerPage}
import org.openqa.selenium.{By, WebDriver}
import java.lang.String

object HomePage {
  private val DEFAULT_PORT = 9090;

  def open(server: String = "localhost", port: Int = DEFAULT_PORT)(implicit driver: WebDriver) = {
    driver.navigate.to("http://" + server + ":" + port + "/")
    new HomePage(driver)
  }
}

class HomePage(driver: WebDriver) extends Page[HomePage]("home", driver) {

  def showServerName() = click(linkText("Server Name")).expecting[ServerNamePage]
  def showStaticFile() = click(linkText("Static File")).expecting[StaticFilePage]
  def addCustomer() = click(linkText("Add a Customer")).expecting[AddCustomerPage]

  def viewCustomer(customerName: String) = click(By.partialLinkText(customerName)).expecting[ViewCustomerPage]

  def customerNames: Seq[String] =
    driver.findElement(By.id("customer-list")).findElements(By.tagName("a")).map(_.getText.split(": ")(1))

  def deleteAllCustomers() = click(linkText("Delete All Customers")).expecting[HomePage]
}