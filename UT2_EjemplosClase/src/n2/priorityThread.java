package n2;

class hP extends Thread {
	String textoString;
	
	public hP (String tex) {
		super();
		this.textoString = tex;
	}
	public void run () {
		int count = 0;
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count == 10) {
				count = 0;
			}
			System.out.println(textoString+": "+count++);
		}
	}
}

public class priorityThread {

	public static void main(String[] args) {
		hP h1 = new hP("thread1");
		h1.setPriority(10);
		hP h2 = new hP("thread2");
		h1.setPriority(8);
		hP h3 = new hP("thread3");
		h1.setPriority(6);
		hP h4 = new hP("thread4");
		h1.setPriority(4);
		hP h5 = new hP("thread5");
		h1.setPriority(2);
		h5.start();
		h4.start();
		h3.start();
		h2.start();
		h1.start();
		
	}
}
