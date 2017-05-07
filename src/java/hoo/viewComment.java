package hoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "viewcomment", urlPatterns = {"/viewcomment"})
public class viewComment extends HttpServlet {

   
   public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
   response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
     
  
    try{
         ResultSet res=new dataBase().returnComment();
        while(res.next())
        {
             out.print("<body><font size=4>ROLL NO:"+res.getString(1)+"<font size=4>Comments:"+res.getString(2)+"<br>");
        }
                
    }catch(Exception e){}
 
  //  out.print("<body><table><tr><td><font size=4>ROLL NO:</td><td></td><td>"+3444+"</td></tr>"
       //         + "<tr><td><font size=4>Comments:</td><td></td><td>"++"</td><tr></table>");
    /*out.print("<body><table><tr><td><font size=4>ROLL NO:</td><td></td><td>152424624</td></tr>"
                + "<tr><td><font size=4>Comments:</td><td></td><td>shhjshjhds"
                + "dsjgdsgjghjdgcgsjgdcgjsgckdksgckusgdcuksgbcdgkdshc"
                + "cdkjgsjkcgkgsdkcdgskcggkc"
                + "dljhbcksjgkckjse<br>ugugfegfuguehfhoeihfiyhfeioyhoiifehiewhyioyfiohweoirfhiowyhefiheihfoiiokd"
                + "dscbskjdckjcd</td><tr></table>");
 */
   }
  }
