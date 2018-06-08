package joker.Service;

import java.util.List;


import joker.models.Food;

public interface FoodInterface 
{
	public int DeleteFood(String id);
	public int InsertFood(Food food);
	public int UpdateFood(Food food,String oldId);
	public String GetMaxFid();
	

	public List<Food> GetFoodByType(String type);
	public Food GetFoodByID(String id);

}
