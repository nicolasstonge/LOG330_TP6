package org.nso.LOG330_TP6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class CalculRegression {

	
	/************************** Variables Globales *****************************/
	
	// ArrayList construite a l'aide du fichier texte "numbersX"
	private ArrayList<Float> _listNombresX;
	
	// ArrayList construite a l'aide du fichier texte "numbersY"
	private ArrayList<Float> _listNombresY;
	
	// Fichier contenant les paires de nombres
	private String _filePath;
	
	// Le nombre de paires a calculer
	private int _nbrElement;
	
	/************************* Constructeur ************************************/
	
	public CalculRegression(String _filePath) {

		this._filePath = _filePath;
		
		loadNumbers();
		
	}
	
	/************************* Fonctions ****************************************/

	// Cette fonction permet de lire un fichier texte de nombres et de le transformer
	// en ArrayList.
	private void loadNumbers()
	{
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		
		File fichierNombres = new File(_filePath);
	
		_listNombresX = new ArrayList<Float>();
		
		_listNombresY = new ArrayList<Float>();
		
		BufferedReader _br = null;
		
		try 
		{
			_br = new BufferedReader(new FileReader(fichierNombres));
			
			String _ligne;
			
			while ((_ligne = _br.readLine()) != null) 
			{

				String[] _paireNombre = _ligne.split(";");
				
				Number _numberX = null;
				
			    Number _numberY = null;
			    
				try 
				{
					_numberX = format.parse(_paireNombre[0]);
					
					_numberY = format.parse(_paireNombre[1]);
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				} 
				Float _chiffreX = _numberX.floatValue();
				
				Float _chiffreY = _numberY.floatValue();
				
					_listNombresX.add(_chiffreX);
					
					_listNombresY.add(_chiffreY);
			}
		} 
		catch (IOException _e) 
		{
			_e.printStackTrace();
		}
		
		_nbrElement = _listNombresX.size();
	}
	
	
	// Sommation d'une liste de nombres
	private Float sommation(ArrayList<Float> liste){

		Float _sommation = (float) 0;

		for (Float _nombre : liste) {

			_sommation = _sommation + _nombre;
		}

		return _sommation;

	}

	// Sommation de la multiplication des composantes d'une paire provenant
	// des deux listes de nombres
	private Float sommationMultiplication(ArrayList<Float> liste1, ArrayList<Float> liste2 ){

		Float _sommation = (float) 0;

		for (int i = 0; i < liste1.size();i++) {

			_sommation = _sommation + (liste1.get(i) * liste2.get(i));
		}

		return _sommation;

	}

	// Sommation des nombres au carre d'une liste de nombres
	private Float sommationAuCarre(ArrayList<Float> liste ){

		Float _sommation = (float) 0;

		for (Float _chiffre: liste) {

			_sommation = _sommation + (_chiffre * _chiffre);
		}

		return _sommation;

	}
	
	// Calcul de la moyenne d'une liste de nombres
	private Float calculMoyenne(ArrayList<Float> liste){

		Float _sommation = (float) 0;

		for (Float _nombre : liste) {

			_sommation = _sommation + _nombre;
		}

		return _sommation / liste.size();
	}
	
	// calcul de la pente d'une droite a l'aide des deux listes de nombres
	public Float calculPente(){
		
		Float _haut = _nbrElement * sommationMultiplication(_listNombresX, _listNombresY) 
				
				      - sommation(_listNombresX)*sommation(_listNombresY);
		
		Float _bas = (float) (_nbrElement * sommationAuCarre(_listNombresX) 
				
				      - Math.pow(sommation(_listNombresX), 2));
		
		Float _pente = _haut / _bas;
		
		return _pente;
	}
	
	// Calcul de la constante d'une droite a l'aide des deux listes de nombres
	public Float calculConstante(){
		
		Float _constante = (float) 0;
		
		_constante = calculMoyenne(_listNombresY) - calculPente() * calculMoyenne(_listNombresX);
		
		return _constante;
	}
	
}
