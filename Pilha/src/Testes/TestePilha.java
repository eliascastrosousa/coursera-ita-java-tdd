package Testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Pilha;

class TestePilha {
	
	private Pilha p;
	private int maximo = 10;
	
	@BeforeEach
	public void inicializaPilha() {
		p = new Pilha(maximo);
	}

	@Test
	void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0,p.tamanhoPilha());
	}
	
	@Test
	void empilhaUmelemento() {
		p.addPilha("primeiro");
		assertFalse(p.estaVazia());
		assertEquals(1,p.tamanhoPilha());
		assertEquals("primeiro",p.topo());
		
	}
	
	@Test
	void empilhaSegundoelemento() {
		p.addPilha("primeiro");
		p.addPilha("segundo");
		assertEquals(2,p.tamanhoPilha());
		assertEquals("segundo",p.topo());
		
	}
	
	@Test
	void empilhaEDesempilha() {
		p.addPilha("primeiro");
		p.addPilha("segundo");
		assertEquals(2,p.tamanhoPilha());
		Object desempilhado = p.desempilha();
		assertEquals(1,p.tamanhoPilha());
		assertEquals("segundo", desempilhado);
	}
	
	@Test
	void removeDaPilhaVazia() {
		assertThrows(PilhaVaziaException.class, () -> {
            p.desempilha();
        });		
	}
	
	@Test
	void adcionaNaPilhaCheia() {
		for(int i=0; i<10; i++ ) {
			p.empilha("elemento"+i);
		}
		try {
			p.empilha("boom");
			fail();
		} catch (PilhaCheiaException e) {}
	}
	
	
	
	

}
