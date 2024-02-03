package it.betacom.gioco;

import java.util.List;

import it.betacom.model.Giocatore;

public class Partita {
	
	private List<Giocatore> giocatori;
	private Giocatore vincitore;
	
	public Partita(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public Giocatore getVincitore() {
		return vincitore;
	}

	public void setVincitore(Giocatore vincitore) {
		this.vincitore = vincitore;
	}

	public void giocaPartita(int numeroDadi) {
		for (Giocatore giocatore : this.giocatori) {
			giocatore.lanciaDadi(numeroDadi);
			System.out.println("Il risultato del lancio di " + giocatore.getNome() + " è " + giocatore.getLancio());
		}
		this.decretaVincitore();
	}
	
	//da rifare in caso di più di 2 giocatori
	private void decretaVincitore() {
		Giocatore primoGiocatore = this.giocatori.get(0);
		Giocatore secondoGiocatore = this.giocatori.get(1);
		if (primoGiocatore.getLancio() > secondoGiocatore.getLancio())
			this.vincitore = primoGiocatore;
		else if (primoGiocatore.getLancio() < secondoGiocatore.getLancio())
			this.vincitore = secondoGiocatore;
		if(this.vincitore != null) this.vincitore.incrementaPartiteVinte();
	}
	
	public String getRisultatoPartita() {
		if (this.vincitore == null) return "Partita finita in pareggio"; 
		else return "Il vincitore della partita è " + this.vincitore.getNome();
	}
	
}
