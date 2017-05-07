package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "insertGrades", urlPatterns = {"/insertGrades"})
public class insertGrades extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rollno=request.getParameter("id");
        String pca101=request.getParameter("pca101");
        String pca102=request.getParameter("pca102");
        String pca103=request.getParameter("pca103");
        
        
            
        new dataBase().insertGrades(rollno,pca101,pca102,pca103);       
  /*
        out.print("<body><table><tr><td><font size=4>ROLL NO:</td><td></td><td>152424624</td></tr>"
                + "<tr><td><font size=4>Comments:</td><td></td><td>shhjshjhds"
                + "dsjgdsgjghjdgcgsjgdcgjsgckdksgckusgdcuksgbcdgkdshc"
                + "cdkjgsjkcgkgsdkcdgskcggkc"
                + "dljhbcksjgkckjse<br>ugugfegfuguehfhoeihfiyhfeioyhoiifehiewhyioyfiohweoirfhiowyhefiheihfoiiokd"
                + "dscbskjdckjcd</td><tr></table>");
    
    */
       String a="rohit";
        
         out.print("<body><table border=1><tr><td><font size=4>Subject Code&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>"
                + "<td><font size=4>Grades&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                + "&nbsp;&nbsp;&nbsp;</font></td></tr><tr><td>PCA-101</td><td>"+a+"</td></tr>"
                + "<tr><td>PCA-102</td><td>333</td></tr>"
                + "<tr><td>PCA-103</td><td>344</td></tr>");
    out.print("<tr><td>PCA-104</td><td>344</td></tr></table>");
    
    


    
    
    
    }}