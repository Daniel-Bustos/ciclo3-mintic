package com.DAO.Tienda;

	import java.beans.*;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.sql.*;

	import com.DTO.Tienda.ClienteVO;

	public class ClienteDAO{
		public ArrayList<ClienteVO> listaDeClientes(){
			ArrayList<ClienteVO>misClientes = new ArrayList<ClienteVO>();
			Conexion conex =new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
				ResultSet res = consulta.executeQuery();
				
				while(res.next()) {
					ClienteVO Cliente = new ClienteVO();
					Cliente.setCedula(res.getLong("cedula"));
					Cliente.setNombre(res.getString("nombre"));
					Cliente.setDireccion(res.getString("direccion"));
					Cliente.setTelefono(res.getString("telefono"));
					Cliente.setCorreo(res.getString("correo"));
					misClientes.add(Cliente);
				}
				res.close();
				consulta.close();
				conex.desconectar();
			}catch(Exception e) {
				System.out.println("Nose pudo conectar");
			}
			return misClientes;
		}
		
		/******************************************+*/
		public ArrayList<ClienteVO> buscarCliente(long cedula){
			ArrayList<ClienteVO> misClientes = new ArrayList<ClienteVO>();
			Conexion conex =new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.clientes WHERE cedula=?");
				consulta.setLong(1, cedula);
				ResultSet res = consulta.executeQuery();
				
				while(res.next()) {
					ClienteVO Cliente = new ClienteVO();
					
					Cliente.setCedula(res.getLong("cedula"));
				
					Cliente.setNombre(res.getString("nombre"));
					Cliente.setDireccion(res.getString("direccion"));
					Cliente.setTelefono(res.getString("telefono"));
					Cliente.setCorreo(res.getString("correo"));
					misClientes.add(Cliente);
				}
				res.close();
				consulta.close();
				conex.desconectar();
			}catch(Exception e) {
				System.out.println("Nose pudo conectar");
			}
			return misClientes;
		}
		
		
		public boolean existeUsuario(Long cedula){
			boolean existe = false;
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.clientes WHERE cedula=?");
				consulta.setLong(1, cedula);			
				ResultSet res = consulta.executeQuery();
				
				if(res.next()) {
					existe = true;
				}
				res.close();
				consulta.close();
				conex.desconectar();
			}catch(Exception e) {
				System.out.println("No se pudo verificar si existe el usuario");
			}
			return existe;
		}
		
		
		public boolean crearCliente(ClienteVO Cliente){
			boolean swCrear= false;
			if(!existeUsuario(Cliente.getCedula())) {
				Conexion conex =new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "INSERT INTO tiendagenerica1.clientes (cedula, nombre, direccion, telefono, correo) VALUES ("
					+Cliente.getCedula()+",'"+Cliente.getNombre()+"','"+
					Cliente.getDireccion()+"','"+Cliente.getTelefono()+"','"+Cliente.getCorreo()+"');";
					//String SQL = "INSERT INTO usuarios (id_usuario, cedula, nombre, correo, usuario, clave) VALUES ("+Usuario.getId_usuario()+",'"+Usuario.getCedula()+",'"+Usuario.getNombre()+",'"+Usuario.getCorreo()+",'"+Usuario.getUsuario()+"','"+Usuario.getClave()+"');'";
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					conex.desconectar();
					swCrear=true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear eel usuario");
				}
					
			}else {
				System.out.println("El usuarioa ya existe");
			}
			return swCrear;
			
		
		}

		
		public boolean borrarCliente(Long cedula){
			boolean swCrear= false;
			if(existeUsuario(cedula)) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "DELETE FROM tiendagenerica1.clientes WHERE cedula="+cedula; 
					//((java.sql.Statement) consulta).executeUpdate(SQL);	   
					//((java.sql.Statement) consulta).close();
					
					consulta.executeUpdate(SQL);
					consulta.close();
					conex.desconectar();
					swCrear=true;
				}catch(SQLException e) {
					System.out.println("No se pudo eliminar usuario");
				}
					
			}else {
				System.out.println("El usuario no existe");
			}
			return swCrear;
			
		
		}
		

		public boolean actualizarCliente(ClienteVO Cliente){
			boolean swActualizar= false;
			if(existeUsuario(Cliente.getCedula())) {
				Conexion conex =new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "UPDATE tiendagenerica1.clientes SET nombre='"+Cliente.getNombre()+"',"+"direccion='"+Cliente.getDireccion()+"',"+"telefono='"+Cliente.getTelefono()+"',"+"correo='"+Cliente.getCorreo()+"' WHERE cedula="+Cliente.getCedula(); 
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					conex.desconectar();
					swActualizar=true;
				}catch(SQLException e) {
					System.out.println("No se pudo actualizar usuario");
				}
					
			}else {
				System.out.println("El usuario no existe");
			}
			return swActualizar;
			
		
		}
	
}
