package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nso.LOG330_TP6.CalculVariance;

public class Tp6Test {

	static CalculVariance _calculateur;

	@BeforeClass
	public static void initialise(){

		_calculateur = new CalculVariance("src/main/java/org/nso/LOG330_TP6/numbers.csv");
	}
	
	@BeforeClass
	public static void initialise2(){

		_calculateur = new CalculVariance("src/main/java/org/nso/LOG330_TP6/numbers2.csv");
	}
	
	@BeforeClass
	public static void initialise3(){

		_calculateur = new CalculVariance("src/main/java/org/nso/LOG330_TP6/numbers3.csv");
	}
	
	@Test
	public void testHighVar(){
		
		initialise();
		Assert.assertEquals(391417.88, _calculateur.CalculVar(), 0.2);
		System.out.println("testHighVar Passed");
	}
	
	@Test
	public void testLowVar(){
		
		initialise2();
		Assert.assertEquals(9.166666984558105, _calculateur.CalculVar(), 0.2);
		System.out.println("testLowVar Passed");
	}
	
	@Test
	public void testNullVar(){
		
		initialise3();
		Assert.assertEquals(0, _calculateur.CalculVar(), 0.2);
		System.out.println("testNullVar Passed");
	}
}
