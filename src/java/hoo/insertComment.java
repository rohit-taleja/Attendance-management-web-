package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "insertcomment", urlPatterns = {"/insertcomment"})
public class insertComment extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // String rollno=request.getParameter("rollno");
        String msg=request.getParameter("comments");
        
        ServletContext context=getServletContext();  
          String id=(String)context.getAttribute("id");
        out.print(msg+id);
        
        new dataBase().insertComment(id,msg);       
       
  }}


