package joker.models;



public class OrderFood 
{
	private String _orderId;
	private String _foodId;
	private int _id;
	
	
	public int get_id() 
	{
		return _id;
	}
	public void set_id(int _id) 
	{
		this._id = _id;
	}
	public String get_orderId() 
	{
		return _orderId;
	}
	public void set_orderId(String _orderId)
	{
		this._orderId = _orderId;
	}
	public String get_foodId()
	{
		return _foodId;
	}
	public void set_foodId(String _foodId)
	{
		this._foodId = _foodId;
	}
	
}
