package neuhoff.anagram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class MostAnagrams {

	public static void main(String[] args) {

		/**
		 * Best algorithm would be to map each of the 26 English characters to a
		 * unique prime number. Then calculate the product of the string. By the
		 * fundamental theorem of arithmetic, 2 strings are anagrams if and only
		 * if their products are the same.
		 * or you can create a hashmap of sorted array to arraylist of anagrams. 
		 * printout greatest arrayList.length
		 */

		String[] alpha = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", "ñ", "é" };

		Integer[] prime = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
				31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
				101, 103, 107 };

		HashMap<String, Integer> primeNumbers = new HashMap<String, Integer>();

		// writes a alphabet symbol to its numeric prime number HashMap
		// writes a alphabet symbol to its numeric prime number HashMap
		for (int i = 0; i < alpha.length; i++) {
			primeNumbers.put(alpha[i], prime[i]);
		}

		// creates a hashMap of all the words in the dictionary with a value of
		// unique product
		// a second hashMap counts occurrence of each product code
		HashMap<String, Long> dictionary = new HashMap<String, Long>();
		HashMap<Long, Integer> counter = new HashMap<Long, Integer>();

		Long product;
		String word;
		try {
			BufferedReader input = new BufferedReader(
					new FileReader("./Us.dic"));
			while ((word = input.readLine()) != null) {
				product = 1L;

				String[] tokens = word.split("");
				for (int x = 0; x < tokens.length; x++) {
					if (primeNumbers.containsKey(tokens[x])) {
						product *= primeNumbers.get(tokens[x]);
					}
				}

				dictionary.put(word, product); // creates a field of word and
				// unique product

				// if the product does not yet exist input a new occurrence
				if (!counter.containsKey(product)) {
					counter.put(product, 1);
				}
				// if it does, increase the count of occurrences
				else {
					counter.put(product, counter.get(product) + 1);
				}
			}
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// find which product has the maxNumberOfCounts
		int maxNumberOfCounts = 0;
		long maxProduct = 0;
		for (Long prod : counter.keySet()) {
			int value = counter.get(prod);
			if (value > maxNumberOfCounts) {
				maxNumberOfCounts = value;
				maxProduct = prod;
			}
		}

		// display all words that exist in the mostAnagrams group based on
		// maxNumberOfCounts
		HashSet<String> set = new HashSet<String>();
		HashMap<Long, String> reverseDictionary = new HashMap<Long, String>();
		for (Entry<String, Long> entry : dictionary.entrySet()) {
			reverseDictionary.put(entry.getValue(), entry.getKey());
			if (dictionary.containsValue(maxProduct)) {
				set.add(reverseDictionary.get(maxProduct));
			}
		}
		set.remove(null);

		System.out.print(maxNumberOfCounts);
		System.out.print(" words: ");
		System.out.println(set);
	}

}
