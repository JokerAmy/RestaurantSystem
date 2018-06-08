package joker.ConnectionDB;

import java.util.List;


import joker.models.Food;

public interface FoodInterface
{
	public int InsertFood(Food food);
	public int DeleteFood(String id);//根据编号删除该数据的早餐信息
	
	public int UpdateFood(Food food,String oldBid);//更改用户名
	
	public Food GetFoodById(String id);
	
	public List<Food> GetFood();
	
	
	
	public List<Food> GetFoodByType(String type);
	
	public String GetMaxID();
	
	
	
}
