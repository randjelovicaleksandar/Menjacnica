package menjacnica;

import java.util.GregorianCalendar;

import menjacnica.interfejs.MenjacnicaInterfejs;


public class UnosBrisanjePretragaKursneListe extends Menjacnica implements MenjacnicaInterfejs {

	public void dodajKurs(String nazivValute, String skracenica, GregorianCalendar datum, 
			double kupovniKurs, double prodajniKurs, double srednjiKurs) {
		Valuta valuta = new Valuta();
		valuta.setNazivValute(nazivValute);
		valuta.setSkracenica(skracenica);
		valuta.setDatum(datum);
		valuta.setKupovniKurs(kupovniKurs);
		valuta.setProdajniKurs(prodajniKurs);
		valuta.setSrednjiKurs(srednjiKurs);
		kursnaLista.add(valuta);
	}

	public void obrisiKurs(String valuta, GregorianCalendar datum) {
		boolean obrisan = false;
		for (int i = 0; i < kursnaLista.size(); i++) {
			if(kursnaLista.get(i).getNazivValute().equals(valuta) && 
					kursnaLista.get(i).getDatum().equals(datum)) {
				kursnaLista.remove(kursnaLista.get(i));
				obrisan = true;
			}
		}
		if(!obrisan) {
			System.out.println("Nije pronadjen kurs valute: " +valuta+ " na datum koji ste uneli");
		}
	}

	public String pronadjiKurs(String valuta, GregorianCalendar datum) {
		for (int i = 0; i < kursnaLista.size(); i++) {
			if(kursnaLista.get(i).getNazivValute().equals(valuta) && 
					kursnaLista.get(i).getDatum().equals(datum)) {
				return kursnaLista.get(i).toString();
			}
		}
		return "Nije pronadjen kurs koji ste zeleli";
	}

}
