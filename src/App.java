import java.util.Scanner;

public class App
{
	static Empresa empresa = new Empresa();

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		menu(sc);
		sc.close();
	}

	private static void menu(Scanner sc)
	{
		char op;
		do
		{
			System.out.print("¿Eres empresa o cliente (e/c)? ");
			op = sc.nextLine().charAt(0);

		} while (op != 'e' && op != 'c');

		if (op == 'c')
			cliente(sc);
		else
			empresa(sc);
	}

	private static void empresa(Scanner sc)
	{
		String[] opciones =
		{ "Añadir producto", "Añadir repartidor", "Gestionar pedidos" };
		int op = 0;
		do
		{
			op = seleccionar(opciones, sc);
			switch (op)
			{
			case 1:
				empresa.anhadirProducto(sc);
				break;
			case 2:
				empresa.anhadirRepartidor(sc);
				break;
			case 3:
				empresa.gestionarPedidos();
				break;
			default:
				System.out.println("Saliendo...");
			}
		} while (op != 0);
	}

	private static void cliente(Scanner sc)
	{
		Cliente cliente = new Cliente("Cliente", "@mail.com", "1234");
		String[] opciones =
		{ "Añadir producto", "Realizar pedido" };
		int op;
		do
		{
			op = seleccionar(opciones, sc);
			switch (op)
			{
			case 1:
				int p = 1;
				for (int i = 0; i < empresa.getProductos().size(); i++)
				{
					Producto producto = empresa.getProductos().get(i);
					System.out.println((i + 1) + ". " + producto.getNombre() + " - "
							+ String.format("%.2f", producto.getPrecio()) + "€");

				}
				System.out.print("\n\nSelecciona un producto: ");
				try
				{
					p = Integer.parseInt(sc.nextLine());
					cliente.anhadirProducto(empresa.getProductos().get(p - 1), 1);
				}
				catch (Exception e)
				{
					System.out.println("Se ha producido un error.");
				}
				break;
			case 2:
				if (!cliente.getPedidos().isEmpty())
				{
					Pedido pedido = cliente.getPedidos().getLast();
					if (pedido.getEstado() == Estado.pendiente)
						System.out.println("Total a pagar: " + String.format("%.2f", pedido.calcularTotal()) + "€");
					else
						System.out.println("El pedido ya ha sido realizado.");
				}
				else
					System.out.println("No hay artículos añadidos.");
				break;
			default:
				System.out.println("Saliendo...");
			}

		} while (op != 0);
	}

	private static int seleccionar(String[] opciones, Scanner sc)
	{
		boolean error = true;
		int op = 0;
		
		System.out.println("\n\n");
		for (int i = 0; i < opciones.length; i++)
		{
			System.out.println((i + 1) + ". " + opciones[i]);
		}
		System.out.print("0. Salir\n\nSelecciona una opción: ");

		do
		{
			try
			{
				op = Integer.parseInt(sc.nextLine());
				if (op >= 0 && op <= opciones.length)
					error = false;
			} catch (NumberFormatException e)
			{
			} finally
			{
				if (error)
					System.out.print("Vuelve a intentarlo: ");
			}
		} while (error);

		return op;
	}
}
