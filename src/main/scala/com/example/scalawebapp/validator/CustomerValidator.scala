package com.example.scalawebapp.validator

import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

import com.example.scalawebapp.data.Customer

@Component
class CustomerValidator extends Validator {
  def supports(cls: Class[_]) = classOf[Customer].isAssignableFrom(cls)

  def validate(model: Object, errors: Errors) = ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is required.")
}