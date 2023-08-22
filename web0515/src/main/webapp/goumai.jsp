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
<%  String power =(String) request.getAttribute("power");%>
<%  String cus_id =(String) request.getAttribute("cus_id");%>
<%  String cus_pass =(String) request.getAttribute("cus_pass");%>
<%
session.setAttribute("cus_id", cus_id);
session.setAttribute("cus_pass", cus_pass); 
session.setAttribute("p", "ok"); 
%>
<%if (power.equals("yes")){ %>
<% String wel = cus_id + "您已成功登录";%>
<script type="text/javascript">
    alert("您已成功登录");
</script>
<%} else if (power.equals("no")){%>
<script type="text/javascript">
    alert("您以游客进入该界面");
</script>
<%} %>
<h2>所有商品</h2>
<div class="container">
    <%  HashMap<String, Integer> userslist=(HashMap<String, Integer>) request.getAttribute("value");%>
    <table  class="table table-bordered table-hover">
        <tr><td>商品名</td><td>价格</td><td>        </td><td>操作</td></tr>
        <% Iterator<Map.Entry<String, Integer>> iterator = userslist.entrySet().iterator();%>
        <%while (iterator.hasNext()) {%>
        <%Map.Entry<String, Integer> entry = iterator.next();%>
        <tr><td><%=entry.getKey() %></td><td><%=entry.getValue()%></td>

            <td ><span onclick="return confirm('确定加入购物车?')"><a href="/web0515/web0515_01/insert_gwc?good_id=<%=entry.getKey()%>">加入购物车</a></span>
        <%}%>
    </table>
    <br>
    <a href="/web0515/web0515_01/cust_space">进入用户中心</a>
    
 
</div>
</center>
</body>
</html>