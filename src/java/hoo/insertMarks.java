package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "insertMarks", urlPatterns = {"/insertMarks"})

public class insertMarks extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // String rollno=request.getParameter("rollno");
        String pca101=request.getParameter("pca101");
        String pca102=request.getParameter("pca102");
        String pca103=request.getParameter("pca103");
        String rollno=request.getParameter("id");
        new dataBase().insertMarks(rollno,pca101,pca102,pca103);       
       
         RequestDispatcher rd=request.getRequestDispatcher("/imarks.html");  
        rd.include(request, response);  
        
   }
}
    