package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "insertAttendance", urlPatterns = {"/insertAttendance"})
public class insertAttendance extends HttpServlet {

    
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      String rollno=request.getParameter("option");
      String date=request.getParameter("date");
      String attendence=request.getParameter("radio");
      new dataBase().insertAttendance(rollno,date,attendence);     
   }
}