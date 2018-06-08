package joker.Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import joker.Service.Order;
import joker.Service.ServiceFactory;
import joker.Service.UserServer;
import joker.models.User;
/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "UserController1", urlPatterns = { "/UserController1" })
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private UserServer userServer;
	private Order order ;
	
    public UserController()
    {
    	        super();
    	        userServer=(UserServer) ServiceFactory.GetUserService();  
    	        order=(Order) ServiceFactory.GetOrderInterface();

        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		
		//System.out.println(type);
		if(type.equals("login"))
		{
			Login(request, response);
		}
		else if(type.equals("register"))
		{
			Register(request, response);
		}
		else if(type.equals("unlogin"))
		{
			Unlogin(request, response);
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}
	private void Unlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().setAttribute("orderid", null);
		request.getSession().setAttribute("userid", null);
		request.getRequestDispatcher("./food/jsps/login.jsp").forward(request, response); 
	}
	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		//拿到服务层的user服务		
		String num=request.getParameter("uId");
		String password=request.getParameter("uPaw");
		 
		if(userServer.LogIn(num, password))
		{
			if(request.getSession().getAttribute("userid")==null)//不能重复登陆
			{
				User user=userServer.GetUserById(num);
			//跳转
				String ispay="0";
				String orderId=order.GetMaxId();
				if(orderId==null)
				{
					orderId="1001";//如果数据库没有数据，辣么就初始化
				}
				else 
				{
					int id=Integer.parseInt(orderId);//如果数据库有数据就拿出来加一
					id++;
					orderId=Integer.toString(id);
				}		
				order.InsertOrder(orderId, user.get_id(), ispay);  //初始化订单	
				request.getSession().setAttribute("orderid", orderId);
				request.getSession().setAttribute("userid", num);
			
				request.getRequestDispatcher("./food/jsps/user_index.jsp").forward(request, response);
			  }
			else 
			{
				response.sendRedirect("./food/jsps/error.jsp");
			}
		}
		else 
		{
			request.setAttribute("error", "登陆失败");
			request.getRequestDispatcher("./food/jsps/login.jsp").forward(request, response);
			//跳转
			
		}
			
		
	}
	private void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User user=new User();
		int count=userServer.GetMaxId();
		user.set_id(count+1);
		user.set_name(request.getParameter("user_name"));
		System.out.println(user.get_name());
		user.set_phoneNum(request.getParameter("user_phone"));
		user.set_passWord(request.getParameter("user_password"));
		user.set_discount(1);
		user.set_key(0);
		userServer.Register(user);
		request.getRequestDispatcher("./food/jsps/login.jsp").forward(request, response);										
	}
	

}
