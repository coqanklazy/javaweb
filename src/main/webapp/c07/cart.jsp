<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/c07/css/cd.css" type="text/css"/>
    <style>
        .info {
            margin-top: 15px;
            margin-bottom: 15px;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons button {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h1>Your cart</h1>

<%--    <c:if test="${cart == null || cart.count == 0}">--%>
<%--        <p>Your cart is empty.</p>--%>
<%--    </c:if>--%>

<%--    <c:if test="${cart != null && cart.count > 0}">--%>
        <table>
            <thead>
                <tr>
                    <th>Quantity</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <c:if test="${cart != null && cart.count > 0}">
                        <th></th>
                    </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items}">
                    <tr>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart" method="post" style="display: inline;">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="productCode" value="${item.product.code}">
                                <input type="text" name="quantity" value="${item.quantity}" size="3">
                                <button type="submit">Update</button>
                            </form>
                        </td>
                        <td>${item.product.name}</td>
                        <td>${item.product.priceCurrencyFormat}</td>
                        <td>${item.totalCurrencyFormat}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart" method="post" style="display: inline;">
                                <input type="hidden" name="action" value="remove">
                                <input type="hidden" name="productCode" value="${item.product.code}">
                                <button type="submit">Remove Item</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="info">
            <p><strong>To change the quantity</strong>, enter the new quantity and click on the Update button.</p>
        </div>
<%--    </c:if>--%>

    <div class="buttons">
        <form action="${pageContext.request.contextPath}/c07/CDList.jsp" method="get" style="display: inline;">
            <button type="submit">Continue Shopping</button>
        </form>
        <button>Checkout</button>
    </div>
</body>
</html>

