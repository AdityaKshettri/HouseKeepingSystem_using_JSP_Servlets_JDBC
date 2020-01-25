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
public class addAssetInDB extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
          
	String assetId = request.getParameter("assetId");
        String assetname = request.getParameter("assetname");
        String quantity = request.getParameter("quantity");
        String place = request.getParameter("place");
        
        final String driver="org.apache.derby.jdbc.ClientDriver";
        final String DB_URL = "jdbc:derby://localhost:1527/aditya";
        final String USER = "aditya";
        final String PASS = "1234";
        Connection con=null;
        Class.forName(driver);
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        
        PreparedStatement st=con.prepareStatement("INSERT INTO ASSET(assetId,assetname,quantity,place) VALUES(?,?,?,?)");
        st.setString(1,assetId);
        st.setString(2,assetname);
        st.setString(3,quantity);
        st.setString(4,place);
        int a=st.executeUpdate();
        pwriter.print("<html>");
        
        if(a>0)
            pwriter.print("<body>Asset successfully added<br>");
        else
            pwriter.print("<body>Inserting data unsuccessful!<br>");
        pwriter.print("<a href='index.html'>Click here to return to homepage</a>");
	pwriter.print("</body></html>");
        pwriter.close();
   }
   catch(Exception exp)
   {
       System.out.println(exp);
    }
  }
}
