package joker.Service;

import java.util.List;

import joker.models.Wine;

public interface WineServiceInterface 
{
	public int DeleteWine(String wid);
	public int InsertWine(Wine wine);
	public int UpdateWine(Wine wine,String oldId);
	public String GetMaxFid();
	
	

	public Wine GetWineByID(String wid);
	public List<Wine> GetWineAll();
}
