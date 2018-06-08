package joker.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import joker.JdbcUtils.GetConnectionDB;
import joker.models.RestaurantManager;
public class ManagerConnectionDB implements ManagerInterface
{
	private Connection _con=null;

	@Override
	public String GetPasswordByAccount(String account) 
	{
		String password=null;
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select Password from RestaurantManager where _account=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, account);
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				password=result.getString(1);
			}
			  GetConnectionDB.Closed();
			return password;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
		
	}

	@Override
	public int InsertManager(RestaurantManager manager)
	{
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			String sql="insert into RestaurantManager values(?,?)";		 
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1, manager.get_account());
			statement.setString(2, manager.get_password());
			int row=statement.executeUpdate();
			GetConnectionDB.Closed();
			return row;//成功返回几条数据受到影响			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//失败返回-1
		}
	
	}

	@Override
	public String GetAccount(String account)
	{
		String _account=null;
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select _account from RestaurantManager where _account=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, account);
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				_account=result.getString(1);
			}
			  GetConnectionDB.Closed();
			return _account;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
	}

	


}
