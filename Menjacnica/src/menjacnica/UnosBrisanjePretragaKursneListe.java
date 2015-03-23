package menjacnica;

import java.util.GregorianCalendar;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class UnosBrisanjePretragaKursneListe extends Menjacnica implements MenjacnicaInterfejs {

	public void dodajKurs(String nazivValute, String skracenica, GregorianCalendar datum, 
			double kupovniKurs, double prodajniKurs, double srednjiKurs) {
		boolean ubacen = false;
		
		Valuta valuta = new Valuta();
		valuta.setNazivValute(nazivValute);
		valuta.setSkracenica(skracenica);
		valuta.setDatum(datum);
		valuta.setKupovniKurs(kupovniKurs);
		valuta.setProdajniKurs(prodajniKurs);
		valuta.setSrednjiKurs(srednjiKurs);

		if(kursnaLista.size() == 0) {
			kursnaLista.add(valuta);
			ubacen = true;
		} else {
			for (int i = 0; i < kursnaLista.size(); i++) {
				//Ubacivanje u listu hronoloskim redom po datumu
				if(valuta.getDatum().before(kursnaLista.get(i).getDatum())) {
					kursnaLista.add(i, valuta);
					ubacen = true;
					break;
				}
			}
		}
		if(!ubacen) {
			kursnaLista.addLast(valuta);
		}
	}

	public void obrisiKurs() {
		// TODO Auto-generated method stub
		
	}

	public String pronadjiKurs() {
		// TODO Auto-generated method stub
		return null;
	}

}
