package org.berko.business

class Cliente {
	int id
	String nombre
	String CUIL
	String observaciones
	def sucursales = []
	def empleados =[]
	def vehiculos = []
	def peticiones = []
	
	static constraints = {
		CUIL(maxSize:11)
	}
}
