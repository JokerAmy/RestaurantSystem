package joker.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import joker.JdbcUtils.GetConnectionDB;
import joker.models.User;
public class UserConnectionDB implements UserInterface
{
	private Connection _con=null;
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 插入用户数据
	 * 
	 * 
	 * */
	/*done*/public int InsertUser(User user) 
	{	
		
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			String sql="insert into _user values(?,?,?,?,?,?,?)";		 
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setInt(1, user.get_id());
			statement.setString(2, user.get_name());
			statement.setString(3, user.get_phoneNum());
			statement.setInt(4, user.get_key());
			statement.setFloat(5, user.get_discount());
			statement.setString(6, user.get_passWord());
			statement.setFloat(7, user.get_balance());
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
	
	/*
	 * 
	 * 删除数据
	 * /(non-Javadoc)
	 * @see joker.ConnectionDB.UserInterface#DeleteUserById(int)
	 */
	/*done*/public int DeleteUserById(int id) 
	{
		String sql="delete from _user where uid=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int row=preparedStatement.executeUpdate();
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
	
	
	
	
	/*done*/public int UpdateUserByName(String name, String phonenum)
	{
		String sql="update _user set uname=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, phonenum);
			int row=statement.executeUpdate();
			
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}
	
	}

	@Override
	/*done*/public int UpdateUserByPassword(String password, String phonenum) 
	{
		String sql="update _user set password=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, phonenum);
			int row=statement.executeUpdate();
			
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}
	}

	@Override
	/*done*/public int UpdateUserByBalance(float balance, String phonenum) 
	{
		String sql="update _user set balance=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setFloat(1, balance);
			statement.setString(2, phonenum);
			int row=statement.executeUpdate();
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}

	
	}

	@Override
	/*done*/public int UpdateUserByPhone(String newphonenum, String oldphonenum) 
	{
		String sql="update _user set phone=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1, newphonenum);
			statement.setString(2, oldphonenum);
			int row=statement.executeUpdate();
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}

			

		
	}

	@Override
	/*done*/public int UpdtaeUserByKey(int key, String phonenum)
	{
		
		String sql="update _user set _key=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setInt(1, key);
			statement.setString(2, phonenum);
			int row=statement.executeUpdate();
			
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//出错返回-1
		}
	}

	@Override
	/*done*/public int UpdateUserByDiscount(float discount, int key, String phonenum) 
	{
		String sql="update _user set discount=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setFloat(1, discount);
			statement.setString(2, phonenum);
			int row=statement.executeUpdate();
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//出错返回-1
		}
	}

	@Override
	/*done*/public int UpdateUserById(int id, String phonenum) 
	{
		String sql="update _user set discount=?  where phone=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, phonenum);
			int row=statement.executeUpdate();
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//出错返回-1
		}
		
	
	}

	@Override
	/*done*/public User GetUserByPhone(String phonenum) 
	{
		User user =new User();
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from _user where phone=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, phonenum);
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
			  user.set_id(result.getInt(1));
			  user.set_name(result.getString(2));
			  user.set_phoneNum(result.getString(3));
			  user.set_key(result.getInt(4));
			  user.set_discount(result.getFloat(5));
			  user.set_passWord(result.getString(6));
			  user.set_balance(result.getFloat(7));
			}
			  GetConnectionDB.Closed();
			return user;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
	
	}

	@SuppressWarnings("null")
	@Override
	public List<User> GetUsers(int key) 
	{
		
		User user=new User();
		String sql="select * from _user where _key=?";
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		List<User> userlist=new ArrayList<User>();
		
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setInt(1, key);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				  user.set_id(resultSet.getInt(1));
				  user.set_name(resultSet.getString(2));
				  user.set_phoneNum(resultSet.getString(4));
				  user.set_key(resultSet.getInt(5));
				  user.set_discount(resultSet.getFloat(6));
				  user.set_passWord(resultSet.getString(6));
				  user.set_balance(resultSet.getFloat(7));
				  userlist.add(user);
				 
				
			} 
			GetConnectionDB.Closed();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			
		}
		return userlist;
		
	}

	@Override
	public String GetUserPassword(String phonenum)
	{
		String password=null;
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select password from _user where phone=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, phonenum);
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
	public String GetUserPhone(String phonenum) 
	{
		
		String phone=null;
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select phone from _user where phone=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, phonenum);
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				phone=result.getString(1);
			}
			  GetConnectionDB.Closed();
			return phone;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
	}

	@Override
	public int GetMaxId() 
	{
		
		
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		int maxId=0;
		String sql="select top 1 uid from _user order by uid desc";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				maxId=result.getInt(1);
			}
			  GetConnectionDB.Closed();
			return maxId;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}
	}



}
