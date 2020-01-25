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
public class addTaskAllocatedInDB extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
          
	String assetId = request.getParameter("assetId");
        String taskId = request.getParameter("taskId");
        String workerId = request.getParameter("workerId");
        String timeOfAllocation = request.getParameter("timeOfAllocation");
        String taskToBePerformedBy = request.getParameter("taskToBePerformedBy");
        
        final String driver="org.apache.derby.jdbc.ClientDriver";
        final String DB_URL = "jdbc:derby://localhost:1527/aditya";
        final String USER = "aditya";
        final String PASS = "1234";
        Connection con=null;
        Class.forName(driver);
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        
        PreparedStatement st=con.prepareStatement("INSERT INTO TASKALLOCATED(assetId,taskId,workerId,timeOfAllocation,taskToBePerformedBy) VALUES(?,?,?,?,?)");
        st.setString(1,assetId);
        st.setString(2,taskId);
        st.setString(3,assetId);
        st.setString(4,timeOfAllocation);
        st.setString(5,taskToBePerformedBy);
        int a=st.executeUpdate();
        pwriter.print("<html>");
        
        if(a>0)
            pwriter.print("<body>Task successfully allocated<br>");
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
