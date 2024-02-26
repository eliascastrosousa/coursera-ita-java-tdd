package entities;

import Testes.PilhaCheiaException;
import Testes.PilhaVaziaException;

public class Pilha {
	
	/* objeto do tipo array */
	private Object[] elementos; 
	private int quantidade = 0;

	/* construtor */
	public Pilha(int maximo ) { 
		elementos = new Object[maximo] ;
	}
	
	public void empilha(Object elemento) {
		if(quantidade == elementos.length)
			throw new PilhaCheiaException("Não é possivel empilhar mais elementos");
		this.elementos[quantidade] = elemento;
		quantidade++;
	}

	public Integer tamanhoPilha() {
		return quantidade;
	}

	public Boolean estaVazia() {
		return quantidade ==0;
	}

	public void addPilha(Object elemento) {
		this.elementos[quantidade] = elemento;
		quantidade ++;
		
	}

	public Object topo() {
		return elementos[quantidade-1];
	}

	public Object desempilha() {
		if(estaVazia())
			throw new PilhaVaziaException("Não é possivel desempilhar");
		Object topo = topo();
		quantidade--;
		return topo;
	}
	
}
