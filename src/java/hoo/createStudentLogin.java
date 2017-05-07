package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "createStudentLogin", urlPatterns = {"/createStudentLogin"})
public class createStudentLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String name=request.getParameter("sname");
    String id=request.getParameter("sid");  
    new dataBase().createStudentLogin(id,name);
    RequestDispatcher rd=request.getRequestDispatcher("slogin.html");  
            rd.include(request, response);  
    }

}
