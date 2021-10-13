package com.BO.Tienda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DAO.Tienda.*;
import com.DTO.Tienda.LoginVO;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class LoginController {
	// devuelve true o false si existe el usuario
	@RequestMapping("/loginusuario2")
	public ArrayList<LoginVO> validarlogin2(String usuario, String clave) //recibe esta cadena y convierte en un objeto de tipo cliente
	{
		ArrayList<LoginVO> miusuario = new ArrayList<LoginVO>();//Crea el objeto arryList
		//pasa la peteción al servicio
		LoginDAO Dao=new LoginDAO(); //cargamos el objeto y se pasa al DAO y valida el usuario
		miusuario= Dao.consultarUsuario(usuario, clave);
		return miusuario;
		
		
		/*if(miusuario.isEmpty())
		{
			return Collections.singletonMap("existe", false);
		}
		else
		{
			return Collections.singletonMap("existe", true);
		}*/
	}
}
