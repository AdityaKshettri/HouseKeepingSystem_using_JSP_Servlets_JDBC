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
public class getTask extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        String workerId = request.getParameter("workerId");
        
        final String driver="org.apache.derby.jdbc.ClientDriver";
        final String DB_URL = "jdbc:derby://localhost:1527/aditya";
        final String USER = "aditya";
        final String PASS = "1234";
        Connection con=null;
        Class.forName(driver);
        con=DriverManager.getConnection(DB_URL,USER,PASS);
        pwriter.print("<html>");
        
        int f=0;
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM TASKALLOCATED,TASK WHERE WORKERID="+workerId);
        while (rs.next())
        {
            f++;
            String taskId=rs.getString("taskId");
            //String taskname=rs.getString("taskname");
            pwriter.print("TaskId : " +taskId);//+"    taskname : "+taskname+"<br>");
        }
        rs.close();
        if(f==0)
            pwriter.print("Table Empty...<br>");
        else
            pwriter.print("<br><br>Total no. of tasks the worker has to do : "+f+"<br>");
        
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
