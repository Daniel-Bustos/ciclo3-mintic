/**
 * 
 */
$(document).ready(function(){
	
	$("#listarU").click(function(){
		$.get("http://localhost:8080/listaclientes", function(data, status){
			if(status=="success"){
				let longitud = data.length;
				let salida = "<table border='1'>";
				salida = salida + "<tr><th>Cedula</th><th>Nombre</th><th>Direccion</th><th>Telefono</th><th>Correo</th></tr>";
				for(let i=0; i<longitud; i++){
					salida = salida + "<tr>";
					//salida = salida + "<td>"+data[i].id_usuario+"</td>";
					salida = salida + "<td>"+data[i].cedula+"</td>";
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].direccion+"</td>";
					salida = salida + "<td>"+data[i].telefono+"</td>";
					salida = salida + "<td>"+data[i].correo+"</td>";
					salida = salida + "</tr>";
				}
				salida = salida + "</table>";
				$("#mensaje").html(salida);
			}
		});
	});
	$("#buscarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/buscarclienteID", {cedula: elid}, function(data,status){
			let longitud = data.length;
			if(longitud>0){
				$("#id").val(data[0].cedula);
				//$("#cedula").val(data[0].cedula);
				$("#nombre").val(data[0].nombre);
				$("#direccion").val(data[0].direccion);
				$("#telefono").val(data[0].telefono);
				$("#correo").val(data[0].correo);
			}else{
				$("#mensaje").html("<b style='color:red;'>CLIENTE NO ENCONTRADO !!</b>");
			}
		});
	});
	
	$("#agregarU").click(function(){
		let elid = $("#id").val(); 
		let elnombre = $("#nombre").val();  
		let ladireccion = $("#direccion").val();  
		let eltelefono = $("#telefono").val();
		let elcorreo = $("#correo").val();  
		
		$.post("http://localhost:8080/crearcliente", {cedula: elid, nombre: elnombre, direccion: ladireccion, telefono: eltelefono, correo:elcorreo}, function(data,status){
			if(data==true){
				$("#mensaje").html("El cliente fue agregado .");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo crear, ya existe</b>");
			}
		});
	});
	
	
	$("#actualizarU").click(function(){
		let elid = $("#id").val();
		
		let elnombre = $("#nombre").val();
		let ladireccion = $("#direccion").val();
		let eltelefono = $("#telefono").val();
		let elcorreo = $("#correo").val();  
		
		$.post("http://localhost:8080/actualizarcliente",{cedula: elid, nombre: elnombre, direccion: ladireccion, telefono: eltelefono, correo: elcorreo}, function(data,status){
			if(data==true){
				$("#mensaje").html("El cliente fue actualizado .");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo actualizar, no existe</b>");
			}
		});
	});
	
	$("#eliminarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/borrarcliente",{cedula: elid},function(data,status){
			if(data==true){
				$("#mensaje").html("El cliente fue eliminado");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo eliminar </b>)");
			}
		});
	});
	
});