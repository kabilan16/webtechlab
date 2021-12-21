import java.sql.*;  
import java.lang.ClassNotFoundException;
import java.util.Scanner;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DataStudent extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int rollno=Integer.parseInt(req.getParameter("rollno"));
		pw.println("Welcome to grade page: "+rollno);
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kabilan","root","2019115044");  
			Statement stmt=con.createStatement();  
			String temp1="";
			Scanner obj=new Scanner(System.in);
			int mark1=0,mark2=0,mark3=0;
			System.out.println("\nSTUDENT DATABASE\n");
			ResultSet rs=stmt.executeQuery("select * from students where id="+rollno);
			
			while(rs.next())  
			{
				mark1=rs.getInt(3);
				mark2=rs.getInt(4);
				mark3=rs.getInt(5);
				pw.println("\nRoll No: "+rs.getInt(1)+"\nName: "+rs.getString(2)+"\nADS: "+mark1+"\nOS: "+mark2+"\nALGO: "+mark3+"\nGPA: "+rs.getString(6)+"\n");
				/*String grade=calcgrade(mark1,mark2,mark3);
				System.out.println("\nCalculating CGPA....\n");
				System.out.println("CGPA: "+grade+"\n");*/
			}
			pw.println("\nDone");
			con.close();
			System.out.println("\nFinished\n");
		} 
		catch(SQLException e)
		{ 
			System.out.println(e);
			e.printStackTrace();
		}  
		catch(ClassNotFoundException ce)
		{
			System.out.println(ce);
		}

	}
}
