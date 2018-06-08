package joker.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joker.Service.FoodService;
import joker.Service.Order;
import joker.Service.ServiceFactory;
import joker.Service.UserServer;
import joker.models.Food;
import joker.models.User;
import joker.models.Wine;




/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private Order order=(Order) ServiceFactory.GetOrderInterface(); 
    private FoodService foodService=(FoodService) ServiceFactory.GetS_Breakfast();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() 
    {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String type=request.getParameter("type");
		//System.out.println(type);
		if(type.equals("bookfood"))
		{
			BookFood(request, response);
		}
		if(type.equals("bookwine"))
		{
			BookWine(request, response);
		}
		if(type.equals("displayorderform"))
		{
			DisPlayOrderForm(request, response);
		}
		if(type.equals("deletefood"))
		{
			DeleteFood(request, response);
		}
		if(type.equals("deletewine"))
		{
			DelteWine(request, response);
		}
		
	}
	private void DeleteFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String foodid=request.getParameter("foodid");
		String orderid=(String) request.getSession().getAttribute("orderid");
		int id=Integer.parseInt(request.getParameter("id"));
		order.DeleteOrderFood(orderid, foodid,id);
		
		DisPlayOrderForm(request, response);
		
	}
	private void  DelteWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String wineid=request.getParameter("winedid");
		String orderid=(String) request.getSession().getAttribute("orderid");
		
		int id=Integer.parseInt(request.getParameter("id"));
		order.DeleteOrderWine(orderid, wineid,id);
		DisPlayOrderForm(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void DisPlayOrderForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String orderid=(String) request.getSession().getAttribute("orderid");
		List<Food> foods=new ArrayList<>();
		List<Wine> wines=new ArrayList<>();
		
		if(orderid!=null)
		{
			 foods=order.GetAllFoodByOrderId(orderid);
			 wines=order.GetAllWinesByOrderId(orderid);
			 
			 request.setAttribute("foods", foods);//向订单页面发送定的食品数据
			request.setAttribute("wines", wines);//向订单页面发送定的酒水数据
			String userphone=(String) request.getSession().getAttribute("userid");
			
			
			UserServer userServer=(UserServer) ServiceFactory.GetUserService();
			User user=userServer.GetUserById(userphone);
			
			request.setAttribute("user", user);//向订单页面发送用户数据
			float PriceSum=0;
			for(int i=0;i<foods.size();i++)
			{
				PriceSum+=foods.get(i).get_Fprice();
			}
			for(int i=0;i<wines.size();i++)
			{
				PriceSum+=wines.get(i).get_price();
			}
			float before=PriceSum;
			
			float after=PriceSum*user.get_discount();
			request.setAttribute("beforemoney", before);//折扣前的总和
			request.setAttribute("aftermoney", after);//折扣后的总和
			
			request.getRequestDispatcher("./food/jsps/order_form.jsp").forward(request, response);
		}
		else 
		{
			request.getRequestDispatcher("./food/jsps/login.jsp").forward(request, response);
		}
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doGet(request, response);
	}
	private void BookFood (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession().getAttribute("userid")==null)
		{
			
			request.getRequestDispatcher("./food/jsps/login.jsp").forward(request, response);
		}
		else
		{
			
			String foodid=request.getParameter("foodid");
			String orderid=(String) request.getSession().getAttribute("orderid");
			int id=order.GetFoodMaxId();
			if(id==0)
			{
				id=1;
			}
			else 
			{
				id++;		
			}
			
			//id号增加
	
			order.InsertFood(orderid, foodid,id);//实现点餐，加入order food菜单
			
			
			Food food=foodService.GetFoodByID(foodid);
			String foodtype=food.get_Ftype();
			foodtype=foodtype.trim();//将字符串的空格剔除
			
			
			if(foodtype.equals("早餐"))
			{
				request.getRequestDispatcher("displayFoodController?type=displaybreakfast").forward(request, response);
			}
			else if (foodtype.equals("中餐")) 
			{
				request.getRequestDispatcher("displayFoodController?type=displaylunch").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("displayFoodController?type=displaydinner").forward(request, response);
			}
		}
	}
	private void BookWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession().getAttribute("userid")==null)
		{
			
			request.getRequestDispatcher("./food/jsps/login.jsp").forward(request, response);
		}
		else
		{
			
			String wineid=request.getParameter("winedid");
			String orderid=(String) request.getSession().getAttribute("orderid");
			
			int id=order.GetWineMaxId();
			if(id==0)
			{
				id=1;
			}
			else 
			{
				id++;		
			}
			
			order.InsertWine(orderid, wineid,id);
			
			request.getRequestDispatcher("displayFoodController?type=displaywine").forward(request, response);
		}
	}
	

}
