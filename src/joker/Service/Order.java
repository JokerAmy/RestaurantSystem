package joker.Service;

import java.util.ArrayList;
import java.util.List;

import joker.ConnectionDB.Factory;
import joker.ConnectionDB.OrderConnection;
import joker.models.Food;
import joker.models.OrderFood;
import joker.models.OrderForm;
import joker.models.OrderWine;
import joker.models.Wine;

public class Order implements OrderServiceInterface
{
	private OrderConnection _orderCno=new OrderConnection();
	public  Order()
	{
		_orderCno=(OrderConnection) Factory.GetOrderFormInterface();
	}
	@Override
	public int InsertOrder(String orderId, int uid, String ispay) 
	{
		
		return _orderCno.InsertOrder(orderId, uid, ispay);
	}

	@Override
	public int DeleteOrder(String orderid) 
	{
		
		return _orderCno.DeleteOrder(orderid);
	}

	@Override
	public OrderForm GetOrderFormById(String orderid) 
	{
	
		return _orderCno.GetOrderFormById(orderid);
	}

	@Override
	public void UpdateOrderForm(OrderForm orderForm) 
	{
		
		_orderCno.UpdateOrderForm(orderForm);
	}

	@Override
	public int InsertFood(String orderid, String fid,int id)
	{
		
		return _orderCno.InsertFood(orderid, fid, id);
	}

	@Override
	public int InsertWine(String orderid, String wid,int id)
	{
		
		return _orderCno.InsertWine(orderid, wid,id);
	}

	@Override
	public int UpdateTotalMoney(float money, String orderid) 
	{
		
		return _orderCno.UpdateTotalMoney(money, orderid);
	}

	@Override
	public int UpdateIspay(String ispay)
	{
		
		return _orderCno.UpdateIspay(ispay);
	}
	@Override
	public String GetMaxId() 
	{
		
		return _orderCno.GetMaxId();
	}
	@Override
	public List<Wine> GetAllWinesByOrderId(String orderid) 
	{
		List<OrderWine> orderwines=_orderCno.GetAllWinesByOrderId(orderid);
		WineService wineService=(WineService) ServiceFactory.GetWineInterface();
		List<Wine> wines=new ArrayList<>();
		for(int i=0;i<orderwines.size();i++)
		{
			String wineid=orderwines.get(i).get_wineId();
			Wine wine=new Wine();		
			wine=wineService.GetWineByID(wineid);
			wine.set_orderid(orderwines.get(i).get_id());
			wines.add(wine);
		}
		
		
		return wines;
	}
	@Override
	public List<Food> GetAllFoodByOrderId(String orderid) 
	{
		
		List<OrderFood> orderfoods=_orderCno.GetAllFoodByOrderId(orderid);
		FoodService foodService=(FoodService) ServiceFactory.GetS_Breakfast();
		List<Food> foods=new ArrayList<>();
		for(int i=0;i<orderfoods.size();i++)
		{
			String foodid=orderfoods.get(i).get_foodId();
			Food food=new Food();
			
			food=foodService.GetFoodByID(foodid);
			food.set_id(orderfoods.get(i).get_id());
			
			foods.add(food);
		}
		
		
		return foods;
	}
	@Override
	public int DeleteOrderFood(String orderid, String foodid,int id)
	{
		
		return _orderCno.DeleteOrderFood(orderid, foodid,id);
	}
	@Override
	public int DeleteOrderWine(String orderid, String wineid,int id) {
		
		return _orderCno.DeleteOrderWine(orderid, wineid,id);
	}
	@Override
	public int GetWineMaxId() 
	{
	
		return _orderCno.GetWineMaxId();
	}
	@Override
	public int GetFoodMaxId() 
	{
		
		return _orderCno.GetFoodMaxId();
	}

}
