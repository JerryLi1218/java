package unit08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestPerson {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {

		//---//创建一个Connection
		
		//声明connection对象
		Connection con;
		//驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		//URL指向访问的数据库名java_book
		String url = "jdbc:mysql://localhost:3306/hello?characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai";
		//用户名
		String user = "root";
		//密码
		String password = "zy06241224";
		//---//
		

			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database");
			var statement = con.createStatement();
			
			//statement.executeUpdate("insert into student(id,name,age,gender) values(\"1234567896\",\"柴油发电机\",99,1) ");
			statement.executeUpdate("update student set name = \"柴油发癫机\" where id = \"1234567896\"");
			var rs = statement.executeQuery("select * from student");
		
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
		
		
	}

}
