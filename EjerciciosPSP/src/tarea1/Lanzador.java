package tarea1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Lanzador {

	public static void main(String[] args) throws IOException, InterruptedException {
		String clase = args[0];
		String siOno = args[1];
		
		File pathFile = new File("..\\bin");
		
		Process processTrProcess = new ProcessBuilder("java", clase,siOno).redirectErrorStream(true).directory(pathFile).start();

		if(siOno.toLowerCase().equals("si")) {
			processTrProcess.waitFor();
			InputStream inputStream = processTrProcess.getInputStream();
			
			BufferedReader br1 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			var lines = br1.lines();
			
			String s1 = lines.collect(Collectors.joining("\n"));
			
			processTrProcess.onExit().defaultExecutor().execute(() -> System.out.println(s1));
		}		
		
	}

}
