package hoo;
import java.sql.*;  

public class dataBase{  
Connection con;
PreparedStatement pstmt;
Statement stmt;
ResultSet res;

dataBase()
{
try{   
Class.forName("oracle.jdbc.driver.OracleDriver");  
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ramramram1");  
stmt=con.createStatement();  
  }catch(Exception e){}
}

dataBase(String rollno,String name)
{
    this();
    try{
    stmt.executeUpdate("insert into mca  values('"+rollno+"','"+name+"','newemail','')") ;
    }catch(Exception e){}
}

void insertComment(String id,String msg)
{
  try{
   stmt.executeUpdate("insert into message values('"+id+"','"+msg+"')") ;
   }catch(Exception e){}
}

ResultSet returnComment()
{
     try{
   res=stmt.executeQuery("select *from message");
   }catch(Exception e){}
return res;
}
 

// to excecute inserMarks pca101,pca102,pca103 must be in mca table
void insertMarks(String rollno,String pca101,String pca102,String pca103)
{
   try{
   stmt.executeUpdate("update mca set pca101='"+pca101+"',pca102='"+pca102+"',pca103='"+pca103+"'where id='"+rollno+"'"); 
   }catch(Exception e){}
}
void insertGrades(String rollno,String pca101,String pca102,String pca103)
{
   try{
   stmt.executeUpdate("update mca set pca101grade='"+pca101+"',pca102grade='"+pca102+"',pca103grade='"+pca103+"'where id='"+rollno+"'"); 
   }catch(Exception e){}
}


void insertAttendance(String id,String date,String attendence)
{
   try{    
       stmt.executeUpdate("insert into date2 values('"+date + "','"+id+"','"+attendence+"')");
      }catch(Exception e){}
}

boolean isTeacherExit(String id,String pass)
{
try{
ResultSet res=stmt.executeQuery("select * from teacher where id='"+id+"'");
res.next();
if( res.getString(2).equals(pass))
return true;
}catch(Exception e){}
return false;
}
void changePin(String id,String old,String newpass,String tablename)
{
try{
ResultSet res=stmt.executeQuery("select * from "+tablename+" where id='"+id+"'");
res.next();
if( res.getString(2).equals(old))
stmt.executeUpdate("update "+tablename+" set password ='"+newpass+"' where id='"+id+"'");
}catch(Exception e){}
}



void resetPin(String id,String tablename)
{
try{
stmt.executeUpdate("update "+tablename+" set password ='newemail' where id='"+id+"'");
}catch(Exception e){}
}


boolean isStudentExit(String id,String password)
{
try{
res=stmt.executeQuery("select *from mca where id='"+id+"'");
res.next();
if( res.getString(2).equals(password))
return true;
}catch(Exception e){}
return false;
}

void createStudentLogin(String id,String name) 
{    
     try{
     
   stmt.executeUpdate("insert into mca (id,password,name)  values('"+id+"','newemail','"+name+"')") ;
   
    }catch(Exception e){}
}

ResultSet returnMarks(String id)
{
    try{
        res=stmt.executeQuery("select *from mca where id='"+id+"'");
   
    }catch(Exception e){}
    return res;
}

ResultSet returnAttendance(String id)
{
    try{
        res=stmt.executeQuery("select *from date2 where id='"+id+"'");
    }catch(Exception e){}
    return res;
}

void createTeacherLogin(String id,String name) 
{    
     try{
     
   stmt.executeUpdate("insert into teacher (id,password,name)  values('"+id+"','test123','"+name+"')") ;
   
    }catch(Exception e){}
}

public void insertSubject(String sname)
{
try{
stmt.executeUpdate("alter table mca add("+sname+" varchar2(3))");
stmt.executeUpdate("alter table mca add("+sname+"grade varchar2(3))");

}catch(Exception x){}
}
void insertgrade(String id,String s1,String s2,String s3)
{
try{
stmt.executeUpdate("update mca set pca101grade='"+s1+"',pca102grade='"+s2+"',pca103='"+s3+"' where id='"+id+"'");
}catch(Exception e){}
}


int returnmarks(String str)
{
if(str.equals("A"))
return 50;
if(str.equals("B"))
return 40;
if(str.equals("C"))
return 30;
if(str.equals("D"))
return 20;
return 0;
}

float returnCgpa(String id)
{
float temp=0.0f;
try{
res=stmt.executeQuery("select * from mca where id='"+id+"'");
res.next();
temp=returnmarks(res.getString("pca101grade"));
temp=temp+returnmarks(res.getString("pca102grade"));
temp=temp+returnmarks(res.getString("pca103grade"));
}catch(Exception e){}
temp=temp/15;
return temp;
}
}