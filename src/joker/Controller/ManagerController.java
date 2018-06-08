package joker.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import joker.Service.ManagerService;
import joker.Service.ServiceFactory;


/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private  ManagerService managerService=(ManagerService)ServiceFactory.GetManagerInterface();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		String num=request.getParameter("uId");
		String password=request.getParameter("uPaw");
		if(managerService.ManagerLogin(num, password))
		{
			request.getSession().setAttribute("Maccount", num);
			response.sendRedirect(request.getContextPath()+"/managers/jsps/sys_index.jsp");	//登陆成功
		}
		else 
		{
			
			request.setAttribute("error", "登陆失败");
			request.getRequestDispatcher("./managers/jsps/m_index.jsp").forward(request, response);
			
		}
	}

}
