package joker.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import joker.JdbcUtils.GetConnectionDB;

import joker.models.Wine;

public class WineConnectionDB implements WineInterface
{
	private Connection _con=null;
	@Override
	public int InsertWine(Wine wine) 
	{
		
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			String sql="insert into Wine values(?,?,?,?,?,?)";		 
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1,  wine.get_id());
			statement.setString(2, wine.get_name());
			statement.setFloat(3,  wine.get_price());
			statement.setFloat(4, wine.get_capacity());		
			statement.setString(5, wine.get_brand());
			statement.setString(6, wine.get_imgAddress());
			
			int row=statement.executeUpdate();
			GetConnectionDB.Closed();
			return row;//成功返回几条数据受到影响			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//失败返回-1
		}
	}

	@Override
	public int DeleteWine(String id) 
	{
		
		String sql="delete from Wine where Wid=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			int row=preparedStatement.executeUpdate();
			GetConnectionDB.Closed();
			return row;//成功返回几条数据受到影响
		}
		catch (SQLException e) 
		{	
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//失败返回-1
		}
	}

	@Override
	public int UpdateWine(Wine wine, String oldWid)
	{
		
		String sql="update Wine set Wname= ?,Wprice =?,Wcapacity=? ,Wbrand=?,Wimg=? where Wid=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1,wine.get_name() );
			statement.setFloat(2, wine.get_price());
			statement.setFloat(3, wine.get_capacity());
			statement.setString(4, wine.get_brand());
			statement.setString(5, wine.get_imgAddress());	
			statement.setString(6, oldWid);
			int row=statement.executeUpdate();
			
			return row;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}
	}

	@Override
	public Wine GetWineById(String id) 
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from Wine where Wid=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet result=preparedStatement.executeQuery();
			Wine wine =new Wine();
			while(result.next())
			{
				
				wine.set_id(result.getString(1));
				wine.set_name(result.getString(2));
				wine.set_price(result.getFloat(3));
				wine.set_capacity(result.getInt(4));
				wine.set_brand(result.getString(5));
				wine.set_imgAddress(result.getString(6));
			
			}
			  GetConnectionDB.Closed();
			return wine;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
	}

	@Override
	public List<Wine> GetWine() 
	{
		
		List<Wine> wines =new ArrayList<Wine>();
		 
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from Wine ";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				Wine wine=new Wine();
				wine.set_id(result.getString(1));
				wine.set_name(result.getString(2));
				wine.set_price(result.getFloat(3));
				wine.set_capacity(result.getInt(4));
				wine.set_brand(result.getString(5));
				wine.set_imgAddress(result.getString(6));
			  	wines.add(wine);
			
			}
			  GetConnectionDB.Closed();
			return wines;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
	}

	@Override
	public String GetMaxID()
	{
		String sql="select top 1 Wid from Wine order by Wid desc ";
		
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			String MaxWid=null;
			PreparedStatement statement=_con.prepareStatement(sql);
			ResultSet resultSet=statement.executeQuery();
			 
			while(resultSet.next())
			{
				MaxWid=resultSet.getString(1);
			}			
			return MaxWid;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
	}

}
