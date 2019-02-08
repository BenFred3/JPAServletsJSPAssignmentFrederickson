package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetList;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a PetListHelper object.
		PetListHelper plh = new PetListHelper();
		// Get user's response parameter and set it to a string.
		String act = request.getParameter("doThisToItem");
		
		// If no button has been selected do this.
		if (act == null) 
		{
			// Return to the viewAllItemsServlet to redisplay the page.
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		} 
		// If a button is checked see if it's delete if it is, do this.
		else if (act.equals("delete")) 
		{
			// Try and catch statement to avoid errors.
			try 
			{
				// Get the petId, pass it to the search function, then send the results to the delete function.
				Integer tempID = Integer.parseInt(request.getParameter("petID"));
				PetList itemToDelete = plh.searchForItemByPetID(tempID);
				plh.deleteItem(itemToDelete);
			}
			catch (NumberFormatException exception)
			{
				// If the user didn't select anything print this to console.
				System.out.println("Forgot to click a button.");
			}
			finally
			{
				// After the try-catch pass back the request and response to the servlet.
				getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
			}
		} 
		// If a button is checked see if it's edit if it is, do this.
		else if (act.equals("edit")) 
		{
			try 
			{
				// Get the petId, pass it to the search function, then send the results to edit-item.jsp in the form of a attribute.
				Integer tempID = Integer.parseInt(request.getParameter("petID"));
				PetList itemToEdit = plh.searchForItemByPetID(tempID);
				request.setAttribute("itemToEdit", itemToEdit);
				getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
			} 
			catch (NumberFormatException e) 
			{
				// If the user didn't select anything return to the servlet.
				getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
			}
		} 
		// If a button is checked see if it's add if it is, do this.
		else if (act.equals("add")) 
		{
			// Return to the index to allow the user to add to the database.
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
