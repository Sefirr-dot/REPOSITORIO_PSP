package ejerciciosEjemplo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class LanzarSumador {

	public void ejecutar(String ruta) {
		ProcessBuilder pBuilder;
		String param1="", param2="";
		String clase1="ejerciciosEjemplo.Sumador";
		try {
			pBuilder = new ProcessBuilder(ruta,param1,param2);
			pBuilder.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		int n1 = 20;
		int n2 =40;
		Process process;
		
		String comando = "ejerciciosEjemplo.Sumadores";
		
		File directorioSumador = new File(".\\bin");
		ProcessBuilder pBuilder = new ProcessBuilder("java",comando,String.valueOf(n1),String.valueOf(n2));
		pBuilder.directory(directorioSumador);
		process = pBuilder.start();
		
		System.out.println("Suma lanzada...");
		
		Thread.sleep(5000);
		InputStream inputStream = process.getInputStream();
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
		
		var lines = bReader.lines();
		
		String sumaTotal = lines.collect(Collectors.joining("\n"));
		System.out.println("La suma total es: "+ sumaTotal);
	}
	
	public void lanzarSumadorL(Integer n1, Integer n2, String fichResul) {
		String clase1="ejerciciosEjemplo.Sumador";
		ProcessBuilder pBuilder;
		File pathFile = new File("C:\\Users\\Alumno\\Desktop\\PSP\\REPOSITORIO_PSP\\UT1_EjemplosClase\\src\\ejerciciosEjemplo\\Sumador.java");
		try {
			pBuilder = new ProcessBuilder("java",clase1,n1.toString(),n2.toString()).directory(pathFile);
			pBuilder.redirectError(new File("errorLanzador.txt"));
			pBuilder.redirectOutput(new File(fichResul));
			pBuilder.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
