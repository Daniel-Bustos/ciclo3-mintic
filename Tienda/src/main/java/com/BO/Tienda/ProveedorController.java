package com.BO.Tienda;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.Tienda.ProveedorDAO;
import com.DTO.Tienda.ProveedorVO;
//Autoriza para hacer consultas desde afuera
@RestController
public class ProveedorController {
	/**
	* recibe la peticion para el listado de Usuarios
	* @return
	*/
	@RequestMapping("/listaproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ProveedorDAO dao = new ProveedorDAO();
		return dao.listaDeProveedores();
	}
	
	
	/**
	* Busca los datos de un Usuario por su ID
	* @param id
	* @return
	*/
	@RequestMapping("/buscarproveedorID")
	public ArrayList<ProveedorVO> buscarProveedor(String nit){//revisar****
		ProveedorDAO dao = new ProveedorDAO();
		return dao.buscarProveedor(Long.parseLong(nit));
	}
	
	
	
	/**
	* Agrega un nuevo Usuario a la base de datos
	* @param id
	* @param usuario
	* @param clave
	* @return
	*/
	@RequestMapping("/crearproveedor")
	public boolean crearProveedor(String nit, String nombre,String direccion, String telefono,String ciudad) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor = new ProveedorVO();
		//Revisar*****
		Proveedor.setNit(Long.parseLong(nit));
		
		Proveedor.setNombre(nombre);
		Proveedor.setDireccion(direccion);
		Proveedor.setTelefono(telefono);
		Proveedor.setCiudad(ciudad);
		return dao.crearProveedor(Proveedor);
	}
	
	
	/**
	* Elimina un Usuario de acuerdo a su ID
	* @param id
	* @return
	*/
	@RequestMapping("/borrarproveedor")
	public boolean borrarProveedor(String nit) {
		ProveedorDAO dao = new ProveedorDAO();
		return dao.borrarProveedor(Long.parseLong(nit));
	}
	
	
	/**
	* Actualiza los datos del Usuario segun su id
	* @param id
	* @param usuario
	* @param clave
	* @return
	*/
	@RequestMapping("/actualizarproveedor")
	public boolean actualizarProveedor(String nit,String nombre,String direccion,String telefono,String ciudad) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor = new ProveedorVO();
		Proveedor.setNit(Long.parseLong(nit));
		Proveedor.setNombre(nombre);
		Proveedor.setDireccion(direccion);
		Proveedor.setTelefono(telefono);
		Proveedor.setCiudad(ciudad);
		return dao.actualizarProveedor(Proveedor);
	}
}






