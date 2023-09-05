package taller2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import java.util.ArrayList;
import java.util.List;
public class Restaurante {
	private ArrayList<Pedido> pedidos;
	private ProductoAjustado ajustado;
	private Pedido pedidoEnCurso;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> combos;
	public Restaurante()
	
	{
		
		pedidos = new ArrayList<Pedido>();
		pedidoEnCurso = null;
		ingredientes = new ArrayList<Ingrediente>();
		menuBase = new ArrayList<ProductoMenu>();
		combos = new ArrayList<Combo>();
		this.ajustado = null;
	}
	public void iniciarPedidos(String nombreCliente,String direccionCliente)
	{
		this.pedidoEnCurso = new Pedido(nombreCliente,direccionCliente);
	}
	public void cerrarYGuardarpedido()
	{
		this.pedidos.add(pedidoEnCurso);
		this.pedidoEnCurso = null;
	}

	
	
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}

	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
		
	}
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	public void cargarInformacionRestaurante(String archivoIngredientes,String archivoMenu, String archivoCombos) throws IOException
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	private void cargarIngredientes(String archivoIngredientes) throws IOException
	{
		BufferedReader lector = new BufferedReader(new FileReader(new File(archivoIngredientes)));
		String linea = lector.readLine();
		while (linea!=null)
		{
			String [] datos = linea.split(";");
			
			String nombre = datos[0].trim();
			String precio = datos[1].trim();
			int preciof = Integer.parseInt(precio);
			Ingrediente ing = new Ingrediente(nombre,preciof);
			ingredientes.add(ing);
			linea=lector.readLine();
		}
		
	}
		
			
	public void anadirIngrediente(String ing) {
		int iterador = ingredientes.size();
		for(int i = 0; i < iterador; i++) {
			String nombre = ingredientes.get(i).getNombre();
			if (nombre.equals(ing)){
				
				ajustado.agregar(ingredientes.get(i));
			}
		}	
	}
	public void eliminarIngrediente(String ingrediente) {
		int iterador = ingredientes.size();
		for(int i = 0; i < iterador; i++) {
			String nombre = ingredientes.get(i).getNombre();
			if (nombre.equals(ingrediente)){
				
				ajustado.quitar(ingredientes.get(i));
			}
		}
	}
	public void terminarAjuste() 
	{
		pedidoEnCurso.agregarProducto(ajustado);
	}
	private void cargarMenu(String archivoMenu)throws IOException
	{
		BufferedReader lector = new BufferedReader(new FileReader(new File(archivoMenu)));
		String linea = lector.readLine();
		while(linea!=null)
		{
			String [] datos = linea.split(";");
			String nombre = datos[0].trim();
			String precio = datos[1].trim();
			int preciof = Integer.parseInt(precio);
			ProductoMenu menu = new ProductoMenu(nombre,preciof);
			menuBase.add(menu);
			linea=lector.readLine();
			
		}
		
	}
	private void cargarCombos(String archivoCombos) throws IOException
	{
		{
			BufferedReader lector = new BufferedReader(new FileReader(archivoCombos));
			String linea = lector.readLine();
			while(linea != null)
			{
				String[] datos = linea.split(";");
				String nombre = datos[0];
				Integer numero = datos[1].length();
				String price = datos[1].substring(0,numero-1);
				Double descuento = Double.parseDouble(price);
				Integer n = menuBase.size();
				Combo combo = new Combo(nombre, descuento);
				Integer precio = 0;			
				for(int j=2; j < datos.length ;j++)
				{

						for(int i=0; i < n ;i++ ) 
						{
							
							Producto producto = menuBase.get(i);
							String name = producto.getNombre();
							if( name.equals(nombre) ) 
							{
								
								combo.agregarItemACombo(producto);
								Integer cantidad = producto.getPrecio();
								precio += cantidad;			
							}	
						}
					}
				precio = (int)(precio * (100 - descuento)/100) ;
				combo.setPrecio(precio);
				combos.add(combo);
				linea=lector.readLine();
		}
	}
}
}
