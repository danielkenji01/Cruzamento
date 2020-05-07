package controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {

	private String direcao;
	private Semaphore semaforo;
	
	public ThreadCruzamento(String direcao, Semaphore semaforo) {
		this.direcao = direcao;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			carroAndando();
			semaforo.acquire();
			carroCruzando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		semaforo.release();
	}
	
	private void carroAndando() throws InterruptedException {
		int tempo = (int)(Math.random() * 501) + 1500;
		sleep(tempo);
	}

	private void carroCruzando() throws InterruptedException {
		sleep(2000);
		System.out.println("Um carro cruzou na direção " + direcao);
	}
	
}