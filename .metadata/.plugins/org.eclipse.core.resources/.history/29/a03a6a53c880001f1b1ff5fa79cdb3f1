package ejerciciosEjemplo;

import java.io.File;

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
	
	public static void main(String[] args) {
		
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
