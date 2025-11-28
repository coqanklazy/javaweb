<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav-header">
    <a href="index.jsp" class="nav-btn<%= request.getRequestURI().endsWith("index.jsp") ? " active" : "" %>">Email List</a>
    <a href="thanks.jsp" class="nav-btn<%= request.getRequestURI().endsWith("thanks.jsp") ? " active" : "" %>">SQL Gateway</a>
</div>
