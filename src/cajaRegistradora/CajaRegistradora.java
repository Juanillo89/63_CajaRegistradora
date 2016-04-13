package cajaRegistradora;

public class CajaRegistradora implements ICajaRegistradora 
{
	
	private String nombre;
	private static double[] tiposMonedaValidos;
	private int[] monedas;
	
	public CajaRegistradora(String nombre)
	{
		this.nombre = nombre;
		tiposMonedaValidos = new double[] 
				{0.01,
				 0.02,
				 0.05,
				 0.1,
				 0.2,
				 0.5,
				 1,
				 2,
				 5,
				 10,
				 20,
				 50,
				 100,
				 200,
				 500};
		monedas = new int[tiposMonedaValidos.length];
	}
	
	@Override
	public String getNombre() 
	{
		return nombre;
	}

	@Override
	public int getNumTipoMonedas() 
	{
		int numTipoMonedas = 0;
		for (int i = 0; i < monedas.length; i++) 
		{
			if(monedas[i] != 0)
			{
				numTipoMonedas += 1;
			}
		}
		return numTipoMonedas;
	}

	@Override
	public int getUnidadesTipoMoneda(double tipo) 
	{
		if(!monedaValida(tipo))
			return -1;
		else
		{
			return monedas[getPosicionTipo(tipo)];
		}
	}

	@Override
	public boolean meterMonedas(double tipo, int unidades) 
	{
		if(!monedaValida(tipo))
			return false;
		else
		{
			monedas[getPosicionTipo(tipo)] += unidades;
			return true;
		}
	}

	@Override
	public boolean monedaValida(double tipo) 
	{
		for (int i = 0; i < tiposMonedaValidos.length; i++) 
		{
			if(tiposMonedaValidos[i] == tipo)
				return true;
		}
		return false;
	}

	@Override
	public boolean sacarMonedas(double tipo, int unidades) 
	{
		if(!monedaValida(tipo))
			return false;
		else
		{
			if(monedas[getPosicionTipo(tipo)] >= unidades)
			{
				monedas[getPosicionTipo(tipo)] -= unidades;
				return true;
			}
			else
				return false;
		}
	}

	@Override
	public void vaciarCajaRegistradora() 
	{
		for (int i = 0; i < monedas.length; i++) 
		{
			monedas[i] = 0;
		}
	}

	@Override
	public double[] getTiposDeMoneda() 
	{
		int j = 0;
		double[] tiposEnCaja = new double[getNumTipoMonedas()];
		for (int i = 0; i < monedas.length; i++) 
		{
			if(monedas[i] != 0)
			{
				tiposEnCaja[j] = tiposMonedaValidos[i];
				j++;
			}
		}
		return tiposEnCaja;
	}

	@Override
	public double getSaldo() 
	{
		double saldo = 0;
		for (int i = 0; i < monedas.length; i++) 
		{
			saldo += monedas[i] * tiposMonedaValidos[i]; 
		}
		return saldo;
	}
	
	/**
	 * Encuentra la posición en el array de el tipo de moneda indicado.
	 * @param tipo
	 * @return La posición del array. 
	 * -1 si el tipo no es válido.
	 */
	private int getPosicionTipo(double tipo)
	{
		for (int i = 0; i < tiposMonedaValidos.length; i++) 
		{
			if(tiposMonedaValidos[i] == tipo)
				return i;
		}
		return -1;
	}

}
