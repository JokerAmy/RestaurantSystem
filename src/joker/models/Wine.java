package joker.models;

public class Wine
{
	protected String _id;
	protected String _name;
	protected String _brand;
	protected float _price;
	protected float _capacity;//毫升
	protected String _imgAddress;
	protected int _orderid;
	
	public int get_orderid() {
		return _orderid;
	}
	public void set_orderid(int _orderid) {
		this._orderid = _orderid;
	}
	public String get_imgAddress() 
	{
		return _imgAddress;
	}
	public void set_imgAddress(String _imgAddress) 
	{
		this._imgAddress = _imgAddress;
	}
	public String get_id() 
	{
		return _id;
	}
	public void set_id(String _id) 
	{
		this._id = _id;
	}
	
	
	
	public String get_brand() 
	{
		return _brand;
	}
	
	public void set_brand(String _brand) 
	{
		this._brand = _brand;
	}
	public String get_name() 
	{
		return _name;
	}
	public void set_name(String _name) 
	{
		this._name = _name;
	}
	public float get_price() 
	{
		return _price;
	}
	public void set_price(float _price) 
	{
		this._price = _price;
	}
	public float get_capacity() 
	{
		return _capacity;
	}
	public void set_capacity(float _capacity) 
	{
		this._capacity = _capacity;
	}
	
	
}
