package joker.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import joker.JdbcUtils.GetConnectionDB;

import joker.models.OrderFood;
import joker.models.OrderForm;
import joker.models.OrderWine;


public class OrderConnection implements OrderFormInterface
{
	private Connection _con=null;
	@Override
	public int InsertOrder(String orderId,int uid,String ispay)
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="insert into _order(orderid,uid,ispay) values (?,?,?)";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, orderId);
			preparedStatement.setInt(2, uid);
			preparedStatement.setString(3, ispay);
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
	public int DeleteOrder(String orderid) 
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="delete  _order where orderid=?";
		try 
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, orderid);
			int row=preparedStatement.executeUpdate();
			return row;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;//失败返回-1
		}
		
	}

	@Override
	public OrderForm GetOrderFormById(String orderid) 
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		OrderForm orderForm=new OrderForm();
		String sql1="select * from _order where orderid=?";
		String sql2="select * from orderFood where orderid=?";
		String sql3="select * from orderWine where orderid=?";
		
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql1);
			preparedStatement.setString(1, orderid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				orderForm.set_orderId(resultSet.getString(1));
				orderForm.set_userId(resultSet.getInt(2));
				orderForm.set_ispay(resultSet.getString(4));
			}
			
			
			
			/*
			 * 
			 * 
			 * 
			 * 
			 * 填充orderfood表
			 * 
			 * 
			 * 
			 */
			
			preparedStatement=_con.prepareStatement(sql2);
			preparedStatement.setString(1, orderid);
			resultSet=preparedStatement.executeQuery();
			List<OrderFood> foods=new ArrayList<>();
			while(resultSet.next())
			{
				OrderFood orderFood=new OrderFood();
				orderFood.set_orderId(resultSet.getString(1));
				orderFood.set_foodId(resultSet.getString(2));
				foods.add(orderFood);
			}
			orderForm.set_FoodList(foods);
			
			/*
			 * 
			 * 填充orderwine表
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			preparedStatement=_con.prepareStatement(sql3);
			preparedStatement.setString(1, orderid);
			resultSet=preparedStatement.executeQuery();
			List<OrderWine> wines=new ArrayList<>();
			while(resultSet.next())
			{
				OrderWine orderWine=new OrderWine();
				orderWine.set_orderId(resultSet.getString(1));
				orderWine.set_wineId(resultSet.getString(2));
				wines.add(orderWine);
				
			}
			orderForm.set_WinesList(wines);
			
			
			
			return orderForm;
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
		
	}

	@Override
	public void UpdateOrderForm(OrderForm orderForm) 
	{
		
		
	}

	@Override
	public int InsertFood(String orderid,String fid,int id) 
	{
		
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="insert into orderFood(orderid,Foodid,id) values(?,?,?)";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, orderid);
			preparedStatement.setString(2, fid);
			preparedStatement.setInt(3, id);
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
	public int InsertWine(String orderid,String wid,int id)
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="insert into orderwine(orderid,Wid,id) values(?,?,?)";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, orderid);
			preparedStatement.setString(2, wid);
			preparedStatement.setInt(3, id);
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
	public int UpdateTotalMoney(float money,String orderid)
	{
		
		String sql="update _order set totalmoney=? where orderid=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			
			statement.setFloat(1, money);
			statement.setString(2,orderid);
			
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
	public int UpdateIspay(String ispay) 
	{
		
		String sql="update _order set totalmoney=? where orderid=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement statement=_con.prepareStatement(sql);
			
			statement.setString(1, ispay);
		
			
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
	public String GetMaxId() 
	{
		String sql="select top 1 orderid from _order order by orderid desc";
		
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

	@Override
	public List<OrderWine> GetAllWinesByOrderId(String orderid) 
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from orderWine where orderid=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			preparedStatement.setString(1, orderid);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<OrderWine> orderWines=new ArrayList<>();
			
			while(resultSet.next())
			{
				OrderWine orderWine=new OrderWine();
				orderWine.set_orderId(resultSet.getString(1));
				orderWine.set_wineId(resultSet.getString(2));
				orderWine.set_id(resultSet.getInt(3));
				
				orderWines.add(orderWine);
			}
			return orderWines;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
	
	}

	@Override
	public List<OrderFood> GetAllFoodByOrderId(String orderid) 
	{
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		String sql="select * from orderFood where orderid=?";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			preparedStatement.setString(1, orderid);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<OrderFood> orderFoods=new ArrayList<>();
			
			while(resultSet.next())
			{
				OrderFood orderFood=new OrderFood();
				orderFood.set_orderId(resultSet.getString(1));
				orderFood.set_foodId(resultSet.getString(2));
				orderFood.set_id(resultSet.getInt(4));
				orderFoods.add(orderFood);
			}
			return orderFoods;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			GetConnectionDB.Closed();
			return null;
		}
		
		
		
	}

	@Override
	public int DeleteOrderFood(String orderid, String foodid,int id) 
	{
		String sql="delete from orderFood where orderid=? and foodid=? and id=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, orderid);
			preparedStatement.setString(2, foodid);
			preparedStatement.setInt(3, id);
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
	public int DeleteOrderWine(String orderid, String wineid,int id) 
	{
		String sql="delete from orderWine where orderid=? and wid=? and id=?";
		try
		{
			GetConnectionDB.LoadDB();
			_con=GetConnectionDB.GetCon();
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			preparedStatement.setString(1, orderid);
			preparedStatement.setString(2, wineid);
			preparedStatement.setInt(3, id);
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
	public int GetWineMaxId() 
	{
		
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		int maxId=0;
		String sql="select top 1 id from orderWine order by id desc";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				maxId=result.getInt(1);
			}
			  GetConnectionDB.Closed();
			return maxId;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}
	}

	@Override
	public int GetFoodMaxId() 
	{
		
		GetConnectionDB.LoadDB();
		_con=GetConnectionDB.GetCon();
		int maxId=0;
		String sql="select top 1 id from orderFood order by id desc";
		try
		{
			PreparedStatement preparedStatement=_con.prepareStatement(sql);
			
			ResultSet result=preparedStatement.executeQuery();
	
			while(result.next())
			{
				maxId=result.getInt(1);
			}
			  GetConnectionDB.Closed();
			return maxId;
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			GetConnectionDB.Closed();
			return -1;
		}
	}

}
