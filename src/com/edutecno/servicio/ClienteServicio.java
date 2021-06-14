package com.edutecno.servicio;

import java.util.Map;

import com.edutecno.modelo.Cliente;

public interface ClienteServicio {	 
	
	void agregarCliente(Cliente cliente);
	void editarCliente(Cliente cliente);
	Map<String, Cliente> listarClientes();
	void setListaClientes(Map<String, Cliente> listaClientes);

}
