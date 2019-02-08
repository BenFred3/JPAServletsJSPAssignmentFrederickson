// This program was based off of the skeleton program that Kelli Kleindorfer provided. You can view her version here: https://github.com/kjkleindorfer/ConsoleShoppingList/blob/master/src/StartProgram.java
// I have changed variable names, some structure, added comments, how information is displayed to the user, functionality, and edited it to work with my helper class and original class.
// Benjamin Frederickson
// bfrederickson@dmacc.edu
// 1-24-2019

// Imports used by the program.
import java.util.List;
import java.util.Scanner;
import controller.PetListHelper;
import model.PetList;

public class PetStartProgram 
{
	// Scanner to have the user enter in info.
	static Scanner in = new Scanner(System.in);
	// Reference to PetListHelp to allow use of it's methods.
	static PetListHelper plh = new PetListHelper();

	// This method allows the user to add new pets.
	private static void addItem() 
	{
		// The method asks the user for the pet's type, owner, and name then adds the pet.
		System.out.print("Please enter a pet's type: ");
		String type = in.nextLine();
		System.out.print("Please enter a pet's owner: ");
		String owner = in.nextLine();
		System.out.print("Please enter a pet's name: ");
		String name = in.nextLine();

		// It then creates a PetList object that it adds all the newly created variables to.
		PetList itemsToAdd = new PetList(type, owner, name);
		// Then it sends the PetList object (itemsToAdd) to the insertItem method in the PetListHelper class.
		plh.insertItem(itemsToAdd);
	}
	
	// This method allows the user to delete pets.
	private static void deleteItem() 
	{
		// This method asks the user for the pet's type, owner, and name then deletes the pet.
		System.out.print("Enter the pet's type to delete: ");
		String type = in.nextLine();
		System.out.print("Enter the pet's owner to delete: ");
		String owner = in.nextLine();
		System.out.print("Enter the pet's name to delete: ");
		String name = in.nextLine();

		// It then creates a PetList object that it adds all the newly created variables to.
		PetList itemsToDelete = new PetList(type, owner, name);
		// Then it sends the PetList object (itemsToDelete) to the deleteItem method in the PetListHelper class.
		plh.deleteItem(itemsToDelete);
	}
	
