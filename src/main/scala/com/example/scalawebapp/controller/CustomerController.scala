package com.example.scalawebapp.controller

import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{ PathVariable, ModelAttribute, RequestMapping, RequestParam }
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.servlet.ModelAndView

import com.example.scalawebapp.data.Customer
import com.example.scalawebapp.repository.CustomerRepository
import reflect.BeanProperty

@Controller
class CustomerController {

  import ControllerTools._

  @Autowired
  val customerRepository: CustomerRepository = null

  @RequestMapping(value = Array("/customers/new"), method = Array(GET))
  def showNewCustomerForm() = new ModelAndView("customer/customer-new", "customerData", new CustomerPageData)

  @RequestMapping(value = Array("/customers/new"), method = Array(POST))
  def createNewCustomer(@ModelAttribute("customerData") customerData: CustomerPageData): String = {
    val newCustomer = new Customer
    customerData.copyTo(newCustomer)
    "redirect:/customers/" + customerRepository.save(newCustomer) + ".html"
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(GET))
  def viewCustomer(@PathVariable customerId: Long, @RequestParam(required = false) edit: String) = {
    val viewName = "customer/" + (if (edit == null) "customer-view" else "customer-edit")
    new ModelAndView(viewName,
      Map("customerData" -> CustomerPageData(customerRepository.get(customerId)),
          "customerId" -> customerId
      ))
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(POST))
  def editCustomer(@PathVariable customerId: Long, @ModelAttribute("customerData") customerData: CustomerPageData): String = {
    val customer = customerRepository.get(customerId)
    customerData.copyTo(customer)
    customerRepository.update(customer)
    "redirect:/customers/" + customerId + ".html"
  }

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(DELETE))
  def deleteCustomer(@PathVariable customerId: Long) = {
    customerRepository.delete(customerId)
    "redirect:/"
  }
}

class CustomerPageData {
  @BeanProperty
  var name: String = null;

  override def toString = "[CustomerPageData: name = " + name + "]"

  def copyTo(customer: Customer): Unit = {
    // TODO: Use Dozer to do this automatically
    customer.name = name
  }

  def copyFrom(customer: Customer): Unit = {
    // TODO: Use Dozer to do this automatically
    name = customer.name
  }
}

object CustomerPageData {
  def apply(c: Customer): CustomerPageData = {
    val data = new CustomerPageData
    data.copyFrom(c)
    data
  }
}
