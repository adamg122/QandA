package app;

import java.io.Serializable;

public class Odpowiedz implements Serializable {

	static final long serialVersionUID = 12345L;
	private int id;
	// private String tytul;
	private String tresc;
	private int idDodajacego;
	private String nazwaDodajacego;
	private int liczbaKomentarzy;
	private int rank;
	private int idPytania;

	public Odpowiedz() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public String getTytul() { return tytul; }
	 * 
	 * public void setTytul(String tytul) { this.tytul = tytul; }
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setLiczbaKomentarzy(int liczbaKomentarzy) {
		this.liczbaKomentarzy = liczbaKomentarzy;
	}

	public int getliczbaKomentarzy() {
		return liczbaKomentarzy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setIdPytanie(int idPytania) {
		this.idPytania = idPytania;
	}

	public int getIdPytania() {
		return idPytania;
	}

	public void setIdDodajacego(int idDodajacego) {
		this.idDodajacego = idDodajacego;
	}

	public int getIdDodajacego() {
		return idDodajacego;
	}

	public String getTresc() {
		return tresc;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	public String getNazwaDodajacego() {
		return nazwaDodajacego;
	}

	public void setNazwaDodajacego(String nazwaDodajacego) {
		this.nazwaDodajacego = nazwaDodajacego;
	}
}