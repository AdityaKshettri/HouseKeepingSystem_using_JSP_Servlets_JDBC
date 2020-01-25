/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class allocatetask extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        pwriter.print("<html><h1>...Allocate Tasks...</h1><br>");
	pwriter.print("<body><form action='addTaskAllocatedInDB' method='POST'>");
        pwriter.print("assetId :<input type='text' name='assetId'/><br/>");
        pwriter.print("taskId :<input type='text' name='taskId'/><br/>");
        pwriter.print("workerId :<input type='text' name='workerId'/><br/>");
        pwriter.print("timeOfAllocation :<input type='text' name='timeOfAllocation'/><br/>");
        pwriter.print("taskToBePerformedBy :<input type='text' name='taskToBePerformedBy'/><br/>");
        pwriter.print("<input type='submit' value='submit'/>");
	pwriter.print("</form></body></html>");
        pwriter.close();
   }
   catch(Exception exp)
   {
       System.out.println(exp);
    }
  }

    

}
