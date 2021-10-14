/*$(document).ready(function(){
	$("#btn_Enviaru").click(function(){//El evento callback no tiene cuerpo solo se ejecuta en el momento
	let elUsuario = document.getElementById("usuario").value;//cada control de la pagina tiene un Id
	let laClave = document.getElementById("clave").value;
	//esta varialbe contine el valor del campo cedula
	$.post("http://localhost:8080/loginusuario2",{ usuario: elUsuario, clave: laClave },
	function(data, status){
	// data1 = $.parseJSON( data );
	if(data.existe==true)
	{
	alert("Bienvenido "+elUsuario);
	window.location.href = "cliente.jsp";
	}
	else
	{
	alert("No xiste el Usuario");
	}
	});
	});
	function mostrarUno(item, index) {
	let valores = Object.values(item);
	$("#usuario").val(valores[0]);
	$("#clave").val(valores[1]);
	}
});*/
$(document).ready(function(){
	$("#btn_Enviaru").click(function(){//El evento callback no tiene cuerpo solo se ejecuta en el momento
		let elUsuario = document.getElementById("usuario").value;//cada control de la pagina tiene un Id
		let laClave = document.getElementById("clave").value;
		//esta varialbe contine el valor del campo cedula
		$.post("http://localhost:8080/loginusuario2",{ usuario: elUsuario, clave: laClave },
		function(data, status){
			// data1 = $.parseJSON( data );
			if(status="success"){
				let longitud = data.length;
				let salida = "<table class='w3-table-all w3-hoverable w3-card-2'>";
				salida=salida+"<tr><th>USUARIO</th></tr>";
			
				for(let i=0; i<longitud;i++){
					salida=salida+"<tr><td>"+data[i].usuario+"</td><td>";
					window.location.href = "login2.html";
				}
			salida=salida+"</table>";
			$("#salida").html(salida);
		}	
		});
});
});