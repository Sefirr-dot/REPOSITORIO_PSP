package ejer1Ayuda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarNumero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> listaNumeroArrayList = new ArrayList<Integer>();
		String num1 = "";
		
		while((num1 =  bReader.readLine())!=null && !num1.isBlank()) {
			listaNumeroArrayList.add(Integer.parseInt(num1));
		}
		Collections.sort(listaNumeroArrayList);
		
		for (Integer integer : listaNumeroArrayList) {
			System.out.println(integer);
		}
	}

}
