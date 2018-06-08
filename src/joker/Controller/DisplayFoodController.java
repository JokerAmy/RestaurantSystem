package joker.Controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joker.Service.FoodService;
import joker.Service.ServiceFactory;
import joker.Service.WineService;
import joker.models.Food;
import joker.models.Wine;





/**
 * Servlet implementation class DisplayFoodController
 */
@WebServlet("/DisplayFoodController")
public class DisplayFoodController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    private FoodService foodService=null;
    private WineService wineService=null;


    public DisplayFoodController() 
    {
        super();
        foodService=(FoodService) ServiceFactory.GetS_Breakfast();
        wineService=(WineService)ServiceFactory.GetWineInterface();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String type=request.getParameter("type");
		
		//System.out.println(type);
		
		
		if(type.equals("displaybreakfast"))
		{
			DisplayBreakfast(request, response);
		}
		else if (type.equals("displaylunch")) 
		{
			DisplayLunch(request, response);
		}
		else if (type.equals("displaydinner")) 
		{
			DisplayDinner(request, response);
		}
		else if(type.equals("displaywine"))
		{
			DisPlayWine(request, response);
		}
	}
	private void DisPlayWine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Wine> wines=wineService.GetWineAll();
		request.setAttribute("winelist", wines);
		request.getRequestDispatcher("./food/jsps/wine_select.jsp").forward(request, response);
	}
	private void DisplayBreakfast(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		List<Food> foodlist=foodService.GetFoodByType("早餐");
		request.setAttribute("foodlist", foodlist);
		
		
		request.getRequestDispatcher("./food/jsps/food_select.jsp").forward(request, response);
	}
	private void DisplayLunch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Food> foodlist=foodService.GetFoodByType("中餐");
	
		request.setAttribute("foodlist", foodlist);
		request.getRequestDispatcher("./food/jsps/food_select.jsp").forward(request, response);
	}
	private void DisplayDinner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Food> foodlist=foodService.GetFoodByType("晚餐");
	
		request.setAttribute("foodlist", foodlist);
		request.getRequestDispatcher("./food/jsps/food_select.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doGet(request, response);
	}

}
