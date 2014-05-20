
/**
 * Employee class represents an employee who has a first name, last name, and position
 *
 */
public class Employee {
	// fields
	private String fName;
	private String lName;
	private Position pos;
	
	/**
	 * Constructor
	 * @param fName first name
	 * @param lName last name
	 * @param pos position
	 */
	public Employee(String fName, String lName, Position pos)
	{
		this.fName = fName;
		this.lName = lName;
		this.pos = pos;
	}
	
	/**
	 * Returns first name
	 * @return first name
	 */
	public String getfName()
	{
		return fName;
	}
	
	/**
	 * Returns last name
	 * @return last name
	 */
	public String getlName()
	{
		return lName;
	}
	
	/**
	 * Returns position
	 * @return position
	 */
	public String getPosition()
	{
		return pos.name();
	}
	
	
}
