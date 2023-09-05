package taller2;

import java.io.File;
import java.util.ArrayList;
public class Pedido {

 private  int numeropedidos;
 private int idpedido;
 private String nombrecliente;
 private String direccion;
 private ArrayList<Producto> itemsPedido;
 
	public Pedido(String nombreCliente, String direccioncliente) 
	{	
		itemsPedido = new ArrayList<Producto>();
		this.nombrecliente = nombreCliente;
		direccion = direccioncliente;
		
		
		
	}
	
	public int getIdpedido() 
	{
		return idpedido;
	}

	public void setIdpedido(int idpedido) 
	{
		this.idpedido = idpedido;
	}
	public void agregarProducto(Producto nuevoitem) 
	{
		
		itemsPedido.add(nuevoitem);
	}
	private int getprecionetopedido() 
	{
		int respuesta = 0;
		for (Producto k : itemsPedido)
		{
			int precio = k.getPrecio();
			respuesta = respuesta + precio;
			
		}
		return respuesta;
	}
	private int getpreciototalpedido()
	{
		double total = getprecionetopedido()+ getprecioivapedido();
		int respuesta = (int)total;
		return respuesta;
		
	}
	private int getprecioivapedido()
	{
		double iva = (getprecionetopedido()*(19/100));
		int respuesta = (int) iva;
		return respuesta;
	}
	private String generartextofactura()
	{
		return "";
	}
	public void guardarfactura(File archivo)
	{
		
	}
}

