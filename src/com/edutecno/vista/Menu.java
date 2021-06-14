package com.edutecno.vista;

import java.util.Map;

import com.edutecno.modelo.CategoriaEnum;
import com.edutecno.modelo.Cliente;
import com.edutecno.servicio.ClienteServicio;
import com.edutecno.servicio.ClienteServicioImp;
import com.edutecno.servicio.ExportarCsv;
import com.edutecno.servicio.ExportarTxt;
import com.edutecno.servicio.ArchivoServicio;
import com.edutecno.servicio.ArchivoServicioImp;

public class Menu extends MenuTemplate{

    private ClienteServicio clienteServicio = new ClienteServicioImp();
    private ArchivoServicio archivoServicio = new ArchivoServicioImp();
        
	@Override
	public void listarCliente() {
		
		clienteServicio.listarClientes().entrySet().forEach(entry -> {
		Cliente cliente = entry.getValue();
		System.out.println("--------------------Datos del Cliente--------------------");
		System.out.println("");
		System.out.println("RUN del cliente: " + cliente.getRunCliente());
		System.out.println("Nombre del cliente: " + cliente.getNombreCliente());
		System.out.println("Apellido del cliente: " + cliente.getApellidoCliente());
		System.out.println("Años como cliente: " + cliente.getAniosCliente());
		System.out.println("Categoría del cliente: " + cliente.getNombreCategoria());
		System.out.println("");
		System.out.println("---------------------------------------------------------");
		
		});
		
	}

	@Override
	public void agregarCliente() {
		System.out.println("Ingrese RUN del cliente");
		String rut = scanner.nextLine();
		
		System.out.println("Ingrese Nombre del cliente");
		String nombre = scanner.nextLine();
		
		System.out.println("Ingrese Apellido del cliente");
		String apellido = scanner.nextLine();
		
		System.out.println("Ingrese años del cliente");
		String anios = scanner.nextLine();
		
		Cliente cliente = new Cliente(rut, nombre, apellido, anios, CategoriaEnum.ACTIVO);
		clienteServicio.agregarCliente(cliente);
		
	}

	@Override
	public void editarCliente() {
		System.out.println("Siga participando! jajaja ");		
	}
	@Override
	public void importarDatos() {

		Map<String, Cliente> clientes = archivoServicio.importarDatos();
		clienteServicio.setListaClientes(clientes);
		
		System.out.println("Datos cargados correctamente");
		
	}

	@Override
	public void exportarDatos() {

		System.out.println("---------Exportar Datos-----------\r\n"
				+ "Seleccione el formato a exportar:\r\n"
				+ "1.-Formato csv\r\n"
				+ "2.-Formato txt\r\n"
				+ "\r\n"
				+ "Ingrese una opción para exportar:\r\n"
				+ "----------------------------------"
				);
		String opc = scanner.nextLine();
			
		if (opc.equals("1")) {
			System.out.println("---------Exportar Datos en Linux o Mac-----------\r\n\"	"
					+ "Ingresa la ruta en donde desea exportar el archivo clientes.csv");

			String ruta = scanner.nextLine();
			
			ExportarCsv exportaCsv = new ExportarCsv();
			exportaCsv.Exportar(clienteServicio.listarClientes(), ruta);
			System.out.println("Los datos han sido exportados");

			
		} else {
			System.out.println("---------Exportar Datos en Windows-----------\r\n\"	"
					+ "Ingresa la ruta en donde desea exportar el archivo clientes.txt");
			String ruta = scanner.nextLine();
			
			ExportarTxt exportaTxt = new ExportarTxt();
			exportaTxt.Exportar(clienteServicio.listarClientes(), ruta);

		}	
		
	}

	@Override
	public void terminarPrograma() {
		System.out.println("Gracias por utilizar el sistema");
		System.exit(0);
	}

}
