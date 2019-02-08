package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetList;

/**
 * Servlet implementation class editPetServlet
 */
@WebServlet("/editPetServlet")
public class editPetServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPetServlet() 
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
		
		// Request the three parameters and set them to strings.
		String type = request.getParameter("type");
		String owner = request.getParameter("owner");
		String name = request.getParameter("name");
		
		// Create a integer to hold the petID.
		Integer tempID = Integer.parseInt(request.getParameter("petID"));
		// Get the PetList object from the id.
		PetList itemToUpdate = plh.searchForItemByPetID(tempID);
		// Pass the strings from earlier to the PetList Item..
		itemToUpdate.setType(type);
		itemToUpdate.setOwner(owner);
		itemToUpdate.setName(name);
		// Update the item.
		plh.updateItem(itemToUpdate);
		// Return to the servlet.
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);

	}

}
