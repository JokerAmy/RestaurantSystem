package joker.ConnectionDB;

import java.util.List;


import joker.models.Wine;

public interface WineInterface 
{
	public int InsertWine(Wine wine);
	public int DeleteWine(String id);//根据编号删除该数据的酒水信息
	
	public int UpdateWine(Wine food,String oldBid);//更改用户名
	
	public Wine GetWineById(String id);
	
	public List<Wine> GetWine();
	public String GetMaxID();
}
