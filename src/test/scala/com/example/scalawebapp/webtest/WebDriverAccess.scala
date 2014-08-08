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

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

trait WebDriverAccess {
  implicit val driver = WebDriverAccess.defaultDriver
}

object WebDriverAccess {

  val closeBrowserAfterTests = true

  val defaultDriver: WebDriver = {
    print("Creating WebDriver... ")
    try {
      new FirefoxDriver()
    } finally {
      println("Done.")
    }
  }

  if (!isRunningInIde || closeBrowserAfterTests) {
    Runtime.getRuntime.addShutdownHook(new Thread(new Runnable { def run() {defaultDriver.quit()} } ))
  }

  private def isRunningInIde: Boolean = {
    Thread.currentThread.getStackTrace.find{_.getClassName.startsWith("com.intellij")} != None
  }
}

