package hoo;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class Login extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String temp=request.getParameter("option");
    String id=request.getParameter("login");  
    String password=request.getParameter("password");  
    ServletContext context=getServletContext();  
  
    if(temp.equals("Student"))
    context.setAttribute("tableName","mca");      
    else
        context.setAttribute("tableName","teacher");
        context.setAttribute("id",id);  
     //context.setAttribute("logout","false");  

    
  //       RequestDispatcher rd=request.getRequestDispatcher("teacher.html");  
    //    rd.forward(request, response);
    if(temp.equals("Admin"))
        if(id.equals("9999")&&password.equals("hello"))
        {
            HttpSession session=request.getSession();
            if(session!=null)
            {
       RequestDispatcher rd=request.getRequestDispatcher("admin.html");  
        rd.forward(request, response);   
        }}
        
    if(temp.equals("Teacher"))
       if(new dataBase().isTeacherExit(id,password))
       {
           HttpSession session1=request.getSession();
       if(session1!=null){
        RequestDispatcher rd=request.getRequestDispatcher("teacher.html");  
        rd.forward(request, response); 
      }
       }
    
   if(temp.equals("Student"))
       if(new dataBase().isStudentExit(id,password))
       {
           HttpSession session2=request.getSession();
       if(session2!=null)
       {
        RequestDispatcher rd=request.getRequestDispatcher("student.html");  
        rd.forward(request, response); 
       } 
      }
        
       
    
        out.print("Sorry UserName or Password Error!");  
        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        rd.include(request, response);  
                      
        }  
}

    