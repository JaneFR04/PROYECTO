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
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	font-family: Arial, sans-serif;
	background-size: cover;
}

.login-container {
	background-color: rgba(255, 255, 255, 0.8);
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	width: 300px;
	text-align: center;
}

.login-container h2 {
	margin-bottom: 20px;
	font-size: 24px;
	color: #333;
}

.login-container input[type="text"] {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

.login-container input[type="password"] {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

.login-container input[type="submit"] {
	background-color: blue;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: 100%;
	font-size: 16px;
	margin: 10px 0px;
}

.login-container input[type="submit"]:hover {
	background-color: #0b72ff;
}

.login-container .request {
	color: red;
}
</style>

</head>
<body>
	<div class="login-container">
		<h2>Iniciar Sesión</h2>
		<form action="ServletEmpleado?tipo=sesion" name="frmsesion"
			method="post">
			<input type="text" name="txt_login" placeholder="Login"> <input
				type="password" name="txt_pass" placeholder="Password">
			<table align="center" width="100%">
				<tr>
					<td colspan="2" align="center" class="request">${requestScope.msg}</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Iniciar"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
