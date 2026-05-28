
public class Repartidor extends Usuario
{
	private String zona;
	private boolean disponible = false;
	
	public boolean isDisponible()
	{
		return disponible;
	}
	public void setDisponible(boolean disponible)
	{
		this.disponible = disponible;
	}
	public Repartidor(String nombre, String email, String tlfn, String zona)
	{
		super(nombre, email, tlfn);
		this.zona = zona;
	}		
}
