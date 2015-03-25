package menjacnica;

import java.util.GregorianCalendar;

import menjacnica.interfejs.MenjacnicaInterfejs;


public class UnosBrisanjePretragaKursneListe extends Menjacnica implements MenjacnicaInterfejs {

	public void dodajKurs(String nazivValute, String skracenica, GregorianCalendar datum, 
			double kupovniKurs, double prodajniKurs) {
		boolean ubacen = false;
		
		Valuta valuta = new Valuta();
		valuta.setNazivValute(nazivValute);
		valuta.setSkracenica(skracenica);
		valuta.setDatum(datum);
		valuta.setKupovniKurs(kupovniKurs);
		valuta.setProdajniKurs(prodajniKurs);
		valuta.setSrednjiKurs( (prodajniKurs + kupovniKurs) / 2 );

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

	public void obrisiKurs(String valuta, GregorianCalendar datum) {
		boolean obrisan = false;
		for (int i = 0; i < kursnaLista.size(); i++) {
			if(kursnaLista.get(i).getNazivValute().equals(valuta) && 
					kursnaLista.get(i).getDatum().equals(datum)) {
				kursnaLista.remove(kursnaLista.get(i));
				obrisan = true;
				break;
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
