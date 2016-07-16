package org.nso.LOG330_TP6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

/*
 * @ author: Nicolas St-Onge
 * @ date: 23 juin 2016
 * @ description: Cette classe permet de calculer l'intervalle de confiance
 *   d'un dataset.
 */

public class CalculInterval 
{
	/************************** Variables Globales *****************************/

	// ArrayList construite a l'aide du fichier CSV "donnees"
	private ArrayList<Float> _listNombresX;

	// ArrayList construite a l'aide du fichier CSV "donnees"
	private ArrayList<Float> _listNombresY;

	// Chemin du fichier contenant les nombres a calculer
	private String _filePath;

	// Le nombre de paires a calculer
	private int _nbrElement;

	/************************* Constructeur ************************************/

	public CalculInterval(String _filePath) 
	{
		this._filePath = _filePath;

		loadNumbers();

		ajouterUneValeurDataSet();
	}

	/************************* Fonctions ****************************************/

	// Cette fonction permet de lire un fichier CSV de nombres et de le transformer
	// en  deux ArrayLists.
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

			// Pour chaque ligne du fichier CSV
			while ((_ligne = _br.readLine()) != null) 
			{

				// On separe la ligne a chaque ";"
				String[] _ligneCSV = _ligne.split(";");

				// On instance un tableau de Nombre
				Number[] _nombres = new Number[_ligneCSV.length];

				// Pour chaque morceau de String separ�, on parse le morceau en
				// nombre et on l'ajoute au tableau de nombre
				try 
				{
					for (int i = 0; i < _nombres.length; i++) 
					{
						_nombres[i] =  format.parse(_ligneCSV[i]);
					}
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				} 

				// On cree un tableau de Float
				Float[] _nombresFloat = new Float[_ligneCSV.length];

				// Pour chaque nombre dans le tableau de nombre, on parse
				// le nombre en float et on l'ajoute au tableau de Float.
				for (int i = 0; i < _nombresFloat.length; i++) 
				{
					_nombresFloat[i] = _nombres[i].floatValue();
				}

				// On ajoute tous les Float dans la liste globale de traitement
				for (int i = 0; i < _nombresFloat.length; i++)
				{
					_listNombresY.add(_nombresFloat[i]);
				}

				// Pour les valeur en X, nous avons juste besoin du numero de TP
				// nous allons donc incrementer a partir de 1
				float _tpNbr = 1;

				for (int i = 0; i < _nombresFloat.length; i++) 
				{
					_listNombresX.add(_tpNbr);

					_tpNbr++;
				}
			}
		} 
		catch (IOException _e) 
		{
			_e.printStackTrace();
		}

		// On prend le nombre d'�l�ments dans une liste pour
		// savoir le nombre de paires
		_nbrElement = _listNombresX.size();
	}

	// Cette fonction permet de faire la sommation des �l�ments
	// d'un ArrayList
	private Float sommation(ArrayList<Float> _liste)
	{
		Float _sommation = (float) 0;

		for (Float _nombre : _liste) 
		{
			_sommation = _sommation + _nombre;
		}

		return _sommation;
	}

	// Sommation de la multiplication des composantes d'une paire provenant
	// des deux listes de nombres
	private Float sommationMultiplication(ArrayList<Float> _liste1, ArrayList<Float> _liste2 )
	{
		Float _sommation = (float) 0;

		for (int i = 0; i < _liste1.size();i++) 
		{
			_sommation = _sommation + (_liste1.get(i) * _liste2.get(i));
		}

		return _sommation;
	}

	// Cette fonction permet de faire la sommation des �l�ments
	// d'un ArrayList
	private Float sommationMoinsMoyenne(ArrayList<Float> _liste)
	{
		Float _sommation = (float) 0;

		for (Float _nombre : _liste) 
		{
			_sommation += (float) Math.pow(_nombre - calculMoyenne(_liste), 2);
		}

		return _sommation;
	}

	// Sommation des nombres au carre d'une liste de nombres
	private Float sommationAuCarre(ArrayList<Float> _liste )
	{
		Float _sommation = (float) 0;

		for (Float _chiffre: _liste) 
		{
			_sommation = _sommation + (_chiffre * _chiffre);
		}

		return _sommation;

	}

	// Calcul de la moyenne d'une liste de nombres
	private Float calculMoyenne(ArrayList<Float> _liste)
	{
		Float _sommation = (float) 0;

		for (Float _nombre : _liste) 
		{
			_sommation += _nombre;
		}

		return _sommation / _liste.size();
	}

	// calcul de la pente d'une droite a l'aide des deux listes de nombres
	private Float calculPente()
	{
		Float _haut = _nbrElement * sommationMultiplication(_listNombresX, _listNombresY) 

				- sommation(_listNombresX)*sommation(_listNombresY);

		Float _bas = (float) (_nbrElement * sommationAuCarre(_listNombresX) 

				- Math.pow(sommation(_listNombresX), 2));

		Float _pente = _haut / _bas;

		return _pente;
	}

	// Calcul de la constante d'une droite a l'aide des deux listes de nombres
	private Float calculConstante()
	{
		Float _constante = (float) 0;

		_constante = calculMoyenne(_listNombresY) - calculPente() * calculMoyenne(_listNombresX);

		return _constante;
	}

	// Cette methode permet de calculer la somme des ditances au carre des 
	// elements d'une ArrayList
	private Float calculSommeDistanceCarre(ArrayList<Float> _listeFloat)
	{
		Float _sommationDistance = (float) 0;

		for (Float _nombre : _listeFloat) 
		{
			_sommationDistance = _sommationDistance + (float)Math.pow((_nombre - 
					
					calculMoyenne(_listeFloat)),2);
		}

		return _sommationDistance;
	}

	// Cette methode permet de calculer la variance des elements d'un ArrayList
	private Float calculVar(ArrayList<Float> _listeFloat)
	{
		float _variance = calculSommeDistanceCarre(_listeFloat) / ((float)_listeFloat.size() - 1);

		return _variance;
	}

	// cette methode permet de calculer l'ecart type d'un ArrayList
	private Float calculEcartType(ArrayList<Float> _listeFloat)
	{
		float _ecartType = (float) Math.pow(calculVar(_listeFloat), 0.5);

		return _ecartType;
	}

	// Cette methode permet d'ajouter une valeure au dataSet a l'aide de
	// la formule de regression.
	private void ajouterUneValeurDataSet()
	{
		Float _pente = calculPente();

		Float _constante = calculConstante();

		_listNombresX.add((float) _listNombresX.size()+ 1);

		_listNombresY.add(((_listNombresY.size()+ 1) * _pente)+ _constante);

		_nbrElement = _listNombresY.size();
	}

	// Cette methode permet de calculer l'intervalle de confiance
	public float calculIntervalle(Float _coeff, String _pourcentageIntervale)
	{
		// calcul de la division qui se trouve dans la racine de la formule
		float _division = (float)Math.pow(_listNombresY.get(_nbrElement - 1) - 
				
				calculMoyenne(_listNombresY), 2)

				/ sommationMoinsMoyenne(_listNombresY);

		// calcul de la racine de la formule
		float _racine = (float)Math.pow(1 + (1 / _listNombresY.size()) + _division, 0.5);

		// calcul de la formaule d<intervalle de confiance
		float _interval = _coeff * calculEcartType(_listNombresY) * _racine;

		// Affichage des bornes superieur et inferieur suite au calcul d'intervalle
		// Affichage estimation LOC et ecart type
		System.out.println("LOC estime: "+_listNombresY.get(_nbrElement - 1)+"\n"+"Ecart-type: "
		
				+calculEcartType(_listNombresY)+"\n"+"Pour un niveau de confiance de "
				
				+_pourcentageIntervale+"%"+"\n");
		
		System.out.println("La borne inferieur est: " + (_listNombresY.get(_nbrElement - 1) - 
				
				_interval + "\n"));
		
		System.out.println("La borne superieur est: " + (_listNombresY.get(_nbrElement - 1) + 
				
				_interval + "\n"));
		
		return _interval;
		
	}

}
