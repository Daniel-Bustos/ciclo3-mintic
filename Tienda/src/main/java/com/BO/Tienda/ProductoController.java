package com.BO.Tienda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.DAO.Tienda.ProductoDAO;
import com.DTO.Tienda.ProductoVO;

@RestController
public class ProductoController {

	@RequestMapping("/cargarArchivo")
	public String cargarArchivo(MultipartFile archivoCSV) {
		File archivoNew;
		String salida="";
		FileReader fuente = null;
		String linea="";
		ArrayList<ProductoVO> listado= new ArrayList<ProductoVO>();
		try {
			archivoNew = deMultiPartAFile(archivoCSV);
			fuente = new FileReader(archivoNew.getName());
			BufferedReader archivo = new BufferedReader(fuente);
			do {
				linea = archivo.readLine();
				if (linea!=null) {
					String tmpLinea = linea.replace("\"","'");
					ArrayList<String> miLista = new ArrayList<String>(Arrays.asList(tmpLinea.split(";")));
					ProductoVO producto = new ProductoVO();
					producto.setCodigo(Long.parseLong(miLista.get(0)));
					producto.setNombre(miLista.get(1).replace("'",""));
					producto.setNit(Long.parseLong(miLista.get(2).replace("'","")));
					producto.setPrecio_compra(Double.parseDouble(miLista.get(3).replace("'","")));
					producto.setIva(Double.parseDouble(miLista.get(4).replace("'","")));
					producto.setPrecio_venta(Double.parseDouble(miLista.get(5).replace("'","")));
					listado.add(producto);
				}
			}while (linea!=null);
			archivo.close();
			fuente.close();
			
			boolean secreo= false;
			for(ProductoVO registro:listado) {
				ProductoDAO dao = new ProductoDAO();
				secreo = dao.registrarProducto(registro);
				salida = salida + "**"+secreo+"**" + registro.getCodigo() + "---" +
				registro.getNombre() + "---"+
				registro.getNit() + "---" +
				registro.getPrecio_compra() + " ---"+
				registro.getIva() + " ---"+
				registro.getPrecio_venta() + "<br>";
			}
			salida = salida + " RTA: " + (secreo?"Ok":"No se pudo insertar el listadio");
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e2) {
			System.out.println(e2.getMessage());
		}
			return salida;
	}
	
	private File deMultiPartAFile(MultipartFile archivo) {
		File convFile = new File(archivo.getOriginalFilename());
		FileOutputStream salida;
		try {
			salida = new FileOutputStream(convFile);
			salida.write(archivo.getBytes());
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convFile;
		}
	
	
	@RequestMapping("/listaproductos")
	public ArrayList<ProductoVO> listaDeProductos(){
	ProductoDAO dao = new ProductoDAO();
	ArrayList<ProductoVO> listado = dao.listaDeProductos();
	return listado;
	}
	
}
