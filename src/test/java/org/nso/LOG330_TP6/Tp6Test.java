package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.Regression.CalculRegression;

public class Tp6Test {

	static CalculRegression _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculRegression("/LOG330_TP6/src/main/java/org/nso/Regression/Numbers.csv");
	}
	
	@Test
	public void firstTest(){
		
		Assert.assertEquals(1.7279325f, _calculateur.calculPente(), 0.0002); // true
	}
}
