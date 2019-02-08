// This program uses the information given by the tutorial given by Kelli Kleindorfer. I created this file using the tutorial. I added comments and change several values to match my original class.
// Benjamin Frederickson
// bfrederickson@dmacc.edu
// 1-24-2019

package controller;

// Imports used in the program.
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.PetList;

public class PetListHelper 
{
	// Relate this class to the persistence.xml file.
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pets");

	// This method inserts a item into the database.
	public void insertItem(PetList pl) 
	{
		// Create a EntityManager, start a transaction, send the new pet information, commit it to the database, close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pl);
		em.getTransaction().commit();
		em.close();
	}

	// This method shows all the items from the database.
	public List<PetList> showAllItems() 
	{
		// Create a EntityManager, pass a SQL command and get the results, return the results.
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Make the warning disappear from the line below.
		List<PetList> allItems = em.createQuery("SELECT i FROM PetList i").getResultList();
		return allItems;
	}

	// This method deletes an item from the database.
	public void deleteItem(PetList toDelete) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.type = :selectedType and li.owner = :selectedOwner and li.name = :selectedName", PetList.class);
		
		// Substitute parameter with actual data from the toDelete item.
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());
		typedQuery.setParameter("selectedName", toDelete.getName());

		// Make sure there is only one result.
		typedQuery.setMaxResults(1);

		// Get the result and save it into a new list item.
		PetList result = typedQuery.getSingleResult();

		// Remove it, commit it, and close the transaction.
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	
	// This method searches the database using a PetID.
	public PetList searchForItemByPetID(int PetIDToEdit) 
	{
		// Create a EntityManager, start a transaction, find a petID from the int given, close the transaction, return the found information.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PetList found = em.find(PetList.class, PetIDToEdit);
		em.close();
		return found;
	}
	
	// This method updates an item in the database.
	public void updateItem(PetList toEdit) 
	{
		// Create a EntityManager, start a transaction, merge the existing information with the new pet information given, commit it, and close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	// This method searches the database using a pet's type.
	public List<PetList> searchForItemByType(String typeName) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command, grab the information given and update the foundItems list, close the transaction and return the list.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.type = :selectedType", PetList.class);
		typedQuery.setParameter("selectedType", typeName);

		List<PetList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	// This method searches the database using a pet's owner.
	public List<PetList> searchForItemByOwner(String ownerName) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command, grab the information given and update the foundItems list, close the transaction and return the list.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.owner = :selectedOwner", PetList.class);
		typedQuery.setParameter("selectedOwner", ownerName);

		List<PetList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	// This method searches the database using a pet's name.
	public List<PetList> searchForItemByName(String name) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command, grab the information given and update the foundItems list, close the transaction and return the list.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetList> typedQuery = em.createQuery("select li from PetList li where li.name = :selectedName", PetList.class);
		typedQuery.setParameter("selectedName", name);

		List<PetList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	// This ends the emfactory's processes and ends the program.
	public void cleanUp()
	{
		emfactory.close();
	}

}