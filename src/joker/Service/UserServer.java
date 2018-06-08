package joker.Service;

import java.util.List;

import joker.ConnectionDB.Factory;
import joker.ConnectionDB.UserConnectionDB;
import joker.models.User;

public class UserServer implements userServiceInterface
{
	

	private UserConnectionDB _userConnectionDB;
	public UserServer()
	{
		
		 _userConnectionDB=(UserConnectionDB) Factory.GetUserConInterface();//调用factory
		
	}
	
	public boolean LogIn(String phone ,String password)
	{
		String passwordDB=_userConnectionDB.GetUserPassword(phone);//拿到数据库的密码
		
		if(password.equals(passwordDB) && _userConnectionDB.GetUserPhone(phone)!=null/*电话不为空*/)
		{
			
			return true;//登陆成功
		}
		else
		{
			return false;//失败
		}	
	}
	public int Register(User user)
	{
		
		//过滤非法字符，sql注入
		int row=_userConnectionDB.InsertUser(user);
		if(row>0)return row;//插入成功
		else return 0;//失败		
	}

	@Override
	public List<User> QueryIsVip(int key) 
	{
		return _userConnectionDB.GetUsers(key);		//将查询结果传给控制层
	}

	@Override
	public int GetMaxId() 
	{
		
		return _userConnectionDB.GetMaxId();
	}

	@Override
	public User GetUserById(String phone)
	{
		
		return _userConnectionDB.GetUserByPhone(phone);
	}
	

	
	
}
