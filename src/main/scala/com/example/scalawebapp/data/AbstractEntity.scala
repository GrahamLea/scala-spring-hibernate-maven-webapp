package com.example.scalawebapp.data

import javax.persistence.{MappedSuperclass, GeneratedValue, Id}

@MappedSuperclass
abstract class AbstractEntity {
  @Id @GeneratedValue
  var id: Long = 0

  def getId: Long = id
}
