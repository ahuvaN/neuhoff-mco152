package neuhoff.morsecode;

import java.util.HashMap;

public class MorseCode {
	String[] alphabet;
	String[] morseCode;
	HashMap<String, String> map;

	public MorseCode() {
		this.alphabet = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z" };
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--.." };

		this.map = new HashMap<String, String>();

		for (int i = 0; i < alphabet.length; i++) {
			map.put(alphabet[i], morseCode[i]);
			map.put(morseCode[i], alphabet[i]);
		}

	}

	public String encode(String message) {
		String[] tokens = message.split("");
		StringBuilder code = new StringBuilder();

		for (String abc : tokens) {
			if (map.containsKey(abc)) {
				code.append(map.get(abc));
				code.append(" ");
			} else {
				code.append("  ");
			}
		}

		return code.toString().trim();
	}

	public String decode(String code) {
		String[] tokens = code.split(" ");
		StringBuilder message = new StringBuilder();

		for (int i = 0; i < tokens.length; i++) {
			if (map.containsKey(tokens[i])) {
				message.append(map.get(tokens[i]));
			} else if (!(map.containsKey(tokens[i]))
					&& !(map.containsKey(tokens[i++]))) {
				message.append(" ");
			}
		}

		return message.toString().trim();

	}

}