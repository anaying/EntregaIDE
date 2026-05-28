import java.util.LinkedList;

public class Cliente extends Usuario
{
	LinkedList<Pedido> pedidos;

	void anhadirProducto(Producto producto, int cantidad)
	{
		if (!pedidos.isEmpty())
		{
			Pedido last = pedidos.getLast();
			if (last.getEstado().equals(Estado.pendiente))
			{
				if (last.getProductos().containsKey(producto))
				{
					last.getProductos().put(producto, last.getProductos().get(producto) + cantidad);
				} else
				{
					last.getProductos().put(producto, cantidad);
				}
			} else
			{
				pedidos.add(new Pedido(this));
				pedidos.getLast().getProductos().put(producto, cantidad);
			}			
		} else
		{
			pedidos.add(new Pedido(this));
			pedidos.getLast().getProductos().put(producto, cantidad);
		}
	}

	public Cliente(String nombre, String email, String tlfn)
	{
		super(nombre, email, tlfn);
		pedidos = new LinkedList<>();
	}

	public LinkedList<Pedido> getPedidos()
	{
		return pedidos;
	}
	
	
}
