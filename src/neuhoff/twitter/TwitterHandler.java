package neuhoff.twitter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class TwitterHandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// TODO Auto-generated method stub
		//how the server tells web browser what it is downloading- html/img....
		response.setContentType("text/html;charset=utf-8");
		//status- tells browser what type of response this is SC_OK = 200
		response.setStatus(HttpServletResponse.SC_OK);
		//tell the request that its been handled
		baseRequest.setHandled(true);
		//now the output is sent in html code
		response.getWriter().println("<h1>Hello World</h1>");
		
	}

	
}
