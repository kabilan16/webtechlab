import java.sql.*;  
import java.lang.ClassNotFoundException;
import java.util.Scanner;
class jdbc1
{  
	static String calcgrade(int m1,int m2,int m3)
	{
		float avg=(float)(m1+m2+m3)/3;
		if(avg>90 && avg<=100)
			return "O";
		else if(avg>80 && avg<=90)
			return "A+";
		else if(avg>70 && avg<=80)
			return "A";
		else if(avg>60 && avg<=70)
			return "B+";
		else if(avg>50 && avg<=60)
			return "B";
		else 
			return "C";
	}
	public static void main(String args[])
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kabilan","root","2019115044");  
			Statement stmt=con.createStatement();  
			/*String temp1="CREATE TABLE students "+"(id INTEGER PRIMARY KEY, " +" name VARCHAR(255), " +" ADS INTEGER, " + "OS INTEGER, " + " ALGO INTEGER, " +" CGPA VARCHAR(10))";
			stmt.executeUpdate(temp1);
			*/
			String temp1="";
			Scanner obj=new Scanner(System.in);
			/*System.out.println("Enter the number of students");
			int n=obj.nextInt();
			obj.nextLine();
			String name="",cgpa;
			int rollno,ads,os,algo;
			int i=0;
			while(i<n)
			{
				
				System.out.println("Enter name");
				name=obj.nextLine();
				System.out.println("Enter rollno");
				rollno=obj.nextInt();
				System.out.println("Enter ADS marks");
				ads=obj.nextInt();
				System.out.println("Enter OS marks");
				os=obj.nextInt();
				System.out.println("Enter ALGO marks");
				algo=obj.nextInt();
				obj.nextLine();
				temp1="insert into students values("+rollno+","+"'"+name+"',"+ads+","+os+","+algo+", 'NA')";
				stmt.executeUpdate(temp1);
				i++;
			}
			*/
			int mark1=0,mark2=0,mark3=0;
			System.out.println("\nSTUDENT DATABASE\n");
			ResultSet rs=stmt.executeQuery("select * from students");
			while(rs.next())  
			{
				mark1=rs.getInt(3);
				mark2=rs.getInt(4);
				mark3=rs.getInt(5);
				System.out.println("\nRoll No: "+rs.getInt(1)+"\nName: "+rs.getString(2)+"\nADS: "+mark1+"\nOS: "+mark2+"\nALGO: "+mark3+"\nGPA: "+rs.getString(6)+"\n");
				String grade=calcgrade(mark1,mark2,mark3);
				System.out.println("\nCalculating CGPA....\n");
				System.out.println("CGPA: "+grade+"\n");
			}
			con.close();
			
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