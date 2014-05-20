// Imports used in CompanyDriver
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * CompanyDriver starts the program and provides a GUI
 *
 */
@SuppressWarnings("serial")
public class CompanyDriver extends JFrame implements ActionListener{
	// Fields
	private Company thisCompany;
	private String companyName;
	private JTextField fNameText;
	private JTextField lNameText;
	private JRadioButton design;
	private JRadioButton sales;
	private JRadioButton manufacturing;
	
	/**
	 * Constructor sets up the instance of the class
	 */
	public CompanyDriver()
	{
		// Get company name from user and use this to set title and create new Company instance
		companyName = JOptionPane.showInputDialog("What is the name of this company?");
		thisCompany = new Company(companyName);
		setTitle(companyName);
		// Settings for frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		setSize(315, 470);
		setVisible(true);
		setResizable(false);
		// instantiate fields
		fNameText = new JTextField(15);
		lNameText = new JTextField(15);
		// Build frame
		buildTopPanel();
		buildMidPanel();
		buildBotPanel();
	}
	
	/**
	 * Main starts the program
	 * @param args default arguments to main
	 */
	public static void main(String[] args)
	{
		new CompanyDriver();
	}

	
	/**
	 * Builds the top panel of the JFrame
	 */
	private void buildTopPanel()
	{
		// Create the top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// Image used in top panel
		ImageIcon image = new ImageIcon("company.jpg");
		JLabel imageLabel = new JLabel(image);
		JLabel companyNameLabel = new JLabel("   " + companyName);
		JLabel filler = new JLabel("                          ");  // used to make flow across new row
		JLabel presidentNameLabel = new JLabel("President: Obama");
		// Add components to top panel
		topPanel.add(imageLabel);
		topPanel.add(companyNameLabel);
		topPanel.add(filler);
		topPanel.add(presidentNameLabel);
		// add to JFrame
		add(topPanel);
		
	}
	
	/*
	 * Builds the middle panel of the JFrame
	 */
	private void buildMidPanel()
	{
		// setup mid panel properties
		JPanel midPanel = new JPanel();
		midPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		 
		/*Components for mid panel*/
		// Name
		JLabel firstName = new JLabel("First Name: ");
		JLabel lastName = new JLabel("Last Name: ");
		// Position JPanel setup
		JPanel position = new JPanel();
		position.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "Position"));
		// Setup radio buttons
		design = new JRadioButton("Design");
		sales = new JRadioButton("Sales");
		manufacturing = new JRadioButton("Manufacturing");
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(design);
		radioGroup.add(sales);
		radioGroup.add(manufacturing);
		// Add buttons to position
		position.add(design);
		position.add(sales);
		position.add(manufacturing);
		// Setup last two buttons
		JButton addEmployee = new JButton("Add Employee");
		JButton clear = new JButton("Clear");
		// Add Action Listeners
		addEmployee.addActionListener(this);
		clear.addActionListener(this);
		// Set Action Commands
		addEmployee.setActionCommand("1");
		clear.setActionCommand("2");
		// Add last two buttons
		midPanel.add(firstName);
		midPanel.add(fNameText);
		midPanel.add(lastName);
		midPanel.add(lNameText);
		midPanel.add(position);
		midPanel.add(addEmployee);
		midPanel.add(clear);
		add(midPanel);
		
	}
	
	/**
	 * Builds the bottom panel of the JFrame
	 */
	private void buildBotPanel()
	{
		// Setup Panel
		JPanel botPanel = new JPanel();
		// Setup JButtons
		JButton jPrint = new JButton("Print Company Employees");
		JButton jNew = new JButton("New Company");
		JButton jExit = new JButton("Exit");
		// Add Action Listeners
		jPrint.addActionListener(this);
		jNew.addActionListener(this);
		jExit.addActionListener(this);
		// Setup Action commands
		jPrint.setActionCommand("3");
		jNew.setActionCommand("4");
		jExit.setActionCommand("5");
		botPanel.add(jPrint);
		botPanel.add(jNew);
		botPanel.add(jExit);
		add(botPanel);
	}
	
	

	/**
	 * Performs actions for JButtons that are pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int value = Integer.parseInt(e.getActionCommand());
		switch (value) {
		// add employee button pressed
		case 1:
			String errorMessage = null;
			if(design.isSelected() == true)
				errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Design");
			else if(sales.isSelected() == true)
				errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Sales");
			else if(manufacturing.isSelected() == true)
				errorMessage = thisCompany.addEmployee(fNameText.getText(), lNameText.getText(), "Manufacturing");
			else{
				errorMessage = "No position was selected";
			}
			if(errorMessage != null)
				JOptionPane.showMessageDialog(this, errorMessage);
			break;
		// clear button pressed
		case 2:
			fNameText.setText("");
			lNameText.setText("");
			break;
		// Print Company Employees button pressed
		case 3:
			JOptionPane.showMessageDialog(this, thisCompany.printCompany());
			break;
		// New Company button pressed
		case 4:
			if(Company.getNumCompanies() >= 2)
				JOptionPane.showMessageDialog(this, "There are already two companies\n Company not added");
			else{
				String[] args = {" "};
				main(args);
			}
			break;
		// Exit button pressed
		case 5:
			setVisible(false);
			dispose();
			break;
		}
	}
	

}
