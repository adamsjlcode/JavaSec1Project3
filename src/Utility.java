import java.util.Scanner;

/**
 * ---------------------------------------------------------------------------
 * File name: Utility.java
 * Project name: Proj3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@goldmail.etsu.edu
 * Course:  CSCI 1250-003
 * Creation Date: Nov 4, 2015
 * ---------------------------------------------------------------------------
 */

/**
 * Programmmers Utility Program
 *
 * <hr>
 * Date created: Nov 4, 2015
 * <hr>
 * @author Justin Adams
 */
public class Utility
{
/**
 * Programmers Utility Program         
 *
 * <hr>
 * Date created: Nov 4, 2015
 * 
 * Notes: Ask User For The Of Assignment And Due Date
 * Display With The Assignment And Due Date
 * <hr>
 * @param Assign
 * @param Date
 */
Scanner kbInput = new Scanner(System.in);		//User input from keyboard
public void theProgrammerInfo(String Assign,String Date)
{
		System.out.print("\nProgram Name:\tProj3.java And 1900Project.java");
		System.out.print("\n  Programmer:\tJustin Adams");		
		System.out.print("\n       Class:\tCSCI 1250-003");
		System.out.print("\n         Lab:\t" + Assign);
		System.out.print("\n    Due Date:\t" + Date + "\n\n");	
}//End theProgrammerInfo(String,String)
/** 
* Method Name: pressEnterToContinue <br>
* Method Purpose: Pause Display For User 
* <hr>
* Date:09/23/2015
* <hr>
* Notes:
* <hr>
*
*/
public void pressEnterToContinue()
{
	System.out.println("\nPress Enter To Continue\n");
	kbInput.nextLine();	
	kbInput.nextLine();	
}//End pressEnterToContinue()
/**
 * Method to start program over         
 *
 * <hr>
 * Date created: Nov 7, 2015
 *
 * <hr>
 * 
 */
public char startOver()
{
	
	char cOver;					//Hold The Char To End Or Start Programs
	String strStart;			//User input For Starting Over The Program
	Scanner input = new Scanner(System.in);
	System.out.println("\n\nWould You Like To Restart The Program" + 
						" Add New Values.\nEnter Y For Yes Or N For No");
	strStart = input.nextLine();
	cOver = strStart.charAt(0);	//Turning User Input Into A Char
	return cOver;
}//End startOver()
/**
 * Menu interface for user        
 *
 * <hr>
 * Date created: Nov 5, 2015
 *
 * <hr>
 * @return iMenu
 */
public int menu ( )
{
	int iMenu;				//Holds integer for menu
	System.out.println  ("\n1. Add Grade           \t7. Change Number To Birary"+
														"/Ocatal/Hextal"
						+"\n2. Change Grade        \t8. Find GCF Of Two Ingeter"
						+"\n3. Set/Change Percent  \t9. Find LCM Of Two Ingeter" 
						+"\n4. View Averages      \t10. Student Info" 
						+"\n5. View Course Average\t11. Exit Program" 
						+"\n6. Set Class Info");
	iMenu = kbInput.nextInt();

	return iMenu;
	
}//End menu()

/**
 * Display Binery,Octal,Hex Format Of User Inputed Integer         
 *
 * <hr>
 * Date created: Nov 7, 2015
 *
 * <hr>
 * @param iX //Hold First Integer
 * 
 */
public void BinOctHex(int iX)
{	
	System.out.print("\nBinery: ");
	System.out.print(Integer.toBinaryString (iX));		
	System.out.print(" Octal: ");
	System.out.print(Integer.toOctalString(iX));		
	System.out.print("   Hex: ");
	System.out.print(Integer.toHexString(iX));
}//End BinOctHex(int)
/**
 * Find GCF (Greatest Common Factor) Of Two Integers        
 *
 * <hr>
 * Date created: Nov 7, 2015
 *
 * <hr>
 * @param iX //Hold First Integer
 * @param iY //Hold Second Integer
 * @return iX //Holds Greatest Common Factor of the two integers
 */
public int GCF(int iX, int iY)
{
	int iS;				//Holds greatest integer
	while(iY > 0)
	{
		iS = iY;
		iY = iX%iY;
		iX = iS;
	}
	return iX;
	
}//End GCF(int,int)
/**
 * Find LCM (Least Common Multiple) Of Two Integers           
 *
 * <hr>
 * Date created: Nov 7, 2015
 *
 * <hr>
 * @param iX //Hold First Integer
 * @param iY //Hold Second Integer
 * @return iLCM //Least Common Multiple Of Two User Integer
 */
public int LCM(int iX, int iY)
{
	int iLCM;			//Holds users return value for LCM
	iLCM = (iX*iY)/GCF(iX,iY);
	return iLCM;
	
}//End LCM(int,int)

/**
 * Method to clear screen for user        
 *
 * <hr>
 * Date created: Nov 11, 2015
 *
 * <hr>
 */
public void clearScreen ( )
{
	for(int i =1;i<40;i++)
	{
		System.out.print ("\n");
	}	
}//End clearScreen()
}//End Utility()