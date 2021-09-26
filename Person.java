import java.text.DecimalFormat;


/**
 * Class representing a person (a human user) on a real estate market.
 * A person has a name, age, cash, and (potentially) a house.
 */
public class Person {

	/* Instance variables */

	private String name;
	private int age;
	private double cash;
	private House house;

	/* Constructors */

	/**
	 * The Default constructor creates a 21 year old John L. with a penny of cash and no home.
	 */
	public Person() {

		// Your code here
		this.name="John L.";
		this.age=21;
		this.cash=0.01;
		this.house=null;


	}
	/**
	 * A second constructor that enables the creation of a custom instance of the Person class. 
	 * The house instance variable is set to null.
	 * @param name : the person's name 
	 * @param age : the person's age
	 * @param cash : the amount of money the person has
	 */
	public Person(String name, int age, double cash) {

		// Your code here
		this.name=name;
		this.age=age;
		this.cash=cash;
		this.house=null;

	}

	/**
	 * A third constructor including a parameter for the persons house. The house is also updated
	 * because it is no longer for sale.
	 * @param name : the person's name 
	 * @param age : the person's age
	 * @param cash : the amount of money the person has
	 * @param house : the person's home
	 */
	public Person(String name, int age, double cash, House house) {

		// Your code here
		this.name=name;
		this.age=age;
		this.cash=cash;
		house.setForSale(false);
	}

	/**
	 * Show the name and age of the person as well as their assets (cash and home if they have one).
	 * E.g.
	 * Name: John L.
	 * Age: 20 years old
	 * Cash: $ 0.01
	 */
	@Override
	public String toString() {
		DecimalFormat decimalFormatObj = (DecimalFormat) DecimalFormat.getInstance();

		// Your code here
		String output;
		if(house==null) {
			output="Name: " + name + "\nAge: " + age + "\nCash: $" + cash;
		}
		else {
			output="Name: " + name + "\nAge: " + age + "\nCash: $" + cash + "\nHome: " + house;

		}
		return output; // replace this line with your own code
	}

	/* Accessors / Getters */

	/**
	 * @return the person's name 
	 */
	public String getName() {

		// Your code here

		return name; // replace this line with your own code
	}
	/**
	 * @return the person's age
	 */
	public int getAge() {

		// Your code here

		return age; // replace this line with your own code
	}

	/**
	 * @return the amount of cash this person has
	 */
	public double getCash() {

		// Your code here

		return cash; // replace this line with your own code
	}

	/**
	 * @return a reference the house object currently owned by this person
	 */
	public House getHouse() {

		// Your code here


		return house; // replace this line with your own code
	}


	/**
	 * @return true if this person has a home
	 */
	public boolean ownsAHouse() {

		// Your code here
		if (house==null) {
			return false; // replace this line with your own code
		}
		else {
			return true;
		}

	}

	/* Mutators */

	/**
	 * @param amount : the amount of cash to give this person
	 */
	public void addCash(double amount) {

		// Your code here
		cash=cash+amount;

	}

	/**
	 * If this person owns home, put it up for sale and pay the person the price of the home.
	 */
	public void sellHome() {
		// Your code here
		if(house==null) {
			System.out.println(name + " has no house to sell");	
		}
		else {
			cash = cash + house.getPrice();
			house.setForSale(true);
			System.out.println(name + " has sold their house!");
			house=null;

		}

	}

	/**
	 * This method lets the person buy a home if they do not already have a home, have the cash and the home is for sale.
	 * If the person successfully buys a home, their cash is decreased by the cost of the home.
	 * @param h the house to be bought
	 */
	public void buyHouse(House h) {

		// Your code here
		if((ownsAHouse()==false) && (cash<=h.getPrice()) && (h.isForSale()==true)) {
			cash=cash-h.getPrice();
			house=h;
			h.setForSale(false);
				
		}
		else {
			System.out.println(name + " cannot afford this home.");
		}

	}
}