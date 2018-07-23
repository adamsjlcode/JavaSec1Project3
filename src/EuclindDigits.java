import java.util.*;
/** ---------------------------------------------------------------------------

 * File name: EuclindDigits.java
 * Project name: Proj3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Justin Adams, adamsjl3@goldmail.etsu.edu
 * Course:  CSCI 1250-003
 * Creation Date: Nov 7, 2015
 * ---------------------------------------------------------------------------
 */

/**
 * 1900 Project Due Nov 20, 2015
 *
 * <hr>
 * Date created: Nov 7, 2015
 * <hr>
 * @author Justin Adams
 */
public class EuclindDigits
{

	/**
	 * Enter Two Integers From User And Display Binery, Octal, Hexital        
	 * GCM, And LCM Of Both Numbers
	 *
	 * <hr>
	 * Date created: Nov 7, 2015
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		
		int iX;			//First Integer From User
		int iX2;		//Holder Of First Integer From User
		int iY;			//First Integer From User
		char cRepeat;	//Holds User Input To Repeat Program
		Scanner kb = new Scanner(System.in);
		Utility u1 = new Utility();
		do
		{
			u1.clearScreen ( );
			System.out.print("Fisrt Interger: ");
			iX = kb.nextInt();
			System.out.print("\nSecond Interger: ");
			iY = kb.nextInt();
			iX2=iX;
			u1.BinOctHex(iX,iY);
			u1.pressEnterToContinue();
			System.out.print("Greatest Common Factor Of " + iX +
								"," + iY + " Is ");
			iX = u1.GCF (iX, iY);
			System.out.println(iX);
			System.out.print("Leastest Common Multiple Of " + iX2 +
				"," + iY + " Is ");
			iY = u1.LCM (iX2, iY);
			System.out.println(iY);
			cRepeat = u1.startOver();
	}while(cRepeat == 'Y' || cRepeat == 'y');	
}	

}

