
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
* A class designed to help students in CSCI 1301 at UGA
* during their implementation of the "Bagels" project. This class
* uses reflection to examine the Player & Engine classes and checks 
* that methods are properly declared. 
* Included checks are:
* -method name
* -return type
* -parameters
* An important note: 
* 		This class does not test for correct functionality
* 
* @author MitchWilson
* @version 2.1 - Nov 2017
*/
public class BagelsMethodCheck {
	
	public static void main(String[] args){

		Method askForGuessMethod	 		 = null,													// Player class Method objects
				getNameMethod 		 		 = null,
				getFastestWinMethod 	     = null,
				getGamesCompletedMethod      = null,
				setNameMethod				 = null,
				updateStatsMethod 			 = null,
				
				convertNumToDigitArrayMethod = null,													// Engine class Method objects
				getNumDigitsMethod 			 = null,
				getSecretNumberMethod 		 = null,
				generateNewSecretMethod 	 = null,
				setNumDigitsMethod 			 = null,
				setSecretNumberMethod 		 = null;
		
																										// check Player for methods; all checks throw NoSuchMethodException

		try {
			askForGuessMethod = Player.class.getMethod("askForGuess", (Class<?> []) null);				// askForGuess()
		} catch (NoSuchMethodException e) {}
	
		try {
			getNameMethod = Player.class.getMethod("getName", (Class<?> []) null);						// getName()
		} catch (NoSuchMethodException e) {}
		
		try {
			getFastestWinMethod = Player.class.getMethod("getFastestWin", (Class<?> []) null);			// getFastestWin()
		} catch (NoSuchMethodException e) {}
			
		try {
			getGamesCompletedMethod 
				= Player.class.getMethod("getGamesCompleted", (Class<?> []) null);						// getGamesCompleted()
		} catch (NoSuchMethodException e) {}
				
		try {
			setNameMethod = Player.class.getMethod("setName", new Class[] {String.class});				// setName( String )
		} catch (NoSuchMethodException e) {}
		
		try {
			updateStatsMethod = Player.class.getMethod("updateStats", new Class[] {int.class});			// updateState( int )
		} catch (NoSuchMethodException e) {}
																										// check Engine for methods; all checks throw NoSuchMethodException
		try {
			convertNumToDigitArrayMethod 
				= Engine.class.getMethod("convertNumToDigitArray", new Class[] {String.class});			// convertNumToDigitArray( String )
		} catch (NoSuchMethodException e) {}
				
		try {
			getNumDigitsMethod = Engine.class.getMethod("getNumDigits", (Class<?> []) null);			// getNumDigits()
		} catch (NoSuchMethodException e) {}
				
		try {
			getSecretNumberMethod = Engine.class.getMethod("getSecretNumber", (Class<?> []) null);		// getSecretNumber()
		} catch (NoSuchMethodException e) {}
				
		try {
			generateNewSecretMethod = Engine.class.getMethod("generateNewSecret", (Class<?> []) null);	// generateNewSecret()
		} catch (NoSuchMethodException e) {}
				
		try {
			setNumDigitsMethod = Engine.class.getMethod("setNumDigits", new Class[] {int.class});		// setNumDigits( int )
		} catch (NoSuchMethodException e) {}
		
		try {
			setSecretNumberMethod
				= Engine.class.getMethod("setSecretNumber", new Class[] {int[].class});					// setSecretNumber(int[])
		} catch (NoSuchMethodException e) {}

		
		System.out.println("*************   Player   *************");
	
		checkFields(Player.class);																		// checkFields checks that the proper instance variables are declared
		
		System.out.println();
		
		constructorTest(Player.class);																	// constructorTest checks that there are no additional constructors as well as 
																										// 		that there are the required ones
		
		testMethod("askForGuess()", askForGuessMethod, String.class);									// askForGuess() should return a String
		testMethod("getName()", getNameMethod, String.class);											// getName() should return a String
		testMethod("getFastestWin()", getFastestWinMethod, Integer.TYPE);								// getFastestWin() should return an int
		testMethod("getGamesCompleted()", getGamesCompletedMethod, Integer.TYPE);						// getGamesCompleted() should return an int
		testMethod("setName(String)", setNameMethod, Void.TYPE);										// setName( String ) should return void
		testMethod("updateStats(int)", updateStatsMethod, Void.TYPE);									// updateStats( int ) should return void

		System.out.println("--------------------------------------");
		System.out.println("*************   Engine   *************");
		
		checkFields(Engine.class);																		// checkFields checks that the proper instance variables are declared
		System.out.println();
		constructorTest(Engine.class);

		testMethod("convertNumToDigitArray(String)", convertNumToDigitArrayMethod, int[].class);
		testMethod("getNumDigits()", getNumDigitsMethod, Integer.TYPE);
		testMethod("getSecretNumber()", getSecretNumberMethod, int[].class);
		testMethod("generateNewSecret()", generateNewSecretMethod, Void.TYPE);
		testMethod("setNumDigits(int)", setNumDigitsMethod, Void.TYPE);
		testMethod("setSecretNumber(int[])", setSecretNumberMethod, Void.TYPE);
			
	}
	
