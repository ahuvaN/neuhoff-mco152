package neuhoff.scrabble;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	private ArrayList<String> dictionary;

	public ScrabbleDictionary() {
		this.dictionary = new ArrayList<String>();
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
		for (String d : dictionary) {
			if (d.contains(word)) {
				return true;
			}
		}
		return false;

	}
}
