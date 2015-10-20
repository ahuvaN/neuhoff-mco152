package neuhoff.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

public class TopTenLocations {

	public static void main (String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));
		
		Gson gson = new Gson();
		
		//this will create a Gson UFOSightingList
		UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
		//find top ten location and print in order
		in.close();
		
		//maps location to occurences
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		String key = null;
		for(int i = 0; i < list.size(); i++){
			key = list.get(i).getLocation().trim();
			int counter = count.containsKey(key) ? count.get(key) : 0;
			count.put(key, counter + 1);
		}
		
		//reverces the order to get the location from the number of occurences
		HashMap<Integer, String> rev = new HashMap<Integer, String>();
	    	for(Map.Entry<String, Integer> entry : count.entrySet()){
	    		rev.put(entry.getValue(), entry.getKey());
	    }
		
	    List<Integer> countList = new ArrayList<Integer>(count.values());
		Collections.sort(countList, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++){
			sb.append(i + 1);
			sb.append(". ");
			sb.append(rev.get(countList.get(i)));
			sb.append(" - ");
			sb.append(countList.get(i));
			sb.append(" sightings\n");
		}
		System.out.println(sb.toString());
		
	}
}
