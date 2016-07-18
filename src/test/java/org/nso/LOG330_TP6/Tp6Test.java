package org.nso.LOG330_TP6;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.notification.Failure;
import org.nso.LOG330_TP6.CalculEffort;

public class Tp6Test {

	static CalculEffort _calculateur;

	@BeforeClass
	public static void initialise(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculEffort("src/main/java/org/nso/LOG330_TP6/donnees.csv");
	}
	
	@BeforeClass
	public static void initialise2(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculEffort("src/main/java/org/nso/LOG330_TP6/donnees2.csv");
	}
	
	@BeforeClass
	public static void initialise3(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculEffort("src/main/java/org/nso/LOG330_TP6/donnees3.csv");
	}
	
	@Test
	public void testLowCorrelation(){
		
		initialise();
		Assert.assertEquals(0.1552162305176995, _calculateur.calculCorrelation(), 0.002);
	}
	
	@Test
	public void testHighCorrelation(){
		
		initialise2();
		Assert.assertEquals(1.0, _calculateur.calculCorrelation(), 0.002);
	}
	
	@Test
	public void testInvalid() throws Exception{
		
		initialise3();
		if(Double.isNaN(_calculateur.calculCorrelation())){
			
		}else{
			Exception e = null;
			throw e;
		}
		
	}
}
