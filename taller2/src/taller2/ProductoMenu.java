package taller2;

public class ProductoMenu implements Producto 
{
	private String nombre;
	private int precioBase;
	public int getPrecio()
	{
		return precioBase;
	}
	public ProductoMenu(String nombre,int precioBase) 
	{
		this.nombre=nombre;
		this.precioBase = precioBase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	public String generarTextoFactura()
	{
		return "";
	}

}
