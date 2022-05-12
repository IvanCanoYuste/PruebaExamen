package jcolonia.daw2021.rifa;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Gestión de menú con opciones numeradas sobre consola de texto.
 * 
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 1.0 (20220510)
 */
public class ControlRifa {
	private List<Fetiche> listaFetiches;
//	- listaFetiches: List<String>

	private Scanner entrada;
//	- entrada: Scanner
	
	private int vecesGanado;

	VistaMenúBásico vista;
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Elegir objeto", "Salir" };

	public ControlRifa(Scanner entrada) {
		this.entrada = entrada;
		vista = new VistaMenúBásico("Rifa / Menú principal", entrada, OPCIONES_MENÚ_PRINCIPAL);
		listaFetiches = new Vector<Fetiche>();
		vecesGanado = 0;
	}
//	+ ControlNombres(entrada: Scanner)

	@Override
	public String toString() {
		String texto;
		int tamaño = (listaFetiches == null) ? 0 : listaFetiches.size();

		texto = String.format("Se han sorteado %d fetiches", tamaño);
		return texto;
	}
//	+ toString(): String

//	+ buclePrincipal(): void
	public void buclePrincipal() {
		int opciónElegida;
		boolean fin = false;

		do {
			vista.mostrarTítulo1();
			vista.mostrarOpciones();
			opciónElegida = vista.pedirOpción();

			switch (opciónElegida) {
			case 1:
				gestiónSorteo();
				break;
			case 2:
				fin = true;
				Vista.mostrarTexto("\n\n«Programa finalizado»\n\n");
				for(int i = 0;i<listaFetiches.size();i++) {
					Fetiche texto = listaFetiches.get(i);
					
					String textoString = String.format("%s",texto);
					
					Vista.mostrarTexto(textoString);
					
				}
				break;
			default:
				operaciónNoImplementada();
				break;
			}
		} while (!fin);
	}

//	+ gestiónSorteo(): void
	public void gestiónSorteo() {
		VistaMenúBásico vistaSorteo;
		Fetiche objetoElegido, objetoGanador;

		int opción;
		String mensaje;

		vistaSorteo = new VistaMenúBásico("Pedir boleto", entrada, Fetiche.nombres());

		vistaSorteo.mostrarTítulo2();
		vistaSorteo.mostrarOpciones();
		opción = vistaSorteo.pedirOpción();

		objetoElegido = Fetiche.values()[opción - 1];
		objetoGanador = Fetiche.sortear();
		
		listaFetiches.add(objetoGanador);

		mensaje = String.format("   ** ¡Ha salido «%s»!", objetoGanador);
		Vista.mostrarTexto(mensaje);

		if (objetoElegido == objetoGanador) {
			mensaje = "   ** ¡Mala suerte le llueve a tu compañero!";
			vecesGanado++;
			
		} else {
			mensaje = "   ** ¡Suerte que te libraste!";
		}
		Vista.mostrarTexto(String.format("   **Veces ganas esta vez: %d",vecesGanado));
		Vista.mostrarTexto(mensaje);

		vistaSorteo.pedirContinuar();
	}

	public void operaciónNoImplementada() {
		Vista.mostrarTexto(" --> Operación no implementada todavía…\n");
		Vista.esperar(2000); // 2 s.
	}
//	+ operaciónNoImplementada(): void

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ControlRifa control = new ControlRifa(entrada);

		control.buclePrincipal();
		entrada.close();
	}
//	+ {static} main(argumentos: String[]): void

}
