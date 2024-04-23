package Pacchetto;

public class Book {

	private String idLibro;
	private String titolo;	
	private String autore;
	
	public Book(String idLibro, String titolo, String autore) {
		this.idLibro = idLibro;
		this.titolo = titolo;
		this.autore = autore;
	}
	
	@Override
	public String toString() {
		return idLibro + ", " + titolo + ", " + autore;
	}
	
	public String getidLibro() {
		return idLibro;
	}
	
	public String gettitolo() {
		return titolo;
	}	
	
	public String getautore() {
		return autore;
	}
}
