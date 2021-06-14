package com.edutecno.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.edutecno.modelo.Cliente;
import com.edutecno.servicio.ClienteServicioImp;

public class agregarClienteTest {
 private ClienteServicioImp servicio;
 private Cliente cliente;
 
 @BeforeEach
 void setup() {
	 servicio = new ClienteServicioImp();
	 cliente = new Cliente("1","julio","ferreira","2 años", null);	 
 }
 
 @Test
 public void crearCliente() {
	 //Given
	 
	 //When
	 servicio.agregarCliente(cliente);
	 //Then
	 Assertions.assertNotNull(servicio.listarClientes().get(cliente.getRunCliente()));	 
 }

 @Test
 public void crearCliente_null() {
	 //Given
	 Cliente cliente = null;
	 //When
	 servicio.agregarCliente(cliente);
	 //Then
	 Assertions.assertEquals(servicio.listarClientes().size(),0);	 
 }
 
}
