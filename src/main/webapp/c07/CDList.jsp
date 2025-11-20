<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CD list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/c07/css/cd.css" type="text/css"/>
</head>
<body>
    <h1>CD list</h1>
    <table>
        <thead>
            <tr>
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td>$14.95</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart" method="post">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="productCode" value="8601">
                        <input type="hidden" name="productName" value="86 (the band) - True Life Songs and Pictures">
                        <input type="hidden" name="productPrice" value="14.95">
                        <button type="submit">Add To Cart</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Paddlefoot - The first CD</td>
                <td>$12.95</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart" method="post">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="productCode" value="pf01">
                        <input type="hidden" name="productName" value="Paddlefoot - The first CD">
                        <input type="hidden" name="productPrice" value="12.95">
                        <button type="submit">Add To Cart</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Paddlefoot - The second CD</td>
                <td>$14.95</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart" method="post">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="productCode" value="pf02">
                        <input type="hidden" name="productName" value="Paddlefoot - The second CD">
                        <input type="hidden" name="productPrice" value="14.95">
                        <button type="submit">Add To Cart</button>
                    </form>
                </td>
            </tr>
            <tr>
                <td>Joe Rut - Genuine Wood Grained Finish</td>
                <td>$14.95</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart" method="post">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="productCode" value="jr01">
                        <input type="hidden" name="productName" value="Joe Rut - Genuine Wood Grained Finish">
                        <input type="hidden" name="productPrice" value="14.95">
                        <button type="submit">Add To Cart</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
