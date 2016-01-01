package neuhoff.twitter;

import org.eclipse.jetty.server.Server;

public class TwitterJettyServer {

	public static void main(String[] args) throws Exception{
		Server server = new Server(8080); //port number
		
		//single server responsibility
		//handler sends a request
		server.setHandler(new TwitterHandler());
		
		server.start();
		server.join();
	}
}
