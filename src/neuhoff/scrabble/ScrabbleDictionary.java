package neuhoff.scrabble;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	private HashSet<String> dictionary;

	public ScrabbleDictionary() {
		this.dictionary = new HashSet<String>();
		try {
			Scanner input = new Scanner(new File("./Us.dic"));

			while (input.hasNext()) {
				this.dictionary.add(input.nextLine());
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	/**
	 * @return true if the dictionary contains the word, otherwise false.
	 */
	public boolean contains(String word) {
		
		return dictionary.contains(word.toLowerCase());

	}
}
