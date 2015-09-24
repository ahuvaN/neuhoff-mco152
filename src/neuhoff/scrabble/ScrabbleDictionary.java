package neuhoff.scrabble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {
		this.dictionary = new HashSet<String>();
		try {
			BufferedReader input = new BufferedReader(
					new FileReader("./Us.dic"));

			String line;
			while ((line = input.readLine()) != null) {
				this.dictionary.add(line);
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
