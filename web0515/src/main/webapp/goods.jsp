<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <style>
    </style>
</head>
<body>
<center>
<h2>商品列表</h2>
<div class="container">
    <%  HashMap<String, Integer> userslist=(HashMap<String, Integer>) request.getAttribute("value");%>
    <table  class="table table-bordered table-hover">
        <tr><td>商品名</td><td>价格</td><td>        </td><td>操作</td></tr>
        <% Iterator<Map.Entry<String, Integer>> iterator = userslist.entrySet().iterator();%>
        <%while (iterator.hasNext()) {%>
        <%Map.Entry<String, Integer> entry = iterator.next();%>
        <tr><td><%=entry.getKey() %></td><td><%=entry.getValue()%></td>

            <td ><span onclick="return confirm('确定删除?')"><a href="/web0515/web0515_01/delete_goods?id=<%=entry.getKey()%>">删除</a></span>
            &nbsp;&nbsp;&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;&nbsp;&nbsp;
             <a href="/web0515/web0515_01/change_goods?id=<%=entry.getKey()%>">修改</a></td></tr>
        <%}%>
    </table>
    <div class="container" style="width: 500px">
        <h3>添加</h3>
        <form action="/web0515/web0515_01/save_goods" method="post">
            <p class="form-group">
                <input type="text" required class ="form-control" name ="name" placeholder="名称">
            </p>
            <p class="form-group">
                <input type="text" required class ="form-control" name ="price" placeholder="价格">
            </p>
           <button type="submit" class="btn btn-primary btn-block">保存</button>
        </form>
    </div>
 
</div>
</center>
</body>
</html>