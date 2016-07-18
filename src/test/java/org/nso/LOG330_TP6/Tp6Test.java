package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculRegression;

public class Tp6Test {

	static CalculRegression _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculRegression("src/main/java/org/nso/LOG330_TP6/Numbers.csv");
	}
	
	@BeforeClass
	public static void initialise2(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculRegression("src/main/java/org/nso/LOG330_TP6/Numbers2.csv");
	}
	
	@BeforeClass
	public static void initialise3(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculRegression("src/main/java/org/nso/LOG330_TP6/Numbers3.csv");
	}
	
	@Test
	public void testPositiveSlope(){
		
		initialise();
		Assert.assertEquals(1.7279325f, _calculateur.calculPente(), 0.0002);
		System.out.println("testPositiveSlope Passed");
	}
	
	@Test
	public void testNegativeSlope(){
		
		initialise2();
		Assert.assertEquals(-1.0124706029891968, _calculateur.calculPente(), 0.0002);
		System.out.println("testNegativeSlope Passed");
	}
	
	@Test
	public void testNullSlope(){
		
		initialise3();
		Float.isNaN(_calculateur.calculPente());
		System.out.println("testNullSlope Passed");
	}
}
