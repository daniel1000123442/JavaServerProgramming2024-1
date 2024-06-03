package producteg;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(description = "제품컨드롤", urlPatterns = { "/pcontroller" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ProductService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        service = new ProductService();
    }


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//2024.4.29 Product 관리예제
			//MVC 중 Controller에 해당
			String action = request.getParameter("action");
			String view ="";
			
			if (request.getParameter("action") == null) {
				getServletContext().getRequestDispatcher("/pcontroller?action=list").forward(request, response);
			}
			else {
				switch(action) {
				case "list" : view =list(request,response); break;
				case "info" : view =info(request,response); break;
				}
				getServletContext().getRequestDispatcher(view).forward(request, response);
			}
		}


	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("p", service.find(request.getParameter("id")));
		return "/productinfo.jsp";
	}
	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", service.findAll());
		return "/productlist.jsp";
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				doGet(request, response);
		}
}


