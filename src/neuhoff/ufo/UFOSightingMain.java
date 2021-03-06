package neuhoff.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));
		
		Gson gson = new Gson();
		//this will create a gson UFOSightingList
		UFOSightingList list = gson.fromJson(in, UFOSightingList.class);
		System.out.println(list.size());
		
		in.close();
	}

}
