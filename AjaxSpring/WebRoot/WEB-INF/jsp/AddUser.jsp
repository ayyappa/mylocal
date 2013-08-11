<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

<title>Add Users using ajax</title>
<script type="text/javascript">
	var contexPath = "<%=request.getContextPath() %>";
</script>
<script src="<%=request.getContextPath() %>/js/jquery-1.8.0.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.mobile-1.1.1.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jquery.mobile-1.1.1.css">
<script src="<%=request.getContextPath() %>/js/user.js"></script>

<script type="text/javascript">
function doJsonPost(){
	 var name = $('#name').val();
	  var education = $('#education').val();
	$.ajax({
		type: "POST",
		contentType: "application/json",
		//processData: false,
		url: "<c:url value="/JsonUser.htm"/>",
		data: JSON.stringify({'name': name, 'education': education}),		
		success: function(data, textStatus, XMLHttpRequest) {
	        var textObj = $.parseJSON(XMLHttpRequest.responseText);
	        alert(textObj.result[0].name);
	      },
	    error: function(XMLHttpRequest, textStatus, errorThrown) {
	        //printError(XMLHttpRequest, textStatus);
	        alert()(errorThrown);
	      }
		});
}
</script>
</head>
<body>
<div data-role="page" data-theme="b" id="mainpage">
		<div data-role="header">
			Ajax Test
		</div>
		

	<div data-role="content">  
	
			<div data-role="navbar" id="menu" data-grid="c" data-iconpos="left">
				<ul>
					<li><a href="/AjaxSpring/ShowUsers.htm">ShowUser</a></li>
					
				</ul>
			</div>

<form:form action="AddUser.htm" method="POST" commandName="user">
	<table>
		<tr><td colspan="2"><div id="error" class="error"></div><form:errors path="name"></form:errors></td></tr>
		<tr><td>Enter your name : </td><td> <input type="text" name="name" id="name"><br/></td></tr>
		<tr><td>Education : </td><td> <input name="education" type="text" id="education"><br/></td></tr>
		<tr><td>Salary : </td><td> <input name="salary" type="text" id="salary"><br/></td></tr>
		<tr><td colspan="2"><input type="submit" value="Add Users"><br/></td></tr>
		<tr><td colspan="2"><input type="submit" value="RestTest"><br/></td></tr>
		<tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
	</table>
	<a href="/AjaxSpring/ShowUsers.htm">Show All Users</a>
	</form:form>
	</div>
	</div>
	
	
</body>

</html>