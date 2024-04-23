package Pacchetto;

import java.io.IOException;
import java.util.Scanner;

/*Modificare il sistema per gestire una biblioteca, già creato in Giorno0417.
 *Prevedere la possibilità di scegliere tra inserimento da file, inserimento manuale, rimozione o 
 *fine operazioni. Deve essere possibile effettuare la scelta più volte, finchè non si esce.
 *Al termine delle operazioni bisognerà modificare il file di testo con i nuovi dati
 **/

public class MainBiblio {

	public static void main(String[] args) {
		
		Biblioteca biblio = new Biblioteca();
		try {
			biblio.leggeFileLibro("Libri.txt");

			String scelta = null;
			do {
				System.out.println("Cosa si vuole fare?\n" + "1-Inserire da file\n" + "2-Inserire manualmente\n" + "3-Rimuovere\n" + "4-Uscire");
				Scanner opzione = new Scanner(System.in);
				scelta = opzione.nextLine();

				switch (scelta) {
				case("1"):
					biblio.scriveFileLibro("ElencoLibri.txt");
					break;
				case("2"):
					Scanner nuovoLibro = new Scanner(System.in);
					System.out.println("Inserire l'id");
					String idLib = nuovoLibro.nextLine();	
					System.out.println("Inserire il titolo");
					String titolo = nuovoLibro.nextLine();	
					System.out.println("Inserire l'autore");
					String autore = nuovoLibro.nextLine();	
					System.out.println("Si vuole inserire un audiolibro?");
					if(nuovoLibro.nextLine() == "N") {
						biblio.aggiungeHashMapLibro(idLib, titolo, autore);
					}
					else {
						System.out.println("Inserire la durata");
						String durata = nuovoLibro.nextLine();	
						biblio.aggiungeHashMapAudLib(idLib, titolo, autore, durata);
					}
					biblio.scriveFileLibro("ElencoLibri.txt");
					nuovoLibro.close();
					break;
				case("3"):
					Scanner rimuovi = new Scanner(System.in);
					System.out.println("Inserire l'id da rimuovere");
					String idRimuovi = rimuovi.nextLine();
					biblio.rimuoviLibri(idRimuovi);
					biblio.scriveFileLibro("ElencoLibri.txt");
					rimuovi.close();
					break;
				case("4"):
					System.out.println("Uscita");
					opzione.close();
					break;
				default:
					System.out.println("Effettuare una scelta tra 1 e 4");
					break;
				}
			} while (!scelta.equalsIgnoreCase("4"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
