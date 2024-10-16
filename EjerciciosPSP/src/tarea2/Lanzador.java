package tarea2;

import java.io.File;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ph = args[0];
		
		String num1 = args[0];
		String num2 = args[1];
		
		String phString = "tarea2.Primos";
		
		if(Integer.parseInt(num1)<0 && Integer.parseInt(num2)<1000 && Integer.parseInt(num1)!=Integer.parseInt(num2)) {
			File pathFile = new File("..\\bin\\");
			Process processTrProcess = new ProcessBuilder("java", ph,num1,num2).redirectErrorStream(true).directory(pathFile).start();
			
		} else {
			System.out.println("Error a la hora de introducir los numeros");
		}

	}

}
