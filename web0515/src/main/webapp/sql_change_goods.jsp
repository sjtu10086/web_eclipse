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
        HashMap<String, Integer> change_user =(HashMap<String, Integer>) request.getAttribute("value");
 
    %>
    <h3>修改</h3>
    <% Iterator<Map.Entry<String, Integer>> iterator = change_user.entrySet().iterator();%>
        <%while (iterator.hasNext()) {%>
        <%Map.Entry<String, Integer> entry = iterator.next();%>

            <form action="/web0515/web0515_01/change_goods2?id=<%=entry.getKey()%>" method="post">
        <p class="form-group">
            名称:<input type="text" required class ="form-control" name ="name"  value="<%=entry.getKey()%>">
        </p>
        <p class="form-group">
            价格:<input type="text" required class ="form-control" name ="price" placeholder="<%=entry.getValue()%>" >
        </p>
 
        <button type="submit" class="btn btn-primary btn-block">修改</button>
    </form>
        <%}%>
    
</div>
 
</body>
</html>