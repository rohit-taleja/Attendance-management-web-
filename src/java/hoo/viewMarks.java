
package hoo;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rohit
 */
@WebServlet(name = "viewMarks", urlPatterns = {"/viewMarks"})
public class viewMarks extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
 
      HttpSession session2=request.getSession();    

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        ServletContext context=getServletContext();  
          String id=(String)context.getAttribute("id");
               String tablename=(String)context.getAttribute("tableName"); 
               

    ResultSet res=new dataBase().returnMarks(id);
     
    String str1;
    String str2;
    String str3;
     
    try{
        
        res.next();
     str1=res.getString("pca101");
     str2=res.getString("pca102");
     str3=res.getString("pca103");
      
          out.print("<body><table border=1><tr><td><font size=4>Subject Code&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>"
                + "<td><font size=4>Marks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;</font></td></tr><tr><td>PCA-101</td><td>"+str1+"</td></tr>"
                + "<tr><td>PCA-102</td><td>"+str2+"</td></tr>"
                + "<tr><td>PCA-103</td><td>"+str3+"</td></tr></table>");
                
    }catch(Exception e){}
    }
}