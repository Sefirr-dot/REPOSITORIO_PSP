package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarNumeros {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> listaArrayList = new ArrayList<Integer>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		
		String linea = "";
		
		while ((linea = bf.readLine()) != null && !linea.isBlank()) {
			
			//linea = bf.readLine();
			listaArrayList.add(Integer.parseInt(linea));
			
		}
		
		Collections.sort(listaArrayList);
		
		for (Integer num : listaArrayList) {
			
			System.out.println(num);
			
		}

	}

}
