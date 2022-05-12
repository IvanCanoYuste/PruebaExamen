package jcolonia.daw2021.rifa;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Colección de elementos de «mal fario».
 * 
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.0 (20220510)
 */
public enum Fetiche {
	/** El diablo tuerto. */
	DIABLO_TUERTO,
	/** El gato negro. */
	GATO_NEGRO,
	/** La mula coja. */
	MULA_COJA,
	/** La manzana pocha. */
	MANZANA_POCHA;

	/**
	 * Lista de nombres de todos los elementos en formato limpio.
	 * 
	 * @see #toString()
	 */
	static String[] listaNombres;
	
	static Random rnd;
	static {
		rnd = new Random();
	}

	/**
	 * Devuelve el nombre del objeto en un formato limpio.<div>Ejemplo:
	 * <code>NOMBRE_ORIGINAL</code> → «Nombre original»</div>
	 */
	@Override
	public String toString() {
		String nombreVisible;
		nombreVisible = name().replace('_', ' ').toLowerCase();
		nombreVisible = Vista.capitalizar(nombreVisible);
		return nombreVisible;
	}

	/**
	 * Deveuelve la lista de nombres de todos los objetos.
	 * 
	 * @return todos los textos
	 */
	public static String[] nombres() {
		if (listaNombres == null) {
			List<String> nombresFetiches = new ArrayList<String>();
			for (Fetiche objeto : Fetiche.values()) {
				nombresFetiches.add(objeto.toString());
			}
			listaNombres = nombresFetiches.toArray(new String[0]);
		}
		return listaNombres;
	}

	/**
	 * Devuelve un objeto al azar.
	 * 
	 * @return el objeto obtenido
	 */
	public static Fetiche sortear() {
		 int numeroObjetos;
		// Código pendiente de hacer
		
		Fetiche objetoElegido, listaObjetos[];
		
		listaObjetos = values();
		numeroObjetos = listaObjetos.length;
		
		objetoElegido = listaObjetos[rnd.nextInt(numeroObjetos)];
		
		return objetoElegido;
		
		
		
		//(throw new RuntimeException("Código pendiente, programador descuidado");
	}
}
