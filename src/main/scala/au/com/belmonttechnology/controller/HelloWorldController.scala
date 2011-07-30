package au.com.belmonttechnology.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloWorldController {
  @RequestMapping(Array("/hello"))
  def showHello = "helloPage"
}