/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aditya Kshettri
 */
public class assetsall extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
          
        
        final String driver="org.apache.derby.jdbc.ClientDriver";
        final String DB_URL = "jdbc:derby://localhost:1527/aditya";
        final String USER = "aditya";
        final String PASS = "1234";
        Connection con=null;
        Class.forName(driver);
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        
        int f=0;
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM ASSET");
        pwriter.print("<html>");
        while (rs.next())
        {
            f++;
            String assetid=rs.getString("assetId");
            String assetname=rs.getString("assetname");
            String quantity=rs.getString("quantity");
            String place=rs.getString("place");
            pwriter.print("ID : "+assetid+" Name : " + assetname+"  Quantity : "+quantity+" place : "+place+"<br>");
        }
        rs.close();
        if(f==0)
            pwriter.print("Table Empty...<br>");
        else
            pwriter.print("<br>Total no. of assets : "+f+"<br>");
        
        pwriter.print("<a href='http://localhost:8080/Udaan/index.html'>Click here to return to homepage</a>");
	pwriter.print("</body></html>");
        pwriter.close();
   }
   catch(Exception exp)
   {
       System.out.println(exp);
    }
  }
}
