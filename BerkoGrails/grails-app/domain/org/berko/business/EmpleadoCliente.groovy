package org.berko.business

class EmpleadoCliente {
	int id
	String nombre
	String apellido
	String primerTelefono
	String segundoTelefono
	
	static constraints = {
		primerTelefono(maxSize:20)
		segundoTelefono(maxSize:20)
	}
}