	/**
	 * Method for checking if the student created any constructors
	 * in a given class
	 * 
	 * The project instructions say that they are not to create any
	 * constructors and that we will use the default constructors
	 * during grading. There are 3 different cases that are checked
	 * by this method:
	 * 	1) There is no default constructor - result: fail
	 *  2) There is a default constructor, but there is also another 
	 *  	constructor - result: warning
	 *  3) There is only a default constructor - result: pass
	 *  
	 *  NOTE: for this implementation, we don't care if the student 
	 *  creates/implements a default constructor, we just care that 
	 *  the default constructor is there
	 *  
	 * @param clazz - the class to be checked
	 */
	private static void constructorTest(Class<?> clazz){
		System.out.print("Constructor: \t\t\t");
		Constructor<?> [] arr = clazz.getDeclaredConstructors();
		boolean moreThan1 = false;
		if (arr.length > 1){
			//there's more than 1 constructor
			moreThan1 = true;
		}
		boolean defaultExists = false;
		for (Constructor<?> c: arr){
			//loop through all constructors, looking for default 
			//default constructor has no parameters
			if (c.getParameterCount() == 0)
				defaultExists = true;
		}
		
		if (!defaultExists){
			//if the default doesn't exist
			//we don't really care how many there were
			System.out.println("FAIL: ");
			System.out.println("You should not create any constructors");
		
		}else if (moreThan1 && defaultExists){
			//if there was more than 1 constructor, but the
			//default exists..give warning
			System.out.println("WARNING: ");
			System.out.println("The default constructor exists, but you should not create any others");
		
		}else if (!moreThan1 && defaultExists){
			//there was only one & it was the default
			System.out.println("passed");
		}
		
		System.out.println("\n--------------------------------------");
	}

	/**
     * Method for checking if a method is correctly declared in a Stat class
     * @param methodName - the String representation of the method - only used for printing in the test
     * @param method - the Method object that we are testing. Prints an error if the method is null, 
     * which would result from improper spelling or improper parameters. Prints an error if the method
     * has incorrect return type
     * @param type - the return type of the method being testing
     */
    private static void testMethod(String methodName, Method method, java.lang.reflect.Type returnType){
        System.out.print(methodName + ":\t" + tabs(methodName)); 
         
        //just for looking good
        if(methodName.length() < 7) System.out.print("\t");
         
        if (method == null) 
            System.out.println("failed\n *incorrect parameters, incorrectly spelled, or non-existent*");
        else if
            (!method.getReturnType().equals(returnType)) System.out.println("failed\n *incorrect return type*");
        else
            System.out.println("passed");
         
        System.out.println("\n--------------------------------------");
    }
    
    /**
     * Just for helping the output line up and look pretty.
     * Takes a method name as a string and decides how 
     * many tabs to return based on the length of the name
     * @param method - the String name to check
     * @return - tabs based on the method name
     */
    private static String tabs(String method){
    	if (method.equals("askForGuess()") || method.equals("getName()")
    			|| method.equals("getNumDigits()")){
    		return "\t\t";
    		
    	} else if (method.equals("getFastestWin()") || method.equals("getGamesCompleted()")
    			||method.equals("setName(String)") || method.equals("updateStats(int)")
    			|| method.equals("getSecretNumber()") || method.equals("generateNewSecret()")
    			|| method.equals("setNumDigits(int)") || method.equals("setSecretNumber(int[])")){
    		return "\t";
    		
    	} else return "";
    }
    
