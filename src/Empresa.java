import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Empresa
{
	List<Repartidor> repartidores;
	List<Cliente> clientes;
	List<Producto> productos;
	List<Pedido> pedidos;

	static String str = "\nRellena los siguientes datos:\n";

	public void gestionarPedidos()
	{
		pedidos.forEach(p ->
		{
			if (p.getEstado() == Estado.pendiente)
				for (Repartidor r : repartidores)
					if (p.asignarRepartidor(r))
						break;
		});
	}

	public void anhadirRepartidor(Scanner sc)
	{
		String[] datos = new String[4];

		System.out.println(str);
		System.out.print("Nombre: ");
		datos[0] = sc.nextLine();
		System.out.print("Email: ");
		datos[1] = sc.nextLine();
		System.out.print("Número de teléfono: ");
		datos[2] = sc.nextLine();
		System.out.print("Zona: ");
		datos[3] = sc.nextLine();

		repartidores.add(new Repartidor(datos[0], datos[1], datos[2], datos[3]));
	}

	public void anhadirProducto(Scanner sc)
	{
		String nombre;
		int categoria = Categoria.values().length;
		float precio = 0F;
		boolean error;

		System.out.println(str);
		System.out.print("Nombre: ");
		nombre = sc.nextLine();
		System.out.println("Selecciona una categoría:");
		for (int i = 0; i < Categoria.values().length; i++)
			System.out.println("\t" + (i + 1) + ". " + Categoria.values()[i].name().toUpperCase());
		System.out.print("Categoría: ");
		do
		{
			error = true;
			try
			{
				categoria = Integer.parseInt(sc.nextLine());
				if (categoria > 0 && categoria <= Categoria.values().length)
					error = false;
			} catch (NumberFormatException e)
			{
			} finally
			{
				if (error)
					System.out.print("Vuelve a intentarlo: ");
			}
		} while (error);
		categoria--;
		System.out.print("Precio: ");
		error = true;
		do
		{
			error = true;
			try
			{
				precio = Float.parseFloat(sc.nextLine());
				error = false;
			} catch (NumberFormatException e)
			{
			} finally
			{
				if (error)
					System.out.print("Vuelve a intentarlo: ");
			}
		} while (error);

		Producto producto = new Producto(nombre, Categoria.values()[categoria], precio);
		if (productos.contains(producto))
			System.out.println("Error al añadir el producto: ya existe un producto con el mismo nombre.");
		else
			productos.add(producto);
	}

	public Empresa()
	{
		repartidores = new LinkedList<>(
				Arrays.asList(new Repartidor("Don Pepito", "donpepito@gmail.com", "111111111", "Matogrande"),
						new Repartidor("Don José", "donjose@gmail.com", "222222222", "Ciudad Vieja")));
		clientes = new ArrayList<>(Arrays.asList(new Cliente("Fortunata", "fortunata@gmail.com", "333333333"),
				new Cliente("Jacinta", "jacinta@gmail.com", "444444444")));
		productos = new LinkedList<>(Arrays.asList(new Producto("Jamón", Categoria.comida, 1F),
				new Producto("Melón", Categoria.comida, 4F), new Producto("Café", Categoria.bebida, 1.2F),
				new Producto("Té", Categoria.bebida, 1.2F), new Producto("Cinnamon roll", Categoria.postre, 3.5F),
				new Producto("Tiramisú", Categoria.postre, 4.5F)));
		pedidos = new LinkedList<>();
	}

	public List<Producto> getProductos()
	{
		return productos;
	}
	

	
}
