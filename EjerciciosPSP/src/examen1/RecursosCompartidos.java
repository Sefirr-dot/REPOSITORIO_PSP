package examen1;
public class RecursosCompartidos {
	
	static class GestorRecursos {
		
		private boolean recurso1 = false;
		private boolean recurso2 = false;
		private boolean recurso3 = false;
		
		public synchronized void obtenerRecurso1(String nombre) throws InterruptedException {
			
			while(recurso1) {
				System.out.println("El recurso está ocupado, tienes que esperar");
				wait();
			}
			
			recurso1 = true;
			System.out.println(nombre + "está utilizando el recurso 1");
		}
		
		public synchronized void obtenerRecurso2(String nombre) throws InterruptedException {
			
			while(recurso1 || recurso2) {
				System.out.println("Los recursos 1 o 2 estás ocupados, tienes que esperar");
				wait();
			}
			
			recurso1 = true;
			recurso2 = true;
			System.out.println(nombre + "está utilizando el recurso 1 y 2");
			
		}
		
		public synchronized void obtenerRecurso3(String nombre) throws InterruptedException {
			
			while(recurso1 || recurso2 || recurso3) {
				System.out.println("Los recursos 1 o 2 o 3 estás ocupados, tienes que esperar");
				wait();
			}
			
			recurso1 = true;
			recurso2 = true;
			recurso3 = true;
			System.out.println(nombre + "está utilizando el recurso 1, 2 y 3");
			
		}
		
		public synchronized void soltarRecurso(int id) {
			
			if(id == 1) {
				recurso1 = false;
			} else if(id == 2) {
				recurso1 = false;
				recurso2 = false;
			} else {
				recurso1 = false;
				recurso2 = false;
				recurso3 = false;
			}
			
			System.out.println("Se ha dejado de utilizar los recursos");
			
			notifyAll();
			
			
		}
		
	}
	
	static class Hilos extends Thread {
		
		private String nombre;
		private int id;
		private GestorRecursos gestor;
		
		public Hilos(String nombre, int id, GestorRecursos gestor) {
			super();
			this.nombre = nombre;
			this.id = id;
			this.gestor = gestor;
		}
		
		@Override
		public void run() {
			
			try {
				if(id == 1) {
					gestor.obtenerRecurso1(nombre);
				} else if(id==2) {
					gestor.obtenerRecurso2(nombre);
				} else {
					gestor.obtenerRecurso3(nombre);
				}
				Thread.sleep(2000);
				gestor.soltarRecurso(id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		GestorRecursos gestor = new GestorRecursos();
		
		Hilos h1 = new Hilos("Hilo 1", 1, gestor);
		Hilos h2 = new Hilos("Hilo 2", 2, gestor);
		Hilos h3 = new Hilos("Hilo 3", 3, gestor);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-- Fin del programa --");
		
	}
	
}