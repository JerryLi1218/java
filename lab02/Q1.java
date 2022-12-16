package lab02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/*
 * create table Book (
 * id int(5) not null,
 * title varchar(100) not null,
 * pubDate date not null,
 * author char(50),
 * primary key (id)
 * );
 */

public class Q1 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
				String option = null;
				Scanner scanner = new Scanner(System.in);
				
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
				
				
				
				loop:while(true) {
					System.out.println("查看\t加入\t更新\t退出");
					System.out.print("选择要进行的操作：");
					option = scanner.nextLine();
					
					switch(option) {
					case "查看":
						System.out.println("选择想要查看的字段：");
						String field = scanner.nextLine();
						System.out.println("输入想要查询的条件：");
						String queryConditions = scanner.nextLine();
						ResultSet resultSet = statement.executeQuery("SELECT " + field + " FROM staff WHERE " + queryConditions + ";");
					    System.out.println("查询结果为:");
					    while (resultSet.next()) {
							for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
							    System.out.print(resultSet.getString(i) + "\t");
							}
							System.out.println();
					    }
					    break;
					case "加入":
					    System.out.println("请输入字段的值:");
					    String value = scanner.nextLine();
					    statement.execute("INSERT INTO staff VALUE(" + value + ");");
					    break;
					case "更新":
					    System.out.println("请输入新的值:");
					    String newValue = scanner.nextLine();
					    System.out.println("输入想要查询的条件");
					    String updateConditions = scanner.nextLine();
					    statement.execute("UPDATE staff SET " + newValue + " WHERE " + updateConditions + ";");
					    break;
					case "退出":
					    System.out.println("已退出");
					    break loop;
					default:
					    System.out.println("ERROR");
					}
				 }	
	}

}
