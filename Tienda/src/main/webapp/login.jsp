<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href ="css/estilos.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script src="login.js"></script><!-- Incorporo al proyecto javascript -->
</head>
<body><!-- 
	<h1>CRECDENCIASLES DE INGRESO A LA TIENDA VIRTUAL</h1>
	<form>
	<table>
	<tr>
	<td><label>Usuario:</label></td>
	<td><input Id="usuario" type="text" value=""></td>
	</tr>
	<tr>
	<td><label>Clave:</label></td>
	<td><input Id="clave" type="text" value=""></td>
	</tr>
	<tr><td><input type="button" value="Enviaru" id="btn_Enviaru"></td></tr>
	<!-- <tr><td><button id="btnEnviar" class="w3-button">Enviar</button></td></tr>
	</table>
	</form>
	<br><br><div id="salida"></div>
-->
	
	<form class="LoginBox">
		<img alt="" src="images/a32.png" class="user">
		<h2>Login</h2>
		<p>Username</p>
		<input type="text" placeholder="Enter username" required Id="usuario">
		<p>Password</p>
		<input type="text" placeholder="**********" required Id="clave">
		<input type="button" value="entregar" id="btn_Enviaru"> 		
			
		</form>
		<br><br><div id="salida"></div>
</body>
</html>