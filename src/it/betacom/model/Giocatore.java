package it.betacom.model;

import java.util.Random;

public class Giocatore {

	private String nome;
	private int lancio;
	private int partiteVinte;

	public Giocatore(String nome) {
		this.lancio = 0;
		this.partiteVinte = 0;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getLancio() {
		return lancio;
	}

	public void setLancio(int lancio) {
		this.lancio = lancio;
	}

	public int getPartiteVinte() {
		return partiteVinte;
	}

	public void setPartiteVinte(int partiteVinte) {
		this.partiteVinte = partiteVinte;
	}
	
	public void lanciaDadi(int numeroDadi) {
		this.lancio = 0;
		for (int i=0; i<numeroDadi; i++) {
			this.lancio += (new Random().nextInt(6) + 1);
		}
	}
	
	public void incrementaPartiteVinte() {
		this.partiteVinte++;
	}
	
}
