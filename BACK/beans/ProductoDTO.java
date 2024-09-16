package beans;

public class ProductoDTO {
	private int codigo;
	private String nombre, apellido, apodo, nacionalidad, club;
	private int edad;
	private double sueldo;
	private int codPosicion;
	private String nomPosicion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getCodPosicion() {
		return codPosicion;
	}

	public void setCodPosicion(int codPosicion) {
		this.codPosicion = codPosicion;
	}

	public String getNomPosicion() {
		return nomPosicion;
	}

	public void setNomPosicion(String nomPosicion) {
		this.nomPosicion = nomPosicion;
	}

}
