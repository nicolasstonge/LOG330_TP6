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
 * @ date: 10 juin 2016
 * @ description: Cette classe permet de calculer la correlation entre l'effort
 *   et les r�sulats d'une liste d'�tudiants du cours de LOG330
 */

public class CalculEffort {


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

	public CalculEffort(String _filePath) {

		this._filePath = _filePath;

		loadNumbers();

	}

	/************************* Fonctions ****************************************/

	// Cette fonction permet de lire un fichier CSV de nombres et de le transformer
	// en  deux ArrayLists.
	public void loadNumbers()
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
				Number[] _nombres = new Number[8];

				// Pour chaque morceau de String separ�, on parse le morceau en
				// nombre et on l'ajoute au tableau de nombre
				try 
				{
					for (int i = 1; i < _nombres.length; i++) {

						_nombres[i] =  format.parse(_ligneCSV[i]);
					}
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				} 

				// On cree un tableau de Float
				Float[] _nombresFloat = new Float[8];

				// Pour chaque nombre dans le tableau de nombre, on parse
				// le nombre en float et on l'ajoute au tableau de Float.
				for (int i = 1; i < _nombresFloat.length; i++) {

					_nombresFloat[i] = _nombres[i].floatValue();
				}

				// On cree les Float de r�sullat pour les Arraylist X et Y
				Float _resultX = (float) 0;

				Float _reslutY = (float) 0;

				// Pour le r�sulat en X, on addtionne tout les heures
				// de chaque chapitre.
				for (int i = 1; i < _nombresFloat.length - 1; i++) {

					_resultX += _nombresFloat[i];
				}

				// pour le r�sultat en Y, on prend la derni�re valeur du
				// tableau de Float.
				_reslutY = _nombresFloat[7];

				// On ajoute les r�sulats de la ligne du fichier CSV dans
				// les ArrayLists atitr�s.
				_listNombresX.add(_resultX);

				_listNombresY.add(_reslutY);

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
	public double sommation(ArrayList<Float> _liste)
	{
		double _sommation = 0;

		for (double _nombre : _liste) 
		{
			_sommation += _nombre;
		}

		return _sommation;
	}

	// Cette fonction permet de faire la sommation de la multiplication de deux
	// �l�ments provenant chacun d'une ArrayList diff�rente.
	public double sommation(ArrayList<Float> _liste1, ArrayList<Float> _liste2 )
	{
		double _sommation = 0;

		for (int i = 0; i < _liste1.size();i++) 
		{
			_sommation += (_liste1.get(i) * _liste2.get(i));
		}

		return _sommation;
	}

	// Cette fonction permet de faire la sommation des �l�ments
	// au carr� d'une ArrayList.
	public double sommationCarre(ArrayList<Float> _liste )
	{
		double _sommation = 0;

		for (double _chiffre: _liste) {

			_sommation += (_chiffre * _chiffre);
		}

		return _sommation;
	}

	// Cette fonction permet de calculer le coefficient de correlation
	// selon les paires de nombre contenu dans les deux ArrayLists globales.
	public double calculCorrelation()
	{
		double _correlation = 0;

		// On calcule le haut de la division de la formule math�matique.
		double _haut = _nbrElement * sommation(_listNombresX, _listNombresY)

				- sommation(_listNombresX) * sommation(_listNombresY);

		// On calcule le bas de la division de la formule math�matique.
		double _bas = Math.sqrt((_nbrElement * sommationCarre(_listNombresX) -

				Math.pow(sommation(_listNombresX),2)) *

				(_nbrElement * sommationCarre(_listNombresY) -

						Math.pow(sommation(_listNombresY),2)));

		// On rejoint les deux parties ensemble.
		_correlation = _haut / _bas;
		
		return _correlation;

		// On affiche le coefficient de correlation.
		//System.out.println("Le coefficient de correlation est = "+_correlation);

		// On affiche la justification
		//if (_correlation < 0.70){

			//System.out.println("Il n'y a pas de correlation, car le coefficient est plus petit que 0.70");

		//}else{

			//System.out.println("Il y a une correlation, car le coefficient est plus gros ou �gal � 0.70");
		//}
	}

}
