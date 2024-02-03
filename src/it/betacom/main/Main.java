package it.betacom.main;

import java.util.Scanner;

import it.betacom.gioco.Gioco;
import it.betacom.model.Giocatore;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numeroDadi, numeroPartite;
		
//		System.out.println("Quanti giocatori: ");
//		numeroGiocatori = inserisciIntero(scanner);
		
		System.out.println("Quanti dadi?");
		numeroDadi = inserisciIntero(scanner);
		
		System.out.println("\nQuante partite?");
		numeroPartite = inserisciIntero(scanner);
		
		Gioco gioco = new Gioco(numeroDadi);
		gioco.gioca(numeroPartite);
		Giocatore vincitore = gioco.getVincitore();
		System.out.println("\n\nIl vincitore è " + vincitore.getNome());
		
		scanner.close();
	}
	
	private static int inserisciIntero(Scanner scanner) {
		int numero = 0;
		boolean isIntero = false;
		do {
			try {
				String next = scanner.nextLine();
				numero = Integer.parseInt(next.trim());
				isIntero = true;
			} catch(NumberFormatException e) {
				System.out.println("Attenzione! Non è un intero, prova di nuovo!\n");
			}
		} while (!isIntero);
		return numero;
	}
	
}
