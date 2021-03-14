package edu.usm.cos420.ConsultingRegister.delegate;

import java.util.Scanner;

public class VisitView {
	/** {@value}  : no choice selected by user */
	public static final int NO_CHOICE = 0;
	/** {@value #ADDONE}  : Add one CItem to the collection of items */
    public static final int ADDONE = 1;
    public static final int GETALL = 2;
    public static final int CONSULT = 3;

	/** {@value #DISPLAYALL}  : Display CItem collection of items */
    public static final int EXIT = 6;
  
    // Object to read menu choices
    private Scanner in; 
 
    /**
     * This small version of the UI does not need the model or service objects but, in general, 
     *     references to these objects are needed in the UI. Default constructor
     *     creates a reference to Example1Service class to illustrate this.
     */
  public VisitView()
  {
	  in = new Scanner(System.in);  
  }
  /**
   * This small version of the UI does not need the model or service objects but, in general, 
   *     references to these objects are needed in the UI.
   * @param example1Service reference to class which provides CItem Services
   */
   public VisitView(Scanner input)
   {
	  this.in = input;
   }
   
  /**
   * Display top level menu.
   */
  public void displayMenu () {
    System.out.println();
    System.out.println("Enter the number denoting the action " +
                       "to perform:");
    System.out.println("ADD NEW PATIENT....................." + ADDONE);
    System.out.println("LIST PATIENTS....................." + GETALL);
    System.out.println("Enter the visit information........"+ CONSULT);
    System.out.println("Exit........................" + EXIT);
    
  }

  /**
   * Read the menu choice from user.
   * @param prompt Text asking user to enter choice
   * @return 
   *  <ul>
   *    <li>{@value #ADDONE}  : Add one item to the collection of items
   *    <li>{@value #DISPLAYALL}  : Display collection of items
   *    <li>{@value #EXIT}  : Exit the program 
   * </ul>
   */
  public int readIntWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    int choice = in.nextInt();
    return choice;
  }
  
  public Long readLongWithPrompt(String prompt)
  {
	    System.out.print(prompt); 
	    System.out.flush();
	    
	    /* validate answer */
	    Long answer = in.nextLong();
	    in.nextLine(); // i think this is required or things will break
	    
	    
	    return answer;
  }
  
  public String readStringWithPrompt(String prompt)
  {
	    System.out.print(prompt); 
	    System.out.flush();
	    String answer = in.nextLine();
	    return answer;
  }
  
  public char readCharWithPrompt(String prompt)
  {
	    System.out.print(prompt); 
	    System.out.flush();
	    char answer = in.next().charAt(0);
	    return answer;
  }
public Boolean readBooleanPrompt(String prompt) {
	
	System.out.print(prompt); 
    System.out.flush();
    char answer = in.next().charAt(0);
    if (answer == 'Y' || answer == 'y') {
    	return true;
    }
    else {
    	return false;
    }
}
  
}
