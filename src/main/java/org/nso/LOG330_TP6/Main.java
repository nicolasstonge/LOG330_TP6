package org.nso.LOG330_TP6;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculVariance calcul = new CalculVariance("src/main/java/org/nso/LOG330_TP6/numbers.csv");
		
		System.out.println(calcul.CalculVar());
	}

}
