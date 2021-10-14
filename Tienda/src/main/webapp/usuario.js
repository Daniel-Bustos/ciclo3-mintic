/**
 * 
 */
$(document).ready(function(){
	
	$("#listarU").click(function(){
		$.get("http://localhost:8080/listausuarios", function(data, status){
			if(status=="success"){
				let longitud = data.length;
				let salida = "<table border='1'>";
				salida = salida + "<tr><th>Cedula</th><th>Nombre</th><th>Correo</th><th>USUARIO</th><th>CLAVE</th></tr>";
				for(let i=0; i<longitud; i++){
					salida = salida + "<tr>";
					//salida = salida + "<td>"+data[i].id_usuario+"</td>";
					salida = salida + "<td>"+data[i].cedula+"</td>";
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].correo+"</td>";
					salida = salida + "<td>"+data[i].usuario+"</td>";
					salida = salida + "<td>"+data[i].clave+"</td>";
					salida = salida + "</tr>";
				}
				salida = salida + "</table>";
				$("#mensaje").html(salida);
			}
		});
	});
	$("#buscarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/buscarusuarioID", {cedula: elid}, function(data,status){
			let longitud = data.length;
			if(longitud>0){
				$("#id").val(data[0].cedula);
				//$("#cedula").val(data[0].cedula);
				$("#nombre").val(data[0].nombre);
				$("#correo").val(data[0].correo);
				$("#usuario").val(data[0].usuario);
				$("#clave").val(data[0].clave);
			}else{
				$("#mensaje").html("<b style='color:red;'>USUARIO NO ENCONTRADO !!</b>");
			}
		});
	});
	
	$("#agregarU").click(function(){
		let elid = $("#id").val(); 
		let elnombre = $("#nombre").val();  
		let elcorreo = $("#correo").val();  
		let elusuario = $("#usuario").val();
		let laclave = $("#clave").val();  
		
		$.post("http://localhost:8080/crearusuario", {cedula: elid, nombre: elnombre, correo: elcorreo, usuario: elusuario, clave:laclave}, function(data,status){
			if(data==true){
				$("#mensaje").html("El usuario fue agregado .");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo crear, ya existe</b>");
			}
		});
	});
	
	
	$("#actualizarU").click(function(){
		let elid = $("#id").val();
		
		let elnombre = $("#nombre").val();
		let elcorreo = $("#correo").val();
		let elusuario = $("#usuario").val();
		let laclave = $("#clave").val();  
		
		$.post("http://localhost:8080/actualizarusuario",{cedula: elid, nombre: elnombre, correo: elcorreo, usuario: elusuario, clave: laclave}, function(data,status){
			if(data==true){
				$("#mensaje").html("El usuario fue actualizado .");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo actualizar, no existe</b>");
			}
		});
	});
	
	$("#eliminarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/borrarusuario",{cedula: elid},function(data,status){
			if(data==true){
				$("#mensaje").html("El usuario fue eliminado");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo eliminar </b>)");
			}
		});
	});
	
});