<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Added using Ajax</title>
</head>
<body style="color: green;">

<div data-role="page" data-theme="b" id="mainpage">
		<div data-role="header">
			Ajax Test
		</div>
		

	<div data-role="content">  
	
			<div data-role="navbar" id="menu" data-grid="c" data-iconpos="left">
				<ul>
					
					<li><a href="/AjaxSpring/AddUser.htm">addUser</a></li>
				</ul>
			</div>
	The following are the users added in the list :<br>
	<c:out value="<%= request.getAttribute("Users") %>"></c:out>
	<ul>
	<c:forEach items="<%= request.getAttribute("Users") %>" var="user">
		<li>Name : <c:out value="${user.name}" />; Education : <c:out value="${user.education}"/>
	</c:forEach>
	
	</ul>
	 <display:table name="Users" sort="list" pagesize="2" export="true"  requestURI="ShowUsers.htm" id="data">
    	<display:column property="education" title="education" sortable="true" style="width:80px" />
    	<display:column property="name" title="name" sortable="true" style="width:300px "/>
    </display:table>
    </div>
    </div>
	
</body>
</html>