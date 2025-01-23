<!-- calculate.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
    <h2>Interest Calculation Result</h2>
    <%
        double principal = Double.parseDouble(request.getParameter("principal"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        double time = Double.parseDouble(request.getParameter("time"));
        
        double interest = (principal * rate * time) / 100;
    %>
    <p>
        Principal Amount: $<%= principal %><br>
        Interest Rate: <%= rate %>%<br>
        Time Period: <%= time %> years<br>
        <b>Simple Interest: $<%= String.format("%.2f", interest) %></b>
    </p>
    <a href="interest.html">Calculate Another</a>
</body>
</html>
