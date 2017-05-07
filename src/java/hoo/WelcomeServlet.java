package hoo;
import java.io.*;
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class WelcomeServlet extends HttpServlet {  
  
    public void dopost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
 
     response.setContentType("text/html");  
     PrintWriter out = response.getWriter();  
    HttpSession session=request.getSession();
    out.print(session);
    if(session!=null)
    session.invalidate();  
    HttpSession session1=request.getSession();
    if(session1!=null)
    session1.invalidate();  
    HttpSession session2=request.getSession();
    if(session2!=null)
    session2.invalidate();  
        
     //  ServletContext context=getServletContext();  
    // context.setAttribute("logout","true");
    
        
  }}  