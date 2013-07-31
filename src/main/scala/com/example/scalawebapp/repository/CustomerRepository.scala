/*
 * This code is in the public domain and may be used in any way you see fit, with the following conditions:
 *
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *     THE SOFTWARE.
 */

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
  def save(customer: Customer): Long = Long.unbox(getCurrentSession.save(customer).asInstanceOf[Object])

  @Transactional
  def update(customer: Customer): Unit = getCurrentSession.saveOrUpdate(customer)

  @Transactional
  def delete(customerId: Long): Unit = getCurrentSession.delete(get(customerId))

  @Transactional(readOnly = true)
  def get(customerId: Long): Customer = getCurrentSession.get(classOf[Customer], Long.box(customerId)).asInstanceOf[Customer]

  @Transactional(readOnly = true)
  def getAll: java.util.List[Customer] = getCurrentSession.createCriteria(classOf[Customer]).list().asInstanceOf[java.util.List[Customer]]

  def setSessionFactory(sessionFactory: SessionFactory): Unit = {
    this.sessionFactory = sessionFactory
  }

  def getCurrentSession = sessionFactory.getCurrentSession
}