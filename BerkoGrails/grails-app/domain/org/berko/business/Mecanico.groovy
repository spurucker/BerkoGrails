package org.berko.business

class Mecanico {
	int id
	String nombre
	String apellido
	String DNI
	
	static constraints = {
		DNI(maxSize:8)
	}
	
}
