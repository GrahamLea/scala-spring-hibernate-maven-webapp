package com.example.scalawebapp.data

import reflect.BeanProperty
import javax.persistence.Entity

@Entity
class Customer extends AbstractEntity {
  @BeanProperty
  var name: String = null;
  
  override def toString = "[Customer: id = " + id + ", name = " + name + "]"
}
