package joker.models;

import java.util.List;

public class OrderForm 
{
	private String _orderId;
	private List<OrderFood> _FoodList;
	private List<OrderWine> _WinesList;
	
	private  int _userId;
	private String _ispay;
	
	
	public String get_orderId() 
	{
		return _orderId;
	}
	public void set_orderId(String _orderId) 
	{
		this._orderId = _orderId;
	}
	public List<OrderFood> get_FoodList()
	{
		return _FoodList;
	}
	public void set_FoodList(List<OrderFood> _FoodList)
	{
		this._FoodList = _FoodList;
	}
	public List<OrderWine> get_WinesList()
	{
		return _WinesList;
	}
	public void set_WinesList(List<OrderWine> _WinesList) 
	{
		this._WinesList = _WinesList;
	}
	public int get_userId() 
	{
		return _userId;
	}
	public void set_userId(int _userId) 
	{
		this._userId = _userId;
	}
	public String get_ispay() 
	{
		return _ispay;
	}
	public void set_ispay(String _ispay) 
	{
		this._ispay = _ispay;
	}
	
}
