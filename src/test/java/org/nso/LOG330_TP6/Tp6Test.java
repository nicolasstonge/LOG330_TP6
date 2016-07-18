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
	
	@BeforeClass
	public static void initialise2(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculInterval("src/main/java/org/nso/LOG330_TP6/donnees2.csv");
	}
	
	@BeforeClass
	public static void initialise3(){

		// Instance de la classe de calcul de regression lineaire
		_calculateur = new CalculInterval("src/main/java/org/nso/LOG330_TP6/donnees3.csv");
	}
	
	@Test
	public void testAt80(){
		
		initialise();
		Assert.assertEquals(121.07923889160156f, _calculateur.calculIntervalle(1.638f, "80"), 0.002);
	}
	
	@Test
	public void testAt70(){
		
		initialise2();
		Assert.assertEquals(76.71610260009766f, _calculateur.calculIntervalle(1.250f, "70"), 0.002);
	}
	
	@Test
	public void testAt90(){
		
		initialise3();
		Assert.assertEquals(135.93719482421875f, _calculateur.calculIntervalle(2.353f, "90"), 0.002);
	}
}
