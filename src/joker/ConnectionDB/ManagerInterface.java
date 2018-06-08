package joker.ConnectionDB;

import joker.models.RestaurantManager;

public interface ManagerInterface 
{
	public String GetPasswordByAccount(String _account);
	public int InsertManager(RestaurantManager manager);
	public String GetAccount(String account);

}
