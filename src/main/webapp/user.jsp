<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Detail</title>
    <link rel="stylesheet" href="loaduser.css" type="text/css"/>
</head>
<body>
<c:import url="/includes/header.jsp" />
<div class="page-wrapper">
    <h1>User Detail</h1>
    <form action="userAdmin" method="post" class="panel">
        <input type="hidden" name="action" value="update_user"/>
        <input type="hidden" name="email" value="${user.email}"/>
        <label>Email:</label>
        <input type="email" value="${user.email}" disabled/><br>
        <label>First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}" required/><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Update" class="button accent"/>
    </form>
    <p>
        <a class="button" href="userAdmin?action=display_users">Back to list</a>
    </p>
</div>
</body>
</html>

