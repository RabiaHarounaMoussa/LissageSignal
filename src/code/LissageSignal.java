package code;

import java.util.Scanner;

public class LissageSignal {

	public static void main(String[] args) {
		int nbMesures, nbLissages=0;
		double diffMax, j;
		
		//Cr�er une nouvelle instance de Scanner pour lire les entr�es clavier
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez entrer le nombre de mesures � effectuer entre 1 et 100 compris: "); 
		//R�cup�rer la valeur saisie du nombre de mesures
		nbMesures = sc.nextInt();
		
		//S'assurer que le nombre de mesures est entre 1 et 100 compris
		while (nbMesures < 1 || nbMesures > 100) {
			
			System.out.println("Le nombre de mesures � effectuer doit �tre entre 1 et 100 compris: "); 
			nbMesures = sc.nextInt();
			
		}
		
		System.out.println("Veuillez entrer la valeur de la diff�rence maximale entre 0 et 100 compris: ");
		//R�cup�rer la valeur saisie de la diff�rence maximale
		diffMax = sc.nextDouble();
		
		//S'assurer que la diff�rence maximale est entre 0 et 100 compris
		while (diffMax < 0 || diffMax > 100) {
			
			System.out.println("La diff�rence maximale doit �tre entre 0 et 100 compris: "); 
			diffMax = sc.nextDouble();
			
		}
		
		//D�clarer le tableau qui contiendra les valeurs des mesures
		double[] tab = new double[nbMesures];
		
		//R�cup�rer les valeurs des mesures
		for(int i=1; i<=nbMesures; i++){
			
			System.out.println("Veuillez entrer la valeur de la mesure "+i+": "); 
			tab[i-1] = sc.nextDouble();
			
			while (tab[i-1] < -100 || tab[i-1] > 100) {
				
				System.out.println("La valeur de la mesure doit �tre entre -100 et 100 compris: "); 
				tab[i-1] = sc.nextDouble();
				
			}
		}
		
		//D�clarer le tableau qui contiendra les valeurs des mesures durant le lissage 
		double[] tab2 = new double[nbMesures];
		
		//S'assurer que le signal est irr�gulier
		 while (diff(tab, nbMesures) > diffMax) {
			 
			 //Proc�der au lissage
			 
			 tab2[0] = tab[0];
			 tab2[nbMesures-1] = tab[nbMesures-1];
			 for(int i = 1; i < nbMesures-1 ; ++i) {
				 tab2[i] = (tab[i-1]+tab[i+1]) / 2.;
			 }
        
        nbLissages++;
		 }
		 
		 System.out.println("Le nombre minimal de lissages n�cessaire est: "+nbLissages); 
     
   
		
		
		
		

	}
	
	public static double diff(double[] t, int taille){
	
		double maxDiff = 0.;
	    for(int i = 0; i < taille ; i++) {
	 
	        maxDiff = Math.max(maxDiff, Math.abs(t[i]-t[i+1]));
	    }
	    return maxDiff;
		
	}

}
