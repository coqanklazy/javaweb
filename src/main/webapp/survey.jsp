
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="main.css" type="text/css"/>
    </head>
    <body>
    <h1>Thanks for joining our survey</h1>

    <p>Here is the information that you entered:</p>

    <table class="survey-result">
        <tr>
            <td class="label-col"><strong>First Name:</strong></td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td class="label-col"><strong>Last Name:</strong></td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td class="label-col"><strong>Email:</strong></td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td class="label-col"><strong>Date of Birth:</strong></td>
            <td>${user.dateOfBirth}</td>
        </tr>
        <tr>
            <td class="label-col"><strong>Heard From:</strong></td>
            <td>
                <c:choose>
                    <c:when test="${user.heardFrom == 'Search engine'}">Search engine</c:when>
                    <c:when test="${user.heardFrom == 'Word of mouth'}">Word of mouth</c:when>
                    <c:when test="${user.heardFrom == 'Social Media'}">Social media</c:when>
                    <c:when test="${user.heardFrom == 'Other'}">Other</c:when>
                    <c:otherwise>N/A</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td class="label-col"><strong>Contact for Offers:</strong></td>
            <td>${user.wantsUpdates ? 'on' : 'off'}</td>
        </tr>
        <tr>
            <td class="label-col"><strong>Send Email Announcements:</strong></td>
            <td>${user.emailAnnouncements ? 'on' : 'off'}</td>
        </tr>
        <tr>
            <td class="label-col"><strong>Preferred Contact:</strong></td>
            <td>
                <c:choose>
                    <c:when test="${user.contactMethod == 'emailOnly'}">Email only</c:when>
                    <c:when test="${user.contactMethod == 'postalMailOnly'}">Postal mail only</c:when>
                    <c:when test="${user.contactMethod == 'emailOrPostalMail'}">Email or postal mail</c:when>
                    <c:otherwise>N/A</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>

    <p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>
    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
</body>
</html>