package com.edutecno.servicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.edutecno.modelo.Cliente;
import com.edutecno.modelo.CategoriaEnum;

public class ArchivoServicioImp implements ArchivoServicio {
	
	@Override
	public Map<String, Cliente> importarDatos() {
	
		Map<String, Cliente> clientes = new HashMap<String, Cliente>();
		CategoriaEnum nombreCategoria;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("DBClientes.csv"));
			
			String linea;
			while((linea = reader.readLine()) != null) {
				String[] datosCliente = linea.split(",");
				String rut = datosCliente[0];
				if (clientes.containsKey(rut)) {
										
				} else {				
					String c = datosCliente[4].toUpperCase();
					if (c.equals("ACTIVO")) {
						nombreCategoria = CategoriaEnum.ACTIVO;
					} else {
						nombreCategoria = CategoriaEnum.INACTIVO;
					}
					Cliente cliente = new Cliente(rut, datosCliente[1], datosCliente[2], datosCliente[3], nombreCategoria);
					clientes.put(rut, cliente);
					
				}
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}

}