	// This method allows the user to edit pet's information
	private static void editItem() 
	{
		// This method asks the user to choose from these three options.
		System.out.println("Please choose an item to search by: ");
		System.out.println("1 - Search by pet's type");
		System.out.println("2 - Search by pet's owner");
		System.out.println("3 - Search by pet's name");
		// Create a variable for the user's response and set it to the response.
		int searchBy = in.nextInt();
		in.nextLine();
		// Create a list for all the found items in this method.
		List<PetList> foundItems = null;
		
		// If the user chooses one do this.
		if (searchBy == 1) 
		{
			// Ask the user for the pet's type.
			System.out.print("\nEnter the pet's type: ");
			String petType = in.nextLine();
			// Send the user's choice to the method in PetListHelper to search for the type given.
			foundItems = plh.searchForItemByType(petType);
		} 
		// If the user chooses two do this.
		else if (searchBy == 2)
		{
			// Ask the user for the pet's owner.
			System.out.print("\nEnter the pet's owner: ");
			String petOwner = in.nextLine();
			// Send the user's choice to the method in PetListHelper to search for the owner given.
			foundItems = plh.searchForItemByOwner(petOwner);
		}
		// If the user chooses three do this.
		else if (searchBy == 3)
		{
			// Ask the user for the pet's name.
			System.out.print("\nEnter the pet's name: ");
			String petName = in.nextLine();
			// Send the user's choice to the method in PetListHelper to search for the name given.
			foundItems = plh.searchForItemByName(petName);
		}

		// If something is found the search function do this.
		if (!foundItems.isEmpty()) 
		{
			// Print out the information found.
			System.out.println("\nFound Results.");
			for (PetList petli : foundItems) 
			{
				System.out.println(petli.getPetID() + " : " + petli.returnPetDetails());
			}
			
			// Ask the user which ID is the correct pet.
			System.out.print("\nWhich ID to edit: ");
			int idToChange = in.nextInt();
			// Send the ID given to the search.
			PetList petToChange = plh.searchForItemByPetID(idToChange);
			
			// Print out the specific pet's information and ask the user what they want to update.
			System.out.println("\nRetrieved Pet: Type - " + petToChange.getType() + " | Owner - " + petToChange.getOwner() + "| Name - " + petToChange.getName());
			System.out.println("1 - Update pet's type");
			System.out.println("2 - Update pet's owner");
			System.out.println("3 - Update pet's name");
			// Create a variable for the user's response and set it to the response.
			int informationToUpdate = in.nextInt();
			in.nextLine();

			// If the user choose one do this.
			if (informationToUpdate == 1) 
			{
				// Ask for the new type then update it.
				System.out.print("Enter the pet's new type: ");
				String newType = in.nextLine();
				petToChange.setType(newType);
			} 
			// Else if the user choose two do this.
			else if (informationToUpdate == 2) 
			{
				// Ask for the new owner then update it.
				System.out.print("Enter the pet's new owner: ");
				String newOwner = in.nextLine();
				petToChange.setOwner(newOwner);
			}
			// Else if the user choose three do this.
			else if (informationToUpdate == 3)
			{
				// Ask for the new name then update it.
				System.out.print("Enter the pet's new name: ");
				String newName = in.nextLine();
				petToChange.setName(newName);
			}
			// Update the helper class.
			plh.updateItem(petToChange);
		} 
		// Else there was nothing found by the searches.
		else 
		{
			// Display this to the user.
			System.out.println("There was no information found by the term you selected.\nPlease update the database or try again.\n");
		}
		
	}

	// This method displays a menu for the user to choose the different functions.
	public static void runMenu() 
	{
		// Create a boolean to allow the loop to end.
		boolean loopIsntDone = true;
		// Greet the user.
		System.out.println("Welcome to the pet database program!");
		// While loop to create a constant menu till the user exits.
		while (loopIsntDone) 
		{
			// Print all the choices to the user.
			System.out.println("\nChoose a task to do:");
			System.out.println("1 - Add a new pet.");
			System.out.println("2 - Edit a pet's information.");
			System.out.println("3 - Delete a pet's information.");
			System.out.println("4 - View the pet database.");
			System.out.println("5 - Exit the pet database program.");
			// Create a variable for the user's response and set it to the response.
			int selection = in.nextInt();
			in.nextLine();
			
			// If the user chooses one go into the addItem function.
			if (selection == 1) 
			{
				System.out.println(""); // Space for output.
				addItem();
			} 
			// If the user chooses one go into the editItem function.
			else if (selection == 2) 
			{
				System.out.println(""); // Space for output.
				editItem();
			} 
			// If the user chooses one go into the deleteItem function.
			else if (selection == 3) 
			{
				System.out.println(""); // Space for output.
				deleteItem();
			} 
			// If the user chooses one go into the viewCurrentDatabase function.
			else if (selection == 4) 
			{
				System.out.println(""); // Space for output.
				viewCurrentDatabase();
			} 
			// Else end the program.
			else 
			{
				System.out.println(""); // Space for output.
				plh.cleanUp();
				System.out.println("Thank you for using the database!\nPlease come again.");
				loopIsntDone = false;
			}
		}
	}

	// This method allows the user to see the current pet database.
	private static void viewCurrentDatabase() 
	{
		// Get all the items and put them into a list.
		List<PetList> allItems = plh.showAllItems();
		// Use a for loop to print all the items out to the user.
		for(PetList singleItem : allItems)
		{
			System.out.println(singleItem.returnPetDetails());
		}
	}
	
	// Main method.
	public static void main(String[] args) 
	{
		// This starts the run menu command and allows the user to choose what to do next.
		runMenu();
	}
}