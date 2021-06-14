package com.edutecno.vista;

import java.util.Scanner;

import com.edutecno.utilidades.Util;

public abstract class MenuTemplate {

	protected Scanner scanner = new Scanner(System.in);

	public abstract void importarDatos();

	public abstract void exportarDatos();

	public abstract void agregarCliente();

	public abstract void editarCliente();

	public abstract void listarCliente();

	public abstract void terminarPrograma();

	public final void iniciarMenu() {
		System.out.println("1. Listar Clientes\n" + "2. Agregar Clientes\n" + "3. Editar Clientes\n" + "4. Importar Datos\n"
				+ "5. Exportar datos\n" + "6. Salir\n");
		System.out.println("Selección");
		String Seleccion = scanner.nextLine();

		switch (Seleccion) {
		case "1":
			listarCliente();
			break;
		case "2":
			agregarCliente();
			break;
		case "3":
			editarCliente();
			break;
		case "4":
			importarDatos();
			break;

		case "5":
			exportarDatos();
			break;

		case "6":
			terminarPrograma();
			break;

		default:
			System.out.println("La opción no es válida.");
			break;
		}
		
		Util.limpiarPantalla();
		iniciarMenu();
	}

}
