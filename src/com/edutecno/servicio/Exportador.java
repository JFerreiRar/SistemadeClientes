package com.edutecno.servicio;

import java.util.Map;

import com.edutecno.modelo.Cliente;

public abstract class Exportador {
	
	public abstract void Exportar(Map<String, Cliente> clientes, String ruta);

}
