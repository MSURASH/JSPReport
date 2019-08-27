package connector;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


@WebServlet("/PDFtoHTTP")
public class PDFtoHTTP extends HttpServlet {
	String str="pdf";
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	Document document = null;
	ServletOutputStream servletOutputStream = null;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try
		{ 
		    document=new Document();
		    if(str.equals("pdf"))
		    {
		        response.setContentType("application/pdf");	        
		        servletOutputStream = response.getOutputStream();
		        PdfWriter.getInstance(document,response.getOutputStream());
		        

		    }
		    con= DBConnector.connect();
		    String sql = "select * from team order by teams";          //Fetching data from table
		    try {
				st=con.createStatement();
				rs=st.executeQuery(sql);

			                
		    
		       
		    document.open();

		    /* new paragraph instance initialized and add function write in pdf file*/
		    document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
		    document.add(new Paragraph("                              CREATED REPORT BY- Mohammad Sufian Rashidi\n\n"));
		    document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
		    document.addCreationDate();
		    
		    
				while(rs.next())
				{
				      // fetch & writing records in pdf files
				    document.add(new Paragraph("Order Number ::"+rs.getInt("DOCO")+"\nTEAMS ::"+rs.getString("TEAMS")+"\nLine Number ::"+rs.getInt("LNID")+"\nCITY ::"+rs.getString("CITY")+"\n\n"));
				}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    document.add(new Paragraph("---------------------------------------------------------PAGE NO::"+document.getPageNumber()+"------------------------------------------------------"));
		   // document.add(new Paragraph("---------------------------------------------------------THE END------------------------------------------------------"));


		}
		catch(DocumentException e) 
		{
		        e.printStackTrace();
		            System.err.println("document: " + e.getMessage());
		            
		}
		finally {
			
			document.close(); //document instance closed
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //db connection close
		    
		    
		} 
	}

}
