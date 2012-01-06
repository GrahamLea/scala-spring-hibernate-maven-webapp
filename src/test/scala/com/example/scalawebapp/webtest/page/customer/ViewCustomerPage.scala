package com.example.scalawebapp.webtest.page.customer

import org.openqa.selenium.WebDriver
import com.example.scalawebapp.webtest.page.{HomePage, Page}

// Copyright (c) 2010 Belmont Technology Pty Ltd. All rights reserved.

class ViewCustomerPage(driver: WebDriver) extends Page[ViewCustomerPage]("customer-view", driver) {
  def deleteCustomer() = click(linkText("Delete the Customer")).expecting[HomePage]

  def edit() = click(linkText("Edit the Customer")).expecting[EditCustomerPage]
}