<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<div class="container" style="width: 500px">
 
    <%
        //从session中获取到要修改的对象
        HashMap<String, String> change_user =(HashMap<String, String>) request.getAttribute("value");
 
    %>
    <h3>修改</h3>
    <% Iterator<Map.Entry<String, String>> iterator = change_user.entrySet().iterator();%>
        <%while (iterator.hasNext()) {%>
        <%Map.Entry<String, String> entry = iterator.next();%>

            <form action="/web0515/web0515_01/change2?id=<%=entry.getKey()%>" method="post">
        <p class="form-group">
            id:<input type="text" required class ="form-control" name ="id"  value="<%=entry.getKey()%>">
        </p>
        <p class="form-group">
            密码:<input type="password" required class ="form-control" name ="password" placeholder="<%=entry.getValue()%>" >
        </p>
 
        <button type="submit" class="btn btn-primary btn-block">修改</button>
    </form>
        <%}%>
    
</div>
 
</body>
</html>