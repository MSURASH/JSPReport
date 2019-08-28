package connector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connector.Data;


@WebServlet("/MemoryLeakDebug")
public class MemoryLeakDebug extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Data> memoryLeak = new ArrayList<>();
		int counter = 0;
		while(counter < 500000) {		
			memoryLeak.add(new Data());
			counter++;
		}
		System.out.println("Done");
	}

}
