package com.edutecno.servicio;

import java.util.Map;

import com.edutecno.modelo.Cliente;

public interface ArchivoServicio {
	
	Map<String, Cliente> importarDatos();
	
}