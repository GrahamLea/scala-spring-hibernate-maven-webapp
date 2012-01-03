package com.example.scalawebapp.controller

import org.springframework.ui.ModelMap

object ControllerTools {
  implicit def map2ModelMap(m: Map[String, Any]): ModelMap = {
    val mm = new ModelMap
    m.foreach((kv) => mm.addAttribute(kv._1, kv._2))
    mm
  }
}