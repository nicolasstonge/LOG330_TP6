package org.nso.LOG330_TP6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instance de la classe de calcul de regression lineaire
		CalculEffort _calculateur = new CalculEffort("src/main/java/org/nso/LOG330_TP6/donnees.csv");
		
		// On fait le calcul de correlation.
		System.out.println(_calculateur.calculCorrelation());
	}

}
