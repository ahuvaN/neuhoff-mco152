package neuhoff.math;

import java.util.HashMap;
import java.util.Map;

public class UniqueString {

	public static void main(String args[]) {

		String array[] = new String[] { "A", "B", "B", "B", "C" };

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// fill the HashMap
		for (String key : array) {
			Integer value = map.get(key); 
			if (value == null) { //means i have not yet found the letter
				map.put(key, 1); // adding a count of one for the first value
			} else {
				map.put(key, value + 1); //i am adding one more to the counter
			}
		}

		// iterate through the HashMap's key-value pairs
		// only do this if you want to go through the whole map for some reason
		//if you only want to know if something exist- just use .contains or .get != null
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}