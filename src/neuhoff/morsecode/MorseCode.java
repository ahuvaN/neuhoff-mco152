package neuhoff.morsecode;

import java.util.ArrayList;

public class MorseCode {
	String[] alphabet;
	String[] morseCode;

	public MorseCode() {
		this.alphabet = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", " "};
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
				"-..-", "-.--", "--..", " "};
	}

	public String encode(String message) {
		String[] tokens = message.split("");
		String code = "  ";

		for (String s : tokens)
			for (int i = 0; i < alphabet.length; i++) {
				if (s.equalsIgnoreCase(alphabet[i])) {
					code += morseCode[i] + " ";
					break;
				} else if (s.contains(" ")) {
					code += "  ";
					break;
				}
			}
		code = code.trim();
		return code;
	}

	public String decode(String code) {
		String[] tokens = code.split(" ");
		char[] msg = new char[100];
		int x = 0;

		for (int s = 0; s <tokens.length; s++) {
			for (int i = 0; i < morseCode.length; i++) {
				if (x < msg.length) {
					if (tokens[s].equalsIgnoreCase(morseCode[i])) {
						msg[x++] = alphabet[i].charAt(0);
						break;
					} else if (tokens[s].equals("") && tokens[s++].equals("")) {
						msg[x++] = ' ';
						break;
					}
				}
			}
		}
		String message = new String(msg);
		return message.trim();
	}

}