    /**
     * A method to check all the instance variables of a class to see if they 
     * correspond to the given UML
     * @param clazz
     */
    private static void checkFields(Class<?> clazz){
    	System.out.println("\n" + clazz.getSimpleName() + " instance variables:");
    	//array of all Fields in the class
    	Field[] fields = clazz.getDeclaredFields();
    	//2 ArrayLists to hold the types of the Fields and the names of the Fields
		List<Class<?>> fieldTypes = new ArrayList<Class<?>>();
		List<String> fieldNames = new ArrayList<String>();
		
		//populate both ArrayLists
		for (Field f : fields){
			//System.out.println(f.getName() + ": " + f.getType());
			fieldTypes.add(f.getType());
			fieldNames.add(f.getName());
		}
		
		//player class test
    	if (clazz.equals(Player.class)){
    		boolean name = false, fastestWin = false, gamesCompleted = false, keyboard = false;
    		
    		System.out.print("String name\t\t\t");
    		try{
    			
	    		if (fieldTypes.get(fieldNames.indexOf("name")).equals(String.class)){
	    			System.out.println("passed");
	    			name = true;
	    		} else System.out.println("failed");
	    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}	
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		System.out.print("int fastestWin\t\t\t");
    		try{
    			
    			//could throw OutOfBoundsException if indexOf returns -1
	    		if (fieldTypes.get(fieldNames.indexOf("fastestWin")).equals(int.class)){
	    			System.out.println("passed");
	    			fastestWin = true;
	    			
	    		} else System.out.println("failed");
    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		System.out.print("int gamesCompleted\t\t");
    		try{
    			
	    		if (fieldTypes.get(fieldNames.indexOf("gamesCompleted")).equals(int.class)){
	    			System.out.println("passed");
	    			gamesCompleted = true;
	    			
	    		} else System.out.println("failed");
    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		System.out.print("Scanner keyboard\t\t");
    		try{
    			
    			//could throw OutOfBoundsException if indexOf returns -1
	    		if (fieldTypes.get(fieldNames.indexOf("keyboard")).equals(java.util.Scanner.class)){
	    			System.out.println("passed");
	    			keyboard = true;
	    			
	    		} else System.out.println("failed");
    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		//if the Player variables all exists but another instance variable was created
    		if (name && fastestWin && gamesCompleted && keyboard && fields.length> 4){
    			System.err.println("You should not declare any more instance variables other than"
    					+ "\n name, fastestWin, gamesCompleted, keyboard.");
    			System.exit(0);
    		}
    		
    	}else if (clazz.equals(Engine.class)){
    		boolean numDigits = false, secretNumber = false, rNG = false;
    		System.out.print("int numDigits\t\t\t");
    		try{
    			
	    		if (fieldTypes.get(fieldNames.indexOf("numDigits")).equals(int.class)){
	    			System.out.println("passed");
	    			numDigits = true;
	    			
	    		} else System.out.println("failed");
    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		System.out.print("int[] secretNumber\t\t");
    		try{
    			
    			//could throw OutOfBoundsException if indexOf returns -1
	    		if (fieldTypes.get(fieldNames.indexOf("secretNumber")).equals(int[].class)){
	    			System.out.println("passed");
	    			secretNumber = true;
	    			
	    		} else System.out.println("failed");
    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		System.out.print("Random randomNumberGenerator\t");
    		try{
    			
    			//could throw OutOfBoundsException if indexOf returns -1
	    		if (fieldTypes.get(fieldNames.indexOf("randomNumberGenerator")).equals(java.util.Random.class)){
	    			System.out.println("passed");
	    			rNG = true;
	    			
	    		} else System.out.println("failed");
    		
    		}catch(Exception e){
    			System.out.println("failed");
    		}
    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    		
    		//if the Engine variables all exists but another instance variable was created
    		if (numDigits && secretNumber && rNG && fields.length > 3){
    			System.err.println("You should not declare any more instance variables other than"
    					+ "\n numDigits, secretNumber, randomNumberGenerator.");
    			System.exit(0);
    		}
    		
    	} else 
    		//this is a private method and will only be called with Player or Engine as a param
    		//if, for some reason, it isn't --- friendly reminder by 
    		throw new IllegalArgumentException(clazz.getName());
    }
}