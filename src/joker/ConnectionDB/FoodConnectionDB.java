package joker.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import joker.JdbcUtils.GetConnectionDB;

import joker.models.Food;



public class FoodConnectionDB  implements FoodInterface 
{

	private Connection _con=null;
	@Override
	public int InsertFood(Food food)
	{
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			String sql="insert into Food values(?,?,?,?,?,?)";		 
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1, food.get_FID());
			statement.setString(2,  food.get_Fname());
			statement.setFloat(3,  food.get_Fprice());
			statement.setString(4, food.get_Ftime());		
			statement.setString(5, food.get_Ftype());
			statement.setString(6, food.get_img());
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
	public int DeleteFood(String id) 
	{
		
		String sql="delete from Food where Fid=?";
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
	public Food GetFoodById(String id) 
	{
		
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from Food where Fid=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet result=preparedStatement.executeQuery();
			Food food =new Food();
			while(result.next())
			{
				
				food.set_FID(result.getString(1));
				food.set_Fname(result.getString(2));
				food.set_Fprice(result.getFloat(3));
				food.set_Ftime(result.getString(4));
				food.set_Ftype(result.getString(5));
				food.set_img(result.getString(6));
			
			}
			  GetConnectionDB.Closed();
			return food;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
	}

	@Override
	public List<Food> GetFood() 
	{
		
		List<Food> foods =new ArrayList<Food>();
		 
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from Food ";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				Food food=new Food();
			  food.set_FID(result.getString(1));
			  food.set_Fname(result.getString(2));
			  food.set_Fprice(result.getFloat(3));
			  food.set_Ftime(result.getString(4));
			  food.set_Ftype(result.getString(5));
			  food.set_img(result.getString(6));
			  foods.add(food);
			
			}
			  GetConnectionDB.Closed();
			return foods;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
	}

	@Override
	public int UpdateFood(Food food, String oldbid) 
	{
		String sql="update Food set Fname= ?,Fprice =?,Ftime=? ,Fid=? ,Ftype=? ,Fimgurl=? where Fid=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			statement.setString(1, food.get_Fname());
			statement.setFloat(2, food.get_Fprice());
			statement.setString(3, food.get_Ftime());
			statement.setString(4, food.get_FID());
			statement.setString(5, food.get_Ftype());
			statement.setString(6, food.get_img());
			statement.setString(7, oldbid);
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
	public List<Food> GetFoodByType(String type) 
	{
		
		List<Food> foods =new ArrayList<Food>();
		 
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from Food where Ftype = ?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, type);
			 
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				Food food=new Food();
			  food.set_FID(result.getString(1));
			  food.set_Fname(result.getString(2));
			  food.set_Fprice(result.getFloat(3));
			  food.set_Ftime(result.getString(4));
			  food.set_Ftype(result.getString(5));
			  food.set_img(result.getString(6));
			 
			  foods.add(food);
			
			}
			
			  GetConnectionDB.Closed();
			return foods;
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
		String sql="select top 1 Fid from Food order by Fid desc ";
		
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			String Maxfid=null;
			PreparedStatement statement=_con.prepareStatement(sql);
			ResultSet resultSet=statement.executeQuery();
			 
			while(resultSet.next())
			{
				Maxfid=resultSet.getString(1);
			}			
			return Maxfid;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
	}

	

}
