package com.DAO.Tienda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.DTO.Tienda.ProductoVO;

public class ProductoDAO {
	
	public boolean registrarProducto(ProductoVO Producto) {
		boolean creado=false;
		if(!existeProducto(Producto.getCodigo())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = conex.getConnection().createStatement();
				String sql = "INSERT INTO tiendagenerica1.productos (codigo_producto, nombre_producto, nitproveedor, precio_compra, ivacompra, precio_venta) VALUES ("
						+Producto.getCodigo()+",'"+Producto.getNombre()+"','"+
						Producto.getNit()+"','"+Producto.getPrecio_compra()+"','"+Producto.getIva()+"','"+Producto.getPrecio_venta()+"');";
						
				consulta.executeUpdate(sql);
				System.out.println(sql);
				consulta.close();
				conex.desconectar();
				creado = true;
			}catch(SQLException e) {
			System.out.println("No se pudo crear el producto.");
			}
			}else {
			System.out.println("El producto ya exite.");
			}
		return creado;
	}
	
		public boolean existeProducto(Long codigo) {
			boolean existe = false;
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tiendagenerica1.productos WHERE codigo_producto = ?");
				consulta.setLong(1,codigo);
				ResultSet res = consulta.executeQuery();
				if (res.next()) {
					existe = true;
				}
				res.close();
				consulta.close();
				conex.desconectar();
			}catch(Exception e) {
				System.out.println("No se pudo conectar");
			}
			return existe;
			}

		public ArrayList<ProductoVO> listaDeProductos(){
			ArrayList<ProductoVO> misProductos = new ArrayList<ProductoVO>(); 
			Conexion conex = new Conexion();
			try { 
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
				ResultSet res = consulta.executeQuery();
				while(res.next()){
				ProductoVO producto = new ProductoVO();
				producto.setCodigo(res.getLong("codigo_producto"));
				producto.setNombre(res.getString("nombre_producto"));
				producto.setNit(res.getLong("nitproveedor"));
				producto.setPrecio_compra(res.getDouble("precio_compra"));
				producto.setIva(res.getDouble("ivacompra"));
				producto.setPrecio_venta(res.getDouble("precio_venta"));
				misProductos.add(producto);
			}
			res.close();
			consulta.close(); conex.desconectar();
			}catch(Exception e) {
			System.out.println("No se pudo conectar");
			}
			return misProductos;
			}
			}
