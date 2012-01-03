package com.example.scalawebapp.repository

import com.example.scalawebapp.data.Customer
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory

trait CustomerRepository {
  def getAll: java.util.List[Customer]
  def save(customer: Customer): Long
  def update(customer: Customer)
  def get(customerId: Long): Customer
  def delete(customerId: Long)
}

@Repository
class CustomerRepositoryImpl extends CustomerRepository {
  @Autowired
  var sessionFactory: SessionFactory = null

  @Transactional
  def save(customer: Customer): Long = Long.unbox(getCurrentSession.save(customer))

  @Transactional
  def update(customer: Customer) = getCurrentSession.saveOrUpdate(customer)

  @Transactional
  def delete(customerId: Long) = getCurrentSession.delete(get(customerId))

  @Transactional(readOnly = true)
  def get(customerId: Long): Customer = getCurrentSession.get(classOf[Customer], Long.box(customerId)).asInstanceOf[Customer]

  @Transactional(readOnly = true)
  def getAll: java.util.List[Customer] = getCurrentSession.createCriteria(classOf[Customer]).list().asInstanceOf[java.util.List[Customer]]

  def setSessionFactory(sessionFactory: SessionFactory): Unit = {
    this.sessionFactory = sessionFactory
  }

  def getCurrentSession = sessionFactory.getCurrentSession
}