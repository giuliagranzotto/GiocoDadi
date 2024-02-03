package it.betacom.gioco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.betacom.model.Giocatore;

public class Gioco {
	
	private List<Giocatore> giocatori;
	private int numeroDadi;
	private Giocatore vincitore;
	
	//solo 2 giocatori
	public Gioco(int numeroDadi) {
		this.numeroDadi = numeroDadi;
		this.giocatori = new ArrayList<Giocatore>(2);
		this.inizializza(2);
	}
	
	public List<Giocatore> getGiocatori() {
		return giocatori;
	}
	
	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public int getNumeroDadi() {
		return numeroDadi;
	}

	public void setNumeroDadi(int numeroDadi) {
		this.numeroDadi = numeroDadi;
	}

	public Giocatore getVincitore() {
		return vincitore;
	}

	public void setVincitore(Giocatore vincitore) {
		this.vincitore = vincitore;
	}

	public Giocatore aggiungiGiocatore(String nome) {
		Giocatore giocatore = new Giocatore(nome);
		this.giocatori.add(giocatore);
		return giocatore;
	}
	
	private void inizializza(int numeroGiocatori) {
		Scanner scanner = new Scanner(System.in);
		String nome = "";
		for (int i=0; i<numeroGiocatori; i++) {
			boolean inserito = false;
			while(!inserito) {
				System.out.println("\nInserisci nome " + (i+1) + "° giocatore: ");
				nome = scanner.nextLine();
				if(nome.trim().length() == 0) System.out.println("Non è stato inserito nessun nome!");
				else inserito = true;
			}
			Giocatore giocatore = this.aggiungiGiocatore(nome);
			System.out.println("Ciao " + giocatore.getNome() + '!');
		}
		scanner.close();
	}
	
	public void gioca(int numeroPartite) {
		for (int i=0; i<numeroPartite; i++) {
			System.out.println("\n\nPartita numero " + (i+1));
			Partita partita = new Partita(this.giocatori);
			partita.giocaPartita(this.numeroDadi);
			System.out.println(partita.getRisultatoPartita());
		}
		this.decretaVincitore();
	}
	
	private void giocaSpareggio() {
		System.out.println("\n\nPartita di spareggio");
		Partita partita = new Partita(this.giocatori);
		partita.giocaPartita(this.numeroDadi);
		System.out.println(partita.getRisultatoPartita());
	}
	
	//da rifare in caso di più di 2 giocatori
	private void decretaVincitore() {
		for (Giocatore giocatore : this.giocatori)
			System.out.println("\nPartite vinte da " + giocatore.getNome() + ": " + giocatore.getPartiteVinte());
		
		Giocatore primoGiocatore = this.giocatori.get(0);
		Giocatore secondoGiocatore = this.giocatori.get(1);
		while (primoGiocatore.getPartiteVinte() == secondoGiocatore.getPartiteVinte()) {
			this.giocaSpareggio();
		}
		if (primoGiocatore.getPartiteVinte() > secondoGiocatore.getPartiteVinte()) this.vincitore = primoGiocatore;
		else this.vincitore = secondoGiocatore;
	}
	
}
