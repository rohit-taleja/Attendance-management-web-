package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "viewCgpa", urlPatterns = {"/viewCgpa"})
public class viewCgpa extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
  
        HttpSession session2=request.getSession();    
        if(session2==null) 
         {
              RequestDispatcher rd=request.getRequestDispatcher("exit.html"); 
                rd.forward(request, response);
         }       
        
//        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
         ServletContext context=getServletContext();  
         String id=(String)context.getAttribute("id");
               float a=new dataBase().returnCgpa(id);
 
               out.print("cgpa "+a);
         
 }
}
