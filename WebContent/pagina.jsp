<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
a {
padding: 5px;
color: #fff;
background-color: #000;
margin: 10px;
font-weight:bold;
}
button {
padding: 5px;
color: #fff;
background-color: #000;
margin: 10px;
font-weight:bold;
}

</style>
</head>
<body>
<%
Boolean booleanSucesso = (Boolean) session.getAttribute("logado");
String avisoSucesso = (String) request.getAttribute("sucesso");
%>

<a href="${pageContext.request.contextPath}">Voltar para login</a>
<h1><%if(booleanSucesso != null || booleanSucesso != false){out.print(avisoSucesso);}%></h1>
<form action="${pageContext.request.contextPath}/logout" method="GET">
<%if(booleanSucesso != null){out.print("<button>SAIR</button>");} %>
</form>
</body>
</html>