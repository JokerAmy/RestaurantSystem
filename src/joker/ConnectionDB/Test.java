package joker.ConnectionDB;

public class Test 
{
	public static void main(String[] args)
	{
		
		OrderConnection orderConnection=new OrderConnection();
		
		//orderConnection.InsertOrder("1", 2, "1");
		//orderConnection.InsertFood("1", "1002");
		//orderConnection.InsertWine("1", "1001");
		//orderConnection.UpdateTotalMoney(10.1f, "1");
		System.out.println(orderConnection.GetMaxId());
		
	}
}
