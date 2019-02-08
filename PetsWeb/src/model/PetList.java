// This program is a class to create a pet with values of petID, type, owner, and name. This class is to be used by other programs to create a pet database.
// Benjamin Frederickson
// bfrederickson@dmacc.edu
// 1-24-2019

package model;

// Imports used with @Entity.
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class PetList 
{
	// Instance variables.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PETID")
	private int petID;
	@Column(name="TYPE")
	private String type;
	@Column(name="OWNER")
	private String owner;
	@Column(name="NAME")
	private String name;
	
	// Default constructor.
	public PetList()
	{
		super();
	}
	
	// Constructor.
	public PetList(String type, String owner, String name)
	{
		super();
		this.type = type;
		this.owner = owner;
		this.name = name;
	}

	// Getters and setters.
	public int getPetID()
	{
		return petID;
	}
	public void setPetID(int petID)
	{
		this.petID = petID;
	}
	
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getOwner() 
	{
		return owner;
	}
	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	// Helper method.
	public String returnPetDetails()
	{
		return petID + ": Type - " + type + " | Owner - " + owner + " | Name - " + name;
	}
	
}
