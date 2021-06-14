package com.edutecno.servicio;

import java.util.HashMap;
import java.util.Map;

import com.edutecno.modelo.Cliente;

public class ClienteServicioImp implements ClienteServicio {

	private Map<String, Cliente> listaClientes = new HashMap<>();
	
	@Override
	public void agregarCliente(Cliente cliente) {

		if(cliente != null) {
			listaClientes.put(cliente.getRunCliente(), cliente);
		}
	}

	@Override
	public void editarCliente(Cliente cliente) {

		if(cliente != null) {
			listaClientes.put(cliente.getRunCliente(), cliente);
		}
	}

	@Override
	public Map<String, Cliente> listarClientes() {
		
		return listaClientes;
	}

	public void setListaClientes(Map<String, Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
