<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<%  HashMap<String, Integer> userslist=(HashMap<String, Integer>) request.getAttribute("value");%>
	<%  String power = (String) request.getAttribute("p");%>
	<%  String cus_id = (String) request.getAttribute("id");%>
	<%  String cus_pass = (String) request.getAttribute("pass");%>
	<% if (power.equals("ok")) {%>
	<% Iterator<Map.Entry<String, Integer>> iterator = userslist.entrySet().iterator();%>
        <%while (iterator.hasNext()) {%>
        <%Map.Entry<String, Integer> entry = iterator.next();%>
	<form action="/web0515/web0515_01/insert_gwc2" method="post">
        <p class="form-group">
            商品:<input type="text" required class ="form-control" name ="name"  value="<%=entry.getKey()%>">
        </p>
        <p class="form-group">
            数目:<input type="text" required class ="form-control" name ="num" placeholder="<%=entry.getValue()%>" >
        </p>
 
        <button type="submit" class="btn btn-primary btn-block">确认修改</button>
    </form>
	
	
	
	
	
	<%}} else {%>
	<script type="text/javascript">
    alert("warning");
	</script>
	<%} %>
	</center>
</body>
</html>