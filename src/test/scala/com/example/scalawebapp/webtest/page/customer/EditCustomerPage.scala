package com.example.scalawebapp.webtest.page.customer

import org.openqa.selenium.WebDriver
import com.example.scalawebapp.webtest.page.Page

// Copyright (c) 2010 Belmont Technology Pty Ltd. All rights reserved.

class EditCustomerPage(driver: WebDriver) extends Page[EditCustomerPage]("customer-edit", driver) {
  def customerName = valueOf(input("name"))

  def updateCustomer(customerName: String) = {
    set(input("name"), customerName)
    submitExpecting[ViewCustomerPage]
  }

  def updateCustomerExpectingFailure(customerName: String) = {
    set(input("name"), customerName)
    submitExpecting[EditCustomerPage]
  }
}