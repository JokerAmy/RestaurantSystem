package joker.Service;

import joker.models.RestaurantManager;

public interface ManagerInterface 
{
	public boolean ManagerLogin(String account ,String password);
	public int Register(RestaurantManager manager);
}
