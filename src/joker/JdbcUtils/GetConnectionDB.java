package joker.JdbcUtils;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class GetConnectionDB 
{
	private static  Connection _connection;
	private static String _user="sa";
	private static String _passWord="wodeshiyanshi797";
	private static String _className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String _url="jdbc:sqlserver://localhost:1433;DatabaseName=restaurant";
	public static void LoadDB()
	{
		
		try
		{
			Class.forName(_className);
			//System.out.println("连接数据库成功");
			
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("加载数据库驱动失败");
			e.printStackTrace();
		}
		
	}
	public static Connection GetCon()
	{
		try
		{
			_connection=DriverManager.getConnection(_url, _user, _passWord);
			
		}
		catch (SQLException e) 
		{
			System.out.println("创建数据库连接失败！");
			e.printStackTrace();
			_connection=null;
		}
		return _connection;
	}
	public static void Closed()
	{
		try 
		{
			if(_connection!=null)
			{
				_connection.close();
			}
		}
		catch (SQLException e) 
		{
			System.out.println("关闭数据库失败");
			e.printStackTrace();
		}
	}
}
