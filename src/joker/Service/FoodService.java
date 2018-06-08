package joker.Service;

import joker.ConnectionDB.FoodConnectionDB;


import java.util.List;

import joker.ConnectionDB.Factory;

import joker.models.Food;

public class FoodService implements FoodInterface
{
	private FoodConnectionDB foodConnectionDB=null;
	public  FoodService() 
	{
		foodConnectionDB=(FoodConnectionDB) Factory.GetFoodInterface();
	}

	@Override
	public int DeleteFood(String id) 
	{
		
		return foodConnectionDB.DeleteFood(id);
	}

	@Override
	public int InsertFood(Food food) 
	{
		
			return foodConnectionDB.InsertFood(food);
	
		
	}

	@Override
	public int UpdateFood(Food food, String id)
	{
		foodConnectionDB.UpdateFood(food, id);
		return 0;
	}

	@Override
	public String GetMaxFid() 
	{
		
		return foodConnectionDB.GetMaxID();
	}

	@Override
	

	
	public List<Food> GetFoodByType(String type) 
	{
		
		return foodConnectionDB.GetFoodByType(type);
	}

	@Override
	public Food GetFoodByID(String id) 
	{
		return foodConnectionDB.GetFoodById(id);
	}
	
	
	
	



}
