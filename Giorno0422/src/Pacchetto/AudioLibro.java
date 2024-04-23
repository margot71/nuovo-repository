package Pacchetto;

public class AudioLibro extends Book{
	private String durataMinuti;
	
	public AudioLibro(String idLibro, String autore, String titolo, String durataMinuti) {
		super(idLibro,autore,titolo);
		this.durataMinuti = durataMinuti;
	}
	
	public String getDurata() {
		return durataMinuti;
	}

	@Override
	public String toString() {
		return super.toString() + ", durata audiolibro: " + durataMinuti;
	}
}