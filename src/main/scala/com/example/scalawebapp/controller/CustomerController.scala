package com.example.scalawebapp.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{ PathVariable, ModelAttribute, RequestMapping, RequestParam }
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.servlet.ModelAndView
import org.springframework.validation.BindingResult

import com.example.scalawebapp.data.Customer
import com.example.scalawebapp.repository.CustomerRepository
import com.example.scalawebapp.validator.CustomerValidator

@Controller
class CustomerController {
  @Autowired
  val customerRepository: CustomerRepository = null

  @Autowired
  val customerValidator: CustomerValidator = null

  @RequestMapping(value = Array("/customers/new"), method = Array(GET))
  def showNewCustomerForm() = new ModelAndView("newCustomer", "newCustomer", new Customer)

  @RequestMapping(value = Array("/customers/new"), method = Array(POST))
  def createNewCustomer(@ModelAttribute("newCustomer") customer: Customer, result: BindingResult): String = {
    customerValidator.validate(customer, result)

    if (result.hasErrors) {
      return "newCustomer"
    }

    "redirect:/customers/" + customerRepository.save(customer) + ".html"
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(GET))
  def viewCustomer(@PathVariable customerId: Long, @RequestParam(required = false) edit: String) = {
    val viewName = if (edit == null) "customer" else "editCustomer"
    new ModelAndView(viewName, "customer", customerRepository.get(customerId))
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(POST))
  def editCustomer(@PathVariable customerId: Long, @ModelAttribute("editCustomer") customer: Customer, result: BindingResult): String = {
    customerValidator.validate(customer, result)

    if (result.hasErrors) {
      return "editCustomer"
    }

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
