package com.edutecno.servicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.edutecno.modelo.Cliente;

public class ExportarTxt extends Exportador{

	@Override
	public void Exportar(Map<String, Cliente> clientes, String ruta) {
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "clientes.txt"));
			clientes.entrySet().forEach(entry -> {
				try {
					Cliente cliente = entry.getValue();
					writer.write(cliente.getRunCliente() + "," + cliente.getNombreCliente()+ "," + cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + "," + cliente.getNombreCategoria());
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			writer.close();
			
			System.out.println("-----------------------------------------------\r\n"
					+ "Datos de clientes exportados correctamente en formato txt.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
