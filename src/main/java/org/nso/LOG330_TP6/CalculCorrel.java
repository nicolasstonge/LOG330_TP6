package org.nso.LOG330_TP6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;


public class CalculCorrel 
{
	public ArrayList<Float> _listNombresX;
	
	public ArrayList<Float> _listNombresY;
	
	int _nbrElement;

	String _filePath;
	
	Float _moyenne;

	Float _sommeDistanceCarre;

	Float _variance;
	
	Float _ecartType;

	public CalculCorrel(String _filePath)
	{
		this._filePath = _filePath;
		
		LoadNumbers();
		
		CalculCorrelation();	
	}

	public void LoadNumbers()
	{
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		
		File fichierNombres = new File(_filePath);
	
		_listNombresX = new ArrayList<Float>();
		
		_listNombresY = new ArrayList<Float>();

		System.out.println("Liste des paires: \n");
		
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
				
				System.out.println(_chiffreX+" ; "+_chiffreY+"\n");
			}
		} 
		catch (IOException _e) 
		{
			_e.printStackTrace();
		}
		
		_nbrElement = _listNombresX.size();
	}

	public double Sommation(ArrayList<Float> _liste)
	{
		double _sommation = 0;

		for (double _nombre : _liste) 
		{
			_sommation = _sommation + _nombre;
		}
		
		return _sommation;
	}

	public double Sommation(ArrayList<Float> _liste1, ArrayList<Float> _liste2 )
	{
		double _sommation = 0;

		for (int i = 0; i < _liste1.size();i++) 
		{

			_sommation = _sommation + (_liste1.get(i) * _liste2.get(i));
		}

		return _sommation;
	}

	public double SommationCarre(ArrayList<Float> _liste )
	{
		double _sommation = 0;

		for (double _chiffre: _liste) {

			_sommation = _sommation + (_chiffre * _chiffre);
		}

		return _sommation;
	}

	public double CalculCorrelation()
	{
		double _correlation = 0;
		
		double _correlationCarre = 0;

		double _haut = _nbrElement * Sommation(_listNombresX, _listNombresY)
				
				       - Sommation(_listNombresX) * Sommation(_listNombresY);

		double _bas = Math.sqrt((_nbrElement * SommationCarre(_listNombresX) -
				
				      Math.pow(Sommation(_listNombresX),2)) *
				
				      (_nbrElement * SommationCarre(_listNombresY) -
				    		  
					  Math.pow(Sommation(_listNombresY),2)));
		
		_correlation = _haut / _bas;
		
		_correlationCarre = _correlation * _correlation;
		
		return _correlation;
	}
}
