package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculCorrel;

public class Tp6Test {

	static CalculCorrel _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculCorrel("src/main/java/org/nso/LOG330_TP6/Numbers.csv");
	}
	
	@Test
	public void firstTest(){
		
		Assert.assertEquals(0.955920515400237, _calculateur.CalculCorrelation(), 0.2);
	}
}
