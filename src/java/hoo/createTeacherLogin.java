package hoo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "createTeacherLogin", urlPatterns = {"/createTeacherLogin"})
public class createTeacherLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String name=request.getParameter("tname");
    String id=request.getParameter("tid");  
    new dataBase().createTeacherLogin(id,name);
    RequestDispatcher rd=request.getRequestDispatcher("tlogin.html");  
            rd.include(request, response);  
    }
}
