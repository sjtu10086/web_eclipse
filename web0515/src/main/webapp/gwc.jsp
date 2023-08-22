<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="web0515_01.cus_good" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<body>
	<%  List<cus_good> list=(List<cus_good>) request.getAttribute("list");%>
	<%  int account =(int) request.getAttribute("account");%>
	<% String Cid =  "";%>
	<% int all = 0;%>
	<table>
	<tr><td>余额</td></tr>
	<tr><td><%=account  %></td></tr>
	</table>
	
	<table>
	<tr><td>商品名</td>  <td>数目</td> <td>总价</td></tr>
	<% for (cus_good cu : list) {%>
	<%Cid = cu.getC_id(); %>
	<%
    session.setAttribute("cus_id", Cid);
	session.setAttribute("money", cu.getPrice()* cu.getNum());
%>
	<tr><td><%=cu.getG_id() %></td>  <td><%=cu.getNum()  %></td> <td><%=cu.getPrice()* cu.getNum() %></td> 
	<td><span onclick="return confirm('确定删除?')"><a href="/web0515/web0515_01/delete_gwc?good_id=<%=cu.getG_id()%>">删除此项</a></td>
	</tr>
	
	<%all = all +  cu.getPrice()* cu.getNum();%>
	<%} %>
	</table>
	<%session.setAttribute("money", all); %>
	<br><br><br><br><br>
	<span onclick="return confirm('确定结算?')"><a href="/web0515/web0515_01/end_gwc?id=<%=Cid%>">结算</a></span>
	<br><br><br><br><br>
	<form id="loginid" action="/web0515/web0515_01/class_cz" method="post">
                <center><span>请输入金额:</span><input type="text" name="money"><br></center>
                <center><input type="submit" value="充值"></center>
            </form>   
            </center>
</body>
</html>