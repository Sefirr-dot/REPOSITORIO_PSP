package ejerciciosEjemplo;

import java.io.*;
import java.nio.charset.Charset;

public class ProcessTercerPrincipalExecutor {
	
	//ruta a los .class porque los vamos a invocar
	//static File path = new File(".\\bin");
	private final static File FILE = new File("exportT.txt");
	private final static String ENTER = "\n";
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
		File path = new File(".\\bin");
		Process processTr = new ProcessBuilder("java","ejerciciosEjemplo.TransformaString")
				.redirectErrorStream(true).directory(path).start();	
		Process processEx = new ProcessBuilder("java","ejerciciosEjemplo.ExportarAFile",FILE.toString())
				.redirectErrorStream(true).directory(path).start();
		
		
		
		OutputStream osProcTrStream = processTr.getOutputStream();
		InputStream isProcTrStream = processTr.getInputStream();
		OutputStream osProcExStream = processEx.getOutputStream();
		
		System.out.println("Introduce texto a formatear:");
			
		InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(ipsr);
		BufferedReader brTr = new BufferedReader(new InputStreamReader(isProcTrStream,Charset.forName("UTF-8")));
		//BufferedReader brTr = new BufferedReader(new OputStreamReader(osProcTrStream,Charset.forName("UTF-8")));
		String line = "";
			
			do {
				line = br.readLine();
				
				osProcTrStream.write((line+ENTER).getBytes());
				osProcTrStream.flush();
				
				String lineTr = brTr.readLine();
				System.out.println(lineTr);
				
				osProcExStream.write((lineTr+ENTER).getBytes());
				osProcExStream.flush();
				
			} while (!line.isBlank());
			
			if (processEx.waitFor()==0 && processTr.waitFor() ==0)
				System.out.println("Terminó la ejecución");
			else
				System.out.println("Se produjo un fallo");
	
	}

}