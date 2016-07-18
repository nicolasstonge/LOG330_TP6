package org.nso.LOG330_TP6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instance de la classe de calcul de regression lineaire
		CalculEffort _calculateur = new CalculEffort("src/main/java/org/nso/LOG330_TP6/donnees.csv");
		
		double correl = _calculateur.calculCorrelation();
		
		// On fait le calcul de correlation.
		System.out.println("Le coefficient de correlation est de: "+correl+"\n");
		
		if (correl < 0.70){
			
			System.out.println("La correlation est considere comme faible");
		}else{
			System.out.println("La correlation est considere comme haute");
		}
		
	}

}
