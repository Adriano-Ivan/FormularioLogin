<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
form {
width: 200px;
display:flex;
flex-direction: column;
align-items:center;
justify-content:center;
}
input[type=text], input[type=password]{
width:150px;
}
input[type=submit]{
width: 50px;
}
input {
outline:none;
}
</style>
</head>
<body>
	<% String erro =(String) request.getAttribute("erro"); %>
	<% String sucesso =(String) request.getAttribute("sucesso"); %>
	<% String aviso = (String) request.getAttribute("nao_logado");%>
	<h1>DIGITE USUÁRIO E SENHA: </h1>
	<form action="${pageContext.request.contextPath}/login" METHOD="POST">
	<label>
	Nome:<br>
	<input type="text" autocomplete="off"name="campo_nome"><br><br>
	</label>
	<label>
	Senha:<br>
	<input type="password" autocomplete="off"name="campo_password"><br><br>
	</label>
	<input type="submit" value="enviar">
	</form>
	
	<%if(erro != null) {%>
	<strong><%= erro %></strong>
	<%} %>
	<%if(sucesso != null) {%>
	<strong><%= sucesso %></strong>
	<%} %>
	<%if(aviso != null) {%>
	<strong><%= aviso %></strong>
	<%} %>
</body>
</html>