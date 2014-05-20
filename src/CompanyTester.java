import static org.junit.Assert.*;


import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is a JUnit test program to test the Company.
 * The following classes must be defined and implemented:
 * Position - enumeration
 * Employee - data element
 * Company - data manager
 * @author Professor Myers changed by Prof. Justh
 *
 */
public class CompanyTester {

	/**  A Company object reference used for testing */
	Company company, studentCompany;
	
	@Before
	/** This method is run before each individual test
	 *   Creates an object of Company and adds three
	 *   Employees to the Company
	 */
	public void setUp() throws Exception {
		Company.resetCompanyCount();
		company = new Company("New Source");
		company.addEmployee("John", "Smith","Manufacturing");
		company.addEmployee("Bob", "Brown", "Manufacturing");
		company.addEmployee("Harold", "Jones", "Sales");
		company.addEmployee("Betty","Boop", "Design");
		
		//STUDENT: Create your own instance of company (studentCompany) and add employees.
		//You will use this studentCompany instance in the STUDENT test methods
		
		studentCompany = new Company("Second Source");
		studentCompany.addEmployee("Jack", "Ford", "Manufacturing");
		studentCompany.addEmployee("Ted", "Ford", "Manufacturing");
		studentCompany.addEmployee("Frank", "Ford", "Manufacturing");
		studentCompany.addEmployee("Josh", "Ford", "Manufacturing");
		studentCompany.addEmployee("Lauren","Boop", "Design");
		studentCompany.addEmployee("Hurly","Boop", "Design");
		studentCompany.addEmployee("Matt", "Jones", "Sales");
		
	}

	@After
	/** This method is run after each individual test
	 *   It sets the Company reference to null so the garbage
	 *   collector can reclaim the memory used for the
	 *   Company object
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		company = null;
		studentCompany = null;
	}
	
	
	@Test
	/**
	 * Use the studentCompany instance
	 * Test to 
	 * 1.  check the original number of employees
	 * 2.  Add another employee, and check if number of employees has increased by 1
	 * 
	 */
	public void testGetNumEmployeesSTUDENT() {
		assertEquals(7, studentCompany.getNumEmployees(),0);
	}
	
	@Test
	/**
	 * Test to
	 * 1.  add 3 new Employees as a manufacturing person
	 *     check if recognizes there are already 4 manufacturing persons
	 * 2.  add a new employee as a sales person
	 *     check if recognizes there is already a a sales person
	 * 3.  add 2 new employee as a design person
	 *     check if recognizes there is already 2 design persons
	 */
	public void testAddEmployee() {
		String result;
		//add another designer - No problem, should return null
		result = company.addEmployee("Bobby", "Match", "Design");
		assertEquals(null, result);
		//add another designer - already 2 designers - return error message
		result = company.addEmployee("Albert","Pine", "Design");
		assertEquals("There are already two design persons\nEmployee not added", result);
		//add another sales person - already 1 sales person - return error message
		result = company.addEmployee("Susie", "Smith", "Sales");
		assertEquals("There is already a sales person\nEmployee not added", result);
		//add another manufacturer - No problem, should return null
		result = company.addEmployee("Benedict", "Cumberbatch", "Manufacturing");
		assertEquals(null, result);
		//add another manufacturer - No problem, should return null
		result = company.addEmployee("Martin", "Freeman", "Manufacturing");
		assertEquals(null, result);
		//add another manufacturer - already 4 manufacturers - return error message
		result = company.addEmployee("Andrew", "Scott", "Manufacturing");
		assertEquals("There are already four manufacturing persons\nEmployee not added", result);
			
	}
	
	@Test
	/**
	 * Test to
	 * 1.  add a new Employees as a manufacturing person
	 *     check if recognizes there are already 4 manufacturing persons
	 * 2.  add a new employees as a sales person
	 *     check if recognizes there is already a a sales person
	 * 3.  add new employees as a design person
	 *     check if recognizes there are already 2 design persons
	 */
	public void testAddEmployeeSTUDENT() {
		
		String result;
		//add another designer - Should say not added
		result = studentCompany.addEmployee("Bobby", "Match", "Design");
		assertEquals("There are already two design persons\nEmployee not added", result);
		//add another sales person - already 1 sales person - return error message
		result = studentCompany.addEmployee("Susie", "Smith", "Sales");
		assertEquals("There is already a sales person\nEmployee not added", result);
		//add another manufacturer - already 4 manufacturers - return error message
		result = studentCompany.addEmployee("Andrew", "Scott", "Manufacturing");
		assertEquals("There are already four manufacturing persons\nEmployee not added", result);
		
	}

	@Test
	/**
	 * Test to:
	 * 1.  Check if the company name is on the first line
	 * 2.  Check if John is on the second line
	 * 3.  Check if Bob is on the third line
	 * 4.  Check if Harold is on the fourth line
	 * 5.  Check if Betty is on the fifth line
	 */
	public void testPrintCompany() {
		String result = company.printCompany();
		Scanner company = new Scanner(result);
		assertEquals("New Source",company.nextLine()); 
		//extract three Employees
		assertEquals("John", company.next());
		company.nextLine();  //Smith     Position design (rest of line)
		assertEquals("Bob", company.next());
		company.nextLine();  //Brown     Position manufacturing (rest of line)
		assertEquals("Harold",company.next()); //Harold
		company.nextLine();  //Jones     Position Sales (rest of line);
		assertEquals("Betty",company.next());
	}

	@Test
	/**
	 * Test to:
	 * 1.  Check if the company name is on the first line
	 * 2.  Check if other employees are in order as entered
	 */
	public void testPrintCompanySTUDENT() {
		assertEquals("New Source\nJohn Smith Manufacturing\nBob Brown Manufacturing\nHarold Jones Sales\nBetty Boop Design\n", company.printCompany());
				
	}
	
	@Test
	public void testMoreThan1company()
	{
		//created company and studentCompany instances
		assertEquals(2, Company.getNumCompanies());
		//create another company instance
		Company company2 = new Company("New Company");
		assertEquals(3, Company.getNumCompanies());
		
	}
}
