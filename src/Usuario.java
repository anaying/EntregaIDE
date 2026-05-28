
public class Usuario
{
	String nombre, email, tlfn;

	String getNombre()
	{
		return nombre;
	}

	String getEmail()
	{
		return email;
	}

	String getTlfn()
	{
		return tlfn;
	}

	public Usuario(String nombre, String email, String tlfn)
	{
		this.nombre = nombre;
		this.email = email;
		this.tlfn = tlfn;
	}

}
