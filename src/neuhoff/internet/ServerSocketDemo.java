package neuhoff.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) throws IOException {
		//accepts connections
		
		//needs a socket. has to be same number as clients port
		ServerSocket serverSocket = new ServerSocket(52746);
		
		//wait for response
		//this is a blocking call. waits until someone connects to it
		Socket socket = serverSocket.accept();
		
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String response = br.readLine();
		
		System.out.println("RESPONSE: ");
		System.out.println(response);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HOW ARE YOU DOING?");
		out.flush();
		
		serverSocket.close();
		

	}

}
