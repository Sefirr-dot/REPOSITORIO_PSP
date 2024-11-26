package n2;


class TMethodsPriorityPrincipal2 extends Thread {
	private int c = 0;
	private boolean stopHilo = false;
	public long getContador () {
		return c;
	}
	public void pararHilo() {
		stopHilo = true;
		
	}
	
	@Override
	public void run () {
		while(!stopHilo) c++;
	}
}
public class MethodsPriorityPrincipal12 {

	public static void main(String[] args) {
		TMethodsPriorityPrincipal2 h1 = new TMethodsPriorityPrincipal2();
		TMethodsPriorityPrincipal2 h2 = new TMethodsPriorityPrincipal2();
		TMethodsPriorityPrincipal2 h3 = new TMethodsPriorityPrincipal2();
		
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();
		
		System.out.println("h2 (Prio. Max: "+h2.getContador());
		System.out.println("h1 (Prio. Normal: "+h1.getContador());
		System.out.println("h3 (Prio. Min: "+h3.getContador());
	}
}
