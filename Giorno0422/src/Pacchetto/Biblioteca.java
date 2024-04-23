package Pacchetto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
	private Map<String, Book> libreria = new HashMap<>();

	public void leggeFileLibro(String nomeFile) throws IOException{
		//Legge il file e riempie l'hashmap
		try (BufferedReader brLibreria = new BufferedReader(new FileReader(nomeFile))){
			String linea;

			while((linea = brLibreria.readLine()) != null) {
				String[] parte = linea.split(",");
				if(parte.length == 3){
					Book insLib = new Book(parte[0].trim(), parte[1].trim(), parte[2].trim());
					libreria.put(insLib.getidLibro(), insLib);
				}
				else if(parte.length==4) {
					AudioLibro insAudLib = new AudioLibro(parte[0].trim(), parte[1].trim(), parte[2].trim(), parte[3].trim());
					libreria.put(parte[0].trim(), insAudLib);
				}
			}
			brLibreria.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void aggiungeHashMapLibro(String id, String titolo, String autore) {
		if(!libreria.containsKey(id)) {
			libreria.put(id, new Book(id, titolo, autore));
			System.out.println("Aggiunge in hashmap il libro: " + libreria);
		}
		else {
			System.out.println("Il libro con ID: "+ id + " già è presente nella libreria");
		}
	}
	
	public void aggiungeHashMapAudLib(String id, String titolo, String autore, String durataMinuti) {
		if(!libreria.containsKey(id)) {
			libreria.put(id, new AudioLibro(id, titolo, autore, durataMinuti));
			System.out.println("Aggiunge in hashmap l'audiolibro: " + libreria);
		}
		else {
			System.out.println("Il libro con ID: "+ id + " già è presente nella libreria");
		}
	}
	
    public void rimuoviLibri(String id) {
    	if(libreria.remove(id)==null) {
    		System.out.println("Nessun libro trovato con Id "+ id );
    		
    	}	
    }
    
	public void scriveFileLibro(String nomeFile) throws IOException{
		//Crea e riempie il file con l'array
		try (BufferedWriter bwLibreria = new BufferedWriter(new FileWriter(nomeFile))){
			System.out.println("libreria è: " + libreria.values());
			for (Book libro : libreria.values()){
				bwLibreria.write(libro.toString());
				System.out.println("bwLibreria è: " + libro.toString());
				bwLibreria.newLine();
			}
			bwLibreria.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
