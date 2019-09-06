package connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connector.Data;


@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Data> dd = show();
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(gson.toJson(dd));
	       // System.out.println(dd);
	       // out.flush();

//			for(Data d : dd) {
//				//response.getWriter().println(d.getDoco()+" "+d.getLnid()+" "+d.getTeam()+" "+d.getCity());
//				//String employeeJsonString = gson.toJson(d.getDoco(),d.getLnid(),d.getTeam(),d.getCity());
//				PrintWriter out = response.getWriter();
//		        response.setContentType("application/json");
//		        response.setCharacterEncoding("UTF-8");
//		        out.print(gson.toJson(d.getDoco()+""+d.getLnid(),d.getTeam(),d.getCity()));
//		        out.flush();
//
//			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		private List<Data>  show() throws ClassNotFoundException, SQLException {

			String jsonData = null, query = "";
		List<Data> data = new ArrayList<>();
		Connection con = connect();
		Statement st = con.createStatement();
		
				query  = "select * from team order by teams";
				ResultSet rs = st.executeQuery(query);

				while(rs.next()) {
					data.add(new Data(rs.getInt("doco"),rs.getInt("lnid"),rs.getString("teams"),rs.getString("city")));
					//jsonData = gson.toJson(new Data(rs.getInt("doco"),rs.getInt("lnid"),rs.getString("teams"),rs.getString("city")));
					//data.add(gson.toJson(new Data(rs.getInt("doco"),rs.getInt("lnid"),rs.getString("teams"),rs.getString("city"))));


				}
		
		
		
		return data;

	}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Data> memoryLeak = new ArrayList<>();
			int counter = 0;
			while(counter < 5000000) {		
				//memoryLeak.add(new Data());
				counter++;
			}
			System.out.println("Done");
		
		}
	
				private Connection connect() throws SQLException, ClassNotFoundException {
				
				String url = "jdbc:oracle:thin:@localhost:1521/orcl.rev.global.pvt";
				String user = "JDE";
				String password = "jde01";
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(url,user,password);
				System.out.println("Database Ready...");
		
				return con;
			}
	

}
