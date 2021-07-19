import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nivell1Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		int bitllet5 = 5;
		int bitllet10 = 10;
		int bitllet20 = 20;
		int bitllet50 = 50;
		int bitllet100 = 100;
		int bitllet200 = 200;
		int bitllet500 = 500;

		int preuTotal = 0;
		
		String plats[] = new String[10];
		int preus[] = new int[10];
		
		
		HashMap<String, Integer> preuPlat = new HashMap<String, Integer>();
		
		preuPlat.put("Bufalina",12);	
		preuPlat.put("4 Formaggi",12);
		preuPlat.put("Pino Daniele",18);
		preuPlat.put("Margherita",9);
		preuPlat.put("Prosciutto",10);
		preuPlat.put("Parmiggiana",11);
		preuPlat.put("Al Tonno",13);
		preuPlat.put("Carbonara",11);
		preuPlat.put("Massimo Troise",17);
		preuPlat.put("Ortolana",12);
		
		int cont=0; //contador del for
		for (Map.Entry<String,Integer> entry : preuPlat.entrySet()) {   //omplim l'array plats des del hashMap
			plats[cont]= entry.getKey();
			preus[cont]= entry.getValue();
			cont++;
		}
		
		ArrayList<Integer> comanda = new ArrayList<Integer>(); //creem l'arrayList per fer les comandes
		
		int ok=1;
		int plat=0;
				
		
		System.out.println("Benvingut al Restaurant IT-Academy");
		do {
			System.out.println("---------MENU---------");
			for (int i=0; i<plats.length; i++) {
				System.out.println(i + " - "+plats[i]+" - "+preus[i]);
			}
			System.out.println("----------------------");
									
			System.out.print("Quin plat voldràs per dinar: ");
			plat = entrada.nextInt(); 				
			comanda.add(plat);
			System.out.println("Plats triats:"+comanda.size());
			
			do {
				System.out.println("Vols continuar comprant? 1:SI / 0:NO");
				ok = entrada.nextInt(); 
				if (ok!=1 && ok!=0) {
					System.out.println("Has de triar 1:SI / 0:NO");
					
				}
			}while (ok!=1 && ok!=0);
				
		}while(ok==1);
				
		System.out.println("Has finalitzat la comanda, has triat els plats : " + comanda);
		entrada.close();
	}

}
