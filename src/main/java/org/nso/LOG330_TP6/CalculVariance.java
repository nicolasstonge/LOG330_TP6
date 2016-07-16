package org.nso.LOG330_TP6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CalculVariance {

	public ArrayList<Float> listNombres;

	String filePath;
	
	Float moyenne;

	Float sommeDistanceCarre;

	Float variance;
	
	Float ecartType;

	public CalculVariance(String filePath){

		this.filePath = filePath;
		LoadNumbers();
		CalculMoyenne();
		CalculSommeDistanceCarre();
		CalculVar();
		CalculEcartType();
	}

	public void LoadNumbers(){

		File fichierNombres = new File(filePath);
		
		listNombres = new ArrayList<Float>();

		try (BufferedReader br = new BufferedReader(new FileReader(fichierNombres))) {
			String ligne;
			while ((ligne = br.readLine()) != null) {

				Float chiffre = Float.parseFloat(ligne);
				listNombres.add(chiffre);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Liste des nombres: \n");
		for (Float float1 : listNombres) {

			System.out.println(float1);
		}
		System.out.println("");
	}

	public void CalculMoyenne(){

		Float sommation = (float) 0;

		for (Float nombre : listNombres) {

			sommation = sommation + nombre;
		}

		moyenne = sommation / (float)listNombres.size();

	}

	public void CalculSommeDistanceCarre(){

		Float sommationDistance = (float) 0;

		for (Float nombre : listNombres) {

			sommationDistance = sommationDistance + (float)Math.pow((nombre - moyenne),2);
		}

		sommeDistanceCarre = sommationDistance;
	}

	public float CalculVar(){

		variance = sommeDistanceCarre / ((float)listNombres.size() - 1);
		
		return variance;

	}

	public void CalculEcartType(){

		ecartType = (float) Math.pow(variance, 0.5);
		
		System.out.println("L'ecart type est: "+ecartType+"\n");

	}

}
