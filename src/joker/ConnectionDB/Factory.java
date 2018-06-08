package joker.ConnectionDB;

public class Factory 
{
	public static UserInterface GetUserConInterface()
	{
		return new UserConnectionDB();
	}
	public static ManagerInterface GetManagerInterface()
	{
		return new ManagerConnectionDB();
	}
	public static FoodInterface GetFoodInterface()
	{
		return new FoodConnectionDB();
	}
	public static WineInterface GetWineInterface()
	{
		return new WineConnectionDB();
	}
	public static OrderFormInterface GetOrderFormInterface()
	{
		return new OrderConnection();
	}
}
