package joker.ConnectionDB;

import java.util.List;

import joker.models.OrderFood;
import joker.models.OrderForm;
import joker.models.OrderWine;


public interface OrderFormInterface 
{
	public int InsertOrder(String orderId,int uid,String ispay);
	public int DeleteOrder(String orderid);
	
	public OrderForm GetOrderFormById(String orderid);
	
	public void UpdateOrderForm(OrderForm orderForm);
	
	public int InsertFood(String orderid,String fid,int id);
	public int InsertWine(String orderid,String wid,int id);
	
	public int UpdateTotalMoney(float money,String orderid);
	
	public int UpdateIspay(String ispay);
	
	public String GetMaxId();
	
	public List<OrderWine> GetAllWinesByOrderId(String orderid);
	public List<OrderFood> GetAllFoodByOrderId(String orderid);
	
	public int DeleteOrderFood(String orderid,String foodid,int id);
	public int DeleteOrderWine(String orderid,String wineid,int id);
	
	
	public int GetWineMaxId();
	public int GetFoodMaxId();

}
