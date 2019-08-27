<%@page import="javax.swing.border.TitledBorder"%>
<%@page import="java.sql.*"%>
<%@page import="com.lowagie.text.DocumentException"%>
<%@page import="com.lowagie.text.Paragraph"%>
<%@page import="com.lowagie.text.html.HtmlWriter"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.Document"%>
<%@page import="java.io.*"%>;
<%@page import="java.awt.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>
<%@page import="com.lowagie.text.html.*"%>
<%@page import="connector.DBConnector"%>
<%@page import="java.awt.*"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>
<%@page import="com.lowagie.text.html.*"%>
<%@page import="java.io.OutputStream"%>
<%
String str="pdf";

Connection con=null;
Statement st=null;
ResultSet rs=null;
Document document = null;
ServletOutputStream servletOutputStream = null;
try
{ 
    document=new Document();
    if(str.equals("pdf"))
    {
        response.setContentType("application/pdf");
        
       // response.setHeader("Content-Disposition",  "inline; filename=report.pdf ");

      //  response.setContentType("application/vnd.ms-excel");
        //response.setHeader("Content-Disposition", "inline: filename=sufian.xls");
        servletOutputStream = response.getOutputStream();
        PdfWriter.getInstance(document,servletOutputStream);
        

    }
    con= DBConnector.connect();
    String sql = "select * from team order by teams";          //Fetching data from table
    st=con.createStatement();                // executing query
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
    document.add(new Paragraph("---------------------------------------------------------PAGE NO::"+document.getPageNumber()+"------------------------------------------------------"));
    
    
}
catch(DocumentException e) 
{
        e.printStackTrace();
            System.err.println("document: " + e.getMessage());
            
}
finally {
	
	document.close(); //document instance closed
	
	con.close();  //db connection close
    
    
} 


%>