package joker.Service;

import joker.ConnectionDB.Factory;
import joker.ConnectionDB.ManagerConnectionDB;
import joker.models.RestaurantManager;

public class ManagerService implements ManagerInterface
{
	private ManagerConnectionDB MCDB=null;
	public  ManagerService() 
	{
		MCDB=(ManagerConnectionDB) Factory.GetManagerInterface();
	}
	@Override
	public boolean ManagerLogin(String account,String password)
	{
		String passwordDB=MCDB.GetPasswordByAccount(account);//拿到数据库的密码
		if(password.equals(passwordDB) && MCDB.GetAccount(account)!=null/*账户不为空*/)
		{
			return true;//登陆成功
		}
		else
		{
			return false;//失败
		}		
	}

	@Override
	public int Register(RestaurantManager manager)
	{
		return MCDB.InsertManager(manager);		
	}

}
