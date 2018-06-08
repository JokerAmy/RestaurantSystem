package joker.models;

public class OrderWine
{
	private String _orderId;
	private String _wineId;
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
	public String get_wineId() 
	{
		return _wineId;
	}
	public void set_wineId(String _wineId) 
	{
		this._wineId = _wineId;
	}
	
}
