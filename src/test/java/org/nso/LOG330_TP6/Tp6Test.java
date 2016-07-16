package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculInterval;;

public class Tp6Test {

	static CalculInterval _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculInterval("src/main/java/org/nso/LOG330_TP6/donnees.csv");
	}
	
	@Test
	public void firstTest(){
		
		Assert.assertEquals(92.39868f, _calculateur.calculIntervalle(1.250f, "70"), 0.002);
	}
}
