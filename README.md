Scala+Spring+Hibernate+Maven
============================

This project contains source code for kickstarting a webapp project using the latest versions of Scala, Spring, Hibernate and Maven.

Versions currently used in the project are:

* [Scala](http://www.scala-lang.org/): 2.9.0-1
* [Spring](http://www.springsource.org/about): 3.0.5.RELEASE
* [Hibernate](http://www.hibernate.org/): 3.6.5.Final

The code also makes use of [HSQLDB](http://hsqldb.org/), but you'll probably want to replace that with the JDBC driver
for whatever database you're using.


Building and Running
--------------------

Assuming you already have Maven installed, the webapp can be built by running:

    mvn clean install

The webapp can be run inside Jetty using the Maven plugin:

    mvn jetty:run


Attribution
-----------

This source code was originally created by Graham Lea for the blog http://grahamhackingscala.blogspot.com/


Conditions of Usage
-------------------

This code is in the public domain and may be used in any way you see fit, with the following conditions:

> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
> IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
> FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
> AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
> LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
> OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
> THE SOFTWARE.
