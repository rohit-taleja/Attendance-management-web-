package hoo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "resetPassword", urlPatterns = {"/resetPassword"})
public class resetPassword extends HttpServlet {
    
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");  
         
        PrintWriter out = response.getWriter();  
         
       String id=request.getParameter("id");  
         
     if(id.charAt(1)=='2')
     new dataBase().resetPin(id,"mca");
   else 
        new dataBase().resetPin(id,"teacher");
    }}

