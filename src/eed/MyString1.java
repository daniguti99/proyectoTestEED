package eed;

import java.util.HashMap;
import java.util.Map;



public class MyString1 {
	
	private String cadena;
	private int contarPalabras;
	private int contarLetrasDiferentes;
	private int contarFrecuenciaPalabras;
	private int contarFrecuenciaLetras;
	private boolean esPalindroma;
	
	
	
	
	public MyString1(String cadena, int contarPalabras, int contarLetrasDiferentes, int contarFrecuenciaPalabras,
			int contarFrecuenciaLetras, boolean esPalindroma) {
		super();
		this.cadena = cadena;
		this.contarPalabras = contarPalabras();
		this.contarLetrasDiferentes = contarLetrasDiferentes;
		this.contarFrecuenciaPalabras = contarFrecuenciaPalabras;
		this.contarFrecuenciaLetras = contarFrecuenciaLetras;
		this.esPalindroma = esPalindroma;
		
		
	}
	
	

	/*Para el método contarPalabras he añadido el .trim para 
	que quite tanto los espacios de delante como los de detrás. Además, en el método 
	contarLetrasDiferentes y es palindroma he añadido para que contemple la ñ*/

// Método para contar el número de palabras en una cadena
	public static int contarPalabras(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		String[] palabras = str.trim().split("\\s+");
		return palabras.length;
	}

// Método para contar el número de letras diferentes en una cadena
	public static int contarLetrasDiferentes(String str) {
		if (str == null || str.isEmpty()) {
			return 0; 
		}
		
		str = str.toLowerCase().replaceAll("[^a-zñ]", "");
		return (int) str.chars().distinct().count(); 
	}

// Método para contar las veces que aparece cada palabra en una cadena
	public static Map<String, Integer> contarFrecuenciaPalabras(String str) {
		Map<String, Integer> frecuenciaPalabras = new HashMap<>();
		if (str == null || str.isEmpty()) {
			return frecuenciaPalabras;
		}
		String[] palabras = str.toLowerCase().split("\\s+");
		for (String palabra : palabras) {
			frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
		}
		return frecuenciaPalabras;
	}

// Método para contar las veces que aparece cada letra en una cadena
	public static Map<Character, Integer> contarFrecuenciaLetras(String str) {
		Map<Character, Integer> frecuenciaLetras = new HashMap<>();
		if (str == null || str.isEmpty()) {
			return frecuenciaLetras;
		}
		str = str.toLowerCase().replaceAll("[^a-z]", "");
		for (char c : str.toCharArray()) {
			frecuenciaLetras.put(c, frecuenciaLetras.getOrDefault(c, 0) + 1);
		}
		return frecuenciaLetras;
	}

// Método para verificar si una palabra es palíndroma
	public static boolean esPalindroma(String palabra) {
		if (palabra == null || palabra.isEmpty()) {
			return false;
		}
		palabra = palabra.toLowerCase().trim().replaceAll("[^a-z]", "");
		int izquierda = 0;
		int derecha = palabra.length() - 1;
		while (izquierda < derecha) {
			if (palabra.charAt(izquierda) != palabra.charAt(derecha)) {
				return false;
			}
			izquierda++;
			derecha--;
		}
		return true;
	}

} 

