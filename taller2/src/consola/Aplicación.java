package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import taller2.Pedido;
import taller2.ProductoMenu;
import taller2.Restaurante;


public class Aplicación {
	private Restaurante restaurante= new Restaurante();

	
	
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el Menú");
		System.out.println("2. iniciar el pedido");
		System.out.println("3. Para cerrar y guardar el pedido");
		System.out.println("5. Para salir de la aplicación");
	}
	public void ejecutarOpcion(int opcion_seleccionada) throws IOException
	{
		boolean continuar = true;
		while (continuar)
		{
			
			try
			{
				mostrarMenu();
				opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1 && restaurante!=null)
				{
					carga();
					menu();
					System.out.println("Se ha cargado la información del restaurante");
				}
				else if (opcion_seleccionada == 2 && restaurante!=null)
				{
					iniciarPedido();
				}
				else if (opcion_seleccionada == 3 && restaurante!=null)
				{
					cerrarPedidoGuardarfactura();
				}
					
				else if (opcion_seleccionada == 5)
					
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	private void menu()
	{
		System.out.println("\n" + "El menú del retaurante es el siguiente" + "\n");
		System.out.println("Menú:"+"\n");
		System.out.println("corral:14000\r\n"
				+ "1.corral queso:16000\r\n"
				+ "2.corral pollo:15000\r\n"
				+ "3.corralita:13000\r\n"
				+ "4.todoterreno:25000\r\n"
				+ "5.1/2 libra:25000\r\n"
				+ "6.especial:24000\r\n"
				+ "7.casera:23000\r\n"
				+ "8.mexicana:22000\r\n"
				+ "9.criolla:22000\r\n"
				+ "10.costeña:20000\r\n"
				+ "11.hawaiana:20000\r\n"
				+ "12.wrap de pollo:15000\r\n"
				+ "13.wrap de lomo:22000\r\n"
				+ "14.ensalada mexicana:20900\r\n"
				+ "15.papas medianas:5500\r\n"
				+ "16.papas grandes:6900\r\n"
				+ "17.papas en casco medianas:5500\r\n"
				+ "18.papas en casco grandes:6900\r\n"
				+ "19.agua cristal sin gas:5000\r\n"
				+ "20.agua cristal con gas:5000\r\n"
				+ "21.gaseosa:5000\r\n"
				+ ""+"\n Combos:\n"+"combo corral\r\n"
						+ "combo corral queso\r\n"
						+ "combo todoterreno\r\n"
						+ "combo especial\n"+"\n"
						+ "ingredientes:\n"+"lechuga:1000\r\n"
								+ "tomate:1000\r\n"
								+ "cebolla:1000\r\n"
								+ "queso mozzarella:2500\r\n"
								+ "huevo:2500\r\n"
								+ "queso americano:2500\r\n"
								+ "tocineta express:2500\r\n"
								+ "papa callejera:2000\r\n"
								+ "pepinillos:2500\r\n"
								+ "cebolla grille:2500\r\n"
								+ "suero costeño:3000\r\n"
								+ "frijol refrito:4500\r\n"
								+ "queso fundido:4500\r\n"
								+ "tocineta picada:6000\r\n"
								+ "piña:2500");
		
		
	}
	public void carga() throws IOException
	{
		restaurante.cargarInformacionRestaurante("./data/ingredientes.txt", "./data/menu.txt", "./data/combos.txt");
	}
	public void iniciarPedido()
	{
		String nombre = input("Por favor ingrese su nombre");
		String direccion = input("ingrese su direccion");
		restaurante.iniciarPedidos(nombre, direccion);
	}
	public void cerrarPedidoGuardarfactura()
	{
		restaurante.cerrarYGuardarpedido();
		
	}
	public void agregarItem()
	{
		
	}

	private String input(String string) 
	{
		try
		{
			System.out.print(string + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}



	
	public static void main(String[] args) throws IOException
	{
		Aplicación api = new Aplicación();
		
		api.ejecutarOpcion(1);

	}

}
