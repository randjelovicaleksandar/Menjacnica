package menjacnica.interfejs;

import java.util.GregorianCalendar;

public interface MenjacnicaInterfejs {

	public void dodajKurs(String nazivValute, String skracenica, GregorianCalendar datum, 
			double kupovniKurs, double prodajniKurs, double srednjiKurs);
	
	public void obrisiKurs();
	
	public String pronadjiKurs();
		
}
