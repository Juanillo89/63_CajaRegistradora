package cajaRegistradora;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		CajaRegistradora caja = new CajaRegistradora("Caja 1");
		String opcion = "";
		double tipo = 0;
		int unidades;
		do
		{
			mostrarMenu();
			opcion = sc.nextLine();
			switch(opcion)
			{
			case "1":
				System.out.print("Tipo de moneda: ");
				tipo = Double.parseDouble(sc.nextLine());
				System.out.print("Unidades: ");
				unidades = Integer.parseInt(sc.nextLine());
				if(!caja.meterMonedas(tipo, unidades))
				{
					System.out.println("Parámetros incorrectos.");
				}
			break;
			case "2":
				System.out.println("Contenido " + caja.getNombre() + ":\n\n"
						+ "Tipo\t" + "Unidades\t" + "Total\n"
						+ "-----------------------------");
				for (int i = 0; i < caja.getTiposDeMoneda().length; i++) 
				{
					
					System.out.println(caja.getTiposDeMoneda()[i] + "\t" + caja.getUnidadesTipoMoneda(caja.getTiposDeMoneda()[i]) 
						+ "\t\t" + caja.getTiposDeMoneda()[i] * caja.getUnidadesTipoMoneda(caja.getTiposDeMoneda()[i]));
				}
				System.out.println();
			break;
			case "3":
				System.out.println("Saldo total: " + caja.getSaldo() + " €");
			break;
			case "4":
				System.out.print("Tipo de moneda: ");
				tipo = Double.parseDouble(sc.nextLine());
				System.out.print("Unidades: ");
				unidades = Integer.parseInt(sc.nextLine());
				if(!caja.sacarMonedas(tipo, unidades))
				{
					System.out.println("Parámetros incorrectos.");
				}
			break;
			case "5":
				caja.vaciarCajaRegistradora();
			break;
			case "6":
				System.out.println("Hasta luego.");
			break;
			default:
				System.out.println("Opción incorrecta.");
			break;
			}
		}
		while(!opcion.equals("6"));
		sc.close();
	}
	
	private static void mostrarMenu()
	{
		System.out.println("Menú:\n"
				+ "1.- Ingresar monedas.\n"
				+ "2.- Listar contenido.\n"
				+ "3.- Mostrar saldo.\n"
				+ "4.- Extraer monedas.\n"
				+ "5.- Vaciar la caja.\n"
				+ "6.- Salir.");
		System.out.println();
	}

}
