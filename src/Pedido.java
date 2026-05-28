import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Pedido
{
	private long id;
	private LocalDate fecha;
	private Estado estado;
	private Cliente cliente;
	private Repartidor repartidor;
	private HashMap<Producto, Integer> productos;

	float calcularTotal()
	{
		float total = 0;
		for (Producto p : productos.keySet())
			total += p.getPrecio() * (float) productos.get(p);
		return total;
	}

	boolean asignarRepartidor(Repartidor repartidor)
	{
		if (repartidor.isDisponible())
			return false;
		this.repartidor = repartidor;
		estado = Estado.enReparto;
		repartidor.setDisponible(false);
		return true;
	}

	public void entregar()
	{
		estado = Estado.entregado;
		repartidor.setDisponible(true);
	}

	public Estado getEstado()
	{
		return estado;
	}

	public HashMap<Producto, Integer> getProductos()
	{
		return productos;
	}

	public Pedido(Cliente cliente)
	{
		id = this.hashCode();
		this.cliente = cliente;
		fecha = LocalDate.now();
		productos = new HashMap<Producto, Integer>();
		estado = Estado.pendiente;
	}
}
