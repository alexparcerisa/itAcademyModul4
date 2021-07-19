
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Nivell3 {

	static String plats[] = new String[10];
	static int preus[] = new int[10];
	static int plat = 0;
	static Scanner entrada = new Scanner(System.in);
	static int ok = 1;
	static ArrayList<Integer> comanda = new ArrayList<Integer>();

	public static void main(String[] args) {
		
				
		HashMap<String, Integer> preuPlat = new HashMap<String, Integer>();

		preuPlat.put("Bufalina", 12);
		preuPlat.put("4 Formaggi", 12);
		preuPlat.put("Pino Daniele", 18);
		preuPlat.put("Margherita", 9);
		preuPlat.put("Prosciutto", 10);
		preuPlat.put("Parmiggiana", 11);
		preuPlat.put("Al Tonno", 13);
		preuPlat.put("Carbonara", 11);
		preuPlat.put("Massimo Troise", 17);
		preuPlat.put("Ortolana", 12);

		int cont = 0;
		for (Map.Entry<String, Integer> entry : preuPlat.entrySet()) {
			plats[cont] = entry.getKey();
			preus[cont] = entry.getValue();
			cont++;
		}

		System.out.println("Benvingut al Restaurant IT-Academy");
		System.out.println("---------MENU---------");
		for (int i = 0; i < plats.length; i++) {
			System.out.println(i + " - " + plats[i] + " - " + preus[i]);
		}
		
		demanarPlats();

		System.out.println("Has finalitzat la comanda, has triat els plats : " + comanda);

		System.out.println("--------------------------");
		int preu_total = 0;
		int num_platos = 0;
		for (Integer t : comanda) {
			if (t >= 0 && t < plats.length) {
				num_platos++;
				preu_total += preus[t];
				System.out.println("Plato:[" + num_platos + "] " + t + " : " + preus[t] + "€");
			} else {
				System.out.println("ERROR: " + t + " aquest plat no existeix!");
			}
		}

		System.out.println("--------------------------");
		System.out.println("Has triat " + num_platos + " plats");
		System.out.println("Preu TOTAL: " + preu_total + "€");

	}


	static void demanarPlats()  {

		do {
			
			System.out.println("----------------------");
			
			plat = getValor(entrada, "Quin plat voldràs per dinar: ");
			try {
				if (plat<0 || plat>=plats.length) {
				
				throw new PlatInexistentException("Error, has de triar un plat entre 1 i 9");
			
				}else {
							
					comanda.add(plat);
					System.out.println("Plats triats:" + comanda.size());
				}
			
			}catch (PlatInexistentException e) {
				System.out.println(e.getMessage());
			}
			
			do {
			
				ok = getValor(entrada, "Vols continuar comprant? 1:SI / 0:NO");				
				
				try {	
				
					siOno();
				
				}catch (SiNoException e) {
					System.out.println("Error, has de triar 1:SI / 0:NO");
				}
			
			} while (ok != 1 && ok != 0);
		
		} while (ok == 1);

	}

	static int getValor(Scanner entrada, String pregunta) {
		
		int valor = -1;
		boolean continuar = true;
		while (continuar) {
			try {
				System.out.println(pregunta);
				valor = entrada.nextInt();
				continuar = false;
			} catch (InputMismatchException e) {
				System.out.println("ERROR, Has d'introduir un valor numèric");
				entrada.nextLine();
			}
		}

		return valor;
	}

	static void siOno() throws SiNoException {
		
		if (ok != 1 && ok != 0) {
						
			throw new SiNoException(); 
		}	
	}
}
