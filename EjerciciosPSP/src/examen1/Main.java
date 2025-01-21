package examen1;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Semaphore semaphore = new Semaphore(1);

		CaracteresPares c1 = new CaracteresPares(0, semaphore);
		CaracteresPares c2 = new CaracteresPares(0, semaphore);
		
		CaracteresPares c3 = new CaracteresPares(1, semaphore);
		
		c1.start();
		c2.start();
		c3.start();
		
		
		c1.join();
		c2.join();
		c3.join();

	}

}