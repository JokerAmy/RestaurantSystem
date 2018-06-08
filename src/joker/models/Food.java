package joker.models;

public class Food 
{
	protected String _FID;
	protected String _Fname;
	protected float _Fprice;
	protected String _Ftime;
	protected String _Ftype;
	protected String _img;
	protected int _id;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_img() {
		return _img;
	}
	public void set_img(String _img) {
		this._img = _img;
	}
	public String get_FID() {
		return _FID;
	}
	public void set_FID(String _FID) {
		this._FID = _FID;
	}
	public String get_Fname() {
		return _Fname;
	}
	public void set_Fname(String _Fname) {
		this._Fname = _Fname;
	}
	public float get_Fprice() {
		return _Fprice;
	}
	public void set_Fprice(float _Fprice) {
		this._Fprice = _Fprice;
	}
	public String get_Ftime() {
		return _Ftime;
	}
	public void set_Ftime(String _Ftime) {
		this._Ftime = _Ftime;
	}
	public String get_Ftype() {
		return _Ftype;
	}
	public void set_Ftype(String _Ftype) {
		this._Ftype = _Ftype;
	}
	
}
