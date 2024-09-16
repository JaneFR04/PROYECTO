<<jsp:include page="validar.jsp"></jsp:include>
<%@ page import="beans.ProductoDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: radial-gradient(at 20px 20px, red 20%, blue 60%, yellow);
	font-family: Arial, sans-serif;
	height: 100vh;
}
h2{
font-size: 2em;
color: white;
}
table {
        margin: 20px auto;
        border-collapse: collapse;
        width: 80%;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        background-color: #F9F9F9;
    }

    th, td {
        padding: 15px;
        text-align: center;
        border: 1px solid #ddd;
        font-size: 0.9em; /* Tamaño reducido */
    }

    th {
        background-color: blue;
        color: white;
        font-size: 1em;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e1e1e1;
    }

    td a img {
        width: 18px; /* Tamaño reducido de los iconos */
        height: 18px;
    }

    td a:hover img {
        transform: scale(1.5);
        transition: transform 0.2s;
    }
</style>
</head>
<body>
<jsp:include page = "encabezado.jsp"/>
<h2 align="center">Lista de Jugadores</h2>
	<table align="center">
		<tr>
			<th>Código</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Apodo</th>
			<th>Nacionalidad</th>
			<th>Club</th>
			<th>Edad</th>
			<th>Sueldo</th>
			<th>Posición</th>
			<th colspan="2">Acción</th>
		</tr>
		<%
			ArrayList<ProductoDTO> lista = (ArrayList<ProductoDTO>) request.getAttribute("data");

			if (lista != null) {
				for (ProductoDTO xAlu : lista) {
					out.println("<tr>");
					out.println("<td>" + xAlu.getCodigo() + "</td>");
					out.println("<td>" + xAlu.getNombre() + "</td>");
					out.println("<td>" + xAlu.getApellido() + "</td>");
					out.println("<td>" + xAlu.getApodo() + "</td>");
					out.println("<td>" + xAlu.getNacionalidad() + "</td>");
					out.println("<td>" + xAlu.getClub() + "</td>");
					out.println("<td>" + xAlu.getEdad() + "</td>");
					out.println("<td>" + xAlu.getSueldo() + "</td>");
					out.println("<td>" + xAlu.getNomPosicion() + "</td>");
					out.println("<td align='center'><a href='ServletProducto?tipo=buscar&cod=" + xAlu.getCodigo() + "'>"
							+ "<img src='img/edit.png' title='Editar'></a></td>");
					out.println("<td align?'center'><a href='ServletProducto?tipo=eliminar&cod=" + xAlu.getCodigo()
							+ "'>" + "<img src='img/delete.jpg' title='Eliminar'></a></td>");
					out.println("</tr>");
				}
			}
		%>
	</table>
</body>
</html>