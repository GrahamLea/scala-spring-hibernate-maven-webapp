package au.com.belmonttechnology.repository

import au.com.belmonttechnology.data.Customer
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.{Session, SessionFactory}
import java.{util => ju}

trait CustomerRepository {
  def getAll: ju.List[Customer]
  def save(customer: Customer): Long
  def get(customerId: Long): Customer
}

@Repository
class CustomerRepositoryImpl extends CustomerRepository {

  implicit def sessionFactory2Session(sf: SessionFactory): Session = sf.getCurrentSession;

  @Autowired
  var sessionFactory: SessionFactory = null

  @Transactional
  def save(customer: Customer): Long = Long.unbox(sessionFactory.save(customer))

  @Transactional(readOnly = true)
  def get(customerId: Long): Customer = sessionFactory.get(classOf[Customer], Long.box(customerId)).asInstanceOf[Customer]

  @Transactional(readOnly = true)
  def getAll: ju.List[Customer] = sessionFactory.createCriteria(classOf[Customer]).list().asInstanceOf[ju.List[Customer]]

  def setSessionFactory(sessionFactory: SessionFactory): Unit = {
    this.sessionFactory = sessionFactory
  }
}