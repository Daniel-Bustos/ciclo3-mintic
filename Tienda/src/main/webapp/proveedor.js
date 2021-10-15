/**
 * 
 */
$(document).ready(function(){
	
	$("#listarU").click(function(){
		$.get("http://localhost:8080/listaproveedores", function(data, status){
			if(status=="success"){
				let longitud = data.length;
				let salida = "<table border='1'>";
				salida = salida + "<tr><th>NIT</th><th>Nombre</th><th>Direccion</th><th>Telefono</th><th>CIUDAD</th></tr>";
				for(let i=0; i<longitud; i++){
					salida = salida + "<tr>";
					//salida = salida + "<td>"+data[i].id_usuario+"</td>";
					salida = salida + "<td>"+data[i].nit+"</td>";
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].direccion+"</td>";
					salida = salida + "<td>"+data[i].telefono+"</td>";
					salida = salida + "<td>"+data[i].ciudad+"</td>";
					salida = salida + "</tr>";
				}
				salida = salida + "</table>";
				$("#mensaje").html(salida);
			}
		});
	});
	$("#buscarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/buscarproveedorID", {nit: elid}, function(data,status){
			let longitud = data.length;
			if(longitud>0){
				$("#id").val(data[0].nit);
				//$("#cedula").val(data[0].cedula);
				$("#nombre").val(data[0].nombre);
				$("#direccion").val(data[0].direccion);
				$("#telefono").val(data[0].telefono);
				$("#ciudad").val(data[0].ciudad);
			}else{
				$("#mensaje").html("<b style='color:red;'>Proveedor NO ENCONTRADO !!</b>");
			}
		});
	});
	
	$("#agregarU").click(function(){
		let elid = $("#id").val(); 
		let elnombre = $("#nombre").val();  
		let ladireccion = $("#direccion").val();  
		let eltelefono = $("#telefono").val();
		let laciudad = $("#ciudad").val();  
		
		$.post("http://localhost:8080/crearproveedor", {nit: elid, nombre: elnombre, direccion: ladireccion, telefono: eltelefono, ciudad:laciudad}, function(data,status){
			if(data==true){
				$("#mensaje").html("El proveedor fue agregado .");
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
		let elcorreo = $("#ciudad").val();  
		
		$.post("http://localhost:8080/actualizarproveedor",{nit: elid, nombre: elnombre, direccion: ladireccion, telefono: eltelefono, ciudad: elcorreo}, function(data,status){
			if(data==true){
				$("#mensaje").html("El proveedor fue actualizado .");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo actualizar, no existe</b>");
			}
		});
	});
	
	$("#eliminarU").click(function(){
		let elid = $("#id").val();
		$.post("http://localhost:8080/borrarproveedor",{nit: elid},function(data,status){
			if(data==true){
				$("#mensaje").html("El proveedor fue eliminado");
			}else{
				$("#mensaje").html("<b style='color:red;'>No se pudo eliminar </b>)");
			}
		});
	});
	
});