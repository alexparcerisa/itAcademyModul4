import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Nivell1Fase3 {
	
	static String plats[] = new String[10];
	static int preus[] = new int[10];
	static int plat=0;
	static Scanner entrada = new Scanner(System.in);
	static int ok=1;
	static ArrayList<Integer> comanda = new ArrayList<Integer>();
	static int preu_total=0;
	static int num_plats=0;
	
	static int qBitllet1 = 0;
	static int qBitllet2 = 0;
	static int qBitllet5 = 0;
	static int qBitllet10 = 0;
	static int qBitllet20 = 0;
	static int qBitllet50 = 0;
	static int qBitllet100 = 0;
	static int qBitllet200 = 0;
	static int qBitllet500 = 0;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
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
		
		int cont=0;
		for (Map.Entry<String,Integer> entry : preuPlat.entrySet()) {
			plats[cont]= entry.getKey();
			preus[cont]= entry.getValue();
			cont++;
		}
		
		
		System.out.println("Benvingut al Restaurant IT-Academy");
		System.out.println("---------MENU---------");
		for (int i=0; i<plats.length; i++) {
			System.out.println(i + " - " + plats[i]+" - " + preus[i]);
		}
		
					
		demanarPlats();
				
						
		System.out.println("Has finalitzat la comanda, has triat els plats : " + comanda);
		
	
	System.out.println("--------------------------");
	
	for (Integer t : comanda) { 
		if (t>=0 && t<plats.length)  {		
			num_plats++;
			preu_total+=preus[t];
			System.out.println("Plat:["+num_plats+"] "+t+" : "+preus[t]+"€");
		}else {
			System.out.println("ERROR: "+t+" aquest plat no existeix!");
		}
	}
	
	System.out.println("--------------------------");
	System.out.println("Has triat " + num_plats + " plats");
	System.out.println("Preu TOTAL: " + preu_total + "€");
		
	
	desglossamentBitllets();
		
	}
	
	static void desglossamentBitllets() {
			
		while(preu_total>0) {
			if (preu_total/500 >= 1){
				qBitllet500++;
				preu_total = preu_total - 500;
			}else if (preu_total/200 >=1) {
				qBitllet200++;
				preu_total -=200;
			}else if (preu_total/100 >=1) {
				qBitllet100++;
				preu_total -= 100;
			}else if (preu_total/50 >=1) {
				qBitllet50++;
				preu_total -=50;
			}else if (preu_total/20 >=1) {
				qBitllet20++;
				preu_total -=20;
			}else if (preu_total/10 >=1) {
				qBitllet10++;
				preu_total -=10;
			}else if (preu_total/5 >= 1) {
				qBitllet5++;
				preu_total -= 5;
			}else if (preu_total/2 >= 1) {
				qBitllet2++;
				preu_total -= 2;
			}else if (preu_total/1 >= 1) {
				qBitllet1++;
				preu_total -= 1;
			}
		
		}
		
		System.out.println("Per pagar faran falta : " + qBitllet500 + " Bitllets de 500; " + qBitllet200 + " Bitllets de 200; " 
							+ qBitllet100 + " Bitllets de 100; " + qBitllet50 + " Bitllets de 50; "
							+ qBitllet20 + " Bitllets de 20; " + qBitllet10 + " Bitllets de 10; "
							+ qBitllet5 + " Bitllets de 5; " + qBitllet2 + " Monedes de 2; " + qBitllet1 + " Monedes de 1.");
			
	}
	
	
	static void demanarPlats()throws InputMismatchException{
			
	try {	
		do {	
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
			} while (ok!=1 && ok!=0);
			
		} while(ok==1);
	} catch(InputMismatchException e) {
			
			System.out.println("ERROR, Has d'introduir un valor numèric");
			ok=0;
		}	
	}

}
