<%--
 * This code is in the public domain and may be used in any way you see fit, with the following conditions:
 *
 *     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *     IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *     FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *     THE SOFTWARE.
 --%>
<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../taglibs.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tags:head title="Customer \#${customer.id}: ${customer.name}" />
<body id="customer-view">
  <h1>
    Customer #<c:out value="${customer.id}" />: <c:out value="${customer.name}" />
  </h1>
  <p>Might I suggest enhancing the system to support more than just a customer's name?</p>
  <p>
    <a href="<c:url value="/customers/${customer.id}.html?edit"/>">Edit the Customer</a>
  </p>
  <p>
    <form id="deleteCustomerForm" style="height:0;" action="<c:url value="/customers/${customer.id}.html"/>" method="POST">
      <input type="hidden" name="_method" value="delete"/>
    </form>
    <a href="#" onclick="document.getElementById('deleteCustomerForm').submit(); return false;">Delete the Customer</a>
  </p>
  <p>
    <a href="<c:url value="/"/>">Home</a>
  </p>
</body>
</html>
