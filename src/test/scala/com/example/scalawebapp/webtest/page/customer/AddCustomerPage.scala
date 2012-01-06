package com.example.scalawebapp.webtest.page.customer

import org.openqa.selenium.WebDriver
import com.example.scalawebapp.webtest.page.Page

// Copyright (c) 2010 Belmont Technology Pty Ltd. All rights reserved.

class AddCustomerPage(driver: WebDriver) extends Page[AddCustomerPage]("customer-new", driver) {
  def createCustomer(customerName: String) = {
    set(input("name"), customerName)
    submitExpecting[ViewCustomerPage]
  }

  def createCustomerExpectingFailure(customerName: String) = {
    set(input("name"), customerName)
    submitExpecting[AddCustomerPage]
  }
}