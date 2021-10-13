<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<main>
		<form method="get" action="./ArticServlet">
			<table>
				<tr>
					<td><label id="usuario">Usuario</label></td>
					<td><input type="text" name="usuario"></td>
					<td><label id="clave">Contraseña</label></td>
					<td><input type="password" name="clave"></td>
				</tr>
				<tr>
					<td><input type="submit" value="enviar"></td>
				</tr>
			</table>
		</form>
	</main>
	
	<form class="LoginBox">
		<img alt="" src="images/a32.png" class="user">
		<h2>Administrador</h2>
		<p>Username</p>
		<input type="text" placeholder="Enter " required>
		<p>Password</p>
		<input type="text" placeholder="*******" required>
		<input type="submit" value="entregar"> 		
			
		</form>

</body>
</html>