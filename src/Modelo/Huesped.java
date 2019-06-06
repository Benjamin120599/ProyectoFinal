package Modelo;

public class Huesped {

	private String idHuesped;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String fechaNac;
	private String telefono;
	
	public Huesped() {
	}

	public Huesped(String idHuesped, String nombre, String apellidoP, String apellidoM, String fechaNac, String telefono) {
		this.idHuesped = idHuesped;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.fechaNac = fechaNac;
		this.telefono = telefono;
	}

	
	// Getters and Setters
	public String getIdHuesped() {
		return idHuesped;
	}
	public void setIdHuesped(String idHuesped) {
		this.idHuesped = idHuesped;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	@Override
	public String toString() {
		return "Huesped [idHuesped=" + idHuesped + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM="
				+ apellidoM + ", fechaNac=" + fechaNac + ", telefono=" + telefono + "]";
	}
	
}
