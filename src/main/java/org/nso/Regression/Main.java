package org.nso.Regression;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instance de la classe de calcul de regression lineaire
		CalculRegression _calculateur = new CalculRegression("/LOG330_TP6/src/main/java/org/nso/Regression/Numbers.csv");
		
		// Affichage de la pente de la droite
		System.out.println("La pente est: "+_calculateur.calculPente());
		
		// Affichage de la constante de la droite
		System.out.println("La constante est: "+_calculateur.calculConstante());
	}

}
