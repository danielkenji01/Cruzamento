package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] direcoes = new String[] {"Norte-Sul", "Leste-Oeste", "Sul-Norte", "Oeste-Leste"};
		Semaphore semaforo = new Semaphore(1);
		
		for (String direcao : direcoes) {
			ThreadCruzamento thread = new ThreadCruzamento(direcao, semaforo);
			thread.start();
		}
		
	}

}
