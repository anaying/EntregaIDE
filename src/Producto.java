import java.util.Objects;

public class Producto
{
	private String nombre;
	private Categoria categoria;
	private float precio;

	public String getNombre()
	{
		return nombre;
	}

	public Categoria getCategoria()
	{
		return categoria;
	}

	public float getPrecio()
	{
		return precio;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public Producto(String nombre, Categoria categoria, float precio)
	{
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}

}
