<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .navigation {
        background-color: #f0f0f0;
        padding: 15px 20px;
        margin-bottom: 20px;
        border-bottom: 2px solid #333;
    }

    .nav-button {
        display: inline-block;
        padding: 10px 20px;
        margin-right: 10px;
        background-color: #fff;
        color: #333;
        text-decoration: none;
        border: 1px solid #333;
        border-radius: 4px;
        font-weight: normal;
        transition: all 0.3s;
    }

    .nav-button:hover {
        background-color: #333;
        color: #fff;
    }

    .nav-button.active {
        background-color: #333;
        color: #fff;
    }
</style>

<div class="navigation">
    <a href="${pageContext.request.contextPath}/index.jsp" class="nav-button ${pageContext.request.servletPath == '/index.jsp' ? 'active' : ''}">Email List</a>
    <a href="${pageContext.request.contextPath}/thanks.jsp" class="nav-button ${pageContext.request.servletPath == '/thanks.jsp' ? 'active' : ''}">SQL Gateway</a>
</div>
