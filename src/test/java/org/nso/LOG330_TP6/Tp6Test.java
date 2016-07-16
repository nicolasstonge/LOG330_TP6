package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculEffort;

public class Tp6Test {

	static CalculEffort _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculEffort("src/main/java/org/nso/LOG330_TP6/donnees.csv");
	}
	
	@Test
	public void firstTest(){
		
		Assert.assertEquals(0.2552162305176995, _calculateur.calculCorrelation(), 0.002);
	}
}
