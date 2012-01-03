package com.example.scalawebapp.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{ PathVariable, ModelAttribute, RequestMapping, RequestParam }
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.servlet.ModelAndView
import org.springframework.validation.BindingResult

import com.example.scalawebapp.data.Customer
import com.example.scalawebapp.repository.CustomerRepository

@Controller
class CustomerController {
  @Autowired
  val customerRepository: CustomerRepository = null

  @RequestMapping(value = Array("/customers/new"), method = Array(GET))
  def showNewCustomerForm() = new ModelAndView("customer/customer-new", "newCustomer", new Customer)

  @RequestMapping(value = Array("/customers/new"), method = Array(POST))
  def createNewCustomer(@ModelAttribute("newCustomer") customer: Customer): String = {
    "redirect:/customers/" + customerRepository.save(customer) + ".html"
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(GET))
  def viewCustomer(@PathVariable customerId: Long, @RequestParam(required = false) edit: String) = {
    val viewName = "customer/" + (if (edit == null) "customer-view" else "customer-edit")
    new ModelAndView(viewName, "customer", customerRepository.get(customerId))
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(POST))
  def editCustomer(@PathVariable customerId: Long, @ModelAttribute("editCustomer") customer: Customer): String = {
    customer.id = customerId
    customerRepository.update(customer)

    "redirect:/customers/" + customerId + ".html"
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(DELETE))
  def deleteCustomer(@PathVariable customerId: Long) = {
    customerRepository.delete(customerId)
    "redirect:/"
  }
}
