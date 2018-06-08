package joker.Service;

import joker.ConnectionDB.WineInterface;

public class ServiceFactory 
{
	public static userServiceInterface GetUserService()
	{
		return new UserServer();
	}
	public static ManagerInterface GetManagerInterface()
	{
		return new ManagerService();
	}
	public static FoodInterface GetS_Breakfast()
	{
		return new FoodService();
	}
	public static WineServiceInterface GetWineInterface()
	{
		return new WineService();
	}
	public static OrderServiceInterface GetOrderInterface()
	{
		return new Order();
	}
	
}
