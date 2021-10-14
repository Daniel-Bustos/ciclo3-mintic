package com.DAO.Tienda;

import java.beans.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import com.DTO.Tienda.UsuarioVO;

public class UsuarioDAO {
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		ArrayList<UsuarioVO>misUsuarios = new ArrayList<UsuarioVO>();
		Conexion conex =new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setCedula(res.getLong("cedula"));
				Usuario.setNombre(res.getString("nombre"));
				Usuario.setCorreo(res.getString("correo"));
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("Nose pudo conectar");
		}
		return misUsuarios;
	}
	
	/******************************************+*/
	public ArrayList<UsuarioVO> buscarUsuario(long cedula){
		ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
		Conexion conex =new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.usuarios WHERE cedula=?");
			consulta.setLong(1, cedula);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				
				Usuario.setCedula(res.getLong("cedula"));
			
				Usuario.setNombre(res.getString("nombre"));
				Usuario.setCorreo(res.getString("correo"));
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("Nose pudo conectar");
		}
		return misUsuarios;
	}
	
	
	public boolean existeUsuario(Long cedula){
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.usuarios WHERE cedula=?");
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
	
	
	public boolean crearUsuario(UsuarioVO Usuario){
		boolean swCrear= false;
		if(!existeUsuario(Usuario.getCedula())) {
			Conexion conex =new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO tiendagenerica1.usuarios (cedula, nombre, correo, usuario, clave) VALUES ("
				+Usuario.getCedula()+",'"+Usuario.getNombre()+"','"+
				 Usuario.getCorreo()+"','"+Usuario.getUsuario()+"','"+Usuario.getClave()+"');";
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

	
	public boolean borrarUsuario(Long cedula){
		boolean swCrear= false;
		if(existeUsuario(cedula)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM tiendagenerica1.usuarios WHERE cedula="+cedula; 
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
	

	public boolean actualizarUsuario(UsuarioVO Usuario){
		boolean swActualizar= false;
		if(existeUsuario(Usuario.getCedula())) {
			Conexion conex =new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "UPDATE tiendagenerica1.usuarios SET nombre='"+Usuario.getNombre()+"',"+"correo='"+Usuario.getCorreo()+"',"+"usuario='"+Usuario.getUsuario()+"',"+"clave='"+Usuario.getClave()+"' WHERE cedula="+Usuario.getCedula(); 
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