package joker.Service;

import java.util.List;

import joker.ConnectionDB.Factory;
import joker.ConnectionDB.WineConnectionDB;
import joker.models.Wine;

public class WineService implements WineServiceInterface
{
	private WineConnectionDB wineConnectionDB=null;
	public  WineService() 
	{
		wineConnectionDB=(WineConnectionDB) Factory.GetWineInterface();
	}
	@Override
	public int DeleteWine(String wid) 
	{
		
		return wineConnectionDB.DeleteWine(wid);
	}

	@Override
	public int InsertWine(Wine wine) 
	{
		
		return wineConnectionDB.InsertWine(wine);
	}

	@Override
	public int UpdateWine(Wine wine, String oldWid)
	{
		
		return wineConnectionDB.UpdateWine(wine, oldWid);
	}

	@Override
	public String GetMaxFid()
	{
		
		return wineConnectionDB.GetMaxID();
		
	}

	@Override
	public Wine GetWineByID(String wid)
	{
		
		return wineConnectionDB.GetWineById(wid);
	}
	@Override
	public List<Wine> GetWineAll() 
	{
		
		return wineConnectionDB.GetWine();
	}
	
}
