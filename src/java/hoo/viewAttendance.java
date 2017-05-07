package hoo;
import java.sql.*; 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "viewAttendance", urlPatterns = {"/viewAttendance"})
public class viewAttendance extends HttpServlet {
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         ServletContext context=getServletContext();  
      
         String id=(String)context.getAttribute("id");
               String tablename=(String)context.getAttribute("tableName"); 
               

    ResultSet res=new dataBase().returnAttendance(id);
     String str;
    try{
        if(res.next())
        {
            str=res.getString("attendance");
          out.print("<body><table border=1><tr><td><font size=4>Date&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>"
                + "<td><font size=4>Attendance&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;</font></td></tr>");
         out.print("<tr><td>"+res.getString("dob")+"</td><td>"+str+"</td></tr>");
        }
          while(res.next())
              out.print("<tr><td>"+res.getString("dob")+"</td><td>"+res.getString("attendance")+"</td></tr>");
      /*
          out.print("<body><table border=1><tr><td><font size=4>Subject Code&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>"
                + "<td><font size=4>Marks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;</font></td></tr>"*/
                 // out.print("<tr><td>"+res.getString("dob")+"</td><td>"+res.getString("attendance")+"</td></tr>");
               // + "<tr><td>PCA-102</td><td>"+str2+"</td></tr>"
               // + "<tr><td>PCA-103</td><td>"+str3+"</td></tr></table>");
          
         
    }catch(Exception e){}
}}