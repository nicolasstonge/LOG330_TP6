package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculVariance;

public class Tp6Test {

	static CalculVariance _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculVariance("src/main/java/org/nso/LOG330_TP6/numbers.csv");
	}
	
	@Test
	public void firstTest(){
		
		Assert.assertEquals(391417.88, _calculateur.CalculVar(), 0.2);
	}
}
