// imports
import java.util.ArrayList;

/**
 * 
 *
 */
public class Company {
	// Fields
	private String companyName;
	private ArrayList<Employee> employees;
	private static int numberOfCompanies = 0;
	private int numDesign;
	private int numEmployees;
	private int numManufacturing;
	private int numSales;
	
	/**
	 * Constructor for company
	 * @param arg name of company
	 */
	public Company(String arg)
	{
		// Instantiate fields
		companyName = arg;
		employees = new ArrayList<Employee>();
		numSales = 0;
		numEmployees = 0;
		numDesign = 0;
		numManufacturing = 0;
		updateCompanyNumber();
	}
	
	/**
	 * Add an employee to company
	 * @param fName first name of employee
	 * @param lName last name of employee
	 * @param pos position of employee
	 * @return null if successful add. Returns a string that describes the reason for not adding the employee. 
	 */
	public String addEmployee(String fName, String lName, String pos)
	{	
		Position p;
		if(numSales == 1 && pos == "Sales"){
			return "There is already a sales person\nEmployee not added";
		}
		else if(numDesign == 2 && pos == "Design")
			return "There are already two design persons\nEmployee not added";
		else if(numManufacturing == 4 && pos == "Manufacturing")
			return "There are already four manufacturing persons\nEmployee not added";
		else if(this.getNumEmployees()== 7)
			return "There are already 7 employees\nEmployee not added";
		else if(pos != "Sales" && pos != "Design" && pos!= "Manufacturing")
			return "That position does not exist";
		else{
			if(pos == "Sales"){
				p = Position.SALES;
				numSales++;
			}
			else if (pos == "Design"){
				p = Position.DESIGN;
				numDesign++;
			}
			else{
				p = Position.MANUFACTURING;
				numManufacturing++;
			}
			Employee e = new Employee(fName, lName, p);
			employees.add(e);
			numEmployees++;
			return null;
		}
	}
	
	/**
	 * Gets the amount of companies
	 * @return number of companies
	 */
	public static int getNumCompanies()
	{
		return numberOfCompanies;
	}
	
	private static void updateCompanyNumber()
	{
		numberOfCompanies += 1;
	}
	
	public static void resetCompanyCount()
	{
		numberOfCompanies = 0;
	}
	/**
	 * Gets the number of employees
	 * @return number of employees
	 */
	public int getNumEmployees()
	{
		return numEmployees;
	}
	
	/**
	 * Returns a String representation of the company
	 * @return
	 */
	public String printCompany()
	{
		String a = companyName;
		a = this.companyName + "\n";
		for(Employee e: employees){
			a += e.getfName() + " " + e.getlName() + " " + e.getPosition().substring(0,1).toUpperCase() + e.getPosition().substring(1).toLowerCase() + "\n";
		}
		return a;
	}
	
	/**
	 * Returns a String representation of the company
	 * @return String representation
	 */
	public String toString()
	{
		return printCompany();
	}
	
}
