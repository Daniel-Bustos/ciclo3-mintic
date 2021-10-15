package com.DAO.Tienda;

import java.beans.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import com.DTO.Tienda.ProveedorVO;

public class ProveedorDAO {
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ArrayList<ProveedorVO>misProveedores = new ArrayList<ProveedorVO>();
		Conexion conex =new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				ProveedorVO Proveedor = new ProveedorVO();
				Proveedor.setNit(res.getLong("nit"));
				Proveedor.setNombre(res.getString("nombre"));
				Proveedor.setDireccion(res.getString("direccion"));
				Proveedor.setTelefono(res.getString("telefono"));
				Proveedor.setCiudad(res.getString("ciudad"));
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("Nose pudo conectar");
		}
		return misProveedores;
	}
	
	/******************************************+*/
	public ArrayList<ProveedorVO> buscarProveedor(long nit){
		ArrayList<ProveedorVO> misProveedores = new ArrayList<ProveedorVO>();
		Conexion conex =new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.proveedores WHERE nit=?");
			consulta.setLong(1, nit);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				ProveedorVO Proveedor = new ProveedorVO();
				
				Proveedor.setNit(res.getLong("nit"));
			
				Proveedor.setNombre(res.getString("nombre"));
				Proveedor.setDireccion(res.getString("direccion"));
				Proveedor.setTelefono(res.getString("telefono"));
				Proveedor.setCiudad(res.getString("ciudad"));
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("Nose pudo conectar");
		}
		return misProveedores;
	}
	
	
	public boolean existeProveedor(Long nit){
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.proveedores WHERE nit=?");
			consulta.setLong(1, nit);			
			ResultSet res = consulta.executeQuery();
			
			if(res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe el Proveedor");
		}
		return existe;
	}
	
	
	public boolean crearProveedor(ProveedorVO Proveedor){
		boolean swCrear= false;
		if(!existeProveedor(Proveedor.getNit())) {
			Conexion conex =new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO tiendagenerica1.proveedores (nit, nombre, direccion, telefono, ciudad) VALUES ("
				+Proveedor.getNit()+",'"+Proveedor.getNombre()+"','"+
				Proveedor.getDireccion()+"','"+Proveedor.getTelefono()+"','"+Proveedor.getCiudad()+"');";
				//String SQL = "INSERT INTO usuarios (id_usuario, cedula, nombre, correo, usuario, clave) VALUES ("+Usuario.getId_usuario()+",'"+Usuario.getCedula()+",'"+Usuario.getNombre()+",'"+Usuario.getCorreo()+",'"+Usuario.getUsuario()+"','"+Usuario.getClave()+"');'";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear=true;
			}catch(SQLException e) {
				System.out.println("No se pudo crear eel Proveedor");
			}
				
		}else {
			System.out.println("El Proveedor ya existe");
		}
		return swCrear;
		
	
	}

	
	public boolean borrarProveedor(Long nit){
		boolean swCrear= false;
		if(existeProveedor(nit)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM tiendagenerica1.proveedores WHERE nit="+nit; 
				//((java.sql.Statement) consulta).executeUpdate(SQL);	   
				//((java.sql.Statement) consulta).close();
				
				consulta.executeUpdate(SQL);
				consulta.close();
				conex.desconectar();
				swCrear=true;
			}catch(SQLException e) {
				System.out.println("No se pudo eliminar Proveedor");
			}
				
		}else {
			System.out.println("El Proveedor no existe");
		}
		return swCrear;
		
	
	}
	

	public boolean actualizarProveedor(ProveedorVO Proveedor){
		boolean swActualizar= false;
		if(existeProveedor(Proveedor.getNit())) {
			Conexion conex =new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "UPDATE tiendagenerica1.proveedores SET nombre='"+Proveedor.getNombre()+"',"+"direccion='"+Proveedor.getDireccion()+"',"+"telefono='"+Proveedor.getTelefono()+"',"+"ciudad='"+Proveedor.getCiudad()+"' WHERE nit="+Proveedor.getNit(); 
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swActualizar=true;
			}catch(SQLException e) {
				System.out.println("No se pudo actualizar Proveedor");
			}
				
		}else {
			System.out.println("El Proveedor no existe");
		}
		return swActualizar;
		
	
	}
}



