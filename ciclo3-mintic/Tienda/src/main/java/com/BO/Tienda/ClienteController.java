package com.BO.Tienda;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.Tienda.ClienteDAO;
import com.DTO.Tienda.ClienteVO;
//Autoriza para hacer consultas desde afuera
@RestController
public class ClienteController { 
	/**
	* recibe la peticion para el listado de Usuarios
	* @return
	*/
	@RequestMapping("/listaclientes")
	public ArrayList<ClienteVO> listaDeClientes(){
		ClienteDAO dao = new ClienteDAO();
		return dao.listaDeClientes();
	}
	
	
	/**
	* Busca los datos de un Usuario por su ID
	* @param id
	* @return
	*/
	@RequestMapping("/buscarclienteID")
	public ArrayList<ClienteVO> buscarCliente(String cedula){//revisar****
		ClienteDAO dao = new ClienteDAO();
		return dao.buscarCliente(Long.parseLong(cedula));
	}
	
	
	
	/**
	* Agrega un nuevo Usuario a la base de datos
	* @param id
	* @param usuario
	* @param clave
	* @return
	*/
	@RequestMapping("/crearcliente")
	public boolean crearCliente(String cedula, String nombre,String direccion, String telefono,String correo) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente = new ClienteVO();
		//Revisar*****
		Cliente.setCedula(Long.parseLong(cedula));
		
		Cliente.setNombre(nombre);
		Cliente.setDireccion(direccion);
		Cliente.setTelefono(telefono);
		Cliente.setCorreo(correo);
		return dao.crearCliente(Cliente);
	}
	
	
	/**
	* Elimina un Usuario de acuerdo a su ID
	* @param id
	* @return
	*/
	@RequestMapping("/borrarcliente")
	public boolean borrarCliente(String cedula) {
		ClienteDAO dao = new ClienteDAO();
		return dao.borrarCliente(Long.parseLong(cedula));
	}
	
	
	/**
	* Actualiza los datos del Usuario segun su id
	* @param id
	* @param usuario
	* @param clave
	* @return
	*/
	@RequestMapping("/actualizarcliente")
	public boolean actualizarCliente(String cedula,String nombre,String direccion,String telefono,String correo) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente = new ClienteVO();
		Cliente.setCedula(Long.parseLong(cedula));
		Cliente.setNombre(nombre);
		Cliente.setDireccion(direccion);
		Cliente.setTelefono(telefono);
		Cliente.setCorreo(correo);
		return dao.actualizarCliente(Cliente);
	}
}






