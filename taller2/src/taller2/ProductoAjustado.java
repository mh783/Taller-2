package taller2;
import java.util.ArrayList;
public class ProductoAjustado implements Producto 
{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	public ProductoAjustado(ProductoMenu base) 
	{
		
		this.base = base;  
	}
	public void agregar(Ingrediente ing)
	{
		agregados.add(ing);
	}
	public void quitar(Ingrediente ing)
	{
		eliminados.add(ing);
	}
	public String getNombre()
	{
		String nombre = base.getNombre();
		return nombre;
	}
	public int getPrecio()
	{
		int precio = base.getPrecio();
		return precio;
	}
	public String generarTextoFactura()
	{
		return "";
	}
}
