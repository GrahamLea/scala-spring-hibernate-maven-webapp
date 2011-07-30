package au.com.belmonttechnology.controller

import org.springframework.stereotype.Controller
import au.com.belmonttechnology.data.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory
import org.springframework.web.bind.annotation.{PathVariable, ModelAttribute, RequestMapping}
import org.springframework.web.bind.annotation.RequestMethod._
import org.springframework.web.servlet.ModelAndView
import au.com.belmonttechnology.repository.CustomerRepository

@Controller
class CustomerController {
  implicit def sessionFactory2Session(sf: SessionFactory) = sf.getCurrentSession;

  @Autowired
  val customerRepository: CustomerRepository = null

  @ModelAttribute("command")
  def createCustomerForFormBinding = new Customer

  @RequestMapping(value = Array("/customers/new"), method = Array(GET))
  def showNewCustomerForm() = "newCustomer"

  @RequestMapping(value = Array("/customers/new"), method = Array(POST))
  def createNewCustomer(@ModelAttribute("command") customer: Customer) =
    "redirect:/customers/" + customerRepository.save(customer) + ".html"

  @RequestMapping(value = Array("/customers/{customerId}"), method = Array(GET))
  def viewCustomer(@PathVariable customerId: Long) =
    new ModelAndView("customer", "customer", customerRepository.get(customerId))
}
