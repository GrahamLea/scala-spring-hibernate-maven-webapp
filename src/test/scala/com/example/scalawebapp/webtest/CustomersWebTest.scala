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

package com.example.scalawebapp.webtest

import com.example.scalawebapp.webtest.page._
import org.junit.Assert._
import org.hamcrest.CoreMatchers._
import org.junit.{After, Test}

class CustomersWebTest extends WebDriverAccess {
  @After
  def deleteAllCustomers() {
    HomePage.open().deleteAllCustomers()
  }

  @Test
  def shouldBeAbleToBeAdded {
    val viewCustomerPage = createCustomerNamed("Adrian")
    assertThat(viewCustomerPage.text, containsString("Adrian"))
  }

  @Test
  def shouldNotBeAbleToBeAddedWithABlankName {
    val homePage = HomePage.open()
    var addCustomerPage = homePage.addCustomer()
    addCustomerPage = addCustomerPage.createCustomerExpectingFailure(customerName = "")
    assertThat(addCustomerPage.text, containsString("may not be empty"))
  }

  @Test
  def shouldBeAccessibleFromTheHomePageAfterBeingAdded {
    var viewCustomerPage = createCustomerNamed("Bruce")
    val homePage = viewCustomerPage.home()
    assertThat(homePage.customerNames.contains("Bruce"), is(true))
    viewCustomerPage = homePage.viewCustomer("Bruce")
    assertThat(viewCustomerPage.text, containsString("Bruce"))
  }

  @Test
  def shouldBeAbleToBeEdited {
    val viewCustomerPage = createCustomerNamed("Carl")
    val editCustomerPage = viewCustomerPage.edit()
    assertThat(editCustomerPage.customerName, is("Carl"))
    editCustomerPage.updateCustomer(customerName = "Chris")
    assertThat(viewCustomerPage.text, containsString("Chris"))
    val homePage = viewCustomerPage.home()
    assertThat(homePage.customerNames.contains("Chris"), is(true))
    assertThat(homePage.customerNames.contains("Carl"), is(false))
  }

  @Test
  def shouldNotBeAbleToBeEditedToHaveABlankName {
    val viewCustomerPage = createCustomerNamed("David")
    var editCustomerPage = viewCustomerPage.edit()
    assertThat(editCustomerPage.customerName, is("David"))
    editCustomerPage = editCustomerPage.updateCustomerExpectingFailure(customerName = "")
    assertThat(editCustomerPage.text, containsString("may not be empty"))
    val homePage = editCustomerPage.home()
    assertThat(homePage.customerNames.contains("David"), is(true))
  }

  @Test
  def shouldBeAbleToBeDeleted {
    val viewCustomerPage = createCustomerNamed("Elijah")
    val homePage = viewCustomerPage.deleteCustomer()
    assertThat(homePage.customerNames.contains("Elijah"), is(false))
  }

  @Test
  def shouldBeAbleToBeDeletedAllAtOnce {
    createCustomerNamed("Frank")
    createCustomerNamed("George")
    val homePage = HomePage.open()
    assertThat(homePage.customerNames.contains("Frank"), is(true))
    assertThat(homePage.customerNames.contains("George"), is(true))
    homePage.deleteAllCustomers()
    assertThat(homePage.customerNames.contains("Frank"), is(false))
    assertThat(homePage.customerNames.contains("George"), is(false))
  }

  private def createCustomerNamed(name: String) = {
    val homePage = HomePage.open()
    val addCustomerPage = homePage.addCustomer()
    addCustomerPage.createCustomer(customerName = name)
  }

}

