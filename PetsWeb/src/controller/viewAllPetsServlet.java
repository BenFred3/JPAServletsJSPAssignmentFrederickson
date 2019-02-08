package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllPetsServlet
 */
@WebServlet("/viewAllPetsServlet")
public class viewAllPetsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllPetsServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a PetListHelper Object.
		PetListHelper plh = new PetListHelper();
		
		// Get the Attribute from the previous servlet.
		request.setAttribute("allItems", plh.showAllItems());
		
		// If the attribute is empty then set a blank attribute to avoid errors.
		if(plh.showAllItems().isEmpty())
		{
			request.setAttribute("allItems", " ");
		}
		
		// Pass the request and responses to the jsp.
		getServletContext().getRequestDispatcher("/pet-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
