package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "changePin", urlPatterns = {"/changePin"})
public class changePin extends HttpServlet {

     @Override
     public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {
          response.setContentType("text/html");  
           PrintWriter out = response.getWriter();
         
       ServletContext context=getServletContext();  
   
              String id=(String)context.getAttribute("id");  
              String tableName=(String)context.getAttribute("tableName");  
                 
         String confirmpass=request.getParameter("confirmpassword");
         String oldpass=request.getParameter("oldpassword");
         String newpass=request.getParameter("newpassword");
        if(confirmpass.equals(newpass))
         new dataBase().changePin(id,oldpass,newpass,tableName);
     else
        {
        
        }
        }
     }


