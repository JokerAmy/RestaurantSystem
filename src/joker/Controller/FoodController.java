package joker.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import domain.MV;

import joker.Service.FoodService;
import joker.Service.ServiceFactory;
import joker.Service.WineService;
import joker.models.Food;
import joker.models.Wine;

/**
 * Servlet implementation class FoodController
 */
@WebServlet("/sys/FoodController")
public class FoodController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	
	private FoodService foodService=(FoodService) ServiceFactory.GetS_Breakfast();
    private WineService wineService=(WineService) ServiceFactory.GetWineInterface();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodController() 
    {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		
		
		
		
		
		String [] types=type.split("_");//将type分割
		
		if(types.length==1)
		{
			if(types[0].equals("displayBreakfast"))
			{
				DisPlayBreakfast(request, response);
			}
			else if(types[0].equals("displayLunch"))
			{
				DisPlayLunch(request, response);
			}
			else if(types[0].equals("displayDinner"))
			{
				DisPlayDinner(request, response);
			}
			else if(types[0].equals("savedata"))
			{
				SaveData(request, response);
			}
			else if(types[0].equals("toAdd"))
			{
				Transpond(request, response);
			}
			else if(types[0].equals("insertdata"))//添加数据
			{
				InsertData(request, response);
			}
			else if(types[0].equals("displayWine"))
			{
				DisPlayWine(request, response);
			}
			else if(types[0].equals("savewine"))
			{
				SaveWine(request, response);
			}
			else if(types[0].equals("toAddWine"))
			{
				ToaddWine(request, response);
			}
			else if(types[0].equals("insertwine"))
			{
				InsertWine(request, response);
			}
			
		}
		else 
		{
			if(types[0].equals("editfood"))
			{
				EditFood(request, response, types[1]);
			}
			else if(types[0].equals("delete"))
			{
				DeleteFood(request, response,types[1]);
			}
			else if(types[0].equals("editwine")) 
			{
				UpdateWine(request, response,types[1]);
			}
			else if(types[0].equals("deletewine"))
			{
				DeleteWine(request, response,types[1]);
			}
			
			
		}
		
		
	}
	private void InsertWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Wine wine=new Wine();
		
		
		//转化为int类型
		String Maxfid=wineService.GetMaxFid();
		
		if(Maxfid==null)
		{
			Maxfid="1001";
		}
		else
		{
			int id=Integer.parseInt(Maxfid);
			id++;
			Maxfid=Integer.toString(id);
			
		}
		wine.set_id(Maxfid);
		wine.set_name(request.getParameter("wine_name"));
		String price=request.getParameter("wine_price");
		wine.set_price(Float.parseFloat(price));
		
		wine.set_capacity(Float.parseFloat(request.getParameter("wine_capacity")));
		wine.set_brand(request.getParameter("wine_brand"));
		wine.set_imgAddress(request.getParameter("wine_img"));
		if(price.equals(""))
		{
			wine.set_price(Float.parseFloat("0"));
		}
		else 
		{
			wine.set_price(Float.parseFloat(price));
		}
		//
		
		
		if(wine.get_price()>0)
		{
			wineService.InsertWine(wine);
		}
	}
	private void ToaddWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("./managers/jsps/add_wine.jsp").forward(request, response);
	}
	private void SaveWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Wine wine=new Wine();
	
		wine.set_id(request.getParameter("id")); 
		wine.set_name(request.getParameter("wine_name"));
		wine.set_price(Float.parseFloat(request.getParameter("wine_price")));
		wine.set_capacity(Float.parseFloat(request.getParameter("wine_capacity")));
		
		wine.set_imgAddress(request.getParameter("wine_image"));
		wine.set_brand(request.getParameter("wine_brand"));
		
		
		wineService.UpdateWine(wine, wine.get_id());
		DisPlayWine(request, response);
		
		
	}
	private void DeleteWine(HttpServletRequest request, HttpServletResponse response,String wid) throws ServletException, IOException
	{
		wineService.DeleteWine(wid);
	}
	private void UpdateWine(HttpServletRequest request, HttpServletResponse response,String wid) throws ServletException, IOException
	{
		Wine wine=wineService.GetWineByID(wid);
		 request.setAttribute("wine",wine);
		
		request.getRequestDispatcher("./managers/jsps/edit_wine.jsp").forward(request, response);
	}
	
	private void DisPlayWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Wine> wines=wineService.GetWineAll();
		request.setAttribute("wines", wines);
		
		request.getRequestDispatcher("./managers/jsps/list_wine.jsp").forward(request, response);
		
	}
	private void DeleteFood(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException
	{
		foodService.DeleteFood(id);	
	}
	
	@SuppressWarnings("unused")
	private void InsertData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Food food=new Food();
		
		String Maxfid=foodService.GetMaxFid();		
		if(Maxfid==null)
		{
			Maxfid="1001";//当数据库中没有数据是初始化1001
		}
		else
		{
			int id=Integer.parseInt(Maxfid);
			id++;
			Maxfid=Integer.toString(id);
		}	
		String price=request.getParameter("food_price");
		
		food.set_FID(Maxfid);	
		food.set_Fname(request.getParameter("food_name"));
		if(price.equals(""))
		{
			food.set_Fprice(Float.parseFloat("0"));
		}
		else 
		{
			food.set_Fprice(Float.parseFloat(price));
		}
		//
		food.set_Ftime(request.getParameter("food_time"));
		food.set_Ftype(request.getParameter("food_type"));
		if(food.get_Fprice()>0)
		{
			foodService.InsertFood(food);
		}
		
		
		
	}
	private void Transpond(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		request.getRequestDispatcher("./managers/jsps/add_food.jsp").forward(request, response);
	}
	@SuppressWarnings("unused")
	private void DisPlayBreakfast(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		
		List<Food> foods=foodService.GetFoodByType("早餐");
	
		
		request.setAttribute("FoodList", foods);
	
		request.getRequestDispatcher("./managers/jsps/list_breakfast.jsp").forward(request, response);
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	private void DisPlayLunch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Food> foods=foodService.GetFoodByType("中餐");
		request.setAttribute("FoodList", foods);
		request.getRequestDispatcher("./managers/jsps/list_breakfast.jsp").forward(request, response);
	}
	private void DisPlayDinner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Food> foods=foodService.GetFoodByType("晚餐");
	
		
		request.setAttribute("FoodList", foods);
	
		request.getRequestDispatcher("./managers/jsps/list_breakfast.jsp").forward(request, response);
	}
	private void EditFood(HttpServletRequest request, HttpServletResponse response,String id) throws ServletException, IOException
	{
		
		
		 Food food=foodService.GetFoodByID(id);
		 request.setAttribute("food",food);
		
		request.getRequestDispatcher("./managers/jsps/edit_breakfast.jsp").forward(request, response);
	}
	private void SaveData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Food food=new Food();
		
		food.set_FID(request.getParameter("id")); 
		food.set_Fname(request.getParameter("food_name"));
		food.set_Fprice(Float.parseFloat(request.getParameter("food_price")));
		food.set_Ftime(request.getParameter("food_time"));
		food.set_Ftype(request.getParameter("food_type"));
		food.set_img(request.getParameter("food_image"));
		
		
		
		foodService.UpdateFood(food, food.get_FID());
		
		
		if(food.get_Ftype().equals("早餐"))//跳转
		{
			DisPlayBreakfast(request, response);
		}
		else if(food.get_Ftype().equals("晚餐"))
		{
			System.out.println(food.get_Ftype());
			DisPlayDinner(request, response);
		}
		else if(food.get_Ftype().equals("中餐"))
		{
			DisPlayLunch(request, response);
		}	
	}
}
