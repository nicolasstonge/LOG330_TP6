package org.nso.LOG330_TP6;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculVariance calcul = new CalculVariance("src/main/java/org/nso/LOG330_TP6/numbers.csv");
		
		System.out.println("Liste des nombres: \n");
		for (Float float1 : calcul.listNombres) {

			System.out.println(float1);
		}
		System.out.println("");
		System.out.println("La Variance est de: "+ calcul.CalculVar()+"\n");
		System.out.println("L'Écart-type est de: "+ calcul.CalculEcartType()+"\n");
	}

}
