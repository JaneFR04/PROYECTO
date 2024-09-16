<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-image: radial-gradient(at 20px 20px, red 20%, blue 60%, yellow);
	font-family: Arial, sans-serif;
	height: 100vh;
}

.container {
	justify-content: center;
	color: blue;
	display:flex;
}
.menu{
background-color: white;
display:flex;
align-items: center;
justify-content: center;
padding:20px;
margin: 20px;
width: 110px;
border-radius: 10px;
}
.menu:hover {
	background-color: #e1e1e1;
}
a{
text-decoration: none;
color: black;
font-weight: bold;
}
</style>
<body>
	<div class="container">
		<div class="menu">
			<a href="ServletProducto?tipo=listar">Listar</a>
		</div>
		<div class="menu">
			<a href="registrarProducto.jsp">Nuevo</a>
		</div>
		<div class="menu">
			<a href="ServletEmpleado?tipo=cerrarSesion">Cerrar Sesión</a>
		</div>
	</div>
</body>
</html>