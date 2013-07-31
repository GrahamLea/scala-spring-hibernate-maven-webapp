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

package com.example.scalawebapp.webtest.page

import org.openqa.selenium.{By, WebDriver}
import org.hamcrest.CoreMatchers._
import org.junit.Assert
import java.lang.reflect.InvocationTargetException
import collection.JavaConversions
import org.openqa.selenium.By.ByName
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}

abstract class Page[T <: Page[T]](expectedBodyId: String, val driver: WebDriver) {

  self: T =>

  waitUntil { !driver.findElements(By.tagName("body")).isEmpty }
  Assert.assertThat(driver.findElement(By.tagName("body")).getAttribute("id"), is(expectedBodyId))

  final protected def id = By.id _
  final protected def className = By.className _
  final protected def linkText = By.linkText _
  final protected def input = new ByName(_)
  final protected def xpath = By.xpath _
  final protected def xpathFormat(text: String, arguments: Any*) = xpath(text.format(arguments))
  final protected def spanWithId(id: String) = xpathFormat("//span[@id='%s']", id)

  final private val submitButton = xpath("//input[@type='submit']")

  lazy val text = driver.getPageSource.replaceAll("<[^>]+>", " ").replaceAll("[ \t]+", " ").replaceAll("\n( ?\n)+", "\n")

  protected def textOf(element: By) : String = driver.findElement(element).getText
  protected def valueOf(element: ByName) : String = driver.findElement(element).getAttribute("value")

  def submitButtonText : String = driver.findElement(submitButton).getAttribute("value")

  def home() = click(linkText("Home")).expecting[HomePage]

  protected def waitUntil(f: => Boolean): Unit = {
    new WebDriverWait(driver, 10, 50) until
      (new ExpectedCondition[Boolean] { def apply(input: WebDriver) = f })
  }

  protected def set(inputBy: By, value: String) : T = {
    val inputElement = driver.findElement(inputBy)
    inputElement.clear()
    inputElement.sendKeys(value)
    this
  }

  protected def click(by: By) : T = {
    driver.findElement(by).click()
    this
  }

  protected def expecting[P <: Page[P]](implicit m: Manifest[P]): P = {
    try {
      m.runtimeClass.getConstructor(classOf[WebDriver]).newInstance(driver).asInstanceOf[P]
    } catch {
      case e: InvocationTargetException => throw e.getCause
      case e: Throwable => throw e
    }
  }

  protected implicit def javaList2Seq[A](list: java.util.List[A]): Seq[A] = JavaConversions.asScalaBuffer(list)

  def submitExpecting[P <: Page[P]](implicit m: Manifest[P]): P = click(submitButton).expecting[P]

}
