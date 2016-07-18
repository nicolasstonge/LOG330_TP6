package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculCorrel;

public class Tp6Test {

	static CalculCorrel _calculateur;

	@BeforeClass
	public static void initialise(){

		_calculateur = new CalculCorrel("src/main/java/org/nso/LOG330_TP6/Numbers.csv");
	}
	
	@BeforeClass
	public static void initialise2(){

		_calculateur = new CalculCorrel("src/main/java/org/nso/LOG330_TP6/Numbers2.csv");
	}
	
	@BeforeClass
	public static void initialise3(){

		_calculateur = new CalculCorrel("src/main/java/org/nso/LOG330_TP6/Numbers3.csv");
	}
	
	@Test
	public void testHighCorrel(){
		
		initialise();
		Assert.assertEquals(0.955920515400237, _calculateur.CalculCorrelation(), 0.002);
	}
	
	@Test
	public void testLowCorrel(){
		
		initialise2();
		Assert.assertEquals(0.41263714873707874, _calculateur.CalculCorrelation(), 0.002);
	}
	
	@Test
	public void testInvalidCorrel(){
		
		initialise3();
		Double.isNaN(_calculateur.CalculCorrelation());
	}
}
