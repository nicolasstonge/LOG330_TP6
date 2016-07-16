package org.nso.LOG330_TP6;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instance de la classe de calcul de regression lineaire
		CalculInterval _calculateur = new CalculInterval("src/main/java/org/nso/LOG330_TP6/donnees.csv");
		
		// calcul de l'intervalle de confiance a 70%
		_calculateur.calculIntervalle((float) 1.250, "70");
		
		// calcul de l'intervalle de confiance a 80%
		_calculateur.calculIntervalle((float) 1.638, "80");
		
		// calcul de l'intervalle de confiance a 90%
		_calculateur.calculIntervalle((float) 2.353, "90");
		
	}

}
