package neuhoff.anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String[] args) {
	
		/**
		 * Best algorithm would be to map each of the 26 English characters
		 * to a unique prime number. Then calculate the product of the string.
		 * By the fundamental theorem of arithmetic, 2 strings are anagrams if
		 * and only if their products are the same.
		 */

		String[] alpha = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", "ñ", "é"};
		
		Integer[] prime = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
				37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107};
		
		HashMap<String, Integer> primeNumbers = new HashMap<String, Integer>();

		//writes a alphabet symbol to its numeric prime number HashMap
		//writes a alphabet symbol to its numeric prime number HashMap
				for(int i = 0; i < alpha.length; i++){
					primeNumbers.put(alpha[i], prime[i]); 
				} 
	
		// creates a hashMap of all the words in the dictionary with a value of unique product
		// a second hashMap counts occurrence of each product code
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
		
		Integer product;
		String word;
		try {
			Scanner input = new Scanner(new File("./Us.dic"));
			while (input.hasNext()) {
				product = 1;
				word = input.nextLine().toLowerCase();
				String[] tokens = word.split("");
				for (int x = 0; x < tokens.length; x++) {
					product *= primeNumbers.get(tokens[x]);
				}
				
				dictionary.put(word, product); // creates a field of word and unique product
				
				// if the product does not yet exist input a new occurrence
				if (!counter.containsKey(product)){ 
					counter.put(product, 1);
				}
				//if it does, increase the count of occurrences
				else{
					counter.put(product, counter.get(product)+1);
				}
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		// find which product has the maxNumberOfCounts
		int maxNumberOfCounts = 0;
		int maxProduct = 0;
		for (Integer prod: counter.keySet())	{
			int value = counter.get(prod);
			if (value > maxNumberOfCounts){
				maxNumberOfCounts = value;
				maxProduct = prod;
			}
		}
		
		
		// display all words that exist in the mostAnagrams group based on maxNumberOfCounts
		HashSet<String> set = new HashSet<String>();
		HashMap<Integer, String> reverseDictionary = new HashMap<Integer, String>();
		for (Entry<String, Integer> entry : dictionary.entrySet()) {
		  reverseDictionary.put(entry.getValue(), entry.getKey());
		  if (dictionary.containsValue(maxProduct))
			  set.add(reverseDictionary.get(maxProduct));
		}
		set.remove(null);
		
		System.out.print(maxNumberOfCounts);
		System.out.print(" words: ");
		System.out.println(set);
	}

}

