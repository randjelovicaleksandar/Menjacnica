package menjacnica;

import java.util.GregorianCalendar;


public class Valuta {

	private String nazivValute;
	private String skracenica;
	
	private double kupovniKurs;
	private double prodajniKurs;
	private double srednjiKurs;
	
	private GregorianCalendar datum;

	public String getNazivValute() {
		return nazivValute;
	}

	public void setNazivValute(String nazivValute) {
		if(nazivValute == null) {
			throw new RuntimeException("Naziv valute ne sme biti null");
		}
		this.nazivValute = nazivValute;
	}

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) {
		if(skracenica == null) {
			throw new RuntimeException("Skracenica valute ne sme biti null");
		}
		this.skracenica = skracenica;
	}

	public double getKupovniKurs() {
		return kupovniKurs;
	}

	public void setKupovniKurs(double kupovniKurs) {
		if(kupovniKurs <= 0) {
			throw new RuntimeException("Kupovni kurs mora biti veci od nule");
		}
		this.kupovniKurs = kupovniKurs;
	}

	public double getProdajniKurs() {
		return prodajniKurs;
	}

	public void setProdajniKurs(double prodajniKurs) {
		if(prodajniKurs <= 0) {
			throw new RuntimeException("Prodajni kurs mora biti veci od nule");
		}
		this.prodajniKurs = prodajniKurs;
	}

	public double getSrednjiKurs() {
		return srednjiKurs;
	}

	public void setSrednjiKurs(double srednjiKurs) {
		if(srednjiKurs <= 0) {
			throw new RuntimeException("Srednji kurs mora biti veci od nule");
		}
		this.srednjiKurs = srednjiKurs;
	}

	public GregorianCalendar getDatum() {
		return datum;
	}

	public void setDatum(GregorianCalendar datum) {
		if(datum.YEAR < 2014) {
			throw new RuntimeException("Godina ne moze biti niza od 2014-e");
		}
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Naziv Valute: " + nazivValute + " Kupovni Kurs: "
				+ kupovniKurs + " Prodajni Kurs: " + prodajniKurs
				+ " Srednji Kurs: " + srednjiKurs + " Datum: " + datum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((nazivValute == null) ? 0 : nazivValute.hashCode());
		temp = Double.doubleToLongBits(prodajniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((skracenica == null) ? 0 : skracenica.hashCode());
		temp = Double.doubleToLongBits(srednjiKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valuta other = (Valuta) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (Double.doubleToLongBits(kupovniKurs) != Double
				.doubleToLongBits(other.kupovniKurs))
			return false;
		if (nazivValute == null) {
			if (other.nazivValute != null)
				return false;
		} else if (!nazivValute.equals(other.nazivValute))
			return false;
		if (Double.doubleToLongBits(prodajniKurs) != Double
				.doubleToLongBits(other.prodajniKurs))
			return false;
		if (skracenica == null) {
			if (other.skracenica != null)
				return false;
		} else if (!skracenica.equals(other.skracenica))
			return false;
		if (Double.doubleToLongBits(srednjiKurs) != Double
				.doubleToLongBits(other.srednjiKurs))
			return false;
		return true;
	}
	
	
}
