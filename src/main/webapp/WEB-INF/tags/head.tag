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
<%@tag body-content="tagdependent" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
    <link rel="stylesheet" href="<c:url value="/style/style.css"/>">
    <title>${title}</title>
    <jsp:doBody/>
</head>
