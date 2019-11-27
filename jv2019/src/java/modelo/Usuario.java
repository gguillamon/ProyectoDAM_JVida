package modelo;

import java.util.Date;


public class Usuario {
	
	private String nif;
	private String nombre;
	private String apellidos;
	private String domicilio;
	private String correo;
	private Date fechaNacimiento;
	private Date fechaAlta;
	private String claveAcceso;
	private String rol;
	
	
	
	public static final String [] ROLES = {"NORMAL", "INVITADO","ADMIN"};
	
	
	
	

}
