package org.nso.LOG330_TP6;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculCorrel calcul = new CalculCorrel("src/main/java/org/nso/LOG330_TP6/Numbers.csv");
		
		System.out.println(calcul.CalculCorrelation());
	}

}
