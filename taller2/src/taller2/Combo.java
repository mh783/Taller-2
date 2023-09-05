package taller2;
import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto {
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;
	private int precio;
	public Combo(String nombreCombo,double descuento) 
	{
		this.itemsCombo = new ArrayList();
		this.descuento = descuento;
		this.nombreCombo = nombreCombo; 
	}
	public void agregarItemACombo(Producto itemCombo )
	{
		this.itemsCombo.add(itemCombo);
	}
	public int getPrecio()
	{
		return precio;
	}
	public String generarTextoFactura()
	{
		return "";
		
	}
	public void setPrecio(int pre) {
		this.precio = pre;
	}
	public String getNombre()
	{
		return nombreCombo;
	}
}
