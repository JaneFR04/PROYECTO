<%@page import="beans.ProductoDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.29.0/js/extras/jquery.metadata.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
<script type="text/javascript">
	<script type="text/javascript">
	$(document).ready(function() {
		$("#frmagregar").validate();
	});
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: radial-gradient(at 20px 20px, red 20%, blue 60%, yellow);
	font-family: Arial, sans-serif;
	height: 100vh;
	display:flex;
        justify-content: center;
        align-items: center;
}
form {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 400px;

    }

    h2 {
        text-align: center;
        color: #2E8B57;
        font-size: 1.8em;
        margin-bottom: 20px;
        text-shadow: 1px 1px 1px #aaa;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    td {
        padding: 10px;
        vertical-align: middle;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 1em;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: blue;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 1.1em;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0b72ff;
    }

   /* tr:nth-child(even) td {
        background-color: #f9f9f9;
    }

    tr:nth-child(odd) td {
        background-color: #fff;
    }*/
    select{
    width: 100%;
    padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 1em;
        box-sizing: border-box;
   
    }
</style>
</head>
<body>
	<%
		ProductoDTO obj = (ProductoDTO) request.getAttribute("Producto");
	%>
	<form action="ServletProducto?tipo=actualizar" id="frmagregar" method="post">
		<input type="hidden" name="txt_cod"
			value="${requestScope.Producto.codigo}">
		<table align="center">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txt_nom" class="required"
					value="${requestScope.Producto.nombre}"></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="txt_ape" class="required"
					value="${requestScope.Producto.apellido}"></td>
			</tr>
			<tr>
				<td>Apodo:</td>
				<td><input type="text" name="txt_apo" class="required"
					value="${requestScope.Producto.apodo}"></td>
			</tr>
			<tr>
				<td>Nacionalidad:</td>
				<td><input type="text" name="txt_naci" class="required"
					value="${requestScope.Producto.nacionalidad}"></td>
			</tr>
			<tr>
				<td>Club:</td>
				<td><input type="text" name="txt_club" class="required"
					value="${requestScope.Producto.club}"></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="txt_edad" class="required"
					value="${requestScope.Producto.edad}"></td>
			</tr>
			<tr>
				<td>Sueldo:</td>
				<td><input type="text" name="txt_sue" class="required"
					value="${requestScope.Producto.sueldo}"></td>
			</tr>
			<tr>
				<td>Posición</td>
				<td><select name="cbo_posicion">
						<%
							String marca[] = { "", "Delantero", "Mediocampista", "Portero", "Defensa" };
							String estado = "";
							for (int i = 1; i < marca.length; i++) {
								System.out.println("objeto:" + obj.getNomPosicion());
								System.out.println("array:" + marca[i]);
								if (Integer.parseInt(obj.getNomPosicion()) == i) {
									System.out.println("en selected");
									estado = "selected";
								} else
									estado = "";
						%>
						<option value="<%=i%>" <%=estado%>>
							<%=marca[i]%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Registrar" class="boton2"></td>
			</tr>
		</table>
	</form>
</body>
</html>