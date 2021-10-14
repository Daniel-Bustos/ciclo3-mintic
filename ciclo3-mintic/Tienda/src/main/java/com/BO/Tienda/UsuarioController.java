package com.BO.Tienda;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.Tienda.UsuarioDAO;
import com.DTO.Tienda.UsuarioVO;
//Autoriza para hacer consultas desde afuera
@RestController
public class UsuarioController {
	/**
	* recibe la peticion para el listado de Usuarios
	* @return
	*/
	@RequestMapping("/listausuarios")
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.listaDeUsuarios();
	}
	
	
	/**
	* Busca los datos de un Usuario por su ID
	* @param id
	* @return
	*/
	@RequestMapping("/buscarusuarioID")
	public ArrayList<UsuarioVO> buscarUsuario(String cedula){//revisar****
		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarUsuario(Long.parseLong(cedula));
	}
	
	
	
	/**
	* Agrega un nuevo Usuario a la base de datos
	* @param id
	* @param usuario
	* @param clave
	* @return
	*/
	@RequestMapping("/crearusuario")
	public boolean crearUsuario(String cedula, String nombre,String correo, String usuario,String clave) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
		//Revisar*****
		Usuario.setCedula(Long.parseLong(cedula));
		
		Usuario.setNombre(nombre);
		Usuario.setCorreo(correo);
		Usuario.setUsuario(usuario);
		Usuario.setClave(clave);
		return dao.crearUsuario(Usuario);
	}
	
	
	/**
	* Elimina un Usuario de acuerdo a su ID
	* @param id
	* @return
	*/
	@RequestMapping("/borrarusuario")
	public boolean borrarUsuario(String cedula) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.borrarUsuario(Long.parseLong(cedula));
	}
	
	
	/**
	* Actualiza los datos del Usuario segun su id
	* @param id
	* @param usuario
	* @param clave
	* @return
	*/
	@RequestMapping("/actualizarusuario")
	public boolean actualizarUsuario(String cedula,String nombre,String correo,String usuario,String clave) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
		Usuario.setCedula(Long.parseLong(cedula));
		Usuario.setNombre(nombre);
		Usuario.setCorreo(correo);
		Usuario.setUsuario(usuario);
		Usuario.setClave(clave);
		return dao.actualizarUsuario(Usuario);
	}
}